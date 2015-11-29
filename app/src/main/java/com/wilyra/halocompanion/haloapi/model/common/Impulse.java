
package com.wilyra.halocompanion.haloapi.model.common;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Impulse {

    @SerializedName("Id")
    @Expose
    private String Id;
    @SerializedName("Count")
    @Expose
    private String Count;

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
     *     The Count
     */
    public String getCount() {
        return Count;
    }

    /**
     * 
     * @param Count
     *     The Count
     */
    public void setCount(String Count) {
        this.Count = Count;
    }

}
