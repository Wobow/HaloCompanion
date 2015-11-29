package com.wilyra.halocompanion.haloapi.tasks;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import com.wilyra.halocompanion.apicommon.ApiCallback;
import com.wilyra.halocompanion.haloapi.HaloApi;
import com.wilyra.halocompanion.apicommon.OnTaskFinishedListener;

import java.io.InputStream;
import java.net.URLEncoder;

/**
 * Created by wilyr on 11/22/2015.
 */
public class SpartanImageTask extends AsyncTask<String, Long, Bitmap> implements ApiCallback{

    OnSpartanImageTaskFinishedListener mListener;

    @Override
    protected Bitmap doInBackground(String... params) {
        String player = URLEncoder.encode(params[0]);
        InputStream imageContent = HaloApi.getImage("https://www.haloapi.com/profile/h5/profiles/" + player + "/spartan");
        if (imageContent == null)
            return null;
        return (BitmapFactory.decodeStream(imageContent));
    }

    @Override
    protected void onPostExecute(Bitmap bm)
    {
        if (mListener != null)
            this.mListener.onSpartanImageTaskFinishedListener(bm);

    }

    @Override
    public void setOnTaskFinishedListener(OnTaskFinishedListener listener) {
        this.mListener = (OnSpartanImageTaskFinishedListener) listener;
    }

    public interface OnSpartanImageTaskFinishedListener
    {
        void onSpartanImageTaskFinishedListener(Bitmap bm);
    }
}
