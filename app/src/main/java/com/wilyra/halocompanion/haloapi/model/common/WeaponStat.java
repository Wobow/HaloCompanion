
package com.wilyra.halocompanion.haloapi.model.common;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WeaponStat {

    @SerializedName("WeaponId")
    @Expose
    private WeaponId WeaponId;
    @SerializedName("TotalShotsFired")
    @Expose
    private String TotalShotsFired;
    @SerializedName("TotalShotsLanded")
    @Expose
    private String TotalShotsLanded;
    @SerializedName("TotalHeadshots")
    @Expose
    private String TotalHeadshots;
    @SerializedName("TotalKills")
    @Expose
    private String TotalKills;
    @SerializedName("TotalDamageDealt")
    @Expose
    private String TotalDamageDealt;
    @SerializedName("TotalPossessionTime")
    @Expose
    private String TotalPossessionTime;

    /**
     * 
     * @return
     *     The WeaponId
     */
    public WeaponId getWeaponId() {
        return WeaponId;
    }

    /**
     * 
     * @param WeaponId
     *     The WeaponId
     */
    public void setWeaponId(WeaponId WeaponId) {
        this.WeaponId = WeaponId;
    }

    /**
     * 
     * @return
     *     The TotalShotsFired
     */
    public String getTotalShotsFired() {
        return TotalShotsFired;
    }

    /**
     * 
     * @param TotalShotsFired
     *     The TotalShotsFired
     */
    public void setTotalShotsFired(String TotalShotsFired) {
        this.TotalShotsFired = TotalShotsFired;
    }

    /**
     * 
     * @return
     *     The TotalShotsLanded
     */
    public String getTotalShotsLanded() {
        return TotalShotsLanded;
    }

    /**
     * 
     * @param TotalShotsLanded
     *     The TotalShotsLanded
     */
    public void setTotalShotsLanded(String TotalShotsLanded) {
        this.TotalShotsLanded = TotalShotsLanded;
    }

    /**
     * 
     * @return
     *     The TotalHeadshots
     */
    public String getTotalHeadshots() {
        return TotalHeadshots;
    }

    /**
     * 
     * @param TotalHeadshots
     *     The TotalHeadshots
     */
    public void setTotalHeadshots(String TotalHeadshots) {
        this.TotalHeadshots = TotalHeadshots;
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

    /**
     * 
     * @return
     *     The TotalDamageDealt
     */
    public String getTotalDamageDealt() {
        return TotalDamageDealt;
    }

    /**
     * 
     * @param TotalDamageDealt
     *     The TotalDamageDealt
     */
    public void setTotalDamageDealt(String TotalDamageDealt) {
        this.TotalDamageDealt = TotalDamageDealt;
    }

    /**
     * 
     * @return
     *     The TotalPossessionTime
     */
    public String getTotalPossessionTime() {
        return TotalPossessionTime;
    }

    /**
     * 
     * @param TotalPossessionTime
     *     The TotalPossessionTime
     */
    public void setTotalPossessionTime(String TotalPossessionTime) {
        this.TotalPossessionTime = TotalPossessionTime;
    }

}
