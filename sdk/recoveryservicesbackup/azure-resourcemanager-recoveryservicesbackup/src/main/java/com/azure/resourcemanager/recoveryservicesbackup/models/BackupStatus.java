// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.recoveryservicesbackup.models;

import com.azure.core.http.rest.Response;
import com.azure.core.util.Context;

/** Resource collection API of BackupStatus. */
public interface BackupStatus {
    /**
     * Get the container backup status.
     *
     * @param azureRegion Azure region to hit Api.
     * @param parameters Container Backup Status Request.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the container backup status.
     */
    BackupStatusResponse get(String azureRegion, BackupStatusRequest parameters);

    /**
     * Get the container backup status.
     *
     * @param azureRegion Azure region to hit Api.
     * @param parameters Container Backup Status Request.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the container backup status.
     */
    Response<BackupStatusResponse> getWithResponse(String azureRegion, BackupStatusRequest parameters, Context context);
}