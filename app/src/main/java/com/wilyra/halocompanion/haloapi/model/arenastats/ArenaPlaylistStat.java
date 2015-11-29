
package com.wilyra.halocompanion.haloapi.model.arenastats;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.wilyra.halocompanion.haloapi.model.common.DestroyedEnemyVehicle;
import com.wilyra.halocompanion.haloapi.model.common.EnemyKill;
import com.wilyra.halocompanion.haloapi.model.common.Impulse;
import com.wilyra.halocompanion.haloapi.model.common.MedalAward;
import com.wilyra.halocompanion.haloapi.model.common.WeaponStat;

public class ArenaPlaylistStat {

    @SerializedName("PlaylistId")
    @Expose
    private String PlaylistId;
    @SerializedName("MeasurementMatchesLeft")
    @Expose
    private String MeasurementMatchesLeft;
    @SerializedName("HighestCsr")
    @Expose
    private com.wilyra.halocompanion.haloapi.model.arenastats.HighestCsr HighestCsr;
    @SerializedName("Csr")
    @Expose
    private com.wilyra.halocompanion.haloapi.model.arenastats.Csr Csr;
    @SerializedName("TotalKills")
    @Expose
    private String TotalKills;
    @SerializedName("TotalHeadshots")
    @Expose
    private String TotalHeadshots;
    @SerializedName("TotalWeaponDamage")
    @Expose
    private String TotalWeaponDamage;
    @SerializedName("TotalShotsFired")
    @Expose
    private String TotalShotsFired;
    @SerializedName("TotalShotsLanded")
    @Expose
    private String TotalShotsLanded;
    @SerializedName("WeaponWithMostKills")
    @Expose
    private com.wilyra.halocompanion.haloapi.model.common.WeaponWithMostKills WeaponWithMostKills;
    @SerializedName("TotalMeleeKills")
    @Expose
    private String TotalMeleeKills;
    @SerializedName("TotalMeleeDamage")
    @Expose
    private String TotalMeleeDamage;
    @SerializedName("TotalAssassinations")
    @Expose
    private String TotalAssassinations;
    @SerializedName("TotalGroundPoundKills")
    @Expose
    private String TotalGroundPoundKills;
    @SerializedName("TotalGroundPoundDamage")
    @Expose
    private String TotalGroundPoundDamage;
    @SerializedName("TotalShoulderBashKills")
    @Expose
    private String TotalShoulderBashKills;
    @SerializedName("TotalShoulderBashDamage")
    @Expose
    private String TotalShoulderBashDamage;
    @SerializedName("TotalGrenadeDamage")
    @Expose
    private String TotalGrenadeDamage;
    @SerializedName("TotalPowerWeaponKills")
    @Expose
    private String TotalPowerWeaponKills;
    @SerializedName("TotalPowerWeaponDamage")
    @Expose
    private String TotalPowerWeaponDamage;
    @SerializedName("TotalPowerWeaponGrabs")
    @Expose
    private String TotalPowerWeaponGrabs;
    @SerializedName("TotalPowerWeaponPossessionTime")
    @Expose
    private String TotalPowerWeaponPossessionTime;
    @SerializedName("TotalDeaths")
    @Expose
    private String TotalDeaths;
    @SerializedName("TotalAssists")
    @Expose
    private String TotalAssists;
    @SerializedName("TotalGamesCompleted")
    @Expose
    private String TotalGamesCompleted;
    @SerializedName("TotalGamesWon")
    @Expose
    private String TotalGamesWon;
    @SerializedName("TotalGamesLost")
    @Expose
    private String TotalGamesLost;
    @SerializedName("TotalGamesTied")
    @Expose
    private String TotalGamesTied;
    @SerializedName("TotalTimePlayed")
    @Expose
    private String TotalTimePlayed;
    @SerializedName("TotalGrenadeKills")
    @Expose
    private String TotalGrenadeKills;
    @SerializedName("MedalAwards")
    @Expose
    private MedalAward[] MedalAwards;
    @SerializedName("DestroyedEnemyVehicles")
    @Expose
    private DestroyedEnemyVehicle[] DestroyedEnemyVehicles;
    @SerializedName("EnemyKills")
    @Expose
    private EnemyKill[] EnemyKills;
    @SerializedName("WeaponStats")
    @Expose
    private WeaponStat[] WeaponStats;
    @SerializedName("Impulses")
    @Expose
    private Impulse[] Impulses;
    @SerializedName("TotalSpartanKills")
    @Expose
    private String TotalSpartanKills;

    /**
     * 
     * @return
     *     The PlaylistId
     */
    public String getPlaylistId() {
        return PlaylistId;
    }

    /**
     * 
     * @param PlaylistId
     *     The PlaylistId
     */
    public void setPlaylistId(String PlaylistId) {
        this.PlaylistId = PlaylistId;
    }

    /**
     * 
     * @return
     *     The MeasurementMatchesLeft
     */
    public String getMeasurementMatchesLeft() {
        return MeasurementMatchesLeft;
    }

    /**
     * 
     * @param MeasurementMatchesLeft
     *     The MeasurementMatchesLeft
     */
    public void setMeasurementMatchesLeft(String MeasurementMatchesLeft) {
        this.MeasurementMatchesLeft = MeasurementMatchesLeft;
    }

    /**
     * 
     * @return
     *     The HighestCsr
     */
    public com.wilyra.halocompanion.haloapi.model.arenastats.HighestCsr getHighestCsr() {
        return HighestCsr;
    }

    /**
     * 
     * @param HighestCsr
     *     The HighestCsr
     */
    public void setHighestCsr(com.wilyra.halocompanion.haloapi.model.arenastats.HighestCsr HighestCsr) {
        this.HighestCsr = HighestCsr;
    }

    /**
     * 
     * @return
     *     The Csr
     */
    public com.wilyra.halocompanion.haloapi.model.arenastats.Csr getCsr() {
        return Csr;
    }

    /**
     * 
     * @param Csr
     *     The Csr
     */
    public void setCsr(com.wilyra.halocompanion.haloapi.model.arenastats.Csr Csr) {
        this.Csr = Csr;
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
     *     The TotalWeaponDamage
     */
    public String getTotalWeaponDamage() {
        return TotalWeaponDamage;
    }

    /**
     * 
     * @param TotalWeaponDamage
     *     The TotalWeaponDamage
     */
    public void setTotalWeaponDamage(String TotalWeaponDamage) {
        this.TotalWeaponDamage = TotalWeaponDamage;
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
     *     The WeaponWithMostKills
     */
    public com.wilyra.halocompanion.haloapi.model.common.WeaponWithMostKills getWeaponWithMostKills() {
        return WeaponWithMostKills;
    }

    /**
     * 
     * @param WeaponWithMostKills
     *     The WeaponWithMostKills
     */
    public void setWeaponWithMostKills(com.wilyra.halocompanion.haloapi.model.common.WeaponWithMostKills WeaponWithMostKills) {
        this.WeaponWithMostKills = WeaponWithMostKills;
    }

    /**
     * 
     * @return
     *     The TotalMeleeKills
     */
    public String getTotalMeleeKills() {
        return TotalMeleeKills;
    }

    /**
     * 
     * @param TotalMeleeKills
     *     The TotalMeleeKills
     */
    public void setTotalMeleeKills(String TotalMeleeKills) {
        this.TotalMeleeKills = TotalMeleeKills;
    }

    /**
     * 
     * @return
     *     The TotalMeleeDamage
     */
    public String getTotalMeleeDamage() {
        return TotalMeleeDamage;
    }

    /**
     * 
     * @param TotalMeleeDamage
     *     The TotalMeleeDamage
     */
    public void setTotalMeleeDamage(String TotalMeleeDamage) {
        this.TotalMeleeDamage = TotalMeleeDamage;
    }

    /**
     * 
     * @return
     *     The TotalAssassinations
     */
    public String getTotalAssassinations() {
        return TotalAssassinations;
    }

    /**
     * 
     * @param TotalAssassinations
     *     The TotalAssassinations
     */
    public void setTotalAssassinations(String TotalAssassinations) {
        this.TotalAssassinations = TotalAssassinations;
    }

    /**
     * 
     * @return
     *     The TotalGroundPoundKills
     */
    public String getTotalGroundPoundKills() {
        return TotalGroundPoundKills;
    }

    /**
     * 
     * @param TotalGroundPoundKills
     *     The TotalGroundPoundKills
     */
    public void setTotalGroundPoundKills(String TotalGroundPoundKills) {
        this.TotalGroundPoundKills = TotalGroundPoundKills;
    }

    /**
     * 
     * @return
     *     The TotalGroundPoundDamage
     */
    public String getTotalGroundPoundDamage() {
        return TotalGroundPoundDamage;
    }

    /**
     * 
     * @param TotalGroundPoundDamage
     *     The TotalGroundPoundDamage
     */
    public void setTotalGroundPoundDamage(String TotalGroundPoundDamage) {
        this.TotalGroundPoundDamage = TotalGroundPoundDamage;
    }

    /**
     * 
     * @return
     *     The TotalShoulderBashKills
     */
    public String getTotalShoulderBashKills() {
        return TotalShoulderBashKills;
    }

    /**
     * 
     * @param TotalShoulderBashKills
     *     The TotalShoulderBashKills
     */
    public void setTotalShoulderBashKills(String TotalShoulderBashKills) {
        this.TotalShoulderBashKills = TotalShoulderBashKills;
    }

    /**
     * 
     * @return
     *     The TotalShoulderBashDamage
     */
    public String getTotalShoulderBashDamage() {
        return TotalShoulderBashDamage;
    }

    /**
     * 
     * @param TotalShoulderBashDamage
     *     The TotalShoulderBashDamage
     */
    public void setTotalShoulderBashDamage(String TotalShoulderBashDamage) {
        this.TotalShoulderBashDamage = TotalShoulderBashDamage;
    }

    /**
     * 
     * @return
     *     The TotalGrenadeDamage
     */
    public String getTotalGrenadeDamage() {
        return TotalGrenadeDamage;
    }

    /**
     * 
     * @param TotalGrenadeDamage
     *     The TotalGrenadeDamage
     */
    public void setTotalGrenadeDamage(String TotalGrenadeDamage) {
        this.TotalGrenadeDamage = TotalGrenadeDamage;
    }

    /**
     * 
     * @return
     *     The TotalPowerWeaponKills
     */
    public String getTotalPowerWeaponKills() {
        return TotalPowerWeaponKills;
    }

    /**
     * 
     * @param TotalPowerWeaponKills
     *     The TotalPowerWeaponKills
     */
    public void setTotalPowerWeaponKills(String TotalPowerWeaponKills) {
        this.TotalPowerWeaponKills = TotalPowerWeaponKills;
    }

    /**
     * 
     * @return
     *     The TotalPowerWeaponDamage
     */
    public String getTotalPowerWeaponDamage() {
        return TotalPowerWeaponDamage;
    }

    /**
     * 
     * @param TotalPowerWeaponDamage
     *     The TotalPowerWeaponDamage
     */
    public void setTotalPowerWeaponDamage(String TotalPowerWeaponDamage) {
        this.TotalPowerWeaponDamage = TotalPowerWeaponDamage;
    }

    /**
     * 
     * @return
     *     The TotalPowerWeaponGrabs
     */
    public String getTotalPowerWeaponGrabs() {
        return TotalPowerWeaponGrabs;
    }

    /**
     * 
     * @param TotalPowerWeaponGrabs
     *     The TotalPowerWeaponGrabs
     */
    public void setTotalPowerWeaponGrabs(String TotalPowerWeaponGrabs) {
        this.TotalPowerWeaponGrabs = TotalPowerWeaponGrabs;
    }

    /**
     * 
     * @return
     *     The TotalPowerWeaponPossessionTime
     */
    public String getTotalPowerWeaponPossessionTime() {
        return TotalPowerWeaponPossessionTime;
    }

    /**
     * 
     * @param TotalPowerWeaponPossessionTime
     *     The TotalPowerWeaponPossessionTime
     */
    public void setTotalPowerWeaponPossessionTime(String TotalPowerWeaponPossessionTime) {
        this.TotalPowerWeaponPossessionTime = TotalPowerWeaponPossessionTime;
    }

    /**
     * 
     * @return
     *     The TotalDeaths
     */
    public String getTotalDeaths() {
        return TotalDeaths;
    }

    /**
     * 
     * @param TotalDeaths
     *     The TotalDeaths
     */
    public void setTotalDeaths(String TotalDeaths) {
        this.TotalDeaths = TotalDeaths;
    }

    /**
     * 
     * @return
     *     The TotalAssists
     */
    public String getTotalAssists() {
        return TotalAssists;
    }

    /**
     * 
     * @param TotalAssists
     *     The TotalAssists
     */
    public void setTotalAssists(String TotalAssists) {
        this.TotalAssists = TotalAssists;
    }

    /**
     * 
     * @return
     *     The TotalGamesCompleted
     */
    public String getTotalGamesCompleted() {
        return TotalGamesCompleted;
    }

    /**
     * 
     * @param TotalGamesCompleted
     *     The TotalGamesCompleted
     */
    public void setTotalGamesCompleted(String TotalGamesCompleted) {
        this.TotalGamesCompleted = TotalGamesCompleted;
    }

    /**
     * 
     * @return
     *     The TotalGamesWon
     */
    public String getTotalGamesWon() {
        return TotalGamesWon;
    }

    /**
     * 
     * @param TotalGamesWon
     *     The TotalGamesWon
     */
    public void setTotalGamesWon(String TotalGamesWon) {
        this.TotalGamesWon = TotalGamesWon;
    }

    /**
     * 
     * @return
     *     The TotalGamesLost
     */
    public String getTotalGamesLost() {
        return TotalGamesLost;
    }

    /**
     * 
     * @param TotalGamesLost
     *     The TotalGamesLost
     */
    public void setTotalGamesLost(String TotalGamesLost) {
        this.TotalGamesLost = TotalGamesLost;
    }

    /**
     * 
     * @return
     *     The TotalGamesTied
     */
    public String getTotalGamesTied() {
        return TotalGamesTied;
    }

    /**
     * 
     * @param TotalGamesTied
     *     The TotalGamesTied
     */
    public void setTotalGamesTied(String TotalGamesTied) {
        this.TotalGamesTied = TotalGamesTied;
    }

    /**
     * 
     * @return
     *     The TotalTimePlayed
     */
    public String getTotalTimePlayed() {
        return TotalTimePlayed;
    }

    /**
     * 
     * @param TotalTimePlayed
     *     The TotalTimePlayed
     */
    public void setTotalTimePlayed(String TotalTimePlayed) {
        this.TotalTimePlayed = TotalTimePlayed;
    }

    /**
     * 
     * @return
     *     The TotalGrenadeKills
     */
    public String getTotalGrenadeKills() {
        return TotalGrenadeKills;
    }

    /**
     * 
     * @param TotalGrenadeKills
     *     The TotalGrenadeKills
     */
    public void setTotalGrenadeKills(String TotalGrenadeKills) {
        this.TotalGrenadeKills = TotalGrenadeKills;
    }

    /**
     * 
     * @return
     *     The MedalAwards
     */
    public MedalAward[] getMedalAwards() {
        return MedalAwards;
    }

    /**
     *
     * @param MedalAwards
     *     The MedalAwards
     */
    public void setMedalAwards(MedalAward[] MedalAwards) {
        this.MedalAwards = MedalAwards;
    }

    /**
     * 
     * @return
     *     The DestroyedEnemyVehicles
     */
    public DestroyedEnemyVehicle[] getDestroyedEnemyVehicles() {
        return DestroyedEnemyVehicles;
    }

    /**
     *
     * @param DestroyedEnemyVehicles
     *     The DestroyedEnemyVehicles
     */
    public void setDestroyedEnemyVehicles(DestroyedEnemyVehicle[] DestroyedEnemyVehicles) {
        this.DestroyedEnemyVehicles = DestroyedEnemyVehicles;
    }

    /**
     * 
     * @return
     *     The EnemyKills
     */
    public EnemyKill[] getEnemyKills() {
        return EnemyKills;
    }

    /**
     *
     * @param EnemyKills
     *     The EnemyKills
     */
    public void setEnemyKills(EnemyKill[] EnemyKills) {
        this.EnemyKills = EnemyKills;
    }

    /**
     * 
     * @return
     *     The WeaponStats
     */
    public WeaponStat[] getWeaponStats() {
        return WeaponStats;
    }

    /**
     *
     * @param WeaponStats
     *     The WeaponStats
     */
    public void setWeaponStats(WeaponStat[] WeaponStats) {
        this.WeaponStats = WeaponStats;
    }

    /**
     * 
     * @return
     *     The Impulses
     */
    public Impulse[] getImpulses() {
        return Impulses;
    }

    /**
     *
     * @param Impulses
     *     The Impulses
     */
    public void setImpulses(Impulse[] Impulses) {
        this.Impulses = Impulses;
    }

    /**
     * 
     * @return
     *     The TotalSpartanKills
     */
    public String getTotalSpartanKills() {
        return TotalSpartanKills;
    }

    /**
     * 
     * @param TotalSpartanKills
     *     The TotalSpartanKills
     */
    public void setTotalSpartanKills(String TotalSpartanKills) {
        this.TotalSpartanKills = TotalSpartanKills;
    }

}
