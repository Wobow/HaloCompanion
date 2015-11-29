package com.wilyra.halocompanion.home;

import android.os.Parcel;
import android.os.Parcelable;

import com.wilyra.halocompanion.MetadataContainer;
import com.wilyra.halocompanion.haloapi.model.Weapon;
import com.wilyra.halocompanion.haloapi.model.arenastats.ArenaStats;
import com.wilyra.halocompanion.haloapi.model.common.MedalAward;
import com.wilyra.halocompanion.haloapi.model.common.WeaponStat;
import com.wilyra.halocompanion.haloapi.model.medals.Medals;
import com.wilyra.halocompanion.haloapi.model.warzonestats.WarzoneStats;
import com.wilyra.halocompanion.home.medal.MedalGeneralStat;
import com.wilyra.halocompanion.home.weapon.WeaponGeneralStat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by wilyr on 11/23/2015.
 */
public class PlayerStats implements Parcelable {


    public ArenaStats getArenaStats() {
        return arenaStats;
    }

    public WarzoneStats getWarzoneStats() {
        return warzoneStats;
    }

    public MetadataContainer getMetadataContainer() {
        return metadataContainer;
    }

    public String getGamertag() {
        return gamertag;
    }

    public int getTotalKills() {
        return totalKills;
    }

    public int getTotalDeath() {
        return totalDeath;
    }

    public int getTotalGames() {
        return totalGames;
    }

    public int getTotalGamesWon() {
        return totalGamesWon;
    }

    public int getTotalAssists() {
        return totalAssists;
    }

    public int getTotalHeadshots() {
        return totalHeadshots;
    }

    public float getKillsPerGame() {
        return killsPerGame;
    }

    public String getSpartanRank() {
        return spartanRank;
    }

    public int getRank() {
        return rank;
    }

    public String getTotalXp() {
        return totalXp;
    }

    public int getXpMissing() {
        return xpMissing;
    }

    public int getdXp() {
        return dXp;
    }

    public int getPercentageXp() {
        return percentageXp;
    }

    public String getTotalTimePlayed() {
        return totalTimePlayed;
    }

    public String getTotalKillsText() {
        return totalKillsText;
    }

    public String getTotalKDText() {
        return totalKDText;
    }

    public String getTotalGamesText() {
        return totalGamesText;
    }

    public String getTotalWinRate() {
        return totalWinRate;
    }

    public WeaponGeneralStat getMaxVehicle() {
        return maxVehicle;
    }

    public WeaponGeneralStat getMaxWeapon() {
        return maxWeapon;
    }

    public List<WeaponGeneralStat> getWeaponGeneralStats() {
        return weaponGeneralStats;
    }

    public List<MedalGeneralStat> getMedalGeneralStats() {
        return medalGeneralStats;
    }

    private int totalKills;
    private int totalDeath;
    private int totalGames;
    private int totalGamesWon;
    private int totalAssists;
    private int totalHeadshots;
    private float killsPerGame;
    private String spartanRank;
    private int rank;
    private String totalXp;
    private int xpMissing;
    private int dXp;
    private int percentageXp;
    private String totalTimePlayed;
    private String totalKillsText;
    private String totalKDText;
    private String totalGamesText;
    private String totalWinRate;
    private ArenaStats arenaStats;
    private WarzoneStats warzoneStats;
    private MetadataContainer metadataContainer;
    private String gamertag;
    private WeaponGeneralStat maxVehicle;
    private WeaponGeneralStat maxWeapon;

    public WeaponGeneralStat getMaxArenaVehicle() {
        return maxArenaVehicle;
    }

    public WeaponGeneralStat getMaxArenaWeapon() {
        return maxArenaWeapon;
    }

    public WeaponGeneralStat getMaxWarzoneVehicle() {
        return maxWarzoneVehicle;
    }

    public WeaponGeneralStat getMaxWarzoneWeapon() {
        return maxWarzoneWeapon;
    }

    public List<WeaponGeneralStat> getWeaponArenaStats() {
        return weaponArenaStats;
    }

    public List<WeaponGeneralStat> getWeaponWarzoneStats() {
        return weaponWarzoneStats;
    }

    private WeaponGeneralStat maxArenaVehicle;
    private WeaponGeneralStat maxArenaWeapon;
    private WeaponGeneralStat maxWarzoneVehicle;
    private WeaponGeneralStat maxWarzoneWeapon;
    private List<WeaponGeneralStat> weaponGeneralStats = new ArrayList<>();
    private List<WeaponGeneralStat> weaponArenaStats = new ArrayList<>();
    private List<WeaponGeneralStat> weaponWarzoneStats = new ArrayList<>();


    private List<MedalGeneralStat> medalGeneralStats = new ArrayList<>();

    public List<MedalGeneralStat> getMedalArenaStats() {
        return medalArenaStats;
    }

    public List<MedalGeneralStat> getMedalWarzoneStats() {
        return medalWarzoneStats;
    }

    private List<MedalGeneralStat> medalArenaStats = new ArrayList<>();
    private List<MedalGeneralStat> medalWarzoneStats = new ArrayList<>();


    public PlayerStats(String gamertag, WarzoneStats warzoneStats, ArenaStats arenaStats, MetadataContainer metadataContainer)
    {
        this.gamertag = gamertag;
        this.warzoneStats = warzoneStats;
        this.arenaStats = arenaStats;
        this.metadataContainer = metadataContainer;
        loadStats();
    }

    private void loadStats() {
        if (metadataContainer.getRanks() == null) {
            metadataContainer.loadMetadata();
        }
        totalKills = Integer.parseInt(this.arenaStats.getResults()[0].getResult().getArenaStats().getTotalSpartanKills()) + Integer.parseInt(this.warzoneStats.getResults()[0].getResult().getWarzoneStat().getTotalSpartanKills());
        totalDeath = Integer.parseInt(this.arenaStats.getResults()[0].getResult().getArenaStats().getTotalDeaths()) + Integer.parseInt(this.warzoneStats.getResults()[0].getResult().getWarzoneStat().getTotalDeaths());
        totalGames = Integer.parseInt(this.arenaStats.getResults()[0].getResult().getArenaStats().getTotalGamesCompleted()) + Integer.parseInt(this.warzoneStats.getResults()[0].getResult().getWarzoneStat().getTotalGamesCompleted());
        totalGamesWon = Integer.parseInt(this.arenaStats.getResults()[0].getResult().getArenaStats().getTotalGamesWon()) + Integer.parseInt(this.warzoneStats.getResults()[0].getResult().getWarzoneStat().getTotalGamesWon());
        totalAssists = Integer.parseInt(this.arenaStats.getResults()[0].getResult().getArenaStats().getTotalAssists()) + Integer.parseInt(this.warzoneStats.getResults()[0].getResult().getWarzoneStat().getTotalAssists());
        totalHeadshots = Integer.parseInt(this.arenaStats.getResults()[0].getResult().getArenaStats().getTotalHeadshots()) + Integer.parseInt(this.warzoneStats.getResults()[0].getResult().getWarzoneStat().getTotalHeadshots());
        killsPerGame = totalGames == 0 ? 0 : (float)totalKills / (float)totalGames;

        spartanRank = this.arenaStats.getResults()[0].getResult().getSpartanRank();
        rank = Integer.parseInt(spartanRank);
        totalXp = "";
        if (rank == 152)
            totalXp = "Rank Max";
        else {
            xpMissing = Integer.parseInt(metadataContainer.getRanks()[rank].getStartXp()) - Integer.parseInt(this.arenaStats.getResults()[0].getResult().getXp());
            dXp = Integer.parseInt(metadataContainer.getRanks()[rank].getStartXp()) - Integer.parseInt(metadataContainer.getRanks()[rank - 1].getStartXp());
            percentageXp = (int) (100 - ((float) xpMissing / (float) dXp * 100));
            totalXp = String.format("%d XP (%d%%)", xpMissing, percentageXp);
        }
        totalKillsText = String.valueOf(totalKills);
        totalKDText = String.format("%.2f", totalDeath == 0 ? (float) totalKills : (float) totalKills / (float) totalDeath);
        totalGamesText = String.valueOf(totalGames);
        totalWinRate = String.format("%.0f%%", totalGames == 0 ? 0 : ((float) totalGamesWon / (float) totalGames) * 100);

        ISO8601Duration dur1 = new ISO8601Duration(this.arenaStats.getResults()[0].getResult().getArenaStats().getTotalTimePlayed());
        ISO8601Duration dur2 = new ISO8601Duration(this.warzoneStats.getResults()[0].getResult().getWarzoneStat().getTotalTimePlayed());
        dur1.addDuration(dur2);
        totalTimePlayed = dur1.toString();
        loadWeaponStats();
        loadMedalsStats();
    }

    public void loadWeaponStats() {
        Weapon current = null;
        for (WeaponStat w : this.arenaStats.getResults()[0].getResult().getArenaStats().getWeaponStats())
            if ((current = getWeapon(w)) != null) {
                WeaponGeneralStat wp = new WeaponGeneralStat(w.getWeaponId(), w.getTotalShotsFired(), w.getTotalShotsLanded(), w.getTotalHeadshots(), w.getTotalKills(), w.getTotalDamageDealt(), w.getTotalPossessionTime(),
                        current);
                weaponGeneralStats.add(wp);
                weaponArenaStats.add(wp);
            }
        for (WeaponStat w : this.warzoneStats.getResults()[0].getResult().getWarzoneStat().getWeaponStats())
            if ((current = getWeapon(w)) != null) {
                WeaponGeneralStat toAdd = new WeaponGeneralStat(w.getWeaponId(), w.getTotalShotsFired(), w.getTotalShotsLanded(), w.getTotalHeadshots(), w.getTotalKills(), w.getTotalDamageDealt(), w.getTotalPossessionTime(),
                        current);
                if (weaponGeneralStats.contains(toAdd))
                    weaponGeneralStats.get(weaponGeneralStats.indexOf(toAdd)).addWeaponStat(toAdd);
                else
                    weaponGeneralStats.add(toAdd);
                weaponWarzoneStats.add(toAdd);
            }

        int max = -1;
        for (WeaponGeneralStat s : weaponGeneralStats)
            if (s.getWeapon().getType().compareTo("Vehicle") != 0 && Integer.parseInt(s.getTotalKills()) > max) {
                maxWeapon = s;
                max = Integer.parseInt(s.getTotalKills());
            }
        max = -1;
        for (WeaponGeneralStat s : weaponGeneralStats)
            if (s.getWeapon().getType().compareTo("Vehicle") == 0 && Integer.parseInt(s.getTotalKills()) > max) {
                maxVehicle = s;
                max = Integer.parseInt(s.getTotalKills());
            }

        max = -1;
        for (WeaponGeneralStat s : weaponArenaStats)
            if (s.getWeapon().getType().compareTo("Vehicle") != 0 && Integer.parseInt(s.getTotalKills()) > max) {
                maxArenaWeapon = s;
                max = Integer.parseInt(s.getTotalKills());
            }
        max = -1;
        for (WeaponGeneralStat s : weaponArenaStats)
            if (s.getWeapon().getType().compareTo("Vehicle") == 0 && Integer.parseInt(s.getTotalKills()) > max) {
                maxArenaVehicle = s;
                max = Integer.parseInt(s.getTotalKills());
            }
        max = -1;
        for (WeaponGeneralStat s : weaponWarzoneStats)
            if (s.getWeapon().getType().compareTo("Vehicle") != 0 && Integer.parseInt(s.getTotalKills()) > max) {
                maxWarzoneWeapon = s;
                max = Integer.parseInt(s.getTotalKills());
            }
        max = -1;
        for (WeaponGeneralStat s : weaponWarzoneStats)
            if (s.getWeapon().getType().compareTo("Vehicle") == 0 && Integer.parseInt(s.getTotalKills()) > max) {
                maxWarzoneVehicle = s;
                max = Integer.parseInt(s.getTotalKills());
            }

    }

    public void loadMedalsStats()
    {
        for (Medals m : metadataContainer.getMedals()) {
            medalGeneralStats.add(new MedalGeneralStat(0, m.getId(), m));
            medalArenaStats.add(new MedalGeneralStat(0, m.getId(), m));
            medalWarzoneStats.add(new MedalGeneralStat(0, m.getId(), m));
        }
        for (MedalAward ma : this.arenaStats.getResults()[0].getResult().getArenaStats().getMedalAwards()) {
            int i;
            if ((i = getFromList(medalGeneralStats, ma.getMedalId())) != -1) {
                medalGeneralStats.get(i).addMedalAward(ma.getCount());
                medalArenaStats.get(i).addMedalAward(ma.getCount());
            }
        }
        for (MedalAward ma : this.warzoneStats.getResults()[0].getResult().getWarzoneStat().getMedalAwards()) {
            int i;
            if ((i = getFromList(medalGeneralStats, ma.getMedalId())) != -1) {
                medalGeneralStats.get(i).addMedalAward(ma.getCount());
                medalWarzoneStats.get(i).addMedalAward(ma.getCount());
            }
        }
        Collections.sort(medalGeneralStats, new MedalCountComparator());
        Collections.sort(medalArenaStats, new MedalCountComparator());
        Collections.sort(medalWarzoneStats, new MedalCountComparator());
    }

    public void loadMedalsBreakout()
    {

    }
    public void loadMedalsSpree()
    {

    }
    public void loadMedalsMultiKill()
    {

    }
    public void loadMedalsObjective()
    {

    }
    public void loadMedalsStyle()
    {

    }
    public void loadMedalsVehicule()
    {

    }

    public int getFromList(List<MedalGeneralStat> c, String id) {
        for(MedalGeneralStat o : c) {
            if(o != null && o.getMedal().getId().compareTo(id) == 0) {
                return c.indexOf(o);
            }
        }
        return -1;
    }

    public Weapon getWeapon(WeaponStat w)
    {
        int i = 0;
        while (i < metadataContainer.getWeapons().length) {
            if (metadataContainer.getWeapons()[i].getId().compareTo(w.getWeaponId().getStockId()) == 0)
                return (metadataContainer.getWeapons()[i]);
            i++;
        }
        return null;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    public static class MedalDifficultyComparator implements Comparator<MedalGeneralStat> {

        @Override
        public int compare(MedalGeneralStat lhs, MedalGeneralStat rhs) {
            return rhs.getMedal().getDifficulty() - lhs.getMedal().getDifficulty();
            //TODO REAL DIFFICULTY COMPARATOR
        }
    }

    public static class MedalNameComparator implements Comparator<MedalGeneralStat> {

        @Override
        public int compare(MedalGeneralStat lhs, MedalGeneralStat rhs) {
            return lhs.getMedal().getName().compareTo(rhs.getMedal().getName());
        }
    }

    public static class MedalCountComparator implements Comparator<MedalGeneralStat> {
        @Override
        public int compare(MedalGeneralStat lhs, MedalGeneralStat rhs) {
            return rhs.getCount() - lhs.getCount();
        }
    }

    public static class WeaponKillComparator implements Comparator<WeaponGeneralStat> {
        @Override
        public int compare(WeaponGeneralStat lhs, WeaponGeneralStat rhs) {
            return (Integer.parseInt(rhs.getTotalKills()) - Integer.parseInt(lhs.getTotalKills()));
        }
    }

    public static class WeaponHeadshotsComparator implements Comparator<WeaponGeneralStat> {
        @Override
        public int compare(WeaponGeneralStat lhs, WeaponGeneralStat rhs) {
            return (Integer.parseInt(rhs.getTotalHeadshots()) - Integer.parseInt(lhs.getTotalHeadshots()));
        }
    }

    public static class WeaponShotsComparator implements Comparator<WeaponGeneralStat> {
        @Override
        public int compare(WeaponGeneralStat lhs, WeaponGeneralStat rhs) {
            return (Integer.parseInt(rhs.getTotalShotsFired()) - Integer.parseInt(lhs.getTotalShotsFired()));
        }
    }

    public static class WeaponAccuracyComparator implements Comparator<WeaponGeneralStat> {
        @Override
        public int compare(WeaponGeneralStat lhs, WeaponGeneralStat rhs) {
            int f1 = (int) (Float.parseFloat(lhs.getTotalShotsLanded()) / Float.parseFloat(lhs.getTotalShotsFired()) * 100);
            int f2 = (int) (Float.parseFloat(rhs.getTotalShotsLanded()) / Float.parseFloat(rhs.getTotalShotsFired()) * 100);;
            return (f2 - f1);
        }
    }
    public static class WeaponNameComparator implements Comparator<WeaponGeneralStat> {
        @Override
        public int compare(WeaponGeneralStat lhs, WeaponGeneralStat rhs) {
            return (rhs.getWeapon().getName().compareTo(lhs.getWeapon().getName()));
        }
    }
}
