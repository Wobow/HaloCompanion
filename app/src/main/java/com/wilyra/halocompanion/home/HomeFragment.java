package com.wilyra.halocompanion.home;

import android.app.Fragment;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.wilyra.halocompanion.IBackPressed;
import com.wilyra.halocompanion.MainActivity;
import com.wilyra.halocompanion.R;
import com.wilyra.halocompanion.haloapi.model.arenastats.ArenaStats;
import com.wilyra.halocompanion.haloapi.model.warzonestats.WarzoneStats;
import com.wilyra.halocompanion.haloapi.tasks.ArenaStatsTask;
import com.wilyra.halocompanion.haloapi.tasks.EmblemImageTask;
import com.wilyra.halocompanion.haloapi.tasks.SpartanImageTask;
import com.wilyra.halocompanion.haloapi.tasks.WarzoneStatsTask;
import com.wilyra.halocompanion.home.medal.MedalFragment;
import com.wilyra.halocompanion.home.weapon.WeaponsFragment;


/**
 * Created by wilyr on 11/20/2015.
 */
public class HomeFragment extends Fragment implements ArenaStatsTask.OnArenaStatsTaskFinishedListener, WarzoneStatsTask.OnWarzoneStatsTaskFinishedListener,
        SpartanImageTask.OnSpartanImageTaskFinishedListener, HomeCallback, IBackPressed
{
    ArenaStats arenaStats;
    WarzoneStats warzoneStats;
    boolean warzoneTaskFinished = false;
    boolean arenaTaskFinished = false;
    ArenaStatsTask arenaStatsTask;
    WarzoneStatsTask warzoneStatsTask;
    View rootView = null;
    PlayerStats playerStats = null;
    private LoginCallback callback;

    private Button buttonDisplayArena;
    private Button buttonDisplayWarzone;
    private Button buttonDisplayBoth;
    private TextView gtView;

    private DisplayInterface currentDisplay;
    private DisplayInterface.DisplayStateEnum currentDisplayState = DisplayInterface.DisplayStateEnum.DISPLAY_BOTH;
    private boolean navigationGoDeeper;
    GeneralStatsFragment generalStatsFragment;
    private ImageView emblem;

    public HomeFragment()
    {

    }

    public static HomeFragment newInstance(LoginCallback callback)
    {
        HomeFragment me = new HomeFragment();
        me.callback = callback;
        return (me);
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        updatePlayer();
        super.onCreate(savedInstanceState);
    }

    public void updatePlayer()
    {
        arenaStats = null;
        warzoneStats = null;
        warzoneTaskFinished = false;
        arenaTaskFinished = false;
        if (arenaStatsTask != null)
            arenaStatsTask.cancel(true);
        arenaStatsTask = new ArenaStatsTask();
        arenaStatsTask.setOnTaskFinishedListener(this);
        arenaStatsTask.execute(((MainActivity) getActivity()).getCurrentGt());
        if (warzoneStatsTask != null)
            warzoneStatsTask.cancel(true);
        warzoneStatsTask = new WarzoneStatsTask();
        warzoneStatsTask.setOnTaskFinishedListener(this);
        warzoneStatsTask.execute(((MainActivity) getActivity()).getCurrentGt());
        EmblemImageTask emblemImageTask = new EmblemImageTask();
        emblemImageTask.setOnTaskFinishedListener(new EmblemImageTask.OnEmblemImageTaskFinishedListener() {
            @Override
            public void onEmblemImageTaskFinishedListener(Bitmap bm) {
                emblem.setImageBitmap(bm);
            }

            @Override
            public MainActivity getMainActivity() {
                return (MainActivity) getActivity();
            }
        });
        emblemImageTask.execute(getMainActivity().getCurrentGt());
    }

    public void reload(String gt)
    {
        ProgressBar progressBar = (ProgressBar) rootView.findViewById(R.id.loading);
        progressBar.setVisibility(View.VISIBLE);

        if (gt != null) {
            TextView gtView = (TextView) rootView.findViewById(R.id.currentGt);
            gtView.setText(gt);
            errorDisplay(false, null);
         }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        rootView = inflater.inflate(R.layout.homelayout, null, false);

        gtView = (TextView) rootView.findViewById(R.id.currentGt);
        gtView.setText(((MainActivity) getActivity()).getCurrentGt());
        Button search = (Button) rootView.findViewById(R.id.search);
         search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newGt = ((EditText) rootView.findViewById(R.id.newGamertag)).getText().toString();
                if (newGt.length() > 0) {
                    ((MainActivity) getActivity()).hideSoftKeyboard();
                    callback.onGamertagChanged(newGt);
                    ((EditText) rootView.findViewById(R.id.newGamertag)).setText("");
                    updatePlayer();
                    reload(newGt);
                }
            }
        });
        ImageView refresh = (ImageView) rootView.findViewById(R.id.refresh_button);
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (arenaTaskFinished && warzoneTaskFinished) {
                    updatePlayer();
                    reload(null);
                }
            }
        });
        emblem = (ImageView) rootView.findViewById(R.id.emblemImageView);

        buttonDisplayArena = (Button) rootView.findViewById(R.id.displayArena);
        buttonDisplayWarzone = (Button) rootView.findViewById(R.id.displayWarzone);
        buttonDisplayBoth = (Button) rootView.findViewById(R.id.displayBoth);

        if (generalStatsFragment == null)
            generalStatsFragment = GeneralStatsFragment.newInstance(this);
        getFragmentManager().beginTransaction().replace(R.id.content_page, generalStatsFragment, getResources().getString(R.string.general_stats_frag)).commit();
        currentDisplay = generalStatsFragment;

        FrameLayout contentPage = (FrameLayout) rootView.findViewById(R.id.content_page);
        changeToState(false, true, true);

        buttonDisplayArena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeToState(DisplayInterface.DisplayStateEnum.DISPLAY_ARENA);
            }
        });
        buttonDisplayWarzone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeToState(DisplayInterface.DisplayStateEnum.DISPLAY_WARZONE);
            }
        });
        buttonDisplayBoth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeToState(DisplayInterface.DisplayStateEnum.DISPLAY_BOTH);
            }
        });
        return (rootView);
    }

    private void changeToState(DisplayInterface.DisplayStateEnum display) {
        if (!arenaTaskFinished || !warzoneTaskFinished)
            return ;
        this.currentDisplayState = display;
        changeToState(!(display == DisplayInterface.DisplayStateEnum.DISPLAY_BOTH), !(display == DisplayInterface.DisplayStateEnum.DISPLAY_WARZONE), !(display == DisplayInterface.DisplayStateEnum.DISPLAY_ARENA));
        currentDisplay.displayCurrent(this.currentDisplayState);
    }

    private void changeToState(boolean bothState, boolean warzoneState, boolean arenaState)
    {
        int colorEnabled = getActivity().getResources().getColor(R.color.button_nav_stats_normal);
        int colorDisabled = getActivity().getResources().getColor(R.color.colorPrimary);
        buttonDisplayBoth.setEnabled(bothState);
        buttonDisplayBoth.setTextColor(bothState ? colorDisabled : colorEnabled);
        buttonDisplayWarzone.setEnabled(warzoneState);
        buttonDisplayWarzone.setTextColor(warzoneState ?  colorDisabled: colorEnabled);
        buttonDisplayArena.setEnabled(arenaState);
        buttonDisplayArena.setTextColor(arenaState ? colorDisabled : colorEnabled);
    }

    @Override
    public void onResume()
    {
        super.onResume();
    }

    public void updateStats() {
        if (getActivity() == null)
            return;
        ProgressBar loadingBar = (ProgressBar) rootView.findViewById(R.id.loading);
        if (loadingBar != null)
            loadingBar.setVisibility(View.GONE);

        if (this.arenaStats != null && this.warzoneStats != null &&
                this.arenaStats.getResults()[0].getResult().getPlayerId().getGamerTag() != null &&
                this.arenaStats.getResults().length > 0 && this.warzoneStats.getResults().length > 0) {
            errorDisplay(false, null);
            playerStats = new PlayerStats(this.arenaStats.getResults()[0].getResult().getPlayerId().getGamerTag(), warzoneStats, arenaStats, ((MainActivity)getActivity()).getMetadata());
            callback.onGamertagChanged(playerStats.getGamertag());
            gtView.setText(playerStats.getGamertag());

            currentDisplay.displayCurrent(currentDisplayState);
        } else {
            errorDisplay(true, "Can't load stats for " + ((MainActivity) getActivity()).getCurrentGt());
        }
    }

    @Override
    public void changeFragmentToMedals()
    {
        if (!arenaTaskFinished || !warzoneTaskFinished) {
            Toast.makeText(getActivity(), "Data are loading", Toast.LENGTH_SHORT).show();
            return;
        }
        if (getPlayerStats() == null) {
            Toast.makeText(getActivity(), "Can't load stats for this player", Toast.LENGTH_LONG).show();
            return;
        }
        MedalFragment mf = MedalFragment.newInstance(this);
        getActivity().getFragmentManager().beginTransaction()
                .addToBackStack(generalStatsFragment.getTag())
                .replace(R.id.content_page, mf, getResources().getString(R.string.medals_frag))
                .commit();
        currentDisplay = mf;
        currentDisplay.displayCurrent(currentDisplayState);
        this.navigationGoDeeper = true;
    }

    @Override
    public void changeFragmentToWeapons() {
        if (!arenaTaskFinished || !warzoneTaskFinished) {
            Toast.makeText(getActivity(), "Data are loading", Toast.LENGTH_SHORT).show();
            return;
        }
        if (getPlayerStats() == null) {
            Toast.makeText(getActivity(), "Can't load stats for this player", Toast.LENGTH_LONG).show();
            return;
        }
        WeaponsFragment mf = WeaponsFragment.newInstance(this);
        getActivity().getFragmentManager().beginTransaction()
                .addToBackStack(generalStatsFragment.getTag())
                .replace(R.id.content_page, mf, getResources().getString(R.string.medals_frag))
                .commit();
        currentDisplay = mf;
        currentDisplay.displayCurrent(currentDisplayState);
        this.navigationGoDeeper = true;
    }

    @Override
    public void onArenaStatsTaskFinished(ArenaStats arenaStats) {
        arenaTaskFinished = true;
        this.arenaStats = arenaStats;
        if (warzoneTaskFinished && arenaTaskFinished)
            updateStats();
    }

    @Override
    public void onWarzoneStatsTaskFinished(WarzoneStats warzoneStats) {
        warzoneTaskFinished = true;
        this.warzoneStats = warzoneStats;
        if (warzoneTaskFinished && arenaTaskFinished)
            updateStats();
    }

    @Override
    public void onSpartanImageTaskFinishedListener(Bitmap bm) {

    }

    private void errorDisplay(boolean state, String message)
    {
        TextView err = (TextView) rootView.findViewById(R.id.error);
        if (state) {
            err.setVisibility(View.VISIBLE);
            err.setText(message);
        } else {
            err.setVisibility(View.GONE);
        }
    }

    @Override
    public PlayerStats getPlayerStats() {
        return (playerStats);
    }


    @Override
    public boolean onBackPressedHandle() {
        if (this.navigationGoDeeper)
        {
            getActivity().getFragmentManager().beginTransaction()
                    .replace(R.id.content_page,
                            generalStatsFragment == null ? GeneralStatsFragment.newInstance(this) : generalStatsFragment,
                            getResources().getString(R.string.general_stats_frag))
                    .commit();
            generalStatsFragment.displayCurrent(currentDisplayState);
            this.navigationGoDeeper = false;
            return (false);
        }
        return true;
    }

    @Override
    public MainActivity.FragmentTypes getFragmentType() {
        return MainActivity.FragmentTypes.FRAG_HOME;
    }

    @Override
    public MainActivity getMainActivity() {
        return (MainActivity) getActivity();
    }
}

