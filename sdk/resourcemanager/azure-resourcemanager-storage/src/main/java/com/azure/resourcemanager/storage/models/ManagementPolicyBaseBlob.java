// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.storage.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;

/** Management policy action for base blob. */
@Fluent
public final class ManagementPolicyBaseBlob {
    /*
     * The function to tier blobs to cool storage. Support blobs currently at Hot tier
     */
    @JsonProperty(value = "tierToCool")
    private DateAfterModification tierToCool;

    /*
     * The function to tier blobs to archive storage. Support blobs currently at Hot or Cool tier
     */
    @JsonProperty(value = "tierToArchive")
    private DateAfterModification tierToArchive;

    /*
     * The function to delete the blob
     */
    @JsonProperty(value = "delete")
    private DateAfterModification delete;

    /*
     * This property enables auto tiering of a blob from cool to hot on a blob access. This property requires
     * tierToCool.daysAfterLastAccessTimeGreaterThan.
     */
    @JsonProperty(value = "enableAutoTierToHotFromCool")
    private Boolean enableAutoTierToHotFromCool;

    /**
     * Get the tierToCool property: The function to tier blobs to cool storage. Support blobs currently at Hot tier.
     *
     * @return the tierToCool value.
     */
    public DateAfterModification tierToCool() {
        return this.tierToCool;
    }

    /**
     * Set the tierToCool property: The function to tier blobs to cool storage. Support blobs currently at Hot tier.
     *
     * @param tierToCool the tierToCool value to set.
     * @return the ManagementPolicyBaseBlob object itself.
     */
    public ManagementPolicyBaseBlob withTierToCool(DateAfterModification tierToCool) {
        this.tierToCool = tierToCool;
        return this;
    }

    /**
     * Get the tierToArchive property: The function to tier blobs to archive storage. Support blobs currently at Hot or
     * Cool tier.
     *
     * @return the tierToArchive value.
     */
    public DateAfterModification tierToArchive() {
        return this.tierToArchive;
    }

    /**
     * Set the tierToArchive property: The function to tier blobs to archive storage. Support blobs currently at Hot or
     * Cool tier.
     *
     * @param tierToArchive the tierToArchive value to set.
     * @return the ManagementPolicyBaseBlob object itself.
     */
    public ManagementPolicyBaseBlob withTierToArchive(DateAfterModification tierToArchive) {
        this.tierToArchive = tierToArchive;
        return this;
    }

    /**
     * Get the delete property: The function to delete the blob.
     *
     * @return the delete value.
     */
    public DateAfterModification delete() {
        return this.delete;
    }

    /**
     * Set the delete property: The function to delete the blob.
     *
     * @param delete the delete value to set.
     * @return the ManagementPolicyBaseBlob object itself.
     */
    public ManagementPolicyBaseBlob withDelete(DateAfterModification delete) {
        this.delete = delete;
        return this;
    }

    /**
     * Get the enableAutoTierToHotFromCool property: This property enables auto tiering of a blob from cool to hot on a
     * blob access. This property requires tierToCool.daysAfterLastAccessTimeGreaterThan.
     *
     * @return the enableAutoTierToHotFromCool value.
     */
    public Boolean enableAutoTierToHotFromCool() {
        return this.enableAutoTierToHotFromCool;
    }

    /**
     * Set the enableAutoTierToHotFromCool property: This property enables auto tiering of a blob from cool to hot on a
     * blob access. This property requires tierToCool.daysAfterLastAccessTimeGreaterThan.
     *
     * @param enableAutoTierToHotFromCool the enableAutoTierToHotFromCool value to set.
     * @return the ManagementPolicyBaseBlob object itself.
     */
    public ManagementPolicyBaseBlob withEnableAutoTierToHotFromCool(Boolean enableAutoTierToHotFromCool) {
        this.enableAutoTierToHotFromCool = enableAutoTierToHotFromCool;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (tierToCool() != null) {
            tierToCool().validate();
        }
        if (tierToArchive() != null) {
            tierToArchive().validate();
        }
        if (delete() != null) {
            delete().validate();
        }
    }
}
