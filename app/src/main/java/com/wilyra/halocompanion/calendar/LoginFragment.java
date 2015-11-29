package com.wilyra.halocompanion.calendar;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.wilyra.halocompanion.IBackPressed;
import com.wilyra.halocompanion.MainActivity;
import com.wilyra.halocompanion.R;
import com.wilyra.halocompanion.calendarapi.task.LoginTask;

import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;

/**
 * Created by wilyr on 11/28/2015.
 */
public class LoginFragment extends Fragment implements LoginTask.OnLoginTaskFininishedListener, IBackPressed{

    EditText login;
    EditText passwd;
    TextView error;

    public LoginFragment()
    {

    }

    public static LoginFragment newInstance()
    {
        LoginFragment me = new LoginFragment();
        return (me);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.logincalendarlayout, container, false);
        login = (EditText) view.findViewById(R.id.login);
        passwd = (EditText) view.findViewById(R.id.passwd);
        error = (TextView) view.findViewById(R.id.error);
        view.findViewById(R.id.login_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (login.getText().toString().length() == 0) {
                    login.setBackgroundColor(Color.RED);
                    return;
                }
                if (passwd.getText().toString().length() == 0) {
                    passwd.setBackgroundColor(Color.RED);
                    return;
                }
                login(login.getText().toString(), passwd.getText().toString());
            }
        });
        view.findViewById(R.id.register_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });

        return (view);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (((MainActivity)getActivity()).getCurrentLog() != null && ((MainActivity)getActivity()).getCurrentPasswd() != null)
            login(((MainActivity)getActivity()).getCurrentLog(), ((MainActivity)getActivity()).getCurrentPasswd());
    }

    private void register() {
        getActivity().getFragmentManager().beginTransaction().replace(R.id.container, RegisterFragment.newInstance(this),
                getResources().getString(R.string.register_frag)).commit();
    }

    private void login(String login, String passwd) {
        ((MainActivity)getActivity()).setCredentials(login, passwd);
        LoginTask loginTask = new LoginTask();
        loginTask.setOnTaskFinishedListener(this);
        loginTask.execute(login, passwd);
    }

    @Override
    public void onLoginTaskFininishedFinished(StatusLine resultCode) {
        if (resultCode.getStatusCode() == HttpStatus.SC_OK) {
            Toast.makeText(getActivity(), "Connection successful", Toast.LENGTH_SHORT).show();

            FragmentManager fm = getActivity().getFragmentManager();
            Fragment f;
            f = CalendarFragment.newInstance();
            fm.beginTransaction().replace(R.id.container, f, MainActivity.TAG_FRAG_PROGRESS).commit();

        }
        else {
            error.setText(String.format("Can't connect : %s", resultCode.getReasonPhrase()));
            error.setTextColor(Color.RED);
            Toast.makeText(getActivity(), "Connection refused => Error " + resultCode + " : " + resultCode.getReasonPhrase(), Toast.LENGTH_SHORT).show();
        }
    }

    public void notifyRegisterOk() {
        error.setText("Successfully registered\nYou can log in now");
    }

    @Override
    public boolean onBackPressedHandle() {
        return false;
    }

    @Override
    public MainActivity.FragmentTypes getFragmentType() {
        return null;
    }

    @Override
    public MainActivity getMainActivity() {
        return (MainActivity) getActivity();
    }
}
