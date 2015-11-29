package com.wilyra.halocompanion.haloapi.tasks;

import android.os.AsyncTask;

import com.google.gson.Gson;
import com.wilyra.halocompanion.apicommon.ApiCallback;
import com.wilyra.halocompanion.haloapi.HaloApi;
import com.wilyra.halocompanion.apicommon.OnTaskFinishedListener;
import com.wilyra.halocompanion.haloapi.model.Weapon;

/**
 * Created by wilyr on 11/20/2015.
 */
public class WeaponTask extends AsyncTask<String, Long, Weapon[]> implements ApiCallback {

    OnWeaponTaskFinishedListener mListener = null;

    @Override
    protected Weapon[] doInBackground(String... params) {
        String mapsContent = HaloApi.getUrl("https://www.haloapi.com/metadata/h5/metadata/weapons");
        if (mapsContent == null)
            return null;
        Gson gson =  new Gson();
        Weapon[] weapons = gson.fromJson(mapsContent, Weapon[].class);
        return weapons;
    }

    @Override
    protected void onPostExecute(Weapon[] weapons)
    {
        if (mListener != null)
            mListener.onWeaponTaskFinished(weapons);
    }

    @Override
    public void setOnTaskFinishedListener(OnTaskFinishedListener listener) {
        this.mListener = (OnWeaponTaskFinishedListener) listener;
    }

    public interface OnWeaponTaskFinishedListener extends OnTaskFinishedListener
    {
        void onWeaponTaskFinished(Weapon[] weapons);
    }
}
