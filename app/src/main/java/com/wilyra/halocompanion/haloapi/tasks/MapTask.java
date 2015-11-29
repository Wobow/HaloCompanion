package com.wilyra.halocompanion.haloapi.tasks;

import android.os.AsyncTask;

import com.google.gson.Gson;
import com.wilyra.halocompanion.apicommon.ApiCallback;
import com.wilyra.halocompanion.haloapi.HaloApi;
import com.wilyra.halocompanion.apicommon.OnTaskFinishedListener;
import com.wilyra.halocompanion.haloapi.model.Map;

/**
 * Created by wilyr on 11/20/2015.
 */
public class MapTask extends AsyncTask<String, Long, Map[]> implements ApiCallback {

    OnMapTaskFinishedListener mListener = null;

    @Override
    protected Map[] doInBackground(String... params) {
        String mapsContent = HaloApi.getUrl("https://www.haloapi.com/metadata/h5/metadata/maps");
        if (mapsContent == null)
            return null;
        Gson gson =  new Gson();
        Map[] maps = gson.fromJson(mapsContent, Map[].class);
        return maps;
    }

    @Override
    protected void onPostExecute(Map[] maps)
    {
        if (mListener != null)
            mListener.onMapTaskFinished(maps);
    }

    @Override
    public void setOnTaskFinishedListener(OnTaskFinishedListener listener) {
        this.mListener = (OnMapTaskFinishedListener) listener;
    }

    public interface OnMapTaskFinishedListener extends OnTaskFinishedListener
    {
        void onMapTaskFinished(Map[] maps);
    }
}
