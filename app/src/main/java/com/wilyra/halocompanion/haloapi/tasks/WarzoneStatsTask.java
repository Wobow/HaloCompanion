package com.wilyra.halocompanion.haloapi.tasks;

import android.os.AsyncTask;

import com.google.gson.Gson;
import com.wilyra.halocompanion.apicommon.ApiCallback;
import com.wilyra.halocompanion.haloapi.HaloApi;
import com.wilyra.halocompanion.apicommon.OnTaskFinishedListener;
import com.wilyra.halocompanion.haloapi.model.warzonestats.WarzoneStats;

import java.net.URLEncoder;

/**
 * Created by wilyr on 11/21/2015.
 */
public class WarzoneStatsTask extends AsyncTask<String, Long, WarzoneStats> implements ApiCallback {
    private OnWarzoneStatsTaskFinishedListener mListener;

    @Override
    protected WarzoneStats doInBackground(String... params) {
        String warzoneStatsContent = HaloApi.getUrl("https://www.haloapi.com/stats/h5/servicerecords/warzone?players=" + URLEncoder.encode(params[0]));
        if (warzoneStatsContent == null)
            return null;
        Gson gson =  new Gson();
        return (gson.fromJson(warzoneStatsContent, WarzoneStats.class));
    }

    @Override
    public void onPostExecute(WarzoneStats warzoneStat)
    {
        this.mListener.onWarzoneStatsTaskFinished(warzoneStat);
    }

    @Override
    public void setOnTaskFinishedListener(OnTaskFinishedListener listener) {
        this.mListener = (OnWarzoneStatsTaskFinishedListener) listener;
    }

    public interface OnWarzoneStatsTaskFinishedListener extends OnTaskFinishedListener
    {
        void onWarzoneStatsTaskFinished(WarzoneStats warzoneStats);
    }
}
