
package com.wilyra.halocompanion.haloapi.model.match;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.UUID;

public class Id {

    @SerializedName("MatchId")
    @Expose
    private UUID MatchId;
    @SerializedName("GameMode")
    @Expose
    private int GameMode;

    /**
     * 
     * @return
     *     The MatchId
     */
    public UUID getMatchId() {
        return MatchId;
    }

    /**
     * 
     * @param MatchId
     *     The MatchId
     */
    public void setMatchId(UUID MatchId) {
        this.MatchId = MatchId;
    }

    /**
     * 
     * @return
     *     The GameMode
     */
    public int getGameMode() {
        return GameMode;
    }

    /**
     * 
     * @param GameMode
     *     The GameMode
     */
    public void setGameMode(int GameMode) {
        this.GameMode = GameMode;
    }

}
