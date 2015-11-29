package com.wilyra.halocompanion.haloapi.tasks;

import android.os.AsyncTask;

import com.google.gson.Gson;
import com.wilyra.halocompanion.apicommon.ApiCallback;
import com.wilyra.halocompanion.haloapi.HaloApi;
import com.wilyra.halocompanion.apicommon.OnTaskFinishedListener;
import com.wilyra.halocompanion.haloapi.model.medals.Medals;

/**
 * Created by wilyr on 11/20/2015.
 */
public class MedalsTask extends AsyncTask<String, Long, Medals[]> implements ApiCallback {

    OnMedalsTaskFinishedListener mListener = null;

    @Override
    protected Medals[] doInBackground(String... params) {
        String medalsContent = HaloApi.getUrl("https://www.haloapi.com/metadata/h5/metadata/medals");
        if (medalsContent == null)
            return null;
        Gson gson =  new Gson();
        Medals[] medals = gson.fromJson(medalsContent, Medals[].class);
        return medals;
    }

    @Override
    protected void onPostExecute(Medals[] medals)
    {
        if (mListener != null)
            mListener.onMedalsTaskFinished(medals);
    }

    @Override
    public void setOnTaskFinishedListener(OnTaskFinishedListener listener) {
        this.mListener = (OnMedalsTaskFinishedListener) listener;
    }

    public interface OnMedalsTaskFinishedListener extends OnTaskFinishedListener
    {
        void onMedalsTaskFinished(Medals[] medals);
    }
}
