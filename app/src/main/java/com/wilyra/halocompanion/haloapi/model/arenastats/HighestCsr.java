
package com.wilyra.halocompanion.haloapi.model.arenastats;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HighestCsr {

    @SerializedName("Tier")
    @Expose
    private String Tier;
    @SerializedName("DesignationId")
    @Expose
    private String DesignationId;
    @SerializedName("Csr")
    @Expose
    private String Csr;
    @SerializedName("PercentToNextTier")
    @Expose
    private String PercentToNextTier;
    @SerializedName("Rank")
    @Expose
    private String Rank;

    /**
     * 
     * @return
     *     The Tier
     */
    public String getTier() {
        return Tier;
    }

    /**
     * 
     * @param Tier
     *     The Tier
     */
    public void setTier(String Tier) {
        this.Tier = Tier;
    }

    /**
     * 
     * @return
     *     The DesignationId
     */
    public String getDesignationId() {
        return DesignationId;
    }

    /**
     * 
     * @param DesignationId
     *     The DesignationId
     */
    public void setDesignationId(String DesignationId) {
        this.DesignationId = DesignationId;
    }

    /**
     * 
     * @return
     *     The Csr
     */
    public String getCsr() {
        return Csr;
    }

    /**
     * 
     * @param Csr
     *     The Csr
     */
    public void setCsr(String Csr) {
        this.Csr = Csr;
    }

    /**
     * 
     * @return
     *     The PercentToNextTier
     */
    public String getPercentToNextTier() {
        return PercentToNextTier;
    }

    /**
     * 
     * @param PercentToNextTier
     *     The PercentToNextTier
     */
    public void setPercentToNextTier(String PercentToNextTier) {
        this.PercentToNextTier = PercentToNextTier;
    }

    /**
     * 
     * @return
     *     The Rank
     */
    public String getRank() {
        return Rank;
    }

    /**
     * 
     * @param Rank
     *     The Rank
     */
    public void setRank(String Rank) {
        this.Rank = Rank;
    }

}
