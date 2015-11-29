package com.wilyra.halocompanion.calendarapi.task;

import android.app.Fragment;
import android.os.AsyncTask;

import com.google.gson.Gson;
import com.wilyra.halocompanion.MainActivity;
import com.wilyra.halocompanion.apicommon.ApiCallback;
import com.wilyra.halocompanion.apicommon.OnTaskFinishedListener;
import com.wilyra.halocompanion.calendar.LoginFragment;
import com.wilyra.halocompanion.calendarapi.CalendarApi;
import com.wilyra.halocompanion.calendarapi.model.Calendar;
import com.wilyra.halocompanion.haloapi.HaloApi;
import com.wilyra.halocompanion.haloapi.model.match.MatchesResult;

import java.net.URLEncoder;

/**
 * Created by wilyr on 11/27/2015.
 */
public class CalendarTask extends AsyncTask<String, Long, Calendar[]> implements ApiCallback {

    OnCalendarTaskFininishedListener mListener;

    @Override
    public void setOnTaskFinishedListener(OnTaskFinishedListener listener) {
        this.mListener = (OnCalendarTaskFininishedListener)listener;
    }

    @Override
    protected Calendar[] doInBackground(String... params) {
        String matchContent = CalendarApi.getUrl(mListener.getMainActivity().getClients(), "/calendar");
        if (matchContent == null)
            return null;
        Gson gson =  new Gson();
        return gson.fromJson(matchContent, Calendar[].class);
    }

    @Override
    protected void onPostExecute(Calendar[] s) {
        if (mListener != null)
            mListener.onCalendarTaskFininishedListener(s);
    }


    public interface OnCalendarTaskFininishedListener extends OnTaskFinishedListener {
        void onCalendarTaskFininishedListener(Calendar[] result);
    }
}
