package com.wilyra.halocompanion.home.weapon;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.wilyra.halocompanion.R;
import com.wilyra.halocompanion.home.DisplayInterface;
import com.wilyra.halocompanion.home.HomeCallback;
import com.wilyra.halocompanion.home.PlayerStats;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by wilyr on 11/25/2015.
 */
public class WeaponsFragment extends Fragment implements DisplayInterface {

    HomeCallback callback;
    LinearLayout weaponsContainer;
    List<WeaponGeneralStat> currentWeapons;
    WeaponFilter currentFilter = WeaponFilter.FILTER_NONE;
    WeaponSortType currentSortType = WeaponSortType.SORT_KILL;
    private boolean isLoaded = false;

    public WeaponsFragment()
    {

    }

    @Override
    public void onCreate(Bundle saved)
    {
        super.onCreate(saved);
        this.isLoaded = true;
    }

    public static WeaponsFragment newInstance(HomeCallback callback)
    {
        WeaponsFragment me;
        me = new WeaponsFragment();
        me.callback = callback;
        return (me);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.weapons_layout, container, false);
        weaponsContainer = (LinearLayout) view.findViewById(R.id.weapons_layout);
        currentWeapons = callback.getPlayerStats().getWeaponGeneralStats();

        Spinner spinnerWeapons = (Spinner) view.findViewById(R.id.spinnerWeapons);
        spinnerWeapons.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        currentFilter = WeaponFilter.FILTER_NONE;
                        break;
                    case 1:
                        currentFilter = WeaponFilter.FILTER_GRENADE;
                        break;
                    case 2:
                        currentFilter = WeaponFilter.FILTER_TURRET;
                        break;
                    case 3:
                        currentFilter = WeaponFilter.FILTER_VEHICLE;
                        break;
                    case 4:
                        currentFilter = WeaponFilter.FILTER_STANDARD;
                        break;
                    case 5:
                        currentFilter = WeaponFilter.FILTER_POWER;
                        break;
                    case 6:
                        currentFilter = WeaponFilter.FILTER_OTHER;
                        break;
                }
                loadWeapons();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Spinner spinnerType = (Spinner) view.findViewById(R.id.spinner);
        spinnerType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        currentSortType = WeaponSortType.SORT_KILL;
                        break;
                    case 1:
                        currentSortType = WeaponSortType.SORT_NAME;
                        break;
                    case 2:
                        currentSortType = WeaponSortType.SORT_HEADSHOT;
                        break;
                    case 3:
                        currentSortType = WeaponSortType.SORT_SHOTS;
                        break;
                    case 4:
                        currentSortType = WeaponSortType.SORT_ACCURACY;
                        break;
                }
                loadWeapons();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        loadWeapons();
        return (view);
    }

    public void loadWeapons()
    {
        weaponsContainer.removeAllViews();
        List<WeaponGeneralStat> list = getWeaponsWithFilter(currentFilter);
        Collections.sort(list, getSortingType());
        for (WeaponGeneralStat ws : list)
        {
            WeaponView wv = new WeaponView(getActivity());
            wv.setWeaponStat(ws);
            weaponsContainer.addView(wv);
        }
    }

    private List<WeaponGeneralStat> getWeaponsWithFilter(WeaponFilter filter)
    {
        if (filter == WeaponFilter.FILTER_NONE)
            return (new ArrayList<>(currentWeapons));
        String[] filtersValues = new String[] {
                "",
                "Grenade",
                "Turret",
                "Vehicle",
                "Standard",
                "Power",
                "Unknown"
        };
        List<WeaponGeneralStat> list = new ArrayList<>();
        for (WeaponGeneralStat ms : currentWeapons) {
            if (ms.getWeapon().getType().compareTo(filtersValues[filter.ordinal()]) == 0)
                list.add(ms);
        }
        return (list);
    }

    private Comparator<WeaponGeneralStat> getSortingType()
    {
        switch (currentSortType) {
            case SORT_ACCURACY:
                return (new PlayerStats.WeaponAccuracyComparator());
            case SORT_HEADSHOT:
                return (new PlayerStats.WeaponHeadshotsComparator());
            case SORT_KILL:
                return (new PlayerStats.WeaponKillComparator());
            case SORT_NAME:
                return (new PlayerStats.WeaponNameComparator());
            case SORT_SHOTS:
                return (new PlayerStats.WeaponShotsComparator());
            default:
                return (new PlayerStats.WeaponKillComparator());
        }
    }

    @Override
    public void displayArenaStats() {

    }

    @Override
    public void displayWarzoneStats() {

    }

    @Override
    public void displayBothStats() {

    }

    @Override
    public void displayCurrent(DisplayStateEnum state) {
        switch (state)
        {
            case DISPLAY_WARZONE:
                currentWeapons = callback.getPlayerStats().getWeaponWarzoneStats();
                break;
            case DISPLAY_ARENA:
                currentWeapons = callback.getPlayerStats().getWeaponArenaStats();
                break;
            case DISPLAY_BOTH:
                currentWeapons = callback.getPlayerStats().getWeaponGeneralStats();
                break;
        }
        if (isLoaded)
            loadWeapons();
    }
}
