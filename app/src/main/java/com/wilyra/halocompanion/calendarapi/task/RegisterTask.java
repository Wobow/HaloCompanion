package com.wilyra.halocompanion.calendarapi.task;

import android.os.AsyncTask;

import com.wilyra.halocompanion.MainActivity;
import com.wilyra.halocompanion.apicommon.ApiCallback;
import com.wilyra.halocompanion.apicommon.OnTaskFinishedListener;
import com.wilyra.halocompanion.calendar.LoginFragment;
import com.wilyra.halocompanion.calendarapi.CalendarApi;
import com.wilyra.halocompanion.calendarapi.PostParam;

import org.apache.http.HttpStatus;
import org.apache.http.ProtocolVersion;
import org.apache.http.StatusLine;

/**
 * Created by wilyr on 11/28/2015.
 */
public class RegisterTask extends AsyncTask<String, Long, StatusLine> implements ApiCallback {

    OnRegisterTaskFininishedListener mListener;

    @Override
    public void setOnTaskFinishedListener(OnTaskFinishedListener listener) {
        this.mListener = (OnRegisterTaskFininishedListener)listener;
    }

    @Override
    protected StatusLine doInBackground(String... params) {
        if (params.length != 3)
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
                new PostParam("login", params[0]),
                new PostParam("passwd", params[1]),
                new PostParam("gamerTag", params[2])
        };
        return (CalendarApi.post(mListener.getMainActivity().getClients(), "/user", parameters));
    }

    @Override
    protected void onPostExecute(StatusLine s) {
        if (mListener != null)
            mListener.onRegisterTaskFininishedFinished(s);
    }


    public interface OnRegisterTaskFininishedListener extends OnTaskFinishedListener {
        void onRegisterTaskFininishedFinished(StatusLine resultCode);
    }
}
