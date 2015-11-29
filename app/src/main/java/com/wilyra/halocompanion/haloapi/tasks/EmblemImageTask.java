package com.wilyra.halocompanion.haloapi.tasks;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import com.wilyra.halocompanion.apicommon.ApiCallback;
import com.wilyra.halocompanion.apicommon.OnTaskFinishedListener;
import com.wilyra.halocompanion.haloapi.HaloApi;

import java.io.InputStream;
import java.net.URLEncoder;

/**
 * Created by Gotti on 26/11/2015.
 */

public class EmblemImageTask extends AsyncTask<String, Long, Bitmap> implements ApiCallback {

    OnEmblemImageTaskFinishedListener mListener;

    @Override
    protected Bitmap doInBackground(String... params) {
        String player = URLEncoder.encode(params[0]);
        InputStream stream = HaloApi.getImage("https://www.haloapi.com/profile/h5/profiles/" + player + "/emblem");
        Bitmap ret = null;
        ret = BitmapFactory.decodeStream(stream);
        return (ret);
    }

    @Override
    protected void onPostExecute(Bitmap bm) {
        if (mListener != null)
            this.mListener.onEmblemImageTaskFinishedListener(bm);
    }

    @Override
    public void setOnTaskFinishedListener(OnTaskFinishedListener listener) {
        this.mListener = (OnEmblemImageTaskFinishedListener) listener;
    }

    public interface OnEmblemImageTaskFinishedListener extends OnTaskFinishedListener{
        void onEmblemImageTaskFinishedListener(Bitmap bm);
    }
}
