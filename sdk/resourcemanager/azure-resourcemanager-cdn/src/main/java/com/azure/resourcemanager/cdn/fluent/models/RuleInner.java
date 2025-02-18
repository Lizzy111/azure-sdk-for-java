// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.cdn.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.management.ProxyResource;
import com.azure.core.management.SystemData;
import com.azure.resourcemanager.cdn.models.AfdProvisioningState;
import com.azure.resourcemanager.cdn.models.DeliveryRuleAction;
import com.azure.resourcemanager.cdn.models.DeliveryRuleCondition;
import com.azure.resourcemanager.cdn.models.DeploymentStatus;
import com.azure.resourcemanager.cdn.models.MatchProcessingBehavior;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** Friendly Rules name mapping to the any Rules or secret related information. */
@Fluent
public final class RuleInner extends ProxyResource {
    /*
     * The JSON object that contains the properties of the Rules to create.
     */
    @JsonProperty(value = "properties")
    private RuleProperties innerProperties;

    /*
     * Read only system data
     */
    @JsonProperty(value = "systemData", access = JsonProperty.Access.WRITE_ONLY)
    private SystemData systemData;

    /**
     * Get the innerProperties property: The JSON object that contains the properties of the Rules to create.
     *
     * @return the innerProperties value.
     */
    private RuleProperties innerProperties() {
        return this.innerProperties;
    }

    /**
     * Get the systemData property: Read only system data.
     *
     * @return the systemData value.
     */
    public SystemData systemData() {
        return this.systemData;
    }

    /**
     * Get the provisioningState property: Provisioning status.
     *
     * @return the provisioningState value.
     */
    public AfdProvisioningState provisioningState() {
        return this.innerProperties() == null ? null : this.innerProperties().provisioningState();
    }

    /**
     * Get the deploymentStatus property: The deploymentStatus property.
     *
     * @return the deploymentStatus value.
     */
    public DeploymentStatus deploymentStatus() {
        return this.innerProperties() == null ? null : this.innerProperties().deploymentStatus();
    }

    /**
     * Get the ruleSetName property: The name of the rule set containing the rule.
     *
     * @return the ruleSetName value.
     */
    public String ruleSetName() {
        return this.innerProperties() == null ? null : this.innerProperties().ruleSetName();
    }

    /**
     * Get the order property: The order in which the rules are applied for the endpoint. Possible values {0,1,2,3,………}.
     * A rule with a lesser order will be applied before a rule with a greater order. Rule with order 0 is a special
     * rule. It does not require any condition and actions listed in it will always be applied.
     *
     * @return the order value.
     */
    public Integer order() {
        return this.innerProperties() == null ? null : this.innerProperties().order();
    }

    /**
     * Set the order property: The order in which the rules are applied for the endpoint. Possible values {0,1,2,3,………}.
     * A rule with a lesser order will be applied before a rule with a greater order. Rule with order 0 is a special
     * rule. It does not require any condition and actions listed in it will always be applied.
     *
     * @param order the order value to set.
     * @return the RuleInner object itself.
     */
    public RuleInner withOrder(Integer order) {
        if (this.innerProperties() == null) {
            this.innerProperties = new RuleProperties();
        }
        this.innerProperties().withOrder(order);
        return this;
    }

    /**
     * Get the conditions property: A list of conditions that must be matched for the actions to be executed.
     *
     * @return the conditions value.
     */
    public List<DeliveryRuleCondition> conditions() {
        return this.innerProperties() == null ? null : this.innerProperties().conditions();
    }

    /**
     * Set the conditions property: A list of conditions that must be matched for the actions to be executed.
     *
     * @param conditions the conditions value to set.
     * @return the RuleInner object itself.
     */
    public RuleInner withConditions(List<DeliveryRuleCondition> conditions) {
        if (this.innerProperties() == null) {
            this.innerProperties = new RuleProperties();
        }
        this.innerProperties().withConditions(conditions);
        return this;
    }

    /**
     * Get the actions property: A list of actions that are executed when all the conditions of a rule are satisfied.
     *
     * @return the actions value.
     */
    public List<DeliveryRuleAction> actions() {
        return this.innerProperties() == null ? null : this.innerProperties().actions();
    }

    /**
     * Set the actions property: A list of actions that are executed when all the conditions of a rule are satisfied.
     *
     * @param actions the actions value to set.
     * @return the RuleInner object itself.
     */
    public RuleInner withActions(List<DeliveryRuleAction> actions) {
        if (this.innerProperties() == null) {
            this.innerProperties = new RuleProperties();
        }
        this.innerProperties().withActions(actions);
        return this;
    }

    /**
     * Get the matchProcessingBehavior property: If this rule is a match should the rules engine continue running the
     * remaining rules or stop. If not present, defaults to Continue.
     *
     * @return the matchProcessingBehavior value.
     */
    public MatchProcessingBehavior matchProcessingBehavior() {
        return this.innerProperties() == null ? null : this.innerProperties().matchProcessingBehavior();
    }

    /**
     * Set the matchProcessingBehavior property: If this rule is a match should the rules engine continue running the
     * remaining rules or stop. If not present, defaults to Continue.
     *
     * @param matchProcessingBehavior the matchProcessingBehavior value to set.
     * @return the RuleInner object itself.
     */
    public RuleInner withMatchProcessingBehavior(MatchProcessingBehavior matchProcessingBehavior) {
        if (this.innerProperties() == null) {
            this.innerProperties = new RuleProperties();
        }
        this.innerProperties().withMatchProcessingBehavior(matchProcessingBehavior);
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (innerProperties() != null) {
            innerProperties().validate();
        }
    }
}
