package com.wilyra.halocompanion.calendarapi.task;

import android.app.Fragment;
import android.os.AsyncTask;

import com.wilyra.halocompanion.MainActivity;
import com.wilyra.halocompanion.apicommon.ApiCallback;
import com.wilyra.halocompanion.apicommon.OnTaskFinishedListener;
import com.wilyra.halocompanion.calendarapi.CalendarApi;
import com.wilyra.halocompanion.calendarapi.PostParam;

import org.apache.http.ProtocolVersion;
import org.apache.http.StatusLine;

/**
 * Created by wilyr on 11/28/2015.
 */
public class NewEventTask extends AsyncTask<String, Long, StatusLine> implements ApiCallback {

    OnNewEventTaskFininishedListener mListener;

    @Override
    public void setOnTaskFinishedListener(OnTaskFinishedListener listener) {
        this.mListener = (OnNewEventTaskFininishedListener)listener;
    }

    @Override
    protected StatusLine doInBackground(String... params) {
        if (params.length != 4)
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
                new PostParam("calendarId", params[1]),
                new PostParam("name", params[0]),
                new PostParam("debut", params[2]),
                new PostParam("fin", params[3])
        };
        return (CalendarApi.post(mListener.getMainActivity().getClients(), "/calendar/addEvent", parameters));
    }

    @Override
    protected void onPostExecute(StatusLine s) {
        if (mListener != null)
            mListener.onNewEventTaskFininishedFinished(s);
    }


    public interface OnNewEventTaskFininishedListener extends OnTaskFinishedListener {
        void onNewEventTaskFininishedFinished(StatusLine resultCode);
    }
}
