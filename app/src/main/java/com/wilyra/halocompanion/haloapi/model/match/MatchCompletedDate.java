
package com.wilyra.halocompanion.haloapi.model.match;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MatchCompletedDate {

    @SerializedName("ISO8601Date")
    @Expose
    private String ISO8601Date;

    /**
     * 
     * @return
     *     The ISO8601Date
     */
    public String getISO8601Date() {
        return ISO8601Date;
    }

    /**
     * 
     * @param ISO8601Date
     *     The ISO8601Date
     */
    public void setISO8601Date(String ISO8601Date) {
        this.ISO8601Date = ISO8601Date;
    }

}
