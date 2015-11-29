
package com.wilyra.halocompanion.haloapi.model.common;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PlayerId {

    @SerializedName("Gamertag")
    @Expose
    private String Gamertag;
    @SerializedName("Xuid")
    @Expose
    private Object Xuid;

    /**
     * 
     * @return
     *     The GamerTag
     */
    public String getGamerTag() {
        return Gamertag;
    }

    /**
     * 
     * @param GamerTag
     *     The GamerTag
     */
    public void setGamerTag(String GamerTag) {
        this.Gamertag = GamerTag;
    }

    /**
     * 
     * @return
     *     The Xuid
     */
    public Object getXuid() {
        return Xuid;
    }

    /**
     * 
     * @param Xuid
     *     The Xuid
     */
    public void setXuid(Object Xuid) {
        this.Xuid = Xuid;
    }

}
