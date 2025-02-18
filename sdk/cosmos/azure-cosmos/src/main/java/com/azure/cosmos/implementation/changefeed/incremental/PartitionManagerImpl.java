// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
package com.azure.cosmos.implementation.changefeed.incremental;

import com.azure.cosmos.implementation.changefeed.Bootstrapper;
import com.azure.cosmos.implementation.changefeed.PartitionController;
import com.azure.cosmos.implementation.changefeed.PartitionLoadBalancer;
import com.azure.cosmos.implementation.changefeed.PartitionManager;
import reactor.core.publisher.Mono;

/**
 * Implementation for {@link PartitionManager}.
 */
class PartitionManagerImpl implements PartitionManager {
    private final Bootstrapper bootstrapper;
    private final PartitionController partitionController;
    private final PartitionLoadBalancer partitionLoadBalancer;

    public PartitionManagerImpl(Bootstrapper bootstrapper, PartitionController partitionController, PartitionLoadBalancer partitionLoadBalancer) {
        this.bootstrapper = bootstrapper;
        this.partitionController = partitionController;
        this.partitionLoadBalancer = partitionLoadBalancer;
    }

    @Override
    public Mono<Void> start() {
        return this.bootstrapper.initialize()
            .then(this.partitionController.initialize())
            .then(this.partitionLoadBalancer.start());
    }

    @Override
    public Mono<Void> stop() {
        return this.partitionLoadBalancer.stop();
    }

    @Override
    public boolean isRunning() {
        return this.partitionLoadBalancer.isRunning();
    }
}
