// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.devhub.models;

import com.azure.core.annotation.Fluent;
import com.azure.resourcemanager.devhub.fluent.models.WorkflowInner;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** The response from List Workflows operation. */
@Fluent
public final class WorkflowListResult {
    /*
     * The list of workflows.
     */
    @JsonProperty(value = "value")
    private List<WorkflowInner> value;

    /*
     * The URL to the next set of workflow results.
     */
    @JsonProperty(value = "nextLink", access = JsonProperty.Access.WRITE_ONLY)
    private String nextLink;

    /**
     * Get the value property: The list of workflows.
     *
     * @return the value value.
     */
    public List<WorkflowInner> value() {
        return this.value;
    }

    /**
     * Set the value property: The list of workflows.
     *
     * @param value the value value to set.
     * @return the WorkflowListResult object itself.
     */
    public WorkflowListResult withValue(List<WorkflowInner> value) {
        this.value = value;
        return this;
    }

    /**
     * Get the nextLink property: The URL to the next set of workflow results.
     *
     * @return the nextLink value.
     */
    public String nextLink() {
        return this.nextLink;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (value() != null) {
            value().forEach(e -> e.validate());
        }
    }
}
