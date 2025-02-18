// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.maps.search.implementation.models;

import com.azure.core.annotation.Immutable;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

/** A valid `GeoJSON` object. Please refer to [RFC 7946](https://tools.ietf.org/html/rfc7946#section-3) for details. */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type",
        defaultImpl = GeoJsonObject.class)
@JsonTypeName("GeoJsonObject")
@JsonSubTypes({
    @JsonSubTypes.Type(name = "GeoJsonGeometry", value = GeoJsonGeometry.class),
    @JsonSubTypes.Type(name = "Feature", value = GeoJsonFeature.class),
    @JsonSubTypes.Type(name = "FeatureCollection", value = GeoJsonFeatureCollection.class)
})
@Immutable
public class GeoJsonObject {}
