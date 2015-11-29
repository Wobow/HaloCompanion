package com.wilyra.halocompanion.calendarapi.task;

import android.app.Fragment;
import android.os.AsyncTask;

import com.wilyra.halocompanion.MainActivity;
import com.wilyra.halocompanion.apicommon.ApiCallback;
import com.wilyra.halocompanion.apicommon.OnTaskFinishedListener;
import com.wilyra.halocompanion.calendar.LoginFragment;
import com.wilyra.halocompanion.calendarapi.CalendarApi;
import com.wilyra.halocompanion.calendarapi.PostParam;

import org.apache.http.ProtocolVersion;
import org.apache.http.StatusLine;

/**
 * Created by wilyr on 11/28/2015.
 */
public class NewCalendarTask extends AsyncTask<String, Long, StatusLine> implements ApiCallback {

    OnNewCalendarTaskFininishedListener mListener;

    @Override
    public void setOnTaskFinishedListener(OnTaskFinishedListener listener) {
        this.mListener = (OnNewCalendarTaskFininishedListener)listener;
    }

    @Override
    protected StatusLine doInBackground(String... params) {
        if (params.length != 1)
            return (new StatusLine() {
                @Override
                public ProtocolVersion getProtocolVersion() {
                    return null;
                }

                @Override
                public int getStatusCode() {
                    return 400;
                }

                @Override
                public String getReasonPhrase() {
                    return "Missing parameters";
                }
            });
        PostParam[] parameters = {
                new PostParam("name", params[0])
        };
        return (CalendarApi.post(mListener.getMainActivity().getClients(), "/calendar", parameters));
    }

    @Override
    protected void onPostExecute(StatusLine s) {
        if (mListener != null)
            mListener.onNewCalendarTaskFininishedFinished(s);
    }


    public interface OnNewCalendarTaskFininishedListener extends OnTaskFinishedListener {
        void onNewCalendarTaskFininishedFinished(StatusLine resultCode);
    }
}
