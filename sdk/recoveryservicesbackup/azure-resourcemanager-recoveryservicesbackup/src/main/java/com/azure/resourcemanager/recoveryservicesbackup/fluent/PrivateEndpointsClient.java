// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.recoveryservicesbackup.fluent;

import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.http.rest.Response;
import com.azure.core.util.Context;
import com.azure.resourcemanager.recoveryservicesbackup.fluent.models.OperationStatusInner;

/** An instance of this class provides access to all the operations defined in PrivateEndpointsClient. */
public interface PrivateEndpointsClient {
    /**
     * Gets the operation status for a private endpoint connection.
     *
     * @param vaultName The name of the recovery services vault.
     * @param resourceGroupName The name of the resource group where the recovery services vault is present.
     * @param privateEndpointConnectionName The name of the private endpoint connection.
     * @param operationId Operation id.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the operation status for a private endpoint connection.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    OperationStatusInner getOperationStatus(
        String vaultName, String resourceGroupName, String privateEndpointConnectionName, String operationId);

    /**
     * Gets the operation status for a private endpoint connection.
     *
     * @param vaultName The name of the recovery services vault.
     * @param resourceGroupName The name of the resource group where the recovery services vault is present.
     * @param privateEndpointConnectionName The name of the private endpoint connection.
     * @param operationId Operation id.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the operation status for a private endpoint connection.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<OperationStatusInner> getOperationStatusWithResponse(
        String vaultName,
        String resourceGroupName,
        String privateEndpointConnectionName,
        String operationId,
        Context context);
}