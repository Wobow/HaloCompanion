
package com.wilyra.halocompanion.haloapi.model.spartanrank;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SpartanRank {

    @SerializedName("startXp")
    @Expose
    private String startXp;
    @SerializedName("reward")
    @Expose
    private Reward reward;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("contentId")
    @Expose
    private String contentId;

    /**
     * 
     * @return
     *     The startXp
     */
    public String getStartXp() {
        return startXp;
    }

    /**
     * 
     * @param startXp
     *     The startXp
     */
    public void setStartXp(String startXp) {
        this.startXp = startXp;
    }

    /**
     * 
     * @return
     *     The reward
     */
    public Reward getReward() {
        return reward;
    }

    /**
     * 
     * @param reward
     *     The reward
     */
    public void setReward(Reward reward) {
        this.reward = reward;
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
