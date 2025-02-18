// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.network.generated;

import com.azure.core.util.Context;

/** Samples for AvailableEndpointServices List. */
public final class AvailableEndpointServicesListSamples {
    /*
     * x-ms-original-file: specification/network/resource-manager/Microsoft.Network/stable/2022-01-01/examples/EndpointServicesList.json
     */
    /**
     * Sample code: EndpointServicesList.
     *
     * @param azure The entry point for accessing resource management APIs in Azure.
     */
    public static void endpointServicesList(com.azure.resourcemanager.AzureResourceManager azure) {
        azure.networks().manager().serviceClient().getAvailableEndpointServices().list("westus", Context.NONE);
    }
}
