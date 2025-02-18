// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.analytics.synapse.artifacts.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;

/** DW Copy Command settings. */
@Fluent
public final class DWCopyCommandSettings {
    /*
     * Specifies the default values for each target column in SQL DW. The default values in the property overwrite the
     * DEFAULT constraint set in the DB, and identity column cannot have a default value. Type: array of objects (or
     * Expression with resultType array of objects).
     */
    @JsonProperty(value = "defaultValues")
    private List<DWCopyCommandDefaultValue> defaultValues;

    /*
     * Additional options directly passed to SQL DW in Copy Command. Type: key value pairs (value should be string
     * type) (or Expression with resultType object). Example: "additionalOptions": { "MAXERRORS": "1000", "DATEFORMAT":
     * "'ymd'" }
     */
    @JsonProperty(value = "additionalOptions")
    private Map<String, String> additionalOptions;

    /**
     * Get the defaultValues property: Specifies the default values for each target column in SQL DW. The default values
     * in the property overwrite the DEFAULT constraint set in the DB, and identity column cannot have a default value.
     * Type: array of objects (or Expression with resultType array of objects).
     *
     * @return the defaultValues value.
     */
    public List<DWCopyCommandDefaultValue> getDefaultValues() {
        return this.defaultValues;
    }

    /**
     * Set the defaultValues property: Specifies the default values for each target column in SQL DW. The default values
     * in the property overwrite the DEFAULT constraint set in the DB, and identity column cannot have a default value.
     * Type: array of objects (or Expression with resultType array of objects).
     *
     * @param defaultValues the defaultValues value to set.
     * @return the DWCopyCommandSettings object itself.
     */
    public DWCopyCommandSettings setDefaultValues(List<DWCopyCommandDefaultValue> defaultValues) {
        this.defaultValues = defaultValues;
        return this;
    }

    /**
     * Get the additionalOptions property: Additional options directly passed to SQL DW in Copy Command. Type: key value
     * pairs (value should be string type) (or Expression with resultType object). Example: "additionalOptions": {
     * "MAXERRORS": "1000", "DATEFORMAT": "'ymd'" }.
     *
     * @return the additionalOptions value.
     */
    public Map<String, String> getAdditionalOptions() {
        return this.additionalOptions;
    }

    /**
     * Set the additionalOptions property: Additional options directly passed to SQL DW in Copy Command. Type: key value
     * pairs (value should be string type) (or Expression with resultType object). Example: "additionalOptions": {
     * "MAXERRORS": "1000", "DATEFORMAT": "'ymd'" }.
     *
     * @param additionalOptions the additionalOptions value to set.
     * @return the DWCopyCommandSettings object itself.
     */
    public DWCopyCommandSettings setAdditionalOptions(Map<String, String> additionalOptions) {
        this.additionalOptions = additionalOptions;
        return this;
    }
}
