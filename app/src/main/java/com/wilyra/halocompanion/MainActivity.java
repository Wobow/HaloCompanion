package com.wilyra.halocompanion;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.DatePicker;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.wilyra.halocompanion.calendar.CalendarFragment;
import com.wilyra.halocompanion.home.HomeFragment;
import com.wilyra.halocompanion.home.LoginCallback;
import com.wilyra.halocompanion.home.LoginFragment;
import com.wilyra.halocompanion.matches.MatchesFragment;

import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.HttpParams;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, LoginCallback {

    public String getCurrentGt() {
        return currentGt;
    }

    public void setCurrentGt(String currentGt) {
        onGamertagEntered(currentGt);
    }

    public MetadataContainer getMetadata() {
        return metadata;
    }

    public void setMetadata(MetadataContainer metadata) {
        this.metadata = metadata;
    }

    private String currentGt = null;

    public String getCurrentLog() {
        return currentLog;
    }

    public void setCurrentLog(String currentLog) {
        this.currentLog = currentLog;
    }

    public String getCurrentPasswd() {
        return currentPasswd;
    }

    public void setCurrentPasswd(String currentPasswd) {
        this.currentPasswd = currentPasswd;
    }

    private String currentLog = null;
    private String currentPasswd = null;
    private MetadataContainer metadata = null;

    public static String TAG_FRAG_LOGIN = "Login";
    public static String TAG_FRAG_HOME = "Home";
    public static String TAG_FRAG_MATCH = "Matches";
    public static String TAG_FRAG_PROGRESS = "Progression";
    public static String TAG_FRAG_CALENDAR = "Calendar";

    Fragment currentPart = null;

    public DefaultHttpClient getClients() {
        return clients;
    }

    DefaultHttpClient clients = getThreadSafeClient();

    public static DefaultHttpClient getThreadSafeClient()  {
        DefaultHttpClient client = new DefaultHttpClient();
/*        ClientConnectionManager mgr = client.getConnectionManager();
        HttpParams params = client.getParams();
        client = new DefaultHttpClient(new ThreadSafeClientConnManager(params,

                mgr.getSchemeRegistry()), params);*/
        return client;
    }

    @Override
    public void onGamertagEntered(String gt) {
        this.currentGt = gt;
        SharedPreferences sharedPref = getSharedPreferences(getString(R.string.cache_file_key), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(getString(R.string.last_gt), this.currentGt);
        editor.apply();
        changeFragment(FragmentTypes.FRAG_HOME);
    }

    @Override
    public void onGamertagChanged(String newGt) {
        this.currentGt = newGt;
        SharedPreferences sharedPref = getSharedPreferences(getString(R.string.cache_file_key), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(getString(R.string.last_gt), this.currentGt);
        editor.apply();
    }

    public void setCredentials(String login, String passwd) {
        this.currentLog = login;
        this.currentPasswd = passwd;
        SharedPreferences sharedPref = getSharedPreferences(getString(R.string.cache_file_key), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        if (this.currentLog == null)
            editor.remove(getString(R.string.currentLog));
        else
            editor.putString(getString(R.string.currentLog), this.currentLog);
        if (this.currentPasswd == null)
            editor.remove(getString(R.string.currentPasswd));
        else
            editor.putString(getString(R.string.currentPasswd), this.currentPasswd);
        editor.apply();
    }

    public void setLoading(boolean b) {
        FrameLayout f = (FrameLayout) findViewById(R.id.container);
        if (b) {
            f.setEnabled(false);
        } else {
            f.setEnabled(true);
        }
    }

    public enum FragmentTypes {
        FRAG_LOGIN,
        FRAG_HOME,
        FRAG_MATCH,
        FRAG_PROGRESS,
        FRAG_CALENDAR
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
            @Override
            public void onDrawerClosed(View drawerView) {
                getSupportActionBar().setTitle("Halo Companion : " + getFragmentTitle());
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                getSupportActionBar().setTitle("Navigation");
                super.onDrawerOpened(drawerView);
            }
        };
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        metadata = new MetadataContainer();
        metadata.loadMetadata();

        SharedPreferences sp = getSharedPreferences(getString(R.string.cache_file_key), Context.MODE_PRIVATE);
        String savedGt = sp.getString(getString(R.string.last_gt), null);
        if (savedGt != null) {
            this.currentGt = savedGt;
            changeFragment(FragmentTypes.FRAG_HOME);
        }
        else
            changeFragment(FragmentTypes.FRAG_LOGIN);
        currentLog = sp.getString(getResources().getString(R.string.currentLog), null);
        currentPasswd = sp.getString(getResources().getString(R.string.currentPasswd), null);
    }

    private String getFragmentTitle() {
        if (currentPart == null)
            return ("Home");
        else
            return currentPart.getTag();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if (this.currentPart == null || ((IBackPressed)this.currentPart).onBackPressedHandle())
            super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            clients = getThreadSafeClient();
            Toast.makeText(this, "Connection reset", Toast.LENGTH_LONG).show();
            getFragmentManager().beginTransaction().replace(R.id.container, HomeFragment.newInstance(this), TAG_FRAG_HOME).commit();
            setCredentials(null, null);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (currentGt != null) {
            if (id == R.id.nav_home) {
                if (((IBackPressed)currentPart).getFragmentType() != FragmentTypes.FRAG_HOME)
                    changeFragment(FragmentTypes.FRAG_HOME);
            } else if (id == R.id.nav_calendar) {
                if (((IBackPressed)currentPart).getFragmentType() != FragmentTypes.FRAG_CALENDAR)
                    changeFragment(FragmentTypes.FRAG_CALENDAR);
            } else if (id == R.id.nav_matches) {
                if (((IBackPressed)currentPart).getFragmentType() != FragmentTypes.FRAG_MATCH)
                    changeFragment(FragmentTypes.FRAG_MATCH);
            }
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void changeFragment(FragmentTypes fragmentId)
    {
        FragmentManager fm = getFragmentManager();
        Fragment f = null;
        String tag = "";
        switch (fragmentId)
        {
            case FRAG_LOGIN:
                tag = TAG_FRAG_LOGIN;
                if (fm.findFragmentByTag(tag) != null)
                    f = fm.findFragmentByTag(tag);
                else
                    f = LoginFragment.newInstance(this);
                break;
            case FRAG_HOME:
                tag = TAG_FRAG_HOME;
                if (fm.findFragmentByTag(tag) != null)
                    f = fm.findFragmentByTag(tag);
                else
                    f = HomeFragment.newInstance(this);
                break;
            case FRAG_MATCH:
                tag = TAG_FRAG_MATCH;
                if (fm.findFragmentByTag(tag) != null)
                    f = fm.findFragmentByTag(tag);
                else
                    f = MatchesFragment.newInstance(this);
                break;
            case FRAG_CALENDAR:
                tag = TAG_FRAG_CALENDAR;
                if (fm.findFragmentByTag(tag) != null)
                    f = fm.findFragmentByTag(tag);
                else
                    f = com.wilyra.halocompanion.calendar.LoginFragment.newInstance();
                break;
        }
        this.currentPart = f;
        fm.beginTransaction().replace(R.id.container, f, tag).commit();
    }

    public void hideSoftKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager)  getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
    }

}
