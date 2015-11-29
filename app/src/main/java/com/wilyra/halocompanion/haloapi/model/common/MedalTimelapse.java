
package com.wilyra.halocompanion.haloapi.model.common;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MedalTimelapse {

    @SerializedName("Id")
    @Expose
    private String Id;
    @SerializedName("Timelapse")
    @Expose
    private String Timelapse;

    /**
     * 
     * @return
     *     The Id
     */
    public String getId() {
        return Id;
    }

    /**
     * 
     * @param Id
     *     The Id
     */
    public void setId(String Id) {
        this.Id = Id;
    }

    /**
     * 
     * @return
     *     The Timelapse
     */
    public String getTimelapse() {
        return Timelapse;
    }

    /**
     * 
     * @param Timelapse
     *     The Timelapse
     */
    public void setTimelapse(String Timelapse) {
        this.Timelapse = Timelapse;
    }

}
