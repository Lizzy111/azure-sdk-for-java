// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
//
// Code generated by Microsoft (R) AutoRest Code Generator.
// Changes may cause incorrect behavior and will be lost if the code is regenerated.

package com.azure.search.documents.indexes.implementation.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** The SkillNames model. */
@Fluent
public final class SkillNames {
    /*
     * the names of skills to be reset.
     */
    @JsonProperty(value = "skillNames")
    private List<String> skillNames;

    /**
     * Get the skillNames property: the names of skills to be reset.
     *
     * @return the skillNames value.
     */
    public List<String> getSkillNames() {
        return this.skillNames;
    }

    /**
     * Set the skillNames property: the names of skills to be reset.
     *
     * @param skillNames the skillNames value to set.
     * @return the SkillNames object itself.
     */
    public SkillNames setSkillNames(List<String> skillNames) {
        this.skillNames = skillNames;
        return this;
    }
}
