// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.appplatform.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

/** Build resource properties payload. */
@Fluent
public final class BuildProperties {
    /*
     * The relative path of source code
     */
    @JsonProperty(value = "relativePath")
    private String relativePath;

    /*
     * The resource id of builder to build the source code
     */
    @JsonProperty(value = "builder")
    private String builder;

    /*
     * The resource id of agent pool
     */
    @JsonProperty(value = "agentPool")
    private String agentPool;

    /*
     * Provisioning state of the KPack build result
     */
    @JsonProperty(value = "provisioningState", access = JsonProperty.Access.WRITE_ONLY)
    private BuildProvisioningState provisioningState;

    /*
     * The environment variables for this build
     */
    @JsonProperty(value = "env")
    @JsonInclude(value = JsonInclude.Include.NON_NULL, content = JsonInclude.Include.ALWAYS)
    private Map<String, String> env;

    /*
     * The build result triggered by this build
     */
    @JsonProperty(value = "triggeredBuildResult", access = JsonProperty.Access.WRITE_ONLY)
    private TriggeredBuildResult triggeredBuildResult;

    /**
     * Get the relativePath property: The relative path of source code.
     *
     * @return the relativePath value.
     */
    public String relativePath() {
        return this.relativePath;
    }

    /**
     * Set the relativePath property: The relative path of source code.
     *
     * @param relativePath the relativePath value to set.
     * @return the BuildProperties object itself.
     */
    public BuildProperties withRelativePath(String relativePath) {
        this.relativePath = relativePath;
        return this;
    }

    /**
     * Get the builder property: The resource id of builder to build the source code.
     *
     * @return the builder value.
     */
    public String builder() {
        return this.builder;
    }

    /**
     * Set the builder property: The resource id of builder to build the source code.
     *
     * @param builder the builder value to set.
     * @return the BuildProperties object itself.
     */
    public BuildProperties withBuilder(String builder) {
        this.builder = builder;
        return this;
    }

    /**
     * Get the agentPool property: The resource id of agent pool.
     *
     * @return the agentPool value.
     */
    public String agentPool() {
        return this.agentPool;
    }

    /**
     * Set the agentPool property: The resource id of agent pool.
     *
     * @param agentPool the agentPool value to set.
     * @return the BuildProperties object itself.
     */
    public BuildProperties withAgentPool(String agentPool) {
        this.agentPool = agentPool;
        return this;
    }

    /**
     * Get the provisioningState property: Provisioning state of the KPack build result.
     *
     * @return the provisioningState value.
     */
    public BuildProvisioningState provisioningState() {
        return this.provisioningState;
    }

    /**
     * Get the env property: The environment variables for this build.
     *
     * @return the env value.
     */
    public Map<String, String> env() {
        return this.env;
    }

    /**
     * Set the env property: The environment variables for this build.
     *
     * @param env the env value to set.
     * @return the BuildProperties object itself.
     */
    public BuildProperties withEnv(Map<String, String> env) {
        this.env = env;
        return this;
    }

    /**
     * Get the triggeredBuildResult property: The build result triggered by this build.
     *
     * @return the triggeredBuildResult value.
     */
    public TriggeredBuildResult triggeredBuildResult() {
        return this.triggeredBuildResult;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (triggeredBuildResult() != null) {
            triggeredBuildResult().validate();
        }
    }
}
