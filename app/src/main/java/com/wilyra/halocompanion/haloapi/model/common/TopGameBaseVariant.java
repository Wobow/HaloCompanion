
package com.wilyra.halocompanion.haloapi.model.common;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TopGameBaseVariant {

    @SerializedName("GameBaseVariantRank")
    @Expose
    private String GameBaseVariantRank;
    @SerializedName("NumberOfMatchesCompleted")
    @Expose
    private String NumberOfMatchesCompleted;
    @SerializedName("GameBaseVariantId")
    @Expose
    private String GameBaseVariantId;
    @SerializedName("NumberOfMatchesWon")
    @Expose
    private String NumberOfMatchesWon;

    /**
     * 
     * @return
     *     The GameBaseVariantRank
     */
    public String getGameBaseVariantRank() {
        return GameBaseVariantRank;
    }

    /**
     * 
     * @param GameBaseVariantRank
     *     The GameBaseVariantRank
     */
    public void setGameBaseVariantRank(String GameBaseVariantRank) {
        this.GameBaseVariantRank = GameBaseVariantRank;
    }

    /**
     * 
     * @return
     *     The NumberOfMatchesCompleted
     */
    public String getNumberOfMatchesCompleted() {
        return NumberOfMatchesCompleted;
    }

    /**
     * 
     * @param NumberOfMatchesCompleted
     *     The NumberOfMatchesCompleted
     */
    public void setNumberOfMatchesCompleted(String NumberOfMatchesCompleted) {
        this.NumberOfMatchesCompleted = NumberOfMatchesCompleted;
    }

    /**
     * 
     * @return
     *     The GameBaseVariantId
     */
    public String getGameBaseVariantId() {
        return GameBaseVariantId;
    }

    /**
     * 
     * @param GameBaseVariantId
     *     The GameBaseVariantId
     */
    public void setGameBaseVariantId(String GameBaseVariantId) {
        this.GameBaseVariantId = GameBaseVariantId;
    }

    /**
     * 
     * @return
     *     The NumberOfMatchesWon
     */
    public String getNumberOfMatchesWon() {
        return NumberOfMatchesWon;
    }

    /**
     * 
     * @param NumberOfMatchesWon
     *     The NumberOfMatchesWon
     */
    public void setNumberOfMatchesWon(String NumberOfMatchesWon) {
        this.NumberOfMatchesWon = NumberOfMatchesWon;
    }

}
