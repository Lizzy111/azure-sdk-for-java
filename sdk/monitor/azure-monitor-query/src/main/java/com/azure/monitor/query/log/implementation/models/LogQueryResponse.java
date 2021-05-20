// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.monitor.query.log.implementation.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

/** The LogQueryResponse model. */
@Fluent
public final class LogQueryResponse {
    /*
     * The id property.
     */
    @JsonProperty(value = "id")
    private String id;

    /*
     * The status property.
     */
    @JsonProperty(value = "status")
    private Integer status;

    /*
     * Contains the tables, columns & rows resulting from a query.
     */
    @JsonProperty(value = "body")
    private QueryResults body;

    @JsonProperty(value = "headers")
    private Map<String, String> responseHeaders;

    public Map<String, String> getResponseHeaders() {
        return responseHeaders;
    }

    public void setResponseHeaders(Map<String, String> responseHeaders) {
        this.responseHeaders = responseHeaders;
    }

    /**
     * Get the id property: The id property.
     *
     * @return the id value.
     */
    public String getId() {

        return this.id;
    }

    /**
     * Set the id property: The id property.
     *
     * @param id the id value to set.
     * @return the LogQueryResponse object itself.
     */
    public LogQueryResponse setId(String id) {
        this.id = id;
        return this;
    }

    /**
     * Get the status property: The status property.
     *
     * @return the status value.
     */
    public Integer getStatus() {
        return this.status;
    }

    /**
     * Set the status property: The status property.
     *
     * @param status the status value to set.
     * @return the LogQueryResponse object itself.
     */
    public LogQueryResponse setStatus(Integer status) {
        this.status = status;
        return this;
    }

    /**
     * Get the body property: Contains the tables, columns &amp; rows resulting from a query.
     *
     * @return the body value.
     */
    public QueryResults getBody() {
        return this.body;
    }

    /**
     * Set the body property: Contains the tables, columns &amp; rows resulting from a query.
     *
     * @param body the body value to set.
     * @return the LogQueryResponse object itself.
     */
    public LogQueryResponse setBody(QueryResults body) {
        this.body = body;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (getBody() != null) {
            getBody().validate();
        }
    }
}