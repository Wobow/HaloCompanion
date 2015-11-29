
package com.wilyra.halocompanion.haloapi.model.common;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Enemy {

    @SerializedName("BaseId")
    @Expose
    private String BaseId;
    @SerializedName("Attachments")
    @Expose
    private String[] Attachments;

    /**
     * 
     * @return
     *     The BaseId
     */
    public String getBaseId() {
        return BaseId;
    }

    /**
     * 
     * @param BaseId
     *     The BaseId
     */
    public void setBaseId(String BaseId) {
        this.BaseId = BaseId;
    }

    /**
     * 
     * @return
     *     The Attachments
     */
    public String[] getAttachments() {
        return Attachments;
    }

    /**
     *
     * @param Attachments
     *     The Attachments
     */
    public void setAttachments(String[] Attachments) {
        this.Attachments = Attachments;
    }

}
