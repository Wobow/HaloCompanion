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
public class UnsubscribeEventTask extends AsyncTask<String, Long, StatusLine> implements ApiCallback {

    OnUnsubscribeEventTaskFininishedListener mListener;

    @Override
    public void setOnTaskFinishedListener(OnTaskFinishedListener listener) {
        this.mListener = (OnUnsubscribeEventTaskFininishedListener)listener;
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
        return (CalendarApi.post(mListener.getMainActivity().getClients(), "/calendar/unsubscribeEvent", parameters));
    }

    @Override
    protected void onPostExecute(StatusLine s) {
        if (mListener != null)
            mListener.onUnsubscribeEventTaskFininishedFinished(s);
    }


    public interface OnUnsubscribeEventTaskFininishedListener extends OnTaskFinishedListener {
        void onUnsubscribeEventTaskFininishedFinished(StatusLine resultCode);
    }
}
