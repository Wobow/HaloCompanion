package com.wilyra.halocompanion.home;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.wilyra.halocompanion.R;
import com.wilyra.halocompanion.home.medal.MedalView;

/**
 * Created by wilyr on 11/25/2015.
 */
public class GeneralStatsFragment extends Fragment implements DisplayInterface{
    private TextView totalKillsView;
    private TextView totalKDView;
    private TextView totalGamesView;
    private TextView totalWinRateView;
    private TextView totalAssistsView;
    private TextView totalHeadshotsView;
    private TextView killPerGameView;
    private TextView spartanRankView;
    private TextView totalXpView;
    private TextView totalTimePlayerView;
    private ProgressBar percentageXpView;
    private TextView toolOfDestruction;
    private TextView vehicleOfDestruction;
    private ImageView toolOfDestructionImage;
    private ImageView vehicleOfDestructionImage;
    private TextView weaponTitle;
    private LinearLayout weaponContainer;

    private LinearLayout medalsContainer;

    private HomeCallback callback;
    private DisplayStateEnum currentState = DisplayStateEnum.DISPLAY_BOTH;
    private boolean loaded = false;

    public GeneralStatsFragment()
    {}

    public static GeneralStatsFragment newInstance(HomeCallback callback)
    {
        GeneralStatsFragment me = new GeneralStatsFragment();
        me.callback = callback;
        return (me);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.general_stats_view, container, false);
        totalKillsView = (TextView) rootView.findViewById(R.id.kills);
        totalKDView = (TextView) rootView.findViewById(R.id.kd);
        totalGamesView = (TextView) rootView.findViewById(R.id.games);
        totalWinRateView = (TextView) rootView.findViewById(R.id.lvl);
        totalAssistsView = (TextView) rootView.findViewById(R.id.assists);
        totalHeadshotsView = (TextView) rootView.findViewById(R.id.headshots);
        killPerGameView = (TextView) rootView.findViewById(R.id.killspgame);
        spartanRankView = (TextView) rootView.findViewById(R.id.spartanrank);
        totalXpView = (TextView) rootView.findViewById(R.id.xp);
        totalTimePlayerView = (TextView) rootView.findViewById(R.id.playtime);
        percentageXpView = (ProgressBar) rootView.findViewById(R.id.progressXp);
        toolOfDestruction = (TextView) rootView.findViewById(R.id.weaponMostKills);
        vehicleOfDestruction = (TextView) rootView.findViewById(R.id.vehicleMostKills);
        toolOfDestructionImage = (ImageView) rootView.findViewById(R.id.weaponMostKillsImage);
        vehicleOfDestructionImage = (ImageView) rootView.findViewById(R.id.vehicleMostKillsImage);
        medalsContainer = (LinearLayout) rootView.findViewById(R.id.medalsContainer);

        weaponTitle = (TextView) rootView.findViewById(R.id.titleWeapon);
        weaponContainer = (LinearLayout) rootView.findViewById(R.id.weaponContainer);



        RelativeLayout buttonSeeAllMedals = (RelativeLayout) rootView.findViewById(R.id.medals_see_more);
        buttonSeeAllMedals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.changeFragmentToMedals();
            }
        });

        RelativeLayout buttonSeeAllWeapons = (RelativeLayout) rootView.findViewById(R.id.weapons_see_more);
        buttonSeeAllWeapons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.changeFragmentToWeapons();
            }
        });
        return (rootView);
    }

    @Override
    public void onResume()
    {
        super.onResume();

        if (loaded)
            displayCurrent(currentState);
    }

    public void updateStats() {

        if (percentageXpView == null)
            return ;
        loaded = true;
        percentageXpView.setMax(100);
        percentageXpView.setProgress(callback.getPlayerStats().getPercentageXp());
        spartanRankView.setText(callback.getPlayerStats().getSpartanRank());
        totalXpView.setText(callback.getPlayerStats().getTotalXp());
    }

    public void displayArenaStats()
    {
        updateStats();
        if (totalKillsView == null)
            return ;
        totalKillsView.setText(callback.getPlayerStats().getArenaStats().getResults()[0].getResult().getArenaStats().getTotalSpartanKills());
        totalKDView.setText(String.format("%.2f", Float.parseFloat(callback.getPlayerStats().getArenaStats().getResults()[0].getResult().getArenaStats().getTotalSpartanKills()) / (Float.parseFloat(callback.getPlayerStats().getArenaStats().getResults()[0].getResult().getArenaStats().getTotalDeaths()) == 0 ? 1 : Float.parseFloat(callback.getPlayerStats().getArenaStats().getResults()[0].getResult().getArenaStats().getTotalDeaths()))));
        totalGamesView.setText(callback.getPlayerStats().getArenaStats().getResults()[0].getResult().getArenaStats().getTotalGamesCompleted());
        totalWinRateView.setText(String.format("%.0f%%", Float.parseFloat(callback.getPlayerStats().getArenaStats().getResults()[0].getResult().getArenaStats().getTotalGamesWon()) / (Float.parseFloat(callback.getPlayerStats().getArenaStats().getResults()[0].getResult().getArenaStats().getTotalGamesCompleted()) == 0 ? 1 : Float.parseFloat(callback.getPlayerStats().getArenaStats().getResults()[0].getResult().getArenaStats().getTotalGamesCompleted())) * 100));
        totalAssistsView.setText(callback.getPlayerStats().getArenaStats().getResults()[0].getResult().getArenaStats().getTotalAssists());
        totalHeadshotsView.setText(callback.getPlayerStats().getArenaStats().getResults()[0].getResult().getArenaStats().getTotalHeadshots());
        killPerGameView.setText(String.format("%.2f", Float.parseFloat(callback.getPlayerStats().getArenaStats().getResults()[0].getResult().getArenaStats().getTotalSpartanKills()) / (Float.parseFloat(callback.getPlayerStats().getArenaStats().getResults()[0].getResult().getArenaStats().getTotalGamesCompleted()) == 0 ? 1 : Float.parseFloat(callback.getPlayerStats().getArenaStats().getResults()[0].getResult().getArenaStats().getTotalGamesCompleted()))));
        ISO8601Duration dur = new ISO8601Duration(callback.getPlayerStats().getArenaStats().getResults()[0].getResult().getArenaStats().getTotalTimePlayed());
        totalTimePlayerView.setText(dur.toString());
        toolOfDestruction.setText(callback.getPlayerStats().getMaxArenaWeapon().getTotalKills() + " Kills");
        vehicleOfDestruction.setText(callback.getPlayerStats().getMaxArenaVehicle().getTotalKills() + " Kills");

        Picasso.with(getActivity()).load(callback.getPlayerStats().getMaxArenaWeapon().getWeapon().getSmallIconImageUrl()).into(toolOfDestructionImage);
        Picasso.with(getActivity()).load(callback.getPlayerStats().getMaxArenaVehicle().getWeapon().getSmallIconImageUrl()).into(vehicleOfDestructionImage);
        medalsContainer.removeAllViews();TableRow.LayoutParams rp = new TableRow.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 0.25f);

        for (int i = 0; i < 4; i++)
        {
            MedalView mv = new MedalView(getActivity());
            mv.setMedalStat(callback.getPlayerStats().getMedalGeneralStats().get(i));
            mv.setLayoutParams(rp);
            medalsContainer.addView(mv);
        }
    }


    public void displayWarzoneStats()
    {
        updateStats();
        if (totalKillsView == null)
            return ;
        totalKillsView.setText(callback.getPlayerStats().getWarzoneStats().getResults()[0].getResult().getWarzoneStat().getTotalSpartanKills());
        totalKDView.setText(String.format("%.2f", Float.parseFloat(callback.getPlayerStats().getWarzoneStats().getResults()[0].getResult().getWarzoneStat().getTotalSpartanKills()) / (Float.parseFloat(callback.getPlayerStats().getWarzoneStats().getResults()[0].getResult().getWarzoneStat().getTotalDeaths()) == 0 ? 1 : Float.parseFloat(callback.getPlayerStats().getWarzoneStats().getResults()[0].getResult().getWarzoneStat().getTotalDeaths()))));
        totalGamesView.setText(callback.getPlayerStats().getWarzoneStats().getResults()[0].getResult().getWarzoneStat().getTotalGamesCompleted());
        totalWinRateView.setText(String.format("%.0f%%", Float.parseFloat(callback.getPlayerStats().getWarzoneStats().getResults()[0].getResult().getWarzoneStat().getTotalGamesWon()) / (Float.parseFloat(callback.getPlayerStats().getWarzoneStats().getResults()[0].getResult().getWarzoneStat().getTotalGamesCompleted()) == 0 ? 1 : Float.parseFloat(callback.getPlayerStats().getWarzoneStats().getResults()[0].getResult().getWarzoneStat().getTotalGamesCompleted())) * 100));
        totalAssistsView.setText(callback.getPlayerStats().getWarzoneStats().getResults()[0].getResult().getWarzoneStat().getTotalAssists());
        totalHeadshotsView.setText(callback.getPlayerStats().getWarzoneStats().getResults()[0].getResult().getWarzoneStat().getTotalHeadshots());
        killPerGameView.setText(String.format("%.2f", Float.parseFloat(callback.getPlayerStats().getWarzoneStats().getResults()[0].getResult().getWarzoneStat().getTotalSpartanKills()) / (Float.parseFloat(callback.getPlayerStats().getWarzoneStats().getResults()[0].getResult().getWarzoneStat().getTotalGamesCompleted()) == 0 ? 1 : Float.parseFloat(callback.getPlayerStats().getWarzoneStats().getResults()[0].getResult().getWarzoneStat().getTotalGamesCompleted()))));
        ISO8601Duration dur = new ISO8601Duration(callback.getPlayerStats().getWarzoneStats().getResults()[0].getResult().getWarzoneStat().getTotalTimePlayed());
        totalTimePlayerView.setText(dur.toString());
        toolOfDestruction.setText(callback.getPlayerStats().getMaxWarzoneWeapon().getTotalKills() + " Kills");
        vehicleOfDestruction.setText(callback.getPlayerStats().getMaxWarzoneVehicle().getTotalKills() + " Kills");

        Picasso.with(getActivity()).load(callback.getPlayerStats().getMaxWarzoneWeapon().getWeapon().getSmallIconImageUrl()).into(toolOfDestructionImage);
        Picasso.with(getActivity()).load(callback.getPlayerStats().getMaxWarzoneVehicle().getWeapon().getSmallIconImageUrl()).into(vehicleOfDestructionImage);
        medalsContainer.removeAllViews();TableRow.LayoutParams rp = new TableRow.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 0.25f);

        for (int i = 0; i < 4; i++)
        {
            MedalView mv = new MedalView(getActivity());
            mv.setMedalStat(callback.getPlayerStats().getMedalGeneralStats().get(i));
            mv.setLayoutParams(rp);
            medalsContainer.addView(mv);
        }
    }

    public void displayBothStats() {
        updateStats();
        if (totalKillsView == null)
            return ;
        totalKillsView.setText(callback.getPlayerStats().getTotalKillsText());
        totalKDView.setText(callback.getPlayerStats().getTotalKDText());
        totalGamesView.setText(callback.getPlayerStats().getTotalGamesText());
        totalWinRateView.setText(callback.getPlayerStats().getTotalWinRate());
        totalAssistsView.setText(String.valueOf(callback.getPlayerStats().getTotalAssists()));
        totalHeadshotsView.setText(String.valueOf(callback.getPlayerStats().getTotalHeadshots()));
        killPerGameView.setText(String.format("%.2f", callback.getPlayerStats().getKillsPerGame()));
        totalTimePlayerView.setText(callback.getPlayerStats().getTotalTimePlayed());
        toolOfDestruction.setText(callback.getPlayerStats().getMaxWeapon().getTotalKills() + " Kills");
        vehicleOfDestruction.setText(callback.getPlayerStats().getMaxVehicle().getTotalKills() + " Kills");


        Picasso.with(getActivity()).load(callback.getPlayerStats().getMaxWeapon().getWeapon().getSmallIconImageUrl()).into(toolOfDestructionImage);
        Picasso.with(getActivity()).load(callback.getPlayerStats().getMaxVehicle().getWeapon().getSmallIconImageUrl()).into(vehicleOfDestructionImage);
        medalsContainer.removeAllViews();TableRow.LayoutParams rp = new TableRow.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 0.25f);

        for (int i = 0; i < 4; i++)
        {
            MedalView mv = new MedalView(getActivity());
            mv.setMedalStat(callback.getPlayerStats().getMedalGeneralStats().get(i));
            mv.setLayoutParams(rp);
            medalsContainer.addView(mv);
        }
    }

    @Override
    public void displayCurrent(DisplayStateEnum state) {
        this.currentState = state;
        switch (state) {
            case DISPLAY_ARENA:
                displayArenaStats();
                break;
            case DISPLAY_BOTH:
                displayBothStats();
                break;
            case DISPLAY_WARZONE:
                displayWarzoneStats();
                break;
            default:
                displayBothStats();
                break;
        }
    }

}
