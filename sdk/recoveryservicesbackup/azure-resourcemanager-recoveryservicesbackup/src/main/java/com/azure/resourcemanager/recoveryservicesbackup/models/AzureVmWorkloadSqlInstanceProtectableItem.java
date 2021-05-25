// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.recoveryservicesbackup.models;

import com.azure.core.annotation.Immutable;
import com.azure.core.util.logging.ClientLogger;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

/** Azure VM workload-specific protectable item representing SQL Instance. */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "protectableItemType")
@JsonTypeName("SQLInstance")
@Immutable
public final class AzureVmWorkloadSqlInstanceProtectableItem extends AzureVmWorkloadProtectableItem {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(AzureVmWorkloadSqlInstanceProtectableItem.class);

    /** {@inheritDoc} */
    @Override
    public AzureVmWorkloadSqlInstanceProtectableItem withParentName(String parentName) {
        super.withParentName(parentName);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public AzureVmWorkloadSqlInstanceProtectableItem withParentUniqueName(String parentUniqueName) {
        super.withParentUniqueName(parentUniqueName);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public AzureVmWorkloadSqlInstanceProtectableItem withServerName(String serverName) {
        super.withServerName(serverName);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public AzureVmWorkloadSqlInstanceProtectableItem withIsAutoProtectable(Boolean isAutoProtectable) {
        super.withIsAutoProtectable(isAutoProtectable);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public AzureVmWorkloadSqlInstanceProtectableItem withIsAutoProtected(Boolean isAutoProtected) {
        super.withIsAutoProtected(isAutoProtected);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public AzureVmWorkloadSqlInstanceProtectableItem withSubinquireditemcount(Integer subinquireditemcount) {
        super.withSubinquireditemcount(subinquireditemcount);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public AzureVmWorkloadSqlInstanceProtectableItem withSubprotectableitemcount(Integer subprotectableitemcount) {
        super.withSubprotectableitemcount(subprotectableitemcount);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public AzureVmWorkloadSqlInstanceProtectableItem withPrebackupvalidation(PreBackupValidation prebackupvalidation) {
        super.withPrebackupvalidation(prebackupvalidation);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public AzureVmWorkloadSqlInstanceProtectableItem withBackupManagementType(String backupManagementType) {
        super.withBackupManagementType(backupManagementType);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public AzureVmWorkloadSqlInstanceProtectableItem withWorkloadType(String workloadType) {
        super.withWorkloadType(workloadType);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public AzureVmWorkloadSqlInstanceProtectableItem withFriendlyName(String friendlyName) {
        super.withFriendlyName(friendlyName);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public AzureVmWorkloadSqlInstanceProtectableItem withProtectionState(ProtectionStatus protectionState) {
        super.withProtectionState(protectionState);
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
    public void validate() {
        super.validate();
    }
}