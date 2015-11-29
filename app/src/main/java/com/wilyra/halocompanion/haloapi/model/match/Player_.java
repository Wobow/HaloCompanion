
package com.wilyra.halocompanion.haloapi.model.match;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Player_ {

    @SerializedName("Gamertag")
    @Expose
    private String Gamertag;
    @SerializedName("Xuid")
    @Expose
    private Object Xuid;

    /**
     * 
     * @return
     *     The Gamertag
     */
    public String getGamertag() {
        return Gamertag;
    }

    /**
     * 
     * @param Gamertag
     *     The Gamertag
     */
    public void setGamertag(String Gamertag) {
        this.Gamertag = Gamertag;
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
