package com.wilyra.halocompanion.home.medal;

import com.wilyra.halocompanion.haloapi.model.common.MedalAward;
import com.wilyra.halocompanion.haloapi.model.medals.Medals;

/**
 * Created by wilyr on 11/24/2015.
 */
public class MedalGeneralStat extends MedalAward {

    private Medals medal;
    private String id;

    public MedalGeneralStat(int nbAwards, String id, Medals medal)
    {
        this.setCount(nbAwards);
        this.id = id;
        this.medal = medal;
    }


    public void addMedalAward(int nbAwards)
    {
        this.setCount(getCount() + nbAwards);
    }

    public Medals getMedal()
    {
        return (medal);
    }

}
