package com.wilyra.halocompanion.haloapi.tasks;

import android.os.AsyncTask;

import com.google.gson.Gson;
import com.wilyra.halocompanion.apicommon.ApiCallback;
import com.wilyra.halocompanion.haloapi.HaloApi;
import com.wilyra.halocompanion.apicommon.OnTaskFinishedListener;
import com.wilyra.halocompanion.haloapi.model.spartanrank.SpartanRank;

/**
 * Created by wilyr on 11/20/2015.
 */
public class SpartanRankTask extends AsyncTask<String, Long, SpartanRank[]> implements ApiCallback {

    OnSpartanRankTaskFinishedListener mListener = null;

    @Override
    protected SpartanRank[] doInBackground(String... params) {
        String rankContent = HaloApi.getUrl("https://www.haloapi.com/metadata/h5/metadata/spartan-ranks");
        if (rankContent == null)
            return null;
        Gson gson =  new Gson();
        SpartanRank[] maps = gson.fromJson(rankContent, SpartanRank[].class);
        return maps;
    }

    @Override
    protected void onPostExecute(SpartanRank[] rankContent)
    {
        if (mListener != null)
            mListener.onSpartanRankTaskFinished(rankContent);
    }

    @Override
    public void setOnTaskFinishedListener(OnTaskFinishedListener listener) {
        this.mListener = (OnSpartanRankTaskFinishedListener) listener;
    }

    public interface OnSpartanRankTaskFinishedListener extends OnTaskFinishedListener
    {
        void onSpartanRankTaskFinished(SpartanRank[] maps);
    }
}
