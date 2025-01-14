// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.education.models;

import com.azure.core.util.ExpandableStringEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Collection;

/** Defines values for JoinRequestStatus. */
public final class JoinRequestStatus extends ExpandableStringEnum<JoinRequestStatus> {
    /** Static value Pending for JoinRequestStatus. */
    public static final JoinRequestStatus PENDING = fromString("Pending");

    /** Static value Denied for JoinRequestStatus. */
    public static final JoinRequestStatus DENIED = fromString("Denied");

    /**
     * Creates or finds a JoinRequestStatus from its string representation.
     *
     * @param name a name to look for.
     * @return the corresponding JoinRequestStatus.
     */
    @JsonCreator
    public static JoinRequestStatus fromString(String name) {
        return fromString(name, JoinRequestStatus.class);
    }

    /**
     * Gets known JoinRequestStatus values.
     *
     * @return known JoinRequestStatus values.
     */
    public static Collection<JoinRequestStatus> values() {
        return values(JoinRequestStatus.class);
    }
}
