package com.wilyra.halocompanion.haloapi.tasks;

import android.os.AsyncTask;

import com.google.gson.Gson;
import com.wilyra.halocompanion.apicommon.ApiCallback;
import com.wilyra.halocompanion.haloapi.HaloApi;
import com.wilyra.halocompanion.apicommon.OnTaskFinishedListener;
import com.wilyra.halocompanion.haloapi.model.arenastats.ArenaStats;

import java.net.URLEncoder;

/**
 * Created by wilyr on 11/20/2015.
 */
public class ArenaStatsTask extends AsyncTask<String, Long, ArenaStats> implements ApiCallback{
    private OnArenaStatsTaskFinishedListener mListener;

    @Override
    protected ArenaStats doInBackground(String... params) {
        String arenaStatsContent = HaloApi.getUrl("https://www.haloapi.com/stats/h5/servicerecords/arena?players=" + URLEncoder.encode(params[0]));
        if (arenaStatsContent == null)
            return null;
        Gson gson =  new Gson();
        return (gson.fromJson(arenaStatsContent, ArenaStats.class));
    }

    @Override
    public void onPostExecute(ArenaStats arenaStats)
    {
        this.mListener.onArenaStatsTaskFinished(arenaStats);
    }

    @Override
    public void setOnTaskFinishedListener(OnTaskFinishedListener listener) {
        this.mListener = (OnArenaStatsTaskFinishedListener) listener;
    }

    public interface OnArenaStatsTaskFinishedListener extends OnTaskFinishedListener
    {
        void onArenaStatsTaskFinished(ArenaStats arenaStats);
    }
}
