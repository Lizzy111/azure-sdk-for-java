// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.messaging.eventgrid.systemevents;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;

/** Schema of the Data property of an EventGridEvent for an Microsoft.Storage.BlobInventoryPolicyCompleted event. */
@Fluent
public final class StorageBlobInventoryPolicyCompletedEventData {
    /*
     * The time at which inventory policy was scheduled.
     */
    @JsonProperty(value = "scheduleDateTime")
    private OffsetDateTime scheduleDateTime;

    /*
     * The account name for which inventory policy is registered.
     */
    @JsonProperty(value = "accountName")
    private String accountName;

    /*
     * The rule name for inventory policy.
     */
    @JsonProperty(value = "ruleName")
    private String ruleName;

    /*
     * The status of inventory run, it can be
     * Succeeded/PartiallySucceeded/Failed.
     */
    @JsonProperty(value = "policyRunStatus")
    private String policyRunStatus;

    /*
     * The status message for inventory run.
     */
    @JsonProperty(value = "policyRunStatusMessage")
    private String policyRunStatusMessage;

    /*
     * The policy run id for inventory run.
     */
    @JsonProperty(value = "policyRunId")
    private String policyRunId;

    /*
     * The blob URL for manifest file for inventory run.
     */
    @JsonProperty(value = "manifestBlobUrl")
    private String manifestBlobUrl;

    /**
     * Get the scheduleDateTime property: The time at which inventory policy was scheduled.
     *
     * @return the scheduleDateTime value.
     */
    public OffsetDateTime getScheduleDateTime() {
        return this.scheduleDateTime;
    }

    /**
     * Set the scheduleDateTime property: The time at which inventory policy was scheduled.
     *
     * @param scheduleDateTime the scheduleDateTime value to set.
     * @return the StorageBlobInventoryPolicyCompletedEventData object itself.
     */
    public StorageBlobInventoryPolicyCompletedEventData setScheduleDateTime(OffsetDateTime scheduleDateTime) {
        this.scheduleDateTime = scheduleDateTime;
        return this;
    }

    /**
     * Get the accountName property: The account name for which inventory policy is registered.
     *
     * @return the accountName value.
     */
    public String getAccountName() {
        return this.accountName;
    }

    /**
     * Set the accountName property: The account name for which inventory policy is registered.
     *
     * @param accountName the accountName value to set.
     * @return the StorageBlobInventoryPolicyCompletedEventData object itself.
     */
    public StorageBlobInventoryPolicyCompletedEventData setAccountName(String accountName) {
        this.accountName = accountName;
        return this;
    }

    /**
     * Get the ruleName property: The rule name for inventory policy.
     *
     * @return the ruleName value.
     */
    public String getRuleName() {
        return this.ruleName;
    }

    /**
     * Set the ruleName property: The rule name for inventory policy.
     *
     * @param ruleName the ruleName value to set.
     * @return the StorageBlobInventoryPolicyCompletedEventData object itself.
     */
    public StorageBlobInventoryPolicyCompletedEventData setRuleName(String ruleName) {
        this.ruleName = ruleName;
        return this;
    }

    /**
     * Get the policyRunStatus property: The status of inventory run, it can be Succeeded/PartiallySucceeded/Failed.
     *
     * @return the policyRunStatus value.
     */
    public String getPolicyRunStatus() {
        return this.policyRunStatus;
    }

    /**
     * Set the policyRunStatus property: The status of inventory run, it can be Succeeded/PartiallySucceeded/Failed.
     *
     * @param policyRunStatus the policyRunStatus value to set.
     * @return the StorageBlobInventoryPolicyCompletedEventData object itself.
     */
    public StorageBlobInventoryPolicyCompletedEventData setPolicyRunStatus(String policyRunStatus) {
        this.policyRunStatus = policyRunStatus;
        return this;
    }

    /**
     * Get the policyRunStatusMessage property: The status message for inventory run.
     *
     * @return the policyRunStatusMessage value.
     */
    public String getPolicyRunStatusMessage() {
        return this.policyRunStatusMessage;
    }

    /**
     * Set the policyRunStatusMessage property: The status message for inventory run.
     *
     * @param policyRunStatusMessage the policyRunStatusMessage value to set.
     * @return the StorageBlobInventoryPolicyCompletedEventData object itself.
     */
    public StorageBlobInventoryPolicyCompletedEventData setPolicyRunStatusMessage(String policyRunStatusMessage) {
        this.policyRunStatusMessage = policyRunStatusMessage;
        return this;
    }

    /**
     * Get the policyRunId property: The policy run id for inventory run.
     *
     * @return the policyRunId value.
     */
    public String getPolicyRunId() {
        return this.policyRunId;
    }

    /**
     * Set the policyRunId property: The policy run id for inventory run.
     *
     * @param policyRunId the policyRunId value to set.
     * @return the StorageBlobInventoryPolicyCompletedEventData object itself.
     */
    public StorageBlobInventoryPolicyCompletedEventData setPolicyRunId(String policyRunId) {
        this.policyRunId = policyRunId;
        return this;
    }

    /**
     * Get the manifestBlobUrl property: The blob URL for manifest file for inventory run.
     *
     * @return the manifestBlobUrl value.
     */
    public String getManifestBlobUrl() {
        return this.manifestBlobUrl;
    }

    /**
     * Set the manifestBlobUrl property: The blob URL for manifest file for inventory run.
     *
     * @param manifestBlobUrl the manifestBlobUrl value to set.
     * @return the StorageBlobInventoryPolicyCompletedEventData object itself.
     */
    public StorageBlobInventoryPolicyCompletedEventData setManifestBlobUrl(String manifestBlobUrl) {
        this.manifestBlobUrl = manifestBlobUrl;
        return this;
    }
}