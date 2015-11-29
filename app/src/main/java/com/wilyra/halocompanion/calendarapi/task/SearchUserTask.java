package com.wilyra.halocompanion.calendarapi.task;

import android.app.Activity;
import android.app.Fragment;
import android.os.AsyncTask;

import com.google.gson.Gson;
import com.wilyra.halocompanion.MainActivity;
import com.wilyra.halocompanion.apicommon.ApiCallback;
import com.wilyra.halocompanion.apicommon.OnTaskFinishedListener;
import com.wilyra.halocompanion.calendarapi.CalendarApi;
import com.wilyra.halocompanion.calendarapi.model.User;

/**
 * Created by wilyr on 11/27/2015.
 */
public class SearchUserTask extends AsyncTask<String, Long, User[]> implements ApiCallback {

    OnSearchUserTaskFininishedListener mListener;

    @Override
    public void setOnTaskFinishedListener(OnTaskFinishedListener listener) {
        this.mListener = (OnSearchUserTaskFininishedListener)listener;
    }

    @Override
    protected User[] doInBackground(String... params) {
        if (params.length == 0)
            return (null);
        String matchContent = CalendarApi.getUrl(mListener.getMainActivity().getClients(), "/user/getListUser?param=" + params[0]);
        if (matchContent == null)
            return null;
        Gson gson =  new Gson();
        return gson.fromJson(matchContent, User[].class);
    }

    @Override
    protected void onPostExecute(User[] s) {
        if (mListener != null)
            mListener.onSearchUserTaskFininishedListener(s);
    }


    public interface OnSearchUserTaskFininishedListener extends OnTaskFinishedListener {
        void onSearchUserTaskFininishedListener(User[] result);
    }
}
