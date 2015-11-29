package com.wilyra.halocompanion.matches;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.wilyra.halocompanion.IBackPressed;
import com.wilyra.halocompanion.MainActivity;
import com.wilyra.halocompanion.R;
import com.wilyra.halocompanion.haloapi.model.match.MatchesResult;
import com.wilyra.halocompanion.haloapi.model.match.Result;
import com.wilyra.halocompanion.haloapi.tasks.MatchTask;
import com.wilyra.halocompanion.home.LoginCallback;

/**
 * Created by wilyr on 11/27/2015.
 */
public class MatchesFragment extends Fragment implements IBackPressed, MatchTask.OnMatchTaskFininishedListener {

    private LoginCallback callback;
    private int startNumber = 0;
    private int loadPerPage = 10;
    final int MODE_WARZONE = 2;
    final int MODE_ARENA = 4;
    final int MODE_CUSTOM = 8;
    final int MODE_CAMPAIGN = 16;

    int currentMode = MODE_ARENA | MODE_WARZONE | MODE_CAMPAIGN;
    Result[] matches;
    ListView listMatches;

    public MatchesFragment()
    {

    }

    public static MatchesFragment newInstance(LoginCallback callback)
    {
        MatchesFragment me = new MatchesFragment();
        me.callback = callback;
        return (me);
    }

    public void loadMatches()
    {
        MatchTask matchTask = new MatchTask();
        matchTask.setOnTaskFinishedListener(this);
        MainActivity mActivity = (MainActivity)callback;
        String modes = getCurrentModeString();
        Log.e("Matches", "Loading " + loadPerPage + " matches of " + modes + " from start : " + startNumber);
        matchTask.execute(mActivity.getCurrentGt(), modes, String.valueOf(startNumber), String.valueOf(loadPerPage));
    }

    private String getCurrentModeString() {
        String mode = "";

        if ((currentMode & MODE_ARENA) != 0)
            mode += "arena";
        if ((currentMode & MODE_WARZONE) != 0) {
            if (mode.length() > 0)
                mode += ",";
            mode += "warzone";
        }
        if ((currentMode & MODE_CAMPAIGN) != 0) {
            if (mode.length() > 0)
                mode += ",";
            mode += "campaign";
        }
        if ((currentMode & MODE_CUSTOM) != 0) {
            if (mode.length() > 0)
                mode += ",";
            mode += "custom";
        }
        return (mode);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.matches_fragment, container, false);
        listMatches = (ListView) view.findViewById(R.id.matchList);
        loadMatches();
        return (view);
    }

    @Override
    public boolean onBackPressedHandle() {
        return true;
    }

    @Override
    public MainActivity.FragmentTypes getFragmentType() {
        return MainActivity.FragmentTypes.FRAG_MATCH;
    }

    @Override
    public void onMatchTaskFinishedListener(MatchesResult result) {
        if (getActivity() == null)
            return;
        if (result == null)
        {
            Log.e("Matches", "Couldn't load maps");
            return ;
        }
        MatchAdapter adapter = new MatchAdapter(getActivity(), result.getResults());
        adapter.setMedataData(((MainActivity)getActivity()).getMetadata());
        listMatches.setAdapter(adapter);
    }

    @Override
    public MainActivity getMainActivity() {
        return (MainActivity) getActivity();
    }
}
