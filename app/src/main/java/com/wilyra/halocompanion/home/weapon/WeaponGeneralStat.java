package com.wilyra.halocompanion.home.weapon;

import com.wilyra.halocompanion.haloapi.model.Weapon;
import com.wilyra.halocompanion.haloapi.model.common.WeaponStat;

/**
 * Created by wilyr on 11/24/2015.
 */
public class WeaponGeneralStat extends WeaponStat{

    public Weapon getWeapon() {
        return weapon;
    }

    private Weapon weapon;

    public WeaponGeneralStat(com.wilyra.halocompanion.haloapi.model.common.WeaponId weaponId,
                             String totalShotsFired,
                             String totalShotsLanded,
                             String totalHeadShots,
                             String totalKills,
                             String totalDamageDealt,
                             String totalPossessionTime,
                             Weapon weapon)
    {
        this.setWeaponId(weaponId);
        this.setTotalShotsFired(totalShotsFired);
        this.setTotalShotsLanded(totalShotsLanded);
        this.setTotalHeadshots(totalHeadShots);
        this.setTotalKills(totalKills);
        this.setTotalDamageDealt(totalDamageDealt);
        this.setTotalPossessionTime(totalPossessionTime);
        this.weapon = weapon;
    }

    public void addWeaponStat(WeaponGeneralStat stat)
    {
        this.setTotalShotsFired(String.valueOf(Integer.parseInt(this.getTotalShotsFired()) + Integer.parseInt(stat.getTotalShotsFired())));
        this.setTotalShotsLanded(String.valueOf(Integer.parseInt(this.getTotalShotsLanded()) + Integer.parseInt(stat.getTotalShotsLanded())));
        this.setTotalHeadshots(String.valueOf(Integer.parseInt(this.getTotalHeadshots()) + Integer.parseInt(stat.getTotalHeadshots())));
        this.setTotalKills(String.valueOf(Integer.parseInt(this.getTotalKills()) + Integer.parseInt(stat.getTotalKills())));
        this.setTotalDamageDealt(String.valueOf(Double.parseDouble(this.getTotalDamageDealt()) + Double.parseDouble(stat.getTotalDamageDealt())));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WeaponGeneralStat that = (WeaponGeneralStat) o;

        return weapon.equals(that.weapon);

    }

    @Override
    public int hashCode() {
        return weapon.hashCode();
    }
}
