package com.wilyra.halocompanion.home;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.wilyra.halocompanion.R;

/**
 * Created by wilyr on 11/20/2015.
 */
public class LoginFragment extends Fragment {

    LoginCallback callback;

    public LoginFragment()
    {

    }

    public static LoginFragment newInstance(LoginCallback callback)
    {
        LoginFragment me = new LoginFragment();
        me.callback = callback;
        return (me);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.login_layout, null, false);
        Button search = (Button) view.findViewById(R.id.button);
        final EditText gamerTag = (EditText) view.findViewById(R.id.currentGt);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onGamertagEntered(gamerTag.getText().toString());
            }
        });
        return (view);
    }
}
