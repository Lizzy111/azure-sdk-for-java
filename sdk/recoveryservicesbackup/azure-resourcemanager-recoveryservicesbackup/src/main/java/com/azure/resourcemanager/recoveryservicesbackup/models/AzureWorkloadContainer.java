// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.recoveryservicesbackup.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.time.OffsetDateTime;

/** Container for the workloads running inside Azure Compute or Classic Compute. */
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "containerType",
    defaultImpl = AzureWorkloadContainer.class)
@JsonTypeName("AzureWorkloadContainer")
@JsonSubTypes({
    @JsonSubTypes.Type(name = "SQLAGWorkLoadContainer", value = AzureSqlagWorkloadContainerProtectionContainer.class),
    @JsonSubTypes.Type(name = "VMAppContainer", value = AzureVMAppContainerProtectionContainer.class)
})
@Fluent
public class AzureWorkloadContainer extends ProtectionContainer {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(AzureWorkloadContainer.class);

    /*
     * ARM ID of the virtual machine represented by this Azure Workload
     * Container
     */
    @JsonProperty(value = "sourceResourceId")
    private String sourceResourceId;

    /*
     * Time stamp when this container was updated.
     */
    @JsonProperty(value = "lastUpdatedTime")
    private OffsetDateTime lastUpdatedTime;

    /*
     * Additional details of a workload container.
     */
    @JsonProperty(value = "extendedInfo")
    private AzureWorkloadContainerExtendedInfo extendedInfo;

    /*
     * Workload type for which registration was sent.
     */
    @JsonProperty(value = "workloadType")
    private WorkloadType workloadType;

    /*
     * Re-Do Operation
     */
    @JsonProperty(value = "operationType")
    private OperationType operationType;

    /**
     * Get the sourceResourceId property: ARM ID of the virtual machine represented by this Azure Workload Container.
     *
     * @return the sourceResourceId value.
     */
    public String sourceResourceId() {
        return this.sourceResourceId;
    }

    /**
     * Set the sourceResourceId property: ARM ID of the virtual machine represented by this Azure Workload Container.
     *
     * @param sourceResourceId the sourceResourceId value to set.
     * @return the AzureWorkloadContainer object itself.
     */
    public AzureWorkloadContainer withSourceResourceId(String sourceResourceId) {
        this.sourceResourceId = sourceResourceId;
        return this;
    }

    /**
     * Get the lastUpdatedTime property: Time stamp when this container was updated.
     *
     * @return the lastUpdatedTime value.
     */
    public OffsetDateTime lastUpdatedTime() {
        return this.lastUpdatedTime;
    }

    /**
     * Set the lastUpdatedTime property: Time stamp when this container was updated.
     *
     * @param lastUpdatedTime the lastUpdatedTime value to set.
     * @return the AzureWorkloadContainer object itself.
     */
    public AzureWorkloadContainer withLastUpdatedTime(OffsetDateTime lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
        return this;
    }

    /**
     * Get the extendedInfo property: Additional details of a workload container.
     *
     * @return the extendedInfo value.
     */
    public AzureWorkloadContainerExtendedInfo extendedInfo() {
        return this.extendedInfo;
    }

    /**
     * Set the extendedInfo property: Additional details of a workload container.
     *
     * @param extendedInfo the extendedInfo value to set.
     * @return the AzureWorkloadContainer object itself.
     */
    public AzureWorkloadContainer withExtendedInfo(AzureWorkloadContainerExtendedInfo extendedInfo) {
        this.extendedInfo = extendedInfo;
        return this;
    }

    /**
     * Get the workloadType property: Workload type for which registration was sent.
     *
     * @return the workloadType value.
     */
    public WorkloadType workloadType() {
        return this.workloadType;
    }

    /**
     * Set the workloadType property: Workload type for which registration was sent.
     *
     * @param workloadType the workloadType value to set.
     * @return the AzureWorkloadContainer object itself.
     */
    public AzureWorkloadContainer withWorkloadType(WorkloadType workloadType) {
        this.workloadType = workloadType;
        return this;
    }

    /**
     * Get the operationType property: Re-Do Operation.
     *
     * @return the operationType value.
     */
    public OperationType operationType() {
        return this.operationType;
    }

    /**
     * Set the operationType property: Re-Do Operation.
     *
     * @param operationType the operationType value to set.
     * @return the AzureWorkloadContainer object itself.
     */
    public AzureWorkloadContainer withOperationType(OperationType operationType) {
        this.operationType = operationType;
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public AzureWorkloadContainer withFriendlyName(String friendlyName) {
        super.withFriendlyName(friendlyName);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public AzureWorkloadContainer withBackupManagementType(BackupManagementType backupManagementType) {
        super.withBackupManagementType(backupManagementType);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public AzureWorkloadContainer withRegistrationStatus(String registrationStatus) {
        super.withRegistrationStatus(registrationStatus);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public AzureWorkloadContainer withHealthStatus(String healthStatus) {
        super.withHealthStatus(healthStatus);
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
        if (extendedInfo() != null) {
            extendedInfo().validate();
        }
    }
}