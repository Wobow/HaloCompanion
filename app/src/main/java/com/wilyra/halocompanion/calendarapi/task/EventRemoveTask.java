package com.wilyra.halocompanion.calendarapi.task;

import android.os.AsyncTask;

import com.wilyra.halocompanion.apicommon.ApiCallback;
import com.wilyra.halocompanion.apicommon.OnTaskFinishedListener;
import com.wilyra.halocompanion.calendarapi.CalendarApi;
import com.wilyra.halocompanion.calendarapi.PostParam;

import org.apache.http.ProtocolVersion;
import org.apache.http.StatusLine;

/**
 * Created by wilyr on 11/28/2015.
 */
public class EventRemoveTask extends AsyncTask<String, Long, StatusLine> implements ApiCallback {

    OnEventRemoveTaskFininishedListener mListener;

    @Override
    public void setOnTaskFinishedListener(OnTaskFinishedListener listener) {
        this.mListener = (OnEventRemoveTaskFininishedListener)listener;
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
                new PostParam("id", params[0])
        };
        return (CalendarApi.post(mListener.getMainActivity().getClients(), "/calendar/removeEvent", parameters));
    }

    @Override
    protected void onPostExecute(StatusLine s) {
        if (mListener != null)
            mListener.onEventRemoveTaskFininishedFinished(s);
    }


    public interface OnEventRemoveTaskFininishedListener extends OnTaskFinishedListener {
        void onEventRemoveTaskFininishedFinished(StatusLine resultCode);
    }
}
