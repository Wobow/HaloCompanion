
package com.wilyra.halocompanion.haloapi.model.common;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DestroyedEnemyVehicle {

    @SerializedName("Enemy")
    @Expose
    private com.wilyra.halocompanion.haloapi.model.common.Enemy Enemy;
    @SerializedName("TotalKills")
    @Expose
    private String TotalKills;

    /**
     * 
     * @return
     *     The Enemy
     */
    public com.wilyra.halocompanion.haloapi.model.common.Enemy getEnemy() {
        return Enemy;
    }

    /**
     * 
     * @param Enemy
     *     The Enemy
     */
    public void setEnemy(com.wilyra.halocompanion.haloapi.model.common.Enemy Enemy) {
        this.Enemy = Enemy;
    }

    /**
     * 
     * @return
     *     The TotalKills
     */
    public String getTotalKills() {
        return TotalKills;
    }

    /**
     * 
     * @param TotalKills
     *     The TotalKills
     */
    public void setTotalKills(String TotalKills) {
        this.TotalKills = TotalKills;
    }

}
