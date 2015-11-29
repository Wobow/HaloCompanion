
package com.wilyra.halocompanion.haloapi.model.arenastats;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result_ {

    @SerializedName("ArenaStats")
    @Expose
    private ArenaStats_ ArenaStats;
    @SerializedName("PlayerId")
    @Expose
    private com.wilyra.halocompanion.haloapi.model.common.PlayerId PlayerId;
    @SerializedName("SpartanRank")
    @Expose
    private String SpartanRank;
    @SerializedName("Xp")
    @Expose
    private String Xp;

    /**
     * 
     * @return
     *     The ArenaStats
     */
    public ArenaStats_ getArenaStats() {
        return ArenaStats;
    }

    /**
     * 
     * @param ArenaStats
     *     The ArenaStats
     */
    public void setArenaStats(ArenaStats_ ArenaStats) {
        this.ArenaStats = ArenaStats;
    }

    /**
     * 
     * @return
     *     The PlayerId
     */
    public com.wilyra.halocompanion.haloapi.model.common.PlayerId getPlayerId() {
        return PlayerId;
    }

    /**
     * 
     * @param PlayerId
     *     The PlayerId
     */
    public void setPlayerId(com.wilyra.halocompanion.haloapi.model.common.PlayerId PlayerId) {
        this.PlayerId = PlayerId;
    }

    /**
     * 
     * @return
     *     The SpartanRank
     */
    public String getSpartanRank() {
        return SpartanRank;
    }

    /**
     * 
     * @param SpartanRank
     *     The SpartanRank
     */
    public void setSpartanRank(String SpartanRank) {
        this.SpartanRank = SpartanRank;
    }

    /**
     * 
     * @return
     *     The Xp
     */
    public String getXp() {
        return Xp;
    }

    /**
     * 
     * @param Xp
     *     The Xp
     */
    public void setXp(String Xp) {
        this.Xp = Xp;
    }

}
