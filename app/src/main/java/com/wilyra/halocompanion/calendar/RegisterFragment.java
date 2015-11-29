package com.wilyra.halocompanion.calendar;

import android.app.Fragment;
import android.app.FragmentManager;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.wilyra.halocompanion.MainActivity;
import com.wilyra.halocompanion.R;
import com.wilyra.halocompanion.calendarapi.CalendarApi;
import com.wilyra.halocompanion.calendarapi.task.RegisterTask;

import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;

/**
 * Created by wilyr on 11/28/2015.
 */
public class RegisterFragment extends Fragment implements RegisterTask.OnRegisterTaskFininishedListener {

    LoginFragment callback;
    EditText login;
    EditText passwd;
    EditText passwd2;
    EditText gamertag;
    TextView error;

    public RegisterFragment()
    {

    }

    public static RegisterFragment newInstance(LoginFragment callback)
    {
        RegisterFragment me = new RegisterFragment();
        me.callback = callback;
        return (me);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.register_layout, container, false);
        error = (TextView) view.findViewById(R.id.error);
        login = (EditText) view.findViewById(R.id.login);
        passwd = (EditText) view.findViewById(R.id.passwd);
        passwd2 = (EditText) view.findViewById(R.id.passwd_cf);
        gamertag = (EditText) view.findViewById(R.id.gamertag);
        view.findViewById(R.id.register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });
        return (view);
    }

    private void register() {
        login.setBackgroundColor(Color.TRANSPARENT);
        passwd2.setBackgroundColor(Color.TRANSPARENT);
        passwd.setBackgroundColor(Color.TRANSPARENT);
        gamertag.setBackgroundColor(Color.TRANSPARENT);
        if (login.getText().length() == 0) {
            login.setBackgroundColor(Color.RED);
            return ;
        }
        if (passwd2.getText().length() == 0 || passwd.getText().toString().compareTo(passwd2.getText().toString()) != 0) {
            passwd2.setBackgroundColor(Color.RED);
            return ;
        }
        if (passwd.getText().length() == 0) {
            passwd.setBackgroundColor(Color.RED);
            return ;
        }
        if (gamertag.getText().length() == 0) {
            gamertag.setBackgroundColor(Color.RED);
            return ;
        }
        RegisterTask registerTask = new RegisterTask();
        registerTask.setOnTaskFinishedListener(this);
        registerTask.execute(login.getText().toString(), passwd.getText().toString(), gamertag.getText().toString());
    }

    @Override
    public void onRegisterTaskFininishedFinished(StatusLine resultCode) {
        if (resultCode.getStatusCode() == HttpStatus.SC_OK) {
            Toast.makeText(getActivity(), "Registration successful", Toast.LENGTH_LONG).show();
            FragmentManager fm = getActivity().getFragmentManager();
            fm.beginTransaction().replace(R.id.container, callback, getResources().getString(R.string.logincalendar_frag)).commit();
        } else {
            Toast.makeText(getActivity(), "Registration failed", Toast.LENGTH_LONG).show();
            error.setText(String.format("Can't register : %s", resultCode.getReasonPhrase()));
        }
    }

    @Override
    public MainActivity getMainActivity() {
        return (MainActivity) getActivity();
    }
}
