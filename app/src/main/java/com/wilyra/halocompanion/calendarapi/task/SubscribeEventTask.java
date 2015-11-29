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
public class SubscribeEventTask extends AsyncTask<String, Long, StatusLine> implements ApiCallback {

    OnSubscribeEventTaskFininishedListener mListener;

    @Override
    public void setOnTaskFinishedListener(OnTaskFinishedListener listener) {
        this.mListener = (OnSubscribeEventTaskFininishedListener)listener;
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
                new PostParam("eventId", params[0])
        };
        return (CalendarApi.post(mListener.getMainActivity().getClients(), "/calendar/subscribeEvent", parameters));
    }

    @Override
    protected void onPostExecute(StatusLine s) {
        if (mListener != null)
            mListener.onSubscribeEventTaskFininishedFinished(s);
    }


    public interface OnSubscribeEventTaskFininishedListener extends OnTaskFinishedListener {
        void onSubscribeEventTaskFininishedFinished(StatusLine resultCode);
    }
}
