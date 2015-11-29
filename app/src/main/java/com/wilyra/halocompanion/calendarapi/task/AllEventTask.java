package com.wilyra.halocompanion.calendarapi.task;

import android.app.Fragment;
import android.os.AsyncTask;

import com.google.gson.Gson;
import com.wilyra.halocompanion.MainActivity;
import com.wilyra.halocompanion.apicommon.ApiCallback;
import com.wilyra.halocompanion.apicommon.OnTaskFinishedListener;
import com.wilyra.halocompanion.calendarapi.CalendarApi;
import com.wilyra.halocompanion.calendarapi.model.Calendar;
import com.wilyra.halocompanion.calendarapi.model.Event;

/**
 * Created by wilyr on 11/27/2015.
 */
public class AllEventTask extends AsyncTask<String, Long, Event[]> implements ApiCallback {

    OnAllEventTaskFininishedListener mListener;

    @Override
    public void setOnTaskFinishedListener(OnTaskFinishedListener listener) {
        this.mListener = (OnAllEventTaskFininishedListener)listener;
    }

    @Override
    protected Event[] doInBackground(String... params) {
        String matchContent = CalendarApi.getUrl(mListener.getMainActivity().getClients(), "/calendar/getAllEvent");
        if (matchContent == null)
            return null;
        Gson gson =  new Gson();
        return gson.fromJson(matchContent, Event[].class);
    }

    @Override
    protected void onPostExecute(Event[] s) {
        if (mListener != null)
            mListener.onAllEventTaskFininishedListener(s);
    }


    public interface OnAllEventTaskFininishedListener extends OnTaskFinishedListener {
        void onAllEventTaskFininishedListener(Event[] result);
    }
}
