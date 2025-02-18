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

/** meetingParticipantInfo. */
@Fluent
public final class MicrosoftGraphMeetingParticipantInfo {
    /*
     * identitySet
     */
    @JsonProperty(value = "identity")
    private MicrosoftGraphIdentitySet identity;

    /*
     * onlineMeetingRole
     */
    @JsonProperty(value = "role")
    private MicrosoftGraphOnlineMeetingRole role;

    /*
     * User principal name of the participant.
     */
    @JsonProperty(value = "upn")
    private String upn;

    /*
     * meetingParticipantInfo
     */
    @JsonIgnore private Map<String, Object> additionalProperties;

    /**
     * Get the identity property: identitySet.
     *
     * @return the identity value.
     */
    public MicrosoftGraphIdentitySet identity() {
        return this.identity;
    }

    /**
     * Set the identity property: identitySet.
     *
     * @param identity the identity value to set.
     * @return the MicrosoftGraphMeetingParticipantInfo object itself.
     */
    public MicrosoftGraphMeetingParticipantInfo withIdentity(MicrosoftGraphIdentitySet identity) {
        this.identity = identity;
        return this;
    }

    /**
     * Get the role property: onlineMeetingRole.
     *
     * @return the role value.
     */
    public MicrosoftGraphOnlineMeetingRole role() {
        return this.role;
    }

    /**
     * Set the role property: onlineMeetingRole.
     *
     * @param role the role value to set.
     * @return the MicrosoftGraphMeetingParticipantInfo object itself.
     */
    public MicrosoftGraphMeetingParticipantInfo withRole(MicrosoftGraphOnlineMeetingRole role) {
        this.role = role;
        return this;
    }

    /**
     * Get the upn property: User principal name of the participant.
     *
     * @return the upn value.
     */
    public String upn() {
        return this.upn;
    }

    /**
     * Set the upn property: User principal name of the participant.
     *
     * @param upn the upn value to set.
     * @return the MicrosoftGraphMeetingParticipantInfo object itself.
     */
    public MicrosoftGraphMeetingParticipantInfo withUpn(String upn) {
        this.upn = upn;
        return this;
    }

    /**
     * Get the additionalProperties property: meetingParticipantInfo.
     *
     * @return the additionalProperties value.
     */
    @JsonAnyGetter
    public Map<String, Object> additionalProperties() {
        return this.additionalProperties;
    }

    /**
     * Set the additionalProperties property: meetingParticipantInfo.
     *
     * @param additionalProperties the additionalProperties value to set.
     * @return the MicrosoftGraphMeetingParticipantInfo object itself.
     */
    public MicrosoftGraphMeetingParticipantInfo withAdditionalProperties(Map<String, Object> additionalProperties) {
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

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (identity() != null) {
            identity().validate();
        }
    }
}
