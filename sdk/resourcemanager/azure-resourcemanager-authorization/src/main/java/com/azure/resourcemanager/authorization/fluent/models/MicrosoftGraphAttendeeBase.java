// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.authorization.fluent.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashMap;
import java.util.Map;

/** attendeeBase. */
@Fluent
public class MicrosoftGraphAttendeeBase extends MicrosoftGraphRecipient {
    /*
     * attendeeType
     */
    @JsonProperty(value = "type")
    private MicrosoftGraphAttendeeType type;

    /*
     * attendeeBase
     */
    @JsonIgnore private Map<String, Object> additionalProperties;

    /**
     * Get the type property: attendeeType.
     *
     * @return the type value.
     */
    public MicrosoftGraphAttendeeType type() {
        return this.type;
    }

    /**
     * Set the type property: attendeeType.
     *
     * @param type the type value to set.
     * @return the MicrosoftGraphAttendeeBase object itself.
     */
    public MicrosoftGraphAttendeeBase withType(MicrosoftGraphAttendeeType type) {
        this.type = type;
        return this;
    }

    /**
     * Get the additionalProperties property: attendeeBase.
     *
     * @return the additionalProperties value.
     */
    @JsonAnyGetter
    public Map<String, Object> additionalProperties() {
        return this.additionalProperties;
    }

    /**
     * Set the additionalProperties property: attendeeBase.
     *
     * @param additionalProperties the additionalProperties value to set.
     * @return the MicrosoftGraphAttendeeBase object itself.
     */
    public MicrosoftGraphAttendeeBase withAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
        return this;
    }

    @JsonAnySetter
    void withAdditionalProperties(String key, Object value) {
        if (additionalProperties == null) {
            additionalProperties = new HashMap<>();
        }
        additionalProperties.put(key, value);
    }

    /** {@inheritDoc} */
    @Override
    public MicrosoftGraphAttendeeBase withEmailAddress(MicrosoftGraphEmailAddress emailAddress) {
        super.withEmailAddress(emailAddress);
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
    public void validate() {
        super.validate();
    }
}
