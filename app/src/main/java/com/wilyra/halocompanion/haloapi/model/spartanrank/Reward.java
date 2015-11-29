
package com.wilyra.halocompanion.haloapi.model.spartanrank;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Reward {

    @SerializedName("xp")
    @Expose
    private String xp;
    @SerializedName("requisitionPacks")
    @Expose
    private List<RequisitionPack> requisitionPacks = new ArrayList<RequisitionPack>();
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("contentId")
    @Expose
    private String contentId;

    /**
     * 
     * @return
     *     The xp
     */
    public String getXp() {
        return xp;
    }

    /**
     * 
     * @param xp
     *     The xp
     */
    public void setXp(String xp) {
        this.xp = xp;
    }

    /**
     * 
     * @return
     *     The requisitionPacks
     */
    public List<RequisitionPack> getRequisitionPacks() {
        return requisitionPacks;
    }

    /**
     * 
     * @param requisitionPacks
     *     The requisitionPacks
     */
    public void setRequisitionPacks(List<RequisitionPack> requisitionPacks) {
        this.requisitionPacks = requisitionPacks;
    }

    /**
     * 
     * @return
     *     The id
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The contentId
     */
    public String getContentId() {
        return contentId;
    }

    /**
     * 
     * @param contentId
     *     The contentId
     */
    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

}
