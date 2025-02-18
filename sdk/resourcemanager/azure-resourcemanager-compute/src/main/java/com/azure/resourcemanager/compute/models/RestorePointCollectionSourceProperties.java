// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.compute.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;

/** The properties of the source resource that this restore point collection is created from. */
@Fluent
public final class RestorePointCollectionSourceProperties {
    /*
     * Location of the source resource used to create this restore point collection.
     */
    @JsonProperty(value = "location", access = JsonProperty.Access.WRITE_ONLY)
    private String location;

    /*
     * Resource Id of the source resource used to create this restore point collection
     */
    @JsonProperty(value = "id")
    private String id;

    /**
     * Get the location property: Location of the source resource used to create this restore point collection.
     *
     * @return the location value.
     */
    public String location() {
        return this.location;
    }

    /**
     * Get the id property: Resource Id of the source resource used to create this restore point collection.
     *
     * @return the id value.
     */
    public String id() {
        return this.id;
    }

    /**
     * Set the id property: Resource Id of the source resource used to create this restore point collection.
     *
     * @param id the id value to set.
     * @return the RestorePointCollectionSourceProperties object itself.
     */
    public RestorePointCollectionSourceProperties withId(String id) {
        this.id = id;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
    }
}
