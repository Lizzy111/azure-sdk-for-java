// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.network.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.management.SubResource;
import com.azure.resourcemanager.network.models.ExpressRoutePortsEncapsulation;
import com.azure.resourcemanager.network.models.ProvisioningState;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * ExpressRoutePort Properties
 *
 * <p>Properties specific to ExpressRoutePort resources.
 */
@Fluent
public final class ExpressRoutePortPropertiesFormat {
    /*
     * The name of the peering location that the ExpressRoutePort is mapped to physically.
     */
    @JsonProperty(value = "peeringLocation")
    private String peeringLocation;

    /*
     * Bandwidth of procured ports in Gbps.
     */
    @JsonProperty(value = "bandwidthInGbps")
    private Integer bandwidthInGbps;

    /*
     * Aggregate Gbps of associated circuit bandwidths.
     */
    @JsonProperty(value = "provisionedBandwidthInGbps", access = JsonProperty.Access.WRITE_ONLY)
    private Float provisionedBandwidthInGbps;

    /*
     * Maximum transmission unit of the physical port pair(s).
     */
    @JsonProperty(value = "mtu", access = JsonProperty.Access.WRITE_ONLY)
    private String mtu;

    /*
     * Encapsulation method on physical ports.
     */
    @JsonProperty(value = "encapsulation")
    private ExpressRoutePortsEncapsulation encapsulation;

    /*
     * Ether type of the physical port.
     */
    @JsonProperty(value = "etherType", access = JsonProperty.Access.WRITE_ONLY)
    private String etherType;

    /*
     * Date of the physical port allocation to be used in Letter of Authorization.
     */
    @JsonProperty(value = "allocationDate", access = JsonProperty.Access.WRITE_ONLY)
    private String allocationDate;

    /*
     * ExpressRouteLink Sub-Resources
     *
     * The set of physical links of the ExpressRoutePort resource.
     */
    @JsonProperty(value = "links")
    private List<ExpressRouteLinkInner> links;

    /*
     * Reference the ExpressRoute circuit(s) that are provisioned on this ExpressRoutePort resource.
     */
    @JsonProperty(value = "circuits", access = JsonProperty.Access.WRITE_ONLY)
    private List<SubResource> circuits;

    /*
     * The provisioning state of the express route port resource.
     */
    @JsonProperty(value = "provisioningState", access = JsonProperty.Access.WRITE_ONLY)
    private ProvisioningState provisioningState;

    /*
     * The resource GUID property of the express route port resource.
     */
    @JsonProperty(value = "resourceGuid", access = JsonProperty.Access.WRITE_ONLY)
    private String resourceGuid;

    /**
     * Get the peeringLocation property: The name of the peering location that the ExpressRoutePort is mapped to
     * physically.
     *
     * @return the peeringLocation value.
     */
    public String peeringLocation() {
        return this.peeringLocation;
    }

    /**
     * Set the peeringLocation property: The name of the peering location that the ExpressRoutePort is mapped to
     * physically.
     *
     * @param peeringLocation the peeringLocation value to set.
     * @return the ExpressRoutePortPropertiesFormat object itself.
     */
    public ExpressRoutePortPropertiesFormat withPeeringLocation(String peeringLocation) {
        this.peeringLocation = peeringLocation;
        return this;
    }

    /**
     * Get the bandwidthInGbps property: Bandwidth of procured ports in Gbps.
     *
     * @return the bandwidthInGbps value.
     */
    public Integer bandwidthInGbps() {
        return this.bandwidthInGbps;
    }

    /**
     * Set the bandwidthInGbps property: Bandwidth of procured ports in Gbps.
     *
     * @param bandwidthInGbps the bandwidthInGbps value to set.
     * @return the ExpressRoutePortPropertiesFormat object itself.
     */
    public ExpressRoutePortPropertiesFormat withBandwidthInGbps(Integer bandwidthInGbps) {
        this.bandwidthInGbps = bandwidthInGbps;
        return this;
    }

    /**
     * Get the provisionedBandwidthInGbps property: Aggregate Gbps of associated circuit bandwidths.
     *
     * @return the provisionedBandwidthInGbps value.
     */
    public Float provisionedBandwidthInGbps() {
        return this.provisionedBandwidthInGbps;
    }

    /**
     * Get the mtu property: Maximum transmission unit of the physical port pair(s).
     *
     * @return the mtu value.
     */
    public String mtu() {
        return this.mtu;
    }

    /**
     * Get the encapsulation property: Encapsulation method on physical ports.
     *
     * @return the encapsulation value.
     */
    public ExpressRoutePortsEncapsulation encapsulation() {
        return this.encapsulation;
    }

    /**
     * Set the encapsulation property: Encapsulation method on physical ports.
     *
     * @param encapsulation the encapsulation value to set.
     * @return the ExpressRoutePortPropertiesFormat object itself.
     */
    public ExpressRoutePortPropertiesFormat withEncapsulation(ExpressRoutePortsEncapsulation encapsulation) {
        this.encapsulation = encapsulation;
        return this;
    }

    /**
     * Get the etherType property: Ether type of the physical port.
     *
     * @return the etherType value.
     */
    public String etherType() {
        return this.etherType;
    }

    /**
     * Get the allocationDate property: Date of the physical port allocation to be used in Letter of Authorization.
     *
     * @return the allocationDate value.
     */
    public String allocationDate() {
        return this.allocationDate;
    }

    /**
     * Get the links property: ExpressRouteLink Sub-Resources
     *
     * <p>The set of physical links of the ExpressRoutePort resource.
     *
     * @return the links value.
     */
    public List<ExpressRouteLinkInner> links() {
        return this.links;
    }

    /**
     * Set the links property: ExpressRouteLink Sub-Resources
     *
     * <p>The set of physical links of the ExpressRoutePort resource.
     *
     * @param links the links value to set.
     * @return the ExpressRoutePortPropertiesFormat object itself.
     */
    public ExpressRoutePortPropertiesFormat withLinks(List<ExpressRouteLinkInner> links) {
        this.links = links;
        return this;
    }

    /**
     * Get the circuits property: Reference the ExpressRoute circuit(s) that are provisioned on this ExpressRoutePort
     * resource.
     *
     * @return the circuits value.
     */
    public List<SubResource> circuits() {
        return this.circuits;
    }

    /**
     * Get the provisioningState property: The provisioning state of the express route port resource.
     *
     * @return the provisioningState value.
     */
    public ProvisioningState provisioningState() {
        return this.provisioningState;
    }

    /**
     * Get the resourceGuid property: The resource GUID property of the express route port resource.
     *
     * @return the resourceGuid value.
     */
    public String resourceGuid() {
        return this.resourceGuid;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (links() != null) {
            links().forEach(e -> e.validate());
        }
    }
}
