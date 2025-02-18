// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.resourceconnector.models;

import com.azure.core.annotation.Immutable;
import com.fasterxml.jackson.annotation.JsonProperty;

/** The SupportedVersionMetadata object for appliance. */
@Immutable
public final class SupportedVersionMetadata {
    /*
     * The newer supported version catalog version.
     */
    @JsonProperty(value = "catalogVersion", access = JsonProperty.Access.WRITE_ONLY)
    private SupportedVersionCatalogVersion catalogVersion;

    /**
     * Get the catalogVersion property: The newer supported version catalog version.
     *
     * @return the catalogVersion value.
     */
    public SupportedVersionCatalogVersion catalogVersion() {
        return this.catalogVersion;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (catalogVersion() != null) {
            catalogVersion().validate();
        }
    }
}
