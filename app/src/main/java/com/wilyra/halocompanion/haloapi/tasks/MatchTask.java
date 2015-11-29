package com.wilyra.halocompanion.haloapi.tasks;

import android.os.AsyncTask;

import com.google.gson.Gson;
import com.wilyra.halocompanion.apicommon.ApiCallback;
import com.wilyra.halocompanion.haloapi.HaloApi;
import com.wilyra.halocompanion.apicommon.OnTaskFinishedListener;
import com.wilyra.halocompanion.haloapi.model.match.MatchesResult;

import java.net.URLEncoder;

/**
 * Created by wilyr on 11/27/2015.
 */
public class MatchTask extends AsyncTask<String, Long, MatchesResult> implements ApiCallback {

    OnMatchTaskFininishedListener mListener;

    @Override
    public void setOnTaskFinishedListener(OnTaskFinishedListener listener) {
        this.mListener = (OnMatchTaskFininishedListener)listener;
    }

    @Override
    protected MatchesResult doInBackground(String... params) {
        if (params.length != 4)
            return (null);
        String player = URLEncoder.encode(params[0]);
        String modes = URLEncoder.encode(params[1]);
        String start = URLEncoder.encode(params[2]);
        String count = URLEncoder.encode(params[3]);
        String matchContent = HaloApi.getUrl(String.format("https://www.haloapi.com/stats/h5/players/%s/matches?modes=%s&start=%s&count=%s", player, modes, start, count));
        if (matchContent == null)
            return null;
        Gson gson =  new Gson();
        return gson.fromJson(matchContent, MatchesResult.class);
    }

    @Override
    protected void onPostExecute(MatchesResult s) {
        if (mListener != null)
            mListener.onMatchTaskFinishedListener(s);
    }


    public interface OnMatchTaskFininishedListener extends OnTaskFinishedListener {
        void onMatchTaskFinishedListener(MatchesResult result);
    }
}
