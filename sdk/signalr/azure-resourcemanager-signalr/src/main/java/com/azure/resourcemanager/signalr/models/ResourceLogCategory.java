// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.signalr.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;

/** Resource log category configuration of a Microsoft.SignalRService resource. */
@Fluent
public final class ResourceLogCategory {
    /*
     * Gets or sets the resource log category's name.
     * Available values: ConnectivityLogs, MessagingLogs.
     * Case insensitive.
     */
    @JsonProperty(value = "name")
    private String name;

    /*
     * Indicates whether or the resource log category is enabled.
     * Available values: true, false.
     * Case insensitive.
     */
    @JsonProperty(value = "enabled")
    private String enabled;

    /**
     * Get the name property: Gets or sets the resource log category's name. Available values: ConnectivityLogs,
     * MessagingLogs. Case insensitive.
     *
     * @return the name value.
     */
    public String name() {
        return this.name;
    }

    /**
     * Set the name property: Gets or sets the resource log category's name. Available values: ConnectivityLogs,
     * MessagingLogs. Case insensitive.
     *
     * @param name the name value to set.
     * @return the ResourceLogCategory object itself.
     */
    public ResourceLogCategory withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get the enabled property: Indicates whether or the resource log category is enabled. Available values: true,
     * false. Case insensitive.
     *
     * @return the enabled value.
     */
    public String enabled() {
        return this.enabled;
    }

    /**
     * Set the enabled property: Indicates whether or the resource log category is enabled. Available values: true,
     * false. Case insensitive.
     *
     * @param enabled the enabled value to set.
     * @return the ResourceLogCategory object itself.
     */
    public ResourceLogCategory withEnabled(String enabled) {
        this.enabled = enabled;
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
