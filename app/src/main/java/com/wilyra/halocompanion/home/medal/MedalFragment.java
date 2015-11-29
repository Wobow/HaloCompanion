package com.wilyra.halocompanion.home.medal;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TableRow;
import android.widget.Toast;

import com.wilyra.halocompanion.R;
import com.wilyra.halocompanion.home.DisplayInterface;
import com.wilyra.halocompanion.home.HomeCallback;
import com.wilyra.halocompanion.home.PlayerStats;
import com.wilyra.halocompanion.home.SortType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by wilyr on 11/25/2015.
 */
public class MedalFragment extends Fragment implements DisplayInterface {

    HomeCallback callback;
    LinearLayout medalcontainer;
    List<MedalGeneralStat> medalGeneralStats;
    MedalFilter currentFilter = MedalFilter.FILTER_NONE;
    SortType currentSortType = SortType.SORT_COUNT;

    private boolean isLoaded = false;

    public MedalFragment()
    {

    }

    public static MedalFragment newInstance(HomeCallback callback)
    {
        MedalFragment me = new MedalFragment();
        me.callback = callback;
        return (me);
    }

    @Override
    public void onCreate(Bundle saved)
    {
        super.onCreate(saved);
        this.isLoaded = true;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.medals_layout, container, false);

        Spinner spinnerMedal = (Spinner) view.findViewById(R.id.spinnerMedals);
        spinnerMedal.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position)
                {
                    case 0:
                        currentFilter = MedalFilter.FILTER_NONE;
                        break;
                    case 1:
                        currentFilter = MedalFilter.FILTER_MULTIKILL;
                        break;
                    case 2:
                        currentFilter = MedalFilter.FILTER_STYLE;
                        break;
                    case 3:
                        currentFilter = MedalFilter.FILTER_SPREE;
                        break;
                    case 4:
                        currentFilter = MedalFilter.FILTER_OBJECTIVE;
                        break;
                    case 5:
                        currentFilter = MedalFilter.FILTER_WEAPON;
                        break;
                    case 6:
                        currentFilter = MedalFilter.FILTER_BREAKOUT;
                        break;
                    default:
                        currentFilter = MedalFilter.FILTER_NONE;
                        break;
                }
                loadMedals();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Spinner spinnerSort = (Spinner) view.findViewById(R.id.spinner);
        spinnerSort.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        currentSortType = SortType.SORT_COUNT;
                        break;
                    case 1:
                        currentSortType = SortType.SORT_NAME;
                        break;
                    case 2:
                        currentSortType = SortType.SORT_DIFFICULTY;
                        break;
                    default:
                        currentSortType = SortType.SORT_DIFFICULTY;
                        break;
                }
                loadMedals();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        medalcontainer = (LinearLayout) view.findViewById(R.id.medals_layout);
        loadMedals();
        return (view);
    }

    private void loadMedals() {
        medalcontainer.removeAllViews();
        int i = 0;
        LinearLayout newLine = null;
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        TableRow.LayoutParams rp = new TableRow.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 0.25f);

        List<MedalGeneralStat> filteredMgs = getMedalsWithFilter(currentFilter);
        Collections.sort(filteredMgs, getSortingType());
        for (final MedalGeneralStat ms : filteredMgs)
        {
            if (i % 4 == 0) {
                if (newLine != null) {
                    medalcontainer.addView(newLine);
                }
                newLine = new LinearLayout(getActivity());
                newLine.setLayoutParams(lp);
                newLine.setOrientation(LinearLayout.HORIZONTAL);
            }
            final MedalView mv = new MedalView(getActivity());
            mv.setLayoutParams(rp);
            mv.setMedalStat(ms);
            mv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MedalDetailFragment mdf = MedalDetailFragment.newInstance(ms);
                    getFragmentManager().beginTransaction()
                            .replace(R.id.medaldetailcontainer, mdf, getResources().getString(R.string.medaldetail))
                            .commit();
                }
            });
            if (newLine != null)
                newLine.addView(mv);
            i++;
        }
        if (newLine != null)
            medalcontainer.addView(newLine);
    }

    private Comparator<MedalGeneralStat> getSortingType() {
        switch (currentSortType) {
            case SORT_COUNT:
                return (new PlayerStats.MedalCountComparator());
            case SORT_DIFFICULTY:
                return (new PlayerStats.MedalDifficultyComparator());
            case SORT_NAME:
                return (new PlayerStats.MedalNameComparator());
            default:
                return (new PlayerStats.MedalDifficultyComparator());
        }
    }


    public List<MedalGeneralStat> getMedalsWithFilter(MedalFilter filter)
    {
        if (filter == MedalFilter.FILTER_NONE)
            return (new ArrayList<>(medalGeneralStats));
        String[] filtersValues = new String[] {
                "MultiKill",
                "Style",
                "KillingSpree",
                "Objective",
                "WeaponProficiency",
                "Breakout"
        };
        List<MedalGeneralStat> list = new ArrayList<>();
        for (MedalGeneralStat ms : medalGeneralStats) {
            if (ms.getMedal().getClassification().compareTo(filtersValues[filter.ordinal()]) == 0)
                list.add(ms);
        }
        return (list);
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
                medalGeneralStats = callback.getPlayerStats().getMedalWarzoneStats();
                break;
            case DISPLAY_ARENA:
                medalGeneralStats = callback.getPlayerStats().getMedalArenaStats();
                break;
            case DISPLAY_BOTH:
                medalGeneralStats = callback.getPlayerStats().getMedalGeneralStats();
                break;
        }
        if (isLoaded)
            loadMedals();
    }

}
