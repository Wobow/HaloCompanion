
package com.wilyra.halocompanion.haloapi.model.match;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Player {

    @SerializedName("Player")
    @Expose
    private Player_ Player;
    @SerializedName("TeamId")
    @Expose
    private int TeamId;
    @SerializedName("Rank")
    @Expose
    private int Rank;
    @SerializedName("Result")
    @Expose
    private int Result;
    @SerializedName("TotalKills")
    @Expose
    private int TotalKills;
    @SerializedName("TotalDeaths")
    @Expose
    private int TotalDeaths;
    @SerializedName("TotalAssists")
    @Expose
    private int TotalAssists;
    @SerializedName("PreMatchRatings")
    @Expose
    private Object PreMatchRatings;
    @SerializedName("PostMatchRatings")
    @Expose
    private Object PostMatchRatings;

    /**
     * 
     * @return
     *     The Player
     */
    public Player_ getPlayer() {
        return Player;
    }

    /**
     * 
     * @param Player
     *     The Player
     */
    public void setPlayer(Player_ Player) {
        this.Player = Player;
    }

    /**
     * 
     * @return
     *     The TeamId
     */
    public int getTeamId() {
        return TeamId;
    }

    /**
     * 
     * @param TeamId
     *     The TeamId
     */
    public void setTeamId(int TeamId) {
        this.TeamId = TeamId;
    }

    /**
     * 
     * @return
     *     The Rank
     */
    public int getRank() {
        return Rank;
    }

    /**
     * 
     * @param Rank
     *     The Rank
     */
    public void setRank(int Rank) {
        this.Rank = Rank;
    }

    /**
     * 
     * @return
     *     The Result
     */
    public int getResult() {
        return Result;
    }

    /**
     * 
     * @param Result
     *     The Result
     */
    public void setResult(int Result) {
        this.Result = Result;
    }

    /**
     * 
     * @return
     *     The TotalKills
     */
    public int getTotalKills() {
        return TotalKills;
    }

    /**
     * 
     * @param TotalKills
     *     The TotalKills
     */
    public void setTotalKills(int TotalKills) {
        this.TotalKills = TotalKills;
    }

    /**
     * 
     * @return
     *     The TotalDeaths
     */
    public int getTotalDeaths() {
        return TotalDeaths;
    }

    /**
     * 
     * @param TotalDeaths
     *     The TotalDeaths
     */
    public void setTotalDeaths(int TotalDeaths) {
        this.TotalDeaths = TotalDeaths;
    }

    /**
     * 
     * @return
     *     The TotalAssists
     */
    public int getTotalAssists() {
        return TotalAssists;
    }

    /**
     * 
     * @param TotalAssists
     *     The TotalAssists
     */
    public void setTotalAssists(int TotalAssists) {
        this.TotalAssists = TotalAssists;
    }

    /**
     * 
     * @return
     *     The PreMatchRatings
     */
    public Object getPreMatchRatings() {
        return PreMatchRatings;
    }

    /**
     * 
     * @param PreMatchRatings
     *     The PreMatchRatings
     */
    public void setPreMatchRatings(Object PreMatchRatings) {
        this.PreMatchRatings = PreMatchRatings;
    }

    /**
     * 
     * @return
     *     The PostMatchRatings
     */
    public Object getPostMatchRatings() {
        return PostMatchRatings;
    }

    /**
     * 
     * @param PostMatchRatings
     *     The PostMatchRatings
     */
    public void setPostMatchRatings(Object PostMatchRatings) {
        this.PostMatchRatings = PostMatchRatings;
    }

}
