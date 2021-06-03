// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.deviceprovisioningservices.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.deviceprovisioningservices.models.AccessRightsDescription;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/** Description of the shared access key. */
@Fluent
public final class SharedAccessSignatureAuthorizationRuleInner {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(SharedAccessSignatureAuthorizationRuleInner.class);

    /*
     * Name of the key.
     */
    @JsonProperty(value = "keyName", required = true)
    private String keyName;

    /*
     * Primary SAS key value.
     */
    @JsonProperty(value = "primaryKey")
    private String primaryKey;

    /*
     * Secondary SAS key value.
     */
    @JsonProperty(value = "secondaryKey")
    private String secondaryKey;

    /*
     * Rights that this key has.
     */
    @JsonProperty(value = "rights", required = true)
    private AccessRightsDescription rights;

    /**
     * Get the keyName property: Name of the key.
     *
     * @return the keyName value.
     */
    public String keyName() {
        return this.keyName;
    }

    /**
     * Set the keyName property: Name of the key.
     *
     * @param keyName the keyName value to set.
     * @return the SharedAccessSignatureAuthorizationRuleInner object itself.
     */
    public SharedAccessSignatureAuthorizationRuleInner withKeyName(String keyName) {
        this.keyName = keyName;
        return this;
    }

    /**
     * Get the primaryKey property: Primary SAS key value.
     *
     * @return the primaryKey value.
     */
    public String primaryKey() {
        return this.primaryKey;
    }

    /**
     * Set the primaryKey property: Primary SAS key value.
     *
     * @param primaryKey the primaryKey value to set.
     * @return the SharedAccessSignatureAuthorizationRuleInner object itself.
     */
    public SharedAccessSignatureAuthorizationRuleInner withPrimaryKey(String primaryKey) {
        this.primaryKey = primaryKey;
        return this;
    }

    /**
     * Get the secondaryKey property: Secondary SAS key value.
     *
     * @return the secondaryKey value.
     */
    public String secondaryKey() {
        return this.secondaryKey;
    }

    /**
     * Set the secondaryKey property: Secondary SAS key value.
     *
     * @param secondaryKey the secondaryKey value to set.
     * @return the SharedAccessSignatureAuthorizationRuleInner object itself.
     */
    public SharedAccessSignatureAuthorizationRuleInner withSecondaryKey(String secondaryKey) {
        this.secondaryKey = secondaryKey;
        return this;
    }

    /**
     * Get the rights property: Rights that this key has.
     *
     * @return the rights value.
     */
    public AccessRightsDescription rights() {
        return this.rights;
    }

    /**
     * Set the rights property: Rights that this key has.
     *
     * @param rights the rights value to set.
     * @return the SharedAccessSignatureAuthorizationRuleInner object itself.
     */
    public SharedAccessSignatureAuthorizationRuleInner withRights(AccessRightsDescription rights) {
        this.rights = rights;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (keyName() == null) {
            throw logger
                .logExceptionAsError(
                    new IllegalArgumentException(
                        "Missing required property keyName in model SharedAccessSignatureAuthorizationRuleInner"));
        }
        if (rights() == null) {
            throw logger
                .logExceptionAsError(
                    new IllegalArgumentException(
                        "Missing required property rights in model SharedAccessSignatureAuthorizationRuleInner"));
        }
    }
}