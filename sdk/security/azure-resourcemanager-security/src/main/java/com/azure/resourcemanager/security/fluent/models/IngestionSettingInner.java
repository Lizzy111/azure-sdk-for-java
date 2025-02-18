// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.management.ProxyResource;
import com.fasterxml.jackson.annotation.JsonProperty;

/** Configures how to correlate scan data and logs with resources associated with the subscription. */
@Fluent
public final class IngestionSettingInner extends ProxyResource {
    /*
     * Ingestion setting data
     */
    @JsonProperty(value = "properties")
    private Object properties;

    /**
     * Get the properties property: Ingestion setting data.
     *
     * @return the properties value.
     */
    public Object properties() {
        return this.properties;
    }

    /**
     * Set the properties property: Ingestion setting data.
     *
     * @param properties the properties value to set.
     * @return the IngestionSettingInner object itself.
     */
    public IngestionSettingInner withProperties(Object properties) {
        this.properties = properties;
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
