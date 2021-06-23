// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.verticals.agrifood.farming;

import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceClient;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.experimental.http.DynamicRequest;
import com.azure.core.http.HttpMethod;
import com.azure.core.http.HttpPipeline;
import com.azure.core.util.serializer.ObjectSerializer;

/** Initializes a new instance of the WeatherBaseClient type. */
@ServiceClient(builder = FarmBeatsClientBuilder.class)
public final class WeatherBaseClient {
    private final String endpoint;

    private final String apiVersion;

    private final HttpPipeline httpPipeline;

    private final ObjectSerializer serializer;

    /**
     * Initializes an instance of WeatherBaseClient client.
     *
     * @param endpoint The endpoint of your FarmBeats resource (protocol and hostname, for example:
     *     https://{resourceName}.farmbeats.azure.net).
     * @param apiVersion Api Version.
     * @param httpPipeline The HTTP pipeline to send requests through.
     * @param serializer The serializer to serialize an object into a string.
     */
    WeatherBaseClient(String endpoint, String apiVersion, HttpPipeline httpPipeline, ObjectSerializer serializer) {
        this.endpoint = endpoint;
        this.apiVersion = apiVersion;
        this.httpPipeline = httpPipeline;
        this.serializer = serializer;
    }

    /**
     * Returns a paginated list of weather data.
     *
     * <p><strong>Optional Query Parameters</strong>
     *
     * <table border="1">
     *     <caption>Optional Query Parameters</caption>
     *     <tr><th>Name</th><th>Type</th><th>Description</th></tr>
     *     <tr><td>startDateTime</td><td>OffsetDateTime</td><td>Weather data start UTC date-time (inclusive), sample format: yyyy-MM-ddTHH:mm:ssZ.</td></tr>
     *     <tr><td>endDateTime</td><td>OffsetDateTime</td><td>Weather data end UTC date-time (inclusive), sample format: yyyy-MM-ddTHH:mm:ssZ.</td></tr>
     *     <tr><td>maxPageSize</td><td>Integer</td><td>Maximum number of items needed (inclusive).
     * Minimum = 10, Maximum = 1000, Default value = 50.</td></tr>
     *     <tr><td>skipToken</td><td>String</td><td>Skip token for getting next set of results.</td></tr>
     * </table>
     *
     * <p><strong>Response Body Schema</strong>
     *
     * <pre>{@code
     * {
     *     value: [
     *         {
     *             farmerId: String
     *             boundaryId: String
     *             extensionId: String
     *             location: {
     *                 latitude: double
     *                 longitude: double
     *             }
     *             dateTime: OffsetDateTime
     *             unitSystemCode: String
     *             extensionVersion: String
     *             weatherDataType: String
     *             granularity: String
     *             cloudCover: {
     *                 unit: String
     *                 value: Double
     *             }
     *             dewPoint: (recursive schema, see dewPoint above)
     *             growingDegreeDay: (recursive schema, see growingDegreeDay above)
     *             precipitation: (recursive schema, see precipitation above)
     *             pressure: (recursive schema, see pressure above)
     *             relativeHumidity: (recursive schema, see relativeHumidity above)
     *             soilMoisture: (recursive schema, see soilMoisture above)
     *             soilTemperature: (recursive schema, see soilTemperature above)
     *             temperature: (recursive schema, see temperature above)
     *             visibility: (recursive schema, see visibility above)
     *             wetBulbTemperature: (recursive schema, see wetBulbTemperature above)
     *             windChill: (recursive schema, see windChill above)
     *             windDirection: (recursive schema, see windDirection above)
     *             windGust: (recursive schema, see windGust above)
     *             windSpeed: (recursive schema, see windSpeed above)
     *             id: String
     *             eTag: String
     *             createdDateTime: OffsetDateTime
     *             modifiedDateTime: OffsetDateTime
     *             properties: {
     *                 String: Object
     *             }
     *         }
     *     ]
     *     skipToken: String
     *     nextLink: String
     * }
     * }</pre>
     *
     * @param farmerId Farmer ID.
     * @param boundaryId Boundary ID.
     * @param extensionId ID of the weather extension.
     * @param weatherDataType Type of weather data (forecast/historical).
     * @param granularity Granularity of weather data (daily/hourly).
     * @return a DynamicRequest where customizations can be made before sent to the service.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public DynamicRequest list(
            String farmerId, String boundaryId, String extensionId, String weatherDataType, String granularity) {
        return new DynamicRequest(serializer, httpPipeline)
                .setUrl("{Endpoint}/weather")
                .setPathParam("Endpoint", endpoint)
                .addQueryParam("farmerId", farmerId)
                .addQueryParam("boundaryId", boundaryId)
                .addQueryParam("extensionId", extensionId)
                .addQueryParam("weatherDataType", weatherDataType)
                .addQueryParam("granularity", granularity)
                .addQueryParam("api-version", apiVersion)
                .addHeader("Accept", "application/json")
                .addHeader("Content-Type", "application/json")
                .setHttpMethod(HttpMethod.GET);
    }

    /**
     * Get weather ingestion job.
     *
     * <p><strong>Response Body Schema</strong>
     *
     * <pre>{@code
     * {
     *     boundaryId: String
     *     farmerId: String
     *     extensionId: String
     *     extensionApiName: String
     *     extensionApiInput: {
     *         String: Object
     *     }
     *     extensionDataProviderAppId: String
     *     extensionDataProviderApiKey: String
     *     id: String
     *     status: String
     *     durationInSeconds: Double
     *     message: String
     *     createdDateTime: OffsetDateTime
     *     lastActionDateTime: OffsetDateTime
     *     startTime: OffsetDateTime
     *     endTime: OffsetDateTime
     *     name: String
     *     description: String
     *     properties: {
     *         String: Object
     *     }
     * }
     * }</pre>
     *
     * @param jobId ID of the job.
     * @return a DynamicRequest where customizations can be made before sent to the service.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public DynamicRequest getDataIngestionJobDetails(String jobId) {
        return new DynamicRequest(serializer, httpPipeline)
                .setUrl("{Endpoint}/weather/ingest-data/{jobId}")
                .setPathParam("Endpoint", endpoint)
                .setPathParam("jobId", jobId)
                .addQueryParam("api-version", apiVersion)
                .addHeader("Accept", "application/json")
                .addHeader("Content-Type", "application/json")
                .setHttpMethod(HttpMethod.GET);
    }

    /**
     * Create a weather data ingestion job.
     *
     * <p><strong>Request Body Schema</strong>
     *
     * <pre>{@code
     * {
     *     boundaryId: String
     *     farmerId: String
     *     extensionId: String
     *     extensionApiName: String
     *     extensionApiInput: {
     *         String: Object
     *     }
     *     extensionDataProviderAppId: String
     *     extensionDataProviderApiKey: String
     *     id: String
     *     status: String
     *     durationInSeconds: Double
     *     message: String
     *     createdDateTime: OffsetDateTime
     *     lastActionDateTime: OffsetDateTime
     *     startTime: OffsetDateTime
     *     endTime: OffsetDateTime
     *     name: String
     *     description: String
     *     properties: {
     *         String: Object
     *     }
     * }
     * }</pre>
     *
     * <p><strong>Response Body Schema</strong>
     *
     * <pre>{@code
     * (recursive schema, see above)
     * }</pre>
     *
     * @param jobId Job id supplied by user.
     * @return a DynamicRequest where customizations can be made before sent to the service.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public DynamicRequest createDataIngestionJob(String jobId) {
        return new DynamicRequest(serializer, httpPipeline)
                .setUrl("{Endpoint}/weather/ingest-data/{jobId}")
                .setPathParam("Endpoint", endpoint)
                .setPathParam("jobId", jobId)
                .addQueryParam("api-version", apiVersion)
                .addHeader("Accept", "application/json")
                .addHeader("Content-Type", "application/json")
                .setHttpMethod(HttpMethod.PUT);
    }

    /**
     * Get weather data delete job.
     *
     * <p><strong>Response Body Schema</strong>
     *
     * <pre>{@code
     * {
     *     extensionId: String
     *     farmerId: String
     *     boundaryId: String
     *     weatherDataType: String
     *     granularity: String
     *     startDateTime: OffsetDateTime
     *     endDateTime: OffsetDateTime
     *     id: String
     *     status: String
     *     durationInSeconds: Double
     *     message: String
     *     createdDateTime: OffsetDateTime
     *     lastActionDateTime: OffsetDateTime
     *     startTime: OffsetDateTime
     *     endTime: OffsetDateTime
     *     name: String
     *     description: String
     *     properties: {
     *         String: Object
     *     }
     * }
     * }</pre>
     *
     * @param jobId ID of the job.
     * @return a DynamicRequest where customizations can be made before sent to the service.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public DynamicRequest getDataDeleteJobDetails(String jobId) {
        return new DynamicRequest(serializer, httpPipeline)
                .setUrl("{Endpoint}/weather/delete-data/{jobId}")
                .setPathParam("Endpoint", endpoint)
                .setPathParam("jobId", jobId)
                .addQueryParam("api-version", apiVersion)
                .addHeader("Accept", "application/json")
                .addHeader("Content-Type", "application/json")
                .setHttpMethod(HttpMethod.GET);
    }

    /**
     * Create a weather data delete job.
     *
     * <p><strong>Request Body Schema</strong>
     *
     * <pre>{@code
     * {
     *     extensionId: String
     *     farmerId: String
     *     boundaryId: String
     *     weatherDataType: String
     *     granularity: String
     *     startDateTime: OffsetDateTime
     *     endDateTime: OffsetDateTime
     *     id: String
     *     status: String
     *     durationInSeconds: Double
     *     message: String
     *     createdDateTime: OffsetDateTime
     *     lastActionDateTime: OffsetDateTime
     *     startTime: OffsetDateTime
     *     endTime: OffsetDateTime
     *     name: String
     *     description: String
     *     properties: {
     *         String: Object
     *     }
     * }
     * }</pre>
     *
     * <p><strong>Response Body Schema</strong>
     *
     * <pre>{@code
     * (recursive schema, see above)
     * }</pre>
     *
     * @param jobId Job ID supplied by end user.
     * @return a DynamicRequest where customizations can be made before sent to the service.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public DynamicRequest createDataDeleteJob(String jobId) {
        return new DynamicRequest(serializer, httpPipeline)
                .setUrl("{Endpoint}/weather/delete-data/{jobId}")
                .setPathParam("Endpoint", endpoint)
                .setPathParam("jobId", jobId)
                .addQueryParam("api-version", apiVersion)
                .addHeader("Accept", "application/json")
                .addHeader("Content-Type", "application/json")
                .setHttpMethod(HttpMethod.PUT);
    }

    /**
     * Get the next page of items.
     *
     * <p><strong>Response Body Schema</strong>
     *
     * <pre>{@code
     * {
     *     value: [
     *         {
     *             farmerId: String
     *             boundaryId: String
     *             extensionId: String
     *             location: {
     *                 latitude: double
     *                 longitude: double
     *             }
     *             dateTime: OffsetDateTime
     *             unitSystemCode: String
     *             extensionVersion: String
     *             weatherDataType: String
     *             granularity: String
     *             cloudCover: {
     *                 unit: String
     *                 value: Double
     *             }
     *             dewPoint: (recursive schema, see dewPoint above)
     *             growingDegreeDay: (recursive schema, see growingDegreeDay above)
     *             precipitation: (recursive schema, see precipitation above)
     *             pressure: (recursive schema, see pressure above)
     *             relativeHumidity: (recursive schema, see relativeHumidity above)
     *             soilMoisture: (recursive schema, see soilMoisture above)
     *             soilTemperature: (recursive schema, see soilTemperature above)
     *             temperature: (recursive schema, see temperature above)
     *             visibility: (recursive schema, see visibility above)
     *             wetBulbTemperature: (recursive schema, see wetBulbTemperature above)
     *             windChill: (recursive schema, see windChill above)
     *             windDirection: (recursive schema, see windDirection above)
     *             windGust: (recursive schema, see windGust above)
     *             windSpeed: (recursive schema, see windSpeed above)
     *             id: String
     *             eTag: String
     *             createdDateTime: OffsetDateTime
     *             modifiedDateTime: OffsetDateTime
     *             properties: {
     *                 String: Object
     *             }
     *         }
     *     ]
     *     skipToken: String
     *     nextLink: String
     * }
     * }</pre>
     *
     * @param nextLink The nextLink parameter.
     * @return a DynamicRequest where customizations can be made before sent to the service.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public DynamicRequest listNext(String nextLink) {
        return new DynamicRequest(serializer, httpPipeline)
                .setUrl("{Endpoint}/{nextLink}")
                .setPathParam("Endpoint", endpoint)
                .setPathParam("nextLink", nextLink)
                .addHeader("Accept", "application/json")
                .addHeader("Content-Type", "application/json")
                .setHttpMethod(HttpMethod.GET);
    }

    /**
     * Create an empty DynamicRequest with the serializer and pipeline initialized for this client.
     *
     * @return a DynamicRequest where customizations can be made before sent to the service.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public DynamicRequest invoke() {
        return new DynamicRequest(serializer, httpPipeline);
    }
}