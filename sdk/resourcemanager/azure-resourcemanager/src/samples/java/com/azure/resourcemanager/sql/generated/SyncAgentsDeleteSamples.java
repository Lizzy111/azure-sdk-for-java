// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.sql.generated;

import com.azure.core.util.Context;

/** Samples for SyncAgents Delete. */
public final class SyncAgentsDeleteSamples {
    /*
     * x-ms-original-file: specification/sql/resource-manager/Microsoft.Sql/preview/2015-05-01-preview/examples/SyncAgentDelete.json
     */
    /**
     * Sample code: Delete a sync agent.
     *
     * @param azure The entry point for accessing resource management APIs in Azure.
     */
    public static void deleteASyncAgent(com.azure.resourcemanager.AzureResourceManager azure) {
        azure
            .sqlServers()
            .manager()
            .serviceClient()
            .getSyncAgents()
            .delete("syncagentcrud-65440", "syncagentcrud-8475", "syncagentcrud-3187", Context.NONE);
    }
}
