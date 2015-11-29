package com.wilyra.halocompanion;

import android.graphics.Bitmap;

import com.wilyra.halocompanion.haloapi.model.Map;
import com.wilyra.halocompanion.haloapi.model.Weapon;
import com.wilyra.halocompanion.haloapi.model.gamevariant.GameVariant;
import com.wilyra.halocompanion.haloapi.model.medals.Medals;
import com.wilyra.halocompanion.haloapi.model.spartanrank.SpartanRank;
import com.wilyra.halocompanion.haloapi.tasks.GameVariantTask;
import com.wilyra.halocompanion.haloapi.tasks.MapTask;
import com.wilyra.halocompanion.haloapi.tasks.MedalsTask;
import com.wilyra.halocompanion.haloapi.tasks.SpartanRankTask;
import com.wilyra.halocompanion.haloapi.tasks.WeaponTask;

import java.util.UUID;

/**
 * Created by wilyr on 11/20/2015.
 */
public class MetadataContainer implements MapTask.OnMapTaskFinishedListener, SpartanRankTask.OnSpartanRankTaskFinishedListener,
        WeaponTask.OnWeaponTaskFinishedListener, MedalsTask.OnMedalsTaskFinishedListener, GameVariantTask.OnGameVariantTaskFinishedListener {

    private Map[] maps;
    private SpartanRank[] ranks;
    private Weapon[] weapons;
    private Medals[] medals;

    public GameVariant[] getGameVariants() {
        return gameVariants;
    }

    private GameVariant[] gameVariants;

    public Map[] getMaps() {
        return maps;
    }

    public SpartanRank[] getRanks() {
        return ranks;
    }

    public Weapon[] getWeapons() {
        return weapons;
    }

    public Medals[] getMedals() {
        return medals;
    }

    public Map getMapWithId(UUID id)
    {
        if (maps == null)
            loadMetadata();
        for (Map m : maps)
        {
            if (m.getId().equals(id))
                return (m);
        }
        return (null);
    }

    public void setMapImageFromId(Bitmap bm, UUID id) {
        if (maps == null)
            loadMetadata();
        for (int i = 0; i < maps.length; i++)
        {
            if (maps[i].getId().equals(id)) {
                maps[i].setImage(bm);
            }
        }
    }

    public Bitmap getMapImageFromId(UUID id) {
        if (maps == null)
            loadMetadata();
        for (Map m : maps) {
            if (m.getId().equals(id))
                return (m.getImage());
        }
        return (null);
    }

    public GameVariant getGameVariantWithId(UUID id)
    {
        if (gameVariants == null)
            loadMetadata();
        for (GameVariant g : gameVariants)
            if (g.getId().equals(id))
                return (g);
        return (null);
    }

    public MetadataContainer()
    {
    }

    public void loadMetadata()
    {
        MapTask mapTask = new MapTask();
        mapTask.setOnTaskFinishedListener(this);
        mapTask.execute("");
        SpartanRankTask spartanRankTask = new SpartanRankTask();
        spartanRankTask.setOnTaskFinishedListener(this);
        spartanRankTask.execute("");
        WeaponTask weaponTask = new WeaponTask();
        weaponTask.setOnTaskFinishedListener(this);
        weaponTask.execute("");
        MedalsTask medalsTask = new MedalsTask();
        medalsTask.setOnTaskFinishedListener(this);
        medalsTask.execute("");
    }

    @Override
    public void onMapTaskFinished(Map[] maps) {
        this.maps = maps;
    }

    @Override
    public void onSpartanRankTaskFinished(SpartanRank[] ranks) {
        this.ranks = ranks;
    }

    @Override
    public void onWeaponTaskFinished(Weapon[] weapons) {
        this.weapons = weapons;
    }

    @Override
    public void onMedalsTaskFinished(Medals[] medals) {
        this.medals = medals;
    }

    @Override
    public void onGameVariantTaskFinished(GameVariant[] gameVariants) {
        this.gameVariants = gameVariants;
    }

    @Override
    public MainActivity getMainActivity() {
        return null;
    }
}
