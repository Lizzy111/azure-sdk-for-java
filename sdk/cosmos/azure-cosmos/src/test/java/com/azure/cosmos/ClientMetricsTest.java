/*
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License.
 *
 */

package com.azure.cosmos;

import com.azure.cosmos.implementation.ConsoleLoggingRegistryFactory;
import com.azure.cosmos.implementation.InternalObjectNode;
import com.azure.cosmos.implementation.clienttelemetry.TagName;
import com.azure.cosmos.implementation.guava25.collect.Lists;
import com.azure.cosmos.models.CosmosBatch;
import com.azure.cosmos.models.CosmosBatchResponse;
import com.azure.cosmos.models.CosmosBulkExecutionOptions;
import com.azure.cosmos.models.CosmosBulkOperations;
import com.azure.cosmos.models.CosmosItemOperation;
import com.azure.cosmos.models.CosmosItemRequestOptions;
import com.azure.cosmos.models.CosmosItemResponse;
import com.azure.cosmos.models.CosmosPatchItemRequestOptions;
import com.azure.cosmos.models.CosmosQueryRequestOptions;
import com.azure.cosmos.models.ModelBridgeInternal;
import com.azure.cosmos.models.PartitionKey;
import com.azure.cosmos.models.SqlQuerySpec;
import com.azure.cosmos.util.CosmosPagedIterable;
import io.micrometer.core.instrument.Meter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tag;
import io.netty.handler.codec.http.HttpResponseStatus;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class ClientMetricsTest extends BatchTestBase {

    private CosmosClient client;
    private CosmosContainer container;
    private String databaseId;
    private String containerId;
    private MeterRegistry meterRegistry;

    @Factory(dataProvider = "clientBuildersWithDirectSession")
    public ClientMetricsTest(CosmosClientBuilder clientBuilder) {
        super(clientBuilder);
    }

    public void beforeTest() {
        assertThat(this.client).isNull();
        assertThat(this.meterRegistry).isNull();

        this.meterRegistry = ConsoleLoggingRegistryFactory.create(1);
        this.client = getClientBuilder()
            .clientTelemetryConfig().clientMetrics(this.meterRegistry)
            .buildClient();

        if (databaseId == null) {
            CosmosAsyncContainer asyncContainer = getSharedMultiPartitionCosmosContainer(this.client.asyncClient());
            this.databaseId = asyncContainer.getDatabase().getId();
            this.containerId = asyncContainer.getId();
        }

        container = client.getDatabase(databaseId).getContainer(containerId);
    }

    public void afterTest() {
        this.container = null;
        CosmosClient clientSnapshot = this.client;
        if (clientSnapshot != null) {
            this.client.close();
        }
        this.client = null;

        MeterRegistry meterRegistrySnapshot = this.meterRegistry;
        if (meterRegistrySnapshot != null) {
            meterRegistrySnapshot.clear();
            meterRegistrySnapshot.close();
        }
        this.meterRegistry = null;
    }

    @Test(groups = { "simple" }, timeOut = TIMEOUT)
    public void createItem() throws Exception {
        this.beforeTest();
        try {
            InternalObjectNode properties = getDocumentDefinition(UUID.randomUUID().toString());
            CosmosItemResponse<InternalObjectNode> itemResponse = container.createItem(properties);
            assertThat(itemResponse.getRequestCharge()).isGreaterThan(0);
            validateItemResponse(properties, itemResponse);

            properties = getDocumentDefinition(UUID.randomUUID().toString());
            CosmosItemResponse<InternalObjectNode> itemResponse1 = container.createItem(properties, new CosmosItemRequestOptions());
            validateItemResponse(properties, itemResponse1);

            this.validateMetrics(
                Tag.of(TagName.OperationStatusCode.toString(), "201"),
                Tag.of(TagName.RequestStatusCode.toString(), "201/0")
            );

            this.validateMetrics(
                Tag.of(
                    TagName.Operation.toString(), "Document/Create"),
                Tag.of(TagName.RequestOperationType.toString(), "Document/Create")
            );
        } finally {
            this.afterTest();
        }
    }

    @Test(groups = { "simple" }, timeOut = TIMEOUT)
    public void readItem() throws Exception {
        this.beforeTest();
        try {
            InternalObjectNode properties = getDocumentDefinition(UUID.randomUUID().toString());
            container.createItem(properties);

            CosmosItemResponse<InternalObjectNode> readResponse1 = container.readItem(properties.getId(),
                new PartitionKey(ModelBridgeInternal.getObjectFromJsonSerializable(properties, "mypk")),
                new CosmosItemRequestOptions(),
                InternalObjectNode.class);
            validateItemResponse(properties, readResponse1);

            this.validateMetrics(
                Tag.of(TagName.OperationStatusCode.toString(), "200"),
                Tag.of(TagName.RequestStatusCode.toString(), "200/0")
            );

            this.validateMetrics(
                Tag.of(
                    TagName.Operation.toString(), "Document/Read"),
                Tag.of(TagName.RequestOperationType.toString(), "Document/Read")
            );

            Tag queryPlanTag = Tag.of(TagName.RequestOperationType.toString(), "DocumentCollection_QueryPlan");
            this.assertMetrics("cosmos.client.req.gw", false, queryPlanTag);
            this.assertMetrics("cosmos.client.req.rntbd", false, queryPlanTag);
        } finally {
            this.afterTest();
        }
    }

    @Test(groups = { "simple" }, timeOut = TIMEOUT)
    public void replaceItem() throws Exception {
        this.beforeTest();
        try {
            InternalObjectNode properties = getDocumentDefinition(UUID.randomUUID().toString());
            CosmosItemResponse<InternalObjectNode> itemResponse = container.createItem(properties);

            validateItemResponse(properties, itemResponse);
            String newPropValue = UUID.randomUUID().toString();
            BridgeInternal.setProperty(properties, "newProp", newPropValue);
            CosmosItemRequestOptions options = new CosmosItemRequestOptions();
            ModelBridgeInternal.setPartitionKey(options, new PartitionKey(ModelBridgeInternal.getObjectFromJsonSerializable(properties, "mypk")));
            // replace document
            CosmosItemResponse<InternalObjectNode> replace = container.replaceItem(properties,
                properties.getId(),
                new PartitionKey(ModelBridgeInternal.getObjectFromJsonSerializable(properties, "mypk")),
                options);
            assertThat(ModelBridgeInternal.getObjectFromJsonSerializable(BridgeInternal.getProperties(replace), "newProp")).isEqualTo(newPropValue);

            this.validateMetrics(
                Tag.of(TagName.OperationStatusCode.toString(), "200"),
                Tag.of(TagName.RequestStatusCode.toString(), "200/0")
            );

            this.validateMetrics(
                Tag.of(
                    TagName.Operation.toString(), "Document/Replace"),
                Tag.of(TagName.RequestOperationType.toString(), "Document/Replace")
            );
        } finally {
            this.afterTest();
        }
    }

    @Test(groups = { "simple" }, timeOut = TIMEOUT)
    public void deleteItem() throws Exception {
        this.beforeTest();
        try {
            InternalObjectNode properties = getDocumentDefinition(UUID.randomUUID().toString());
            container.createItem(properties);
            CosmosItemRequestOptions options = new CosmosItemRequestOptions();

            CosmosItemResponse<?> deleteResponse = container.deleteItem(properties.getId(),
                new PartitionKey(ModelBridgeInternal.getObjectFromJsonSerializable(properties, "mypk")),
                options);
            assertThat(deleteResponse.getStatusCode()).isEqualTo(204);

            this.validateMetrics(
                Tag.of(TagName.OperationStatusCode.toString(), "204"),
                Tag.of(TagName.RequestStatusCode.toString(), "204/0")
            );

            this.validateMetrics(
                Tag.of(
                    TagName.Operation.toString(), "Document/Delete"),
                Tag.of(TagName.RequestOperationType.toString(), "Document/Delete")
            );
        } finally {
            this.afterTest();
        }
    }

    @Test(groups = { "simple" }, timeOut = TIMEOUT)
    public void readAllItems() throws Exception {
        this.beforeTest();
        try {
            InternalObjectNode properties = getDocumentDefinition(UUID.randomUUID().toString());
            container.createItem(properties);

            CosmosQueryRequestOptions cosmosQueryRequestOptions = new CosmosQueryRequestOptions();

            CosmosPagedIterable<InternalObjectNode> feedResponseIterator3 =
                container.readAllItems(cosmosQueryRequestOptions, InternalObjectNode.class);
            assertThat(feedResponseIterator3.iterator().hasNext()).isTrue();

            this.validateMetrics(
                Tag.of(TagName.OperationStatusCode.toString(), "200"),
                Tag.of(TagName.RequestStatusCode.toString(), "200/0")
            );

            this.validateMetrics(
                Tag.of(
                    TagName.Operation.toString(), "Document/ReadFeed"),
                Tag.of(TagName.RequestOperationType.toString(), "Document/Query")
            );

            Tag queryPlanTag = Tag.of(TagName.RequestOperationType.toString(), "DocumentCollection/QueryPlan");
            this.assertMetrics("cosmos.client.req.gw", true, queryPlanTag);
            this.assertMetrics("cosmos.client.req.rntbd", false, queryPlanTag);
        } finally {
            this.afterTest();
        }
    }

    @Test(groups = { "simple" }, timeOut = TIMEOUT)
    public void queryItems() throws Exception {
        this.beforeTest();
        try {
            InternalObjectNode properties = getDocumentDefinition(UUID.randomUUID().toString());
            container.createItem(properties);

            String query = String.format("SELECT * from c where c.id = '%s'", properties.getId());
            CosmosQueryRequestOptions cosmosQueryRequestOptions = new CosmosQueryRequestOptions();

            CosmosPagedIterable<InternalObjectNode> feedResponseIterator1 =
                container.queryItems(query, cosmosQueryRequestOptions, InternalObjectNode.class);

            // Very basic validation
            assertThat(feedResponseIterator1.iterator().hasNext()).isTrue();

            SqlQuerySpec querySpec = new SqlQuerySpec(query);
            CosmosPagedIterable<InternalObjectNode> feedResponseIterator3 =
                container.queryItems(querySpec, cosmosQueryRequestOptions, InternalObjectNode.class);
            assertThat(feedResponseIterator3.iterator().hasNext()).isTrue();

            this.validateMetrics(
                Tag.of(TagName.OperationStatusCode.toString(), "200"),
                Tag.of(TagName.RequestStatusCode.toString(), "200/0")
            );

            this.validateMetrics(
                Tag.of(
                    TagName.Operation.toString(), "Document/Query"),
                Tag.of(TagName.RequestOperationType.toString(), "Document/Query")
            );

            Tag queryPlanTag = Tag.of(TagName.RequestOperationType.toString(), "DocumentCollection/QueryPlan");
            this.assertMetrics("cosmos.client.req.gw", true, queryPlanTag);
            this.assertMetrics("cosmos.client.req.rntbd", false, queryPlanTag);
        } finally {
            this.afterTest();
        }
    }

    @Test(groups = { "emulator" }, timeOut = TIMEOUT * 100)
    public void itemPatchSuccess() {
        this.beforeTest();
        try {
            PatchTest.ToDoActivity testItem = PatchTest.ToDoActivity.createRandomItem(this.container);
            PatchTest.ToDoActivity testItem1 = PatchTest.ToDoActivity.createRandomItem(this.container);
            PatchTest.ToDoActivity testItem2 = PatchTest.ToDoActivity.createRandomItem(this.container);

            int originalTaskNum = testItem.taskNum;
            int newTaskNum = originalTaskNum + 1;

            assertThat(testItem.children[1].status).isNull();

            com.azure.cosmos.models.CosmosPatchOperations cosmosPatchOperations = com.azure.cosmos.models.CosmosPatchOperations.create();
            cosmosPatchOperations.add("/children/0/CamelCase", "patched");
            cosmosPatchOperations.remove("/description");
            cosmosPatchOperations.replace("/taskNum", newTaskNum);
            cosmosPatchOperations.replace("/children/1", testItem1);
            cosmosPatchOperations.replace("/nestedChild", testItem2);
            cosmosPatchOperations.set("/valid", false);

            CosmosPatchItemRequestOptions options = new CosmosPatchItemRequestOptions();
            CosmosItemResponse<PatchTest.ToDoActivity> response = this.container.patchItem(
                testItem.id,
                new PartitionKey(testItem.status),
                cosmosPatchOperations,
                options,
                PatchTest.ToDoActivity.class);

            assertThat(response.getStatusCode()).isEqualTo(HttpResponseStatus.OK.code());

            PatchTest.ToDoActivity patchedItem = response.getItem();
            assertThat(patchedItem).isNotNull();

            assertThat(patchedItem.children[0].camelCase).isEqualTo("patched");
            assertThat(patchedItem.description).isNull();
            assertThat(patchedItem.taskNum).isEqualTo(newTaskNum);
            assertThat(patchedItem.valid).isEqualTo(false);
            assertThat(patchedItem.children[1].id).isEqualTo(testItem1.id);
            assertThat(patchedItem.nestedChild.id).isEqualTo(testItem2.id);

            // read resource to validate the patch operation
            response = this.container.readItem(
                testItem.id,
                new PartitionKey(testItem.status),
                options, PatchTest.ToDoActivity.class);

            assertThat(response.getStatusCode()).isEqualTo(HttpResponseStatus.OK.code());
            assertThat(response.getItem()).isEqualTo(patchedItem);

            this.validateMetrics(
                Tag.of(TagName.OperationStatusCode.toString(), "200"),
                Tag.of(TagName.RequestStatusCode.toString(), "200/0")
            );

            this.validateMetrics(
                Tag.of(
                    TagName.Operation.toString(), "Document/Patch"),
                Tag.of(TagName.RequestOperationType.toString(), "Document/Patch")
            );
        } finally {
            this.afterTest();
        }
    }

    @Test(groups = { "simple" }, timeOut = TIMEOUT)
    public void createItem_withBulk() {
        this.beforeTest();
        try {
            int totalRequest = 5;

            List<com.azure.cosmos.models.CosmosItemOperation> cosmosItemOperations = new ArrayList<>();
            for (int i = 0; i < totalRequest; i++) {
                String partitionKey = UUID.randomUUID().toString();
                BatchTestBase.TestDoc testDoc = this.populateTestDoc(partitionKey);
                cosmosItemOperations.add(CosmosBulkOperations.getCreateItemOperation(testDoc, new PartitionKey(partitionKey)));

                partitionKey = UUID.randomUUID().toString();
                BatchTestBase.EventDoc eventDoc = new BatchTestBase.EventDoc(UUID.randomUUID().toString(), 2, 4, "type1", partitionKey);
                cosmosItemOperations.add(CosmosBulkOperations.getCreateItemOperation(eventDoc, new PartitionKey(partitionKey)));
            }

            CosmosBulkExecutionOptions cosmosBulkExecutionOptions = new CosmosBulkExecutionOptions();

            List<com.azure.cosmos.models.CosmosBulkOperationResponse<CosmosBulkAsyncTest>> bulkResponse = Lists.newArrayList(this.container
                .executeBulkOperations(cosmosItemOperations, cosmosBulkExecutionOptions));

            assertThat(bulkResponse.size()).isEqualTo(totalRequest * 2);

            for (com.azure.cosmos.models.CosmosBulkOperationResponse<CosmosBulkAsyncTest> cosmosBulkOperationResponse : bulkResponse) {
                com.azure.cosmos.models.CosmosBulkItemResponse cosmosBulkItemResponse = cosmosBulkOperationResponse.getResponse();

                assertThat(cosmosBulkItemResponse.getStatusCode()).isEqualTo(HttpResponseStatus.CREATED.code());
                assertThat(cosmosBulkItemResponse.getRequestCharge()).isGreaterThan(0);
                assertThat(cosmosBulkItemResponse.getCosmosDiagnostics().toString()).isNotNull();
                assertThat(cosmosBulkItemResponse.getSessionToken()).isNotNull();
                assertThat(cosmosBulkItemResponse.getActivityId()).isNotNull();
                assertThat(cosmosBulkItemResponse.getRequestCharge()).isNotNull();
            }

            this.validateMetrics(
                Tag.of(TagName.OperationStatusCode.toString(), "200"),
                Tag.of(TagName.RequestStatusCode.toString(), "200/0")
            );

            this.validateMetrics(
                Tag.of(
                    TagName.Operation.toString(), "Document/Batch"),
                Tag.of(TagName.RequestOperationType.toString(), "Document/Batch")
            );
        } finally {
            this.afterTest();
        }
    }

    @Test(groups = {"simple"}, timeOut = TIMEOUT)
    public void batchMultipleItemExecution() {
        this.beforeTest();
        try {
            TestDoc firstDoc = this.populateTestDoc(this.partitionKey1);
            TestDoc replaceDoc = this.getTestDocCopy(firstDoc);
            replaceDoc.setCost(replaceDoc.getCost() + 1);

            EventDoc eventDoc1 = new EventDoc(UUID.randomUUID().toString(), 2, 4, "type1", this.partitionKey1);
            EventDoc readEventDoc = new EventDoc(UUID.randomUUID().toString(), 6, 14, "type2", this.partitionKey1);
            CosmosItemResponse<EventDoc> createResponse = container.createItem(readEventDoc, this.getPartitionKey(this.partitionKey1), null);
            assertThat(createResponse.getStatusCode()).isEqualTo(HttpResponseStatus.CREATED.code());

            CosmosBatch batch = CosmosBatch.createCosmosBatch(this.getPartitionKey(this.partitionKey1));
            batch.createItemOperation(firstDoc);
            batch.createItemOperation(eventDoc1);
            batch.replaceItemOperation(replaceDoc.getId(), replaceDoc);
            batch.readItemOperation(readEventDoc.getId());

            CosmosBatchResponse batchResponse = container.executeCosmosBatch(batch);

            this.verifyBatchProcessed(batchResponse, 4);

            assertThat(batchResponse.getResults().get(0).getStatusCode()).isEqualTo(HttpResponseStatus.CREATED.code());
            assertThat(batchResponse.getResults().get(0).getItem(TestDoc.class)).isEqualTo(firstDoc);

            assertThat(batchResponse.getResults().get(1).getStatusCode()).isEqualTo(HttpResponseStatus.CREATED.code());
            assertThat(batchResponse.getResults().get(1).getItem(EventDoc.class)).isEqualTo(eventDoc1);

            assertThat(batchResponse.getResults().get(2).getStatusCode()).isEqualTo(HttpResponseStatus.OK.code());
            assertThat(batchResponse.getResults().get(2).getItem(TestDoc.class)).isEqualTo(replaceDoc);

            assertThat(batchResponse.getResults().get(3).getStatusCode()).isEqualTo(HttpResponseStatus.OK.code());
            assertThat(batchResponse.getResults().get(3).getItem(EventDoc.class)).isEqualTo(readEventDoc);

            // Ensure that the replace overwrote the doc from the first operation
            this.verifyByRead(container, replaceDoc);

            List<CosmosItemOperation> batchOperations = batch.getOperations();
            for (int index = 0; index < batchOperations.size(); index++) {
                assertThat(batchResponse.getResults().get(index).getOperation()).isEqualTo(batchOperations.get(index));
            }

            this.validateMetrics(
                Tag.of(TagName.OperationStatusCode.toString(), "200"),
                Tag.of(TagName.RequestStatusCode.toString(), "200/0")
            );

            this.validateMetrics(
                Tag.of(
                    TagName.Operation.toString(), "Document/Batch"),
                Tag.of(TagName.RequestOperationType.toString(), "Document/Batch")
            );
        } finally {
            this.afterTest();
        }
    }

    private InternalObjectNode getDocumentDefinition(String documentId) {
        final String uuid = UUID.randomUUID().toString();
        return
            new InternalObjectNode(String.format("{ "
                    + "\"id\": \"%s\", "
                    + "\"mypk\": \"%s\", "
                    + "\"sgmts\": [[6519456, 1471916863], [2498434, 1455671440]]"
                    + "}"
                , documentId, uuid));
    }

    private void validateItemResponse(InternalObjectNode containerProperties,
                                      CosmosItemResponse<InternalObjectNode> createResponse) {
        // Basic validation
        assertThat(BridgeInternal.getProperties(createResponse).getId()).isNotNull();
        assertThat(BridgeInternal.getProperties(createResponse).getId())
            .as("check Resource Id")
            .isEqualTo(containerProperties.getId());
    }

    private void validateMetrics() {
        this.assertMetrics("cosmos.client.op.latency", true);
        if (this.client.asyncClient().getConnectionPolicy().getConnectionMode() == ConnectionMode.DIRECT) {
            this.assertMetrics("cosmos.client.req.rntbd", true);
        } else {
            this.assertMetrics("cosmos.client.req.gw", true);
            this.assertMetrics("cosmos.client.req.rntbd", false);
        }
    }

    private void validateMetrics(Tag expectedOperationTag, Tag expectedRequestTag) {
        this.assertMetrics("cosmos.client.op.latency", true, expectedOperationTag);
        if (this.client.asyncClient().getConnectionPolicy().getConnectionMode() == ConnectionMode.DIRECT) {
            this.assertMetrics("cosmos.client.req.rntbd", true, expectedRequestTag);
        } else {
            this.assertMetrics("cosmos.client.req.gw", true, expectedRequestTag);
            this.assertMetrics("cosmos.client.req.rntbd", false);
        }
    }

    private void assertMetrics(String prefix, boolean expectedToFind) {
        assertMetrics(prefix, expectedToFind, null);
    }

    private void assertMetrics(String prefix, boolean expectedToFind, Tag withTag) {
        assertThat(this.meterRegistry).isNotNull();
        assertThat(this.meterRegistry.getMeters()).isNotNull();
        List<Meter> meters = this.meterRegistry.getMeters().stream().collect(Collectors.toList());

        if (expectedToFind) {
            assertThat(meters.size()).isGreaterThan(0);
        }

        List<Meter> meterMatches = meters
            .stream()
            .filter(meter -> meter.getId().getName().startsWith(prefix) &&
                (withTag == null || meter.getId().getTags().contains(withTag)) &&
                meter.measure().iterator().next().getValue() > 0)
            .collect(Collectors.toList());

        if (expectedToFind) {
            assertThat(meterMatches.size()).isGreaterThan(0);
        } else {
            if (meterMatches.size() > 0) {
                meterMatches.forEach(m ->
                    logger.error("Found unexpected meter {}", m.getId().getName()));
            }
            assertThat(meterMatches.size()).isEqualTo(0);
        }
    }
}
