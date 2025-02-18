// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.network.fluent;

import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.http.rest.PagedFlux;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.management.polling.PollResult;
import com.azure.core.util.Context;
import com.azure.core.util.polling.PollerFlux;
import com.azure.core.util.polling.SyncPoller;
import com.azure.resourcemanager.network.fluent.models.NetworkManagerInner;
import com.azure.resourcemanager.network.models.PatchObject;
import com.azure.resourcemanager.resources.fluentcore.collection.InnerSupportsDelete;
import com.azure.resourcemanager.resources.fluentcore.collection.InnerSupportsGet;
import com.azure.resourcemanager.resources.fluentcore.collection.InnerSupportsListing;
import java.nio.ByteBuffer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/** An instance of this class provides access to all the operations defined in NetworkManagersClient. */
public interface NetworkManagersClient
    extends InnerSupportsGet<NetworkManagerInner>,
        InnerSupportsListing<NetworkManagerInner>,
        InnerSupportsDelete<Void> {
    /**
     * Gets the specified Network Manager.
     *
     * @param resourceGroupName The name of the resource group.
     * @param networkManagerName The name of the network manager.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the specified Network Manager along with {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<Response<NetworkManagerInner>> getByResourceGroupWithResponseAsync(
        String resourceGroupName, String networkManagerName);

    /**
     * Gets the specified Network Manager.
     *
     * @param resourceGroupName The name of the resource group.
     * @param networkManagerName The name of the network manager.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the specified Network Manager on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<NetworkManagerInner> getByResourceGroupAsync(String resourceGroupName, String networkManagerName);

    /**
     * Gets the specified Network Manager.
     *
     * @param resourceGroupName The name of the resource group.
     * @param networkManagerName The name of the network manager.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the specified Network Manager.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    NetworkManagerInner getByResourceGroup(String resourceGroupName, String networkManagerName);

    /**
     * Gets the specified Network Manager.
     *
     * @param resourceGroupName The name of the resource group.
     * @param networkManagerName The name of the network manager.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the specified Network Manager along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<NetworkManagerInner> getByResourceGroupWithResponse(
        String resourceGroupName, String networkManagerName, Context context);

    /**
     * Creates or updates a Network Manager.
     *
     * @param resourceGroupName The name of the resource group.
     * @param networkManagerName The name of the network manager.
     * @param parameters Parameters supplied to specify which network manager is.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the Managed Network resource along with {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<Response<NetworkManagerInner>> createOrUpdateWithResponseAsync(
        String resourceGroupName, String networkManagerName, NetworkManagerInner parameters);

    /**
     * Creates or updates a Network Manager.
     *
     * @param resourceGroupName The name of the resource group.
     * @param networkManagerName The name of the network manager.
     * @param parameters Parameters supplied to specify which network manager is.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the Managed Network resource on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<NetworkManagerInner> createOrUpdateAsync(
        String resourceGroupName, String networkManagerName, NetworkManagerInner parameters);

    /**
     * Creates or updates a Network Manager.
     *
     * @param resourceGroupName The name of the resource group.
     * @param networkManagerName The name of the network manager.
     * @param parameters Parameters supplied to specify which network manager is.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the Managed Network resource.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    NetworkManagerInner createOrUpdate(
        String resourceGroupName, String networkManagerName, NetworkManagerInner parameters);

    /**
     * Creates or updates a Network Manager.
     *
     * @param resourceGroupName The name of the resource group.
     * @param networkManagerName The name of the network manager.
     * @param parameters Parameters supplied to specify which network manager is.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the Managed Network resource along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<NetworkManagerInner> createOrUpdateWithResponse(
        String resourceGroupName, String networkManagerName, NetworkManagerInner parameters, Context context);

    /**
     * Deletes a network manager.
     *
     * @param resourceGroupName The name of the resource group.
     * @param networkManagerName The name of the network manager.
     * @param force Deletes the resource even if it is part of a deployed configuration. If the configuration has been
     *     deployed, the service will do a cleanup deployment in the background, prior to the delete.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<Response<Flux<ByteBuffer>>> deleteWithResponseAsync(
        String resourceGroupName, String networkManagerName, Boolean force);

    /**
     * Deletes a network manager.
     *
     * @param resourceGroupName The name of the resource group.
     * @param networkManagerName The name of the network manager.
     * @param force Deletes the resource even if it is part of a deployed configuration. If the configuration has been
     *     deployed, the service will do a cleanup deployment in the background, prior to the delete.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link PollerFlux} for polling of long-running operation.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    PollerFlux<PollResult<Void>, Void> beginDeleteAsync(
        String resourceGroupName, String networkManagerName, Boolean force);

    /**
     * Deletes a network manager.
     *
     * @param resourceGroupName The name of the resource group.
     * @param networkManagerName The name of the network manager.
     * @param force Deletes the resource even if it is part of a deployed configuration. If the configuration has been
     *     deployed, the service will do a cleanup deployment in the background, prior to the delete.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of long-running operation.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<Void>, Void> beginDelete(String resourceGroupName, String networkManagerName, Boolean force);

    /**
     * Deletes a network manager.
     *
     * @param resourceGroupName The name of the resource group.
     * @param networkManagerName The name of the network manager.
     * @param force Deletes the resource even if it is part of a deployed configuration. If the configuration has been
     *     deployed, the service will do a cleanup deployment in the background, prior to the delete.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of long-running operation.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<Void>, Void> beginDelete(
        String resourceGroupName, String networkManagerName, Boolean force, Context context);

    /**
     * Deletes a network manager.
     *
     * @param resourceGroupName The name of the resource group.
     * @param networkManagerName The name of the network manager.
     * @param force Deletes the resource even if it is part of a deployed configuration. If the configuration has been
     *     deployed, the service will do a cleanup deployment in the background, prior to the delete.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return A {@link Mono} that completes when a successful response is received.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<Void> deleteAsync(String resourceGroupName, String networkManagerName, Boolean force);

    /**
     * Deletes a network manager.
     *
     * @param resourceGroupName The name of the resource group.
     * @param networkManagerName The name of the network manager.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return A {@link Mono} that completes when a successful response is received.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<Void> deleteAsync(String resourceGroupName, String networkManagerName);

    /**
     * Deletes a network manager.
     *
     * @param resourceGroupName The name of the resource group.
     * @param networkManagerName The name of the network manager.
     * @param force Deletes the resource even if it is part of a deployed configuration. If the configuration has been
     *     deployed, the service will do a cleanup deployment in the background, prior to the delete.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    void delete(String resourceGroupName, String networkManagerName, Boolean force);

    /**
     * Deletes a network manager.
     *
     * @param resourceGroupName The name of the resource group.
     * @param networkManagerName The name of the network manager.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    void delete(String resourceGroupName, String networkManagerName);

    /**
     * Deletes a network manager.
     *
     * @param resourceGroupName The name of the resource group.
     * @param networkManagerName The name of the network manager.
     * @param force Deletes the resource even if it is part of a deployed configuration. If the configuration has been
     *     deployed, the service will do a cleanup deployment in the background, prior to the delete.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    void delete(String resourceGroupName, String networkManagerName, Boolean force, Context context);

    /**
     * Patch NetworkManager.
     *
     * @param resourceGroupName The name of the resource group.
     * @param networkManagerName The name of the network manager.
     * @param parameters Parameters supplied to specify which network manager is.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the Managed Network resource along with {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<Response<NetworkManagerInner>> patchWithResponseAsync(
        String resourceGroupName, String networkManagerName, PatchObject parameters);

    /**
     * Patch NetworkManager.
     *
     * @param resourceGroupName The name of the resource group.
     * @param networkManagerName The name of the network manager.
     * @param parameters Parameters supplied to specify which network manager is.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the Managed Network resource on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<NetworkManagerInner> patchAsync(String resourceGroupName, String networkManagerName, PatchObject parameters);

    /**
     * Patch NetworkManager.
     *
     * @param resourceGroupName The name of the resource group.
     * @param networkManagerName The name of the network manager.
     * @param parameters Parameters supplied to specify which network manager is.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the Managed Network resource.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    NetworkManagerInner patch(String resourceGroupName, String networkManagerName, PatchObject parameters);

    /**
     * Patch NetworkManager.
     *
     * @param resourceGroupName The name of the resource group.
     * @param networkManagerName The name of the network manager.
     * @param parameters Parameters supplied to specify which network manager is.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the Managed Network resource along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<NetworkManagerInner> patchWithResponse(
        String resourceGroupName, String networkManagerName, PatchObject parameters, Context context);

    /**
     * List all network managers in a subscription.
     *
     * @param top An optional query parameter which specifies the maximum number of records to be returned by the
     *     server.
     * @param skipToken SkipToken is only used if a previous operation returned a partial result. If a previous response
     *     contains a nextLink element, the value of the nextLink element will include a skipToken parameter that
     *     specifies a starting point to use for subsequent calls.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return result of the request to list NetworkManager as paginated response with {@link PagedFlux}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedFlux<NetworkManagerInner> listAsync(Integer top, String skipToken);

    /**
     * List all network managers in a subscription.
     *
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return result of the request to list NetworkManager as paginated response with {@link PagedFlux}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedFlux<NetworkManagerInner> listAsync();

    /**
     * List all network managers in a subscription.
     *
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return result of the request to list NetworkManager as paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<NetworkManagerInner> list();

    /**
     * List all network managers in a subscription.
     *
     * @param top An optional query parameter which specifies the maximum number of records to be returned by the
     *     server.
     * @param skipToken SkipToken is only used if a previous operation returned a partial result. If a previous response
     *     contains a nextLink element, the value of the nextLink element will include a skipToken parameter that
     *     specifies a starting point to use for subsequent calls.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return result of the request to list NetworkManager as paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<NetworkManagerInner> list(Integer top, String skipToken, Context context);

    /**
     * List network managers in a resource group.
     *
     * @param resourceGroupName The name of the resource group.
     * @param top An optional query parameter which specifies the maximum number of records to be returned by the
     *     server.
     * @param skipToken SkipToken is only used if a previous operation returned a partial result. If a previous response
     *     contains a nextLink element, the value of the nextLink element will include a skipToken parameter that
     *     specifies a starting point to use for subsequent calls.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return result of the request to list NetworkManager as paginated response with {@link PagedFlux}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedFlux<NetworkManagerInner> listByResourceGroupAsync(String resourceGroupName, Integer top, String skipToken);

    /**
     * List network managers in a resource group.
     *
     * @param resourceGroupName The name of the resource group.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return result of the request to list NetworkManager as paginated response with {@link PagedFlux}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedFlux<NetworkManagerInner> listByResourceGroupAsync(String resourceGroupName);

    /**
     * List network managers in a resource group.
     *
     * @param resourceGroupName The name of the resource group.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return result of the request to list NetworkManager as paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<NetworkManagerInner> listByResourceGroup(String resourceGroupName);

    /**
     * List network managers in a resource group.
     *
     * @param resourceGroupName The name of the resource group.
     * @param top An optional query parameter which specifies the maximum number of records to be returned by the
     *     server.
     * @param skipToken SkipToken is only used if a previous operation returned a partial result. If a previous response
     *     contains a nextLink element, the value of the nextLink element will include a skipToken parameter that
     *     specifies a starting point to use for subsequent calls.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return result of the request to list NetworkManager as paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<NetworkManagerInner> listByResourceGroup(
        String resourceGroupName, Integer top, String skipToken, Context context);
}
