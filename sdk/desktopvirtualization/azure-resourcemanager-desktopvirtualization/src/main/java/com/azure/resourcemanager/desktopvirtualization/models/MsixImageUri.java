// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.desktopvirtualization.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;

/** Represents URI referring to MSIX Image. */
@Fluent
public final class MsixImageUri {
    /*
     * URI to Image
     */
    @JsonProperty(value = "uri")
    private String uri;

    /**
     * Get the uri property: URI to Image.
     *
     * @return the uri value.
     */
    public String uri() {
        return this.uri;
    }

    /**
     * Set the uri property: URI to Image.
     *
     * @param uri the uri value to set.
     * @return the MsixImageUri object itself.
     */
    public MsixImageUri withUri(String uri) {
        this.uri = uri;
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
