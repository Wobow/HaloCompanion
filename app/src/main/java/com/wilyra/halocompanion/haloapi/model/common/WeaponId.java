
package com.wilyra.halocompanion.haloapi.model.common;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WeaponId {

    @SerializedName("StockId")
    @Expose
    private String StockId;
    @SerializedName("Attachments")
    @Expose
    private String[] Attachments;

    /**
     * 
     * @return
     *     The StockId
     */
    public String getStockId() {
        return StockId;
    }

    /**
     * 
     * @param StockId
     *     The StockId
     */
    public void setStockId(String StockId) {
        this.StockId = StockId;
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
