// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.nginx.implementation;

import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.SimpleResponse;
import com.azure.core.util.Context;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.nginx.fluent.CertificatesClient;
import com.azure.resourcemanager.nginx.fluent.models.NginxCertificateInner;
import com.azure.resourcemanager.nginx.models.Certificates;
import com.azure.resourcemanager.nginx.models.NginxCertificate;

public final class CertificatesImpl implements Certificates {
    private static final ClientLogger LOGGER = new ClientLogger(CertificatesImpl.class);

    private final CertificatesClient innerClient;

    private final com.azure.resourcemanager.nginx.NginxManager serviceManager;

    public CertificatesImpl(
        CertificatesClient innerClient, com.azure.resourcemanager.nginx.NginxManager serviceManager) {
        this.innerClient = innerClient;
        this.serviceManager = serviceManager;
    }

    public NginxCertificate get(String resourceGroupName, String deploymentName, String certificateName) {
        NginxCertificateInner inner = this.serviceClient().get(resourceGroupName, deploymentName, certificateName);
        if (inner != null) {
            return new NginxCertificateImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public Response<NginxCertificate> getWithResponse(
        String resourceGroupName, String deploymentName, String certificateName, Context context) {
        Response<NginxCertificateInner> inner =
            this.serviceClient().getWithResponse(resourceGroupName, deploymentName, certificateName, context);
        if (inner != null) {
            return new SimpleResponse<>(
                inner.getRequest(),
                inner.getStatusCode(),
                inner.getHeaders(),
                new NginxCertificateImpl(inner.getValue(), this.manager()));
        } else {
            return null;
        }
    }

    public void delete(String resourceGroupName, String deploymentName, String certificateName) {
        this.serviceClient().delete(resourceGroupName, deploymentName, certificateName);
    }

    public void delete(String resourceGroupName, String deploymentName, String certificateName, Context context) {
        this.serviceClient().delete(resourceGroupName, deploymentName, certificateName, context);
    }

    public PagedIterable<NginxCertificate> list(String resourceGroupName, String deploymentName) {
        PagedIterable<NginxCertificateInner> inner = this.serviceClient().list(resourceGroupName, deploymentName);
        return Utils.mapPage(inner, inner1 -> new NginxCertificateImpl(inner1, this.manager()));
    }

    public PagedIterable<NginxCertificate> list(String resourceGroupName, String deploymentName, Context context) {
        PagedIterable<NginxCertificateInner> inner =
            this.serviceClient().list(resourceGroupName, deploymentName, context);
        return Utils.mapPage(inner, inner1 -> new NginxCertificateImpl(inner1, this.manager()));
    }

    public NginxCertificate getById(String id) {
        String resourceGroupName = Utils.getValueFromIdByName(id, "resourceGroups");
        if (resourceGroupName == null) {
            throw LOGGER
                .logExceptionAsError(
                    new IllegalArgumentException(
                        String
                            .format("The resource ID '%s' is not valid. Missing path segment 'resourceGroups'.", id)));
        }
        String deploymentName = Utils.getValueFromIdByName(id, "nginxDeployments");
        if (deploymentName == null) {
            throw LOGGER
                .logExceptionAsError(
                    new IllegalArgumentException(
                        String
                            .format(
                                "The resource ID '%s' is not valid. Missing path segment 'nginxDeployments'.", id)));
        }
        String certificateName = Utils.getValueFromIdByName(id, "certificates");
        if (certificateName == null) {
            throw LOGGER
                .logExceptionAsError(
                    new IllegalArgumentException(
                        String.format("The resource ID '%s' is not valid. Missing path segment 'certificates'.", id)));
        }
        return this.getWithResponse(resourceGroupName, deploymentName, certificateName, Context.NONE).getValue();
    }

    public Response<NginxCertificate> getByIdWithResponse(String id, Context context) {
        String resourceGroupName = Utils.getValueFromIdByName(id, "resourceGroups");
        if (resourceGroupName == null) {
            throw LOGGER
                .logExceptionAsError(
                    new IllegalArgumentException(
                        String
                            .format("The resource ID '%s' is not valid. Missing path segment 'resourceGroups'.", id)));
        }
        String deploymentName = Utils.getValueFromIdByName(id, "nginxDeployments");
        if (deploymentName == null) {
            throw LOGGER
                .logExceptionAsError(
                    new IllegalArgumentException(
                        String
                            .format(
                                "The resource ID '%s' is not valid. Missing path segment 'nginxDeployments'.", id)));
        }
        String certificateName = Utils.getValueFromIdByName(id, "certificates");
        if (certificateName == null) {
            throw LOGGER
                .logExceptionAsError(
                    new IllegalArgumentException(
                        String.format("The resource ID '%s' is not valid. Missing path segment 'certificates'.", id)));
        }
        return this.getWithResponse(resourceGroupName, deploymentName, certificateName, context);
    }

    public void deleteById(String id) {
        String resourceGroupName = Utils.getValueFromIdByName(id, "resourceGroups");
        if (resourceGroupName == null) {
            throw LOGGER
                .logExceptionAsError(
                    new IllegalArgumentException(
                        String
                            .format("The resource ID '%s' is not valid. Missing path segment 'resourceGroups'.", id)));
        }
        String deploymentName = Utils.getValueFromIdByName(id, "nginxDeployments");
        if (deploymentName == null) {
            throw LOGGER
                .logExceptionAsError(
                    new IllegalArgumentException(
                        String
                            .format(
                                "The resource ID '%s' is not valid. Missing path segment 'nginxDeployments'.", id)));
        }
        String certificateName = Utils.getValueFromIdByName(id, "certificates");
        if (certificateName == null) {
            throw LOGGER
                .logExceptionAsError(
                    new IllegalArgumentException(
                        String.format("The resource ID '%s' is not valid. Missing path segment 'certificates'.", id)));
        }
        this.delete(resourceGroupName, deploymentName, certificateName, Context.NONE);
    }

    public void deleteByIdWithResponse(String id, Context context) {
        String resourceGroupName = Utils.getValueFromIdByName(id, "resourceGroups");
        if (resourceGroupName == null) {
            throw LOGGER
                .logExceptionAsError(
                    new IllegalArgumentException(
                        String
                            .format("The resource ID '%s' is not valid. Missing path segment 'resourceGroups'.", id)));
        }
        String deploymentName = Utils.getValueFromIdByName(id, "nginxDeployments");
        if (deploymentName == null) {
            throw LOGGER
                .logExceptionAsError(
                    new IllegalArgumentException(
                        String
                            .format(
                                "The resource ID '%s' is not valid. Missing path segment 'nginxDeployments'.", id)));
        }
        String certificateName = Utils.getValueFromIdByName(id, "certificates");
        if (certificateName == null) {
            throw LOGGER
                .logExceptionAsError(
                    new IllegalArgumentException(
                        String.format("The resource ID '%s' is not valid. Missing path segment 'certificates'.", id)));
        }
        this.delete(resourceGroupName, deploymentName, certificateName, context);
    }

    private CertificatesClient serviceClient() {
        return this.innerClient;
    }

    private com.azure.resourcemanager.nginx.NginxManager manager() {
        return this.serviceManager;
    }

    public NginxCertificateImpl define(String name) {
        return new NginxCertificateImpl(name, this.manager());
    }
}
