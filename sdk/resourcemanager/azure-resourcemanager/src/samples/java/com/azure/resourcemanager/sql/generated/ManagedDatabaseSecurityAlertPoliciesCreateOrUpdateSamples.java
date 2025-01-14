// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.sql.generated;

import com.azure.core.util.Context;
import com.azure.resourcemanager.sql.models.SecurityAlertPolicyName;

/** Samples for ManagedDatabaseSecurityAlertPolicies CreateOrUpdate. */
public final class ManagedDatabaseSecurityAlertPoliciesCreateOrUpdateSamples {
    /*
     * x-ms-original-file: specification/sql/resource-manager/Microsoft.Sql/preview/2017-03-01-preview/examples/ManagedDatabaseSecurityAlertCreateMax.json
     */
    /**
     * Sample code: Update a database's threat detection policy with all parameters.
     *
     * @param azure The entry point for accessing resource management APIs in Azure.
     */
    public static void updateADatabaseSThreatDetectionPolicyWithAllParameters(
        com.azure.resourcemanager.AzureResourceManager azure) {
        azure
            .sqlServers()
            .manager()
            .serviceClient()
            .getManagedDatabaseSecurityAlertPolicies()
            .createOrUpdateWithResponse(
                "securityalert-4799",
                "securityalert-6440",
                "testdb",
                SecurityAlertPolicyName.DEFAULT,
                null,
                Context.NONE);
    }

    /*
     * x-ms-original-file: specification/sql/resource-manager/Microsoft.Sql/preview/2017-03-01-preview/examples/ManagedDatabaseSecurityAlertCreateMin.json
     */
    /**
     * Sample code: Update a database's threat detection policy with minimal parameters.
     *
     * @param azure The entry point for accessing resource management APIs in Azure.
     */
    public static void updateADatabaseSThreatDetectionPolicyWithMinimalParameters(
        com.azure.resourcemanager.AzureResourceManager azure) {
        azure
            .sqlServers()
            .manager()
            .serviceClient()
            .getManagedDatabaseSecurityAlertPolicies()
            .createOrUpdateWithResponse(
                "securityalert-4799",
                "securityalert-6440",
                "testdb",
                SecurityAlertPolicyName.DEFAULT,
                null,
                Context.NONE);
    }
}
