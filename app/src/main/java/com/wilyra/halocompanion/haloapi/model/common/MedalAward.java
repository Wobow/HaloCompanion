
package com.wilyra.halocompanion.haloapi.model.common;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MedalAward {

    @SerializedName("MedalId")
    @Expose
    private String MedalId;
    @SerializedName("Count")
    @Expose
    private int Count;

    /**
     * 
     * @return
     *     The MedalId
     */
    public String getMedalId() {
        return MedalId;
    }

    /**
     * 
     * @param MedalId
     *     The MedalId
     */
    public void setMedalId(String MedalId) {
        this.MedalId = MedalId;
    }

    /**
     * 
     * @return
     *     The Count
     */
    public int getCount() {
        return Count;
    }

    /**
     * 
     * @param Count
     *     The Count
     */
    public void setCount(int Count) {
        this.Count = Count;
    }

}
