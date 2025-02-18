// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.sql.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.management.Resource;
import com.azure.resourcemanager.sql.models.JobAgentState;
import com.azure.resourcemanager.sql.models.Sku;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

/** An Azure SQL job agent. */
@Fluent
public final class JobAgentInner extends Resource {
    /*
     * The name and tier of the SKU.
     */
    @JsonProperty(value = "sku")
    private Sku sku;

    /*
     * Resource properties.
     */
    @JsonProperty(value = "properties")
    private JobAgentProperties innerProperties;

    /**
     * Get the sku property: The name and tier of the SKU.
     *
     * @return the sku value.
     */
    public Sku sku() {
        return this.sku;
    }

    /**
     * Set the sku property: The name and tier of the SKU.
     *
     * @param sku the sku value to set.
     * @return the JobAgentInner object itself.
     */
    public JobAgentInner withSku(Sku sku) {
        this.sku = sku;
        return this;
    }

    /**
     * Get the innerProperties property: Resource properties.
     *
     * @return the innerProperties value.
     */
    private JobAgentProperties innerProperties() {
        return this.innerProperties;
    }

    /** {@inheritDoc} */
    @Override
    public JobAgentInner withLocation(String location) {
        super.withLocation(location);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public JobAgentInner withTags(Map<String, String> tags) {
        super.withTags(tags);
        return this;
    }

    /**
     * Get the databaseId property: Resource ID of the database to store job metadata in.
     *
     * @return the databaseId value.
     */
    public String databaseId() {
        return this.innerProperties() == null ? null : this.innerProperties().databaseId();
    }

    /**
     * Set the databaseId property: Resource ID of the database to store job metadata in.
     *
     * @param databaseId the databaseId value to set.
     * @return the JobAgentInner object itself.
     */
    public JobAgentInner withDatabaseId(String databaseId) {
        if (this.innerProperties() == null) {
            this.innerProperties = new JobAgentProperties();
        }
        this.innerProperties().withDatabaseId(databaseId);
        return this;
    }

    /**
     * Get the state property: The state of the job agent.
     *
     * @return the state value.
     */
    public JobAgentState state() {
        return this.innerProperties() == null ? null : this.innerProperties().state();
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (sku() != null) {
            sku().validate();
        }
        if (innerProperties() != null) {
            innerProperties().validate();
        }
    }
}
