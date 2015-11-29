
package com.wilyra.halocompanion.haloapi.model.match;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Team {

    @SerializedName("Id")
    @Expose
    private int Id;
    @SerializedName("Score")
    @Expose
    private int Score;
    @SerializedName("Rank")
    @Expose
    private int Rank;

    /**
     * 
     * @return
     *     The Id
     */
    public int getId() {
        return Id;
    }

    /**
     * 
     * @param Id
     *     The Id
     */
    public void setId(int Id) {
        this.Id = Id;
    }

    /**
     * 
     * @return
     *     The Score
     */
    public int getScore() {
        return Score;
    }

    /**
     * 
     * @param Score
     *     The Score
     */
    public void setScore(int Score) {
        this.Score = Score;
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

}
