package com.wilyra.halocompanion.haloapi.tasks;

import android.os.AsyncTask;

import com.google.gson.Gson;
import com.wilyra.halocompanion.apicommon.ApiCallback;
import com.wilyra.halocompanion.haloapi.HaloApi;
import com.wilyra.halocompanion.apicommon.OnTaskFinishedListener;
import com.wilyra.halocompanion.haloapi.model.gamevariant.GameVariant;

/**
 * Created by wilyr on 11/20/2015.
 */
public class GameVariantTask extends AsyncTask<String, Long, GameVariant[]> implements ApiCallback {

    OnGameVariantTaskFinishedListener mListener = null;

    @Override
    protected GameVariant[] doInBackground(String... params) {
        if (params.length == 0)
            return (null);
        String content = HaloApi.getUrl("https://www.haloapi.com/metadata/h5/metadata/game-variants/" + params[0]);
        if (content == null)
            return null;
        Gson gson =  new Gson();
        GameVariant[] maps = gson.fromJson(content, GameVariant[].class);
        return maps;
    }

    @Override
    protected void onPostExecute(GameVariant[] gameVariants)
    {
        if (mListener != null)
            mListener.onGameVariantTaskFinished(gameVariants);
    }

    @Override
    public void setOnTaskFinishedListener(OnTaskFinishedListener listener) {
        this.mListener = (OnGameVariantTaskFinishedListener) listener;
    }

    public interface OnGameVariantTaskFinishedListener extends OnTaskFinishedListener
    {
        void onGameVariantTaskFinished(GameVariant[] gameVariants);
    }
}
