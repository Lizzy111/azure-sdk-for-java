// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.recoveryservicesbackup.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** Daily retention format. */
@Fluent
public final class DailyRetentionFormat {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(DailyRetentionFormat.class);

    /*
     * List of days of the month.
     */
    @JsonProperty(value = "daysOfTheMonth")
    private List<Day> daysOfTheMonth;

    /**
     * Get the daysOfTheMonth property: List of days of the month.
     *
     * @return the daysOfTheMonth value.
     */
    public List<Day> daysOfTheMonth() {
        return this.daysOfTheMonth;
    }

    /**
     * Set the daysOfTheMonth property: List of days of the month.
     *
     * @param daysOfTheMonth the daysOfTheMonth value to set.
     * @return the DailyRetentionFormat object itself.
     */
    public DailyRetentionFormat withDaysOfTheMonth(List<Day> daysOfTheMonth) {
        this.daysOfTheMonth = daysOfTheMonth;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (daysOfTheMonth() != null) {
            daysOfTheMonth().forEach(e -> e.validate());
        }
    }
}