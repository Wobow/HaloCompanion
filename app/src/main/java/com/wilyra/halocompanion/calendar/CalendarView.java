package com.wilyra.halocompanion.calendar;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wilyra.halocompanion.MainActivity;
import com.wilyra.halocompanion.R;
import com.wilyra.halocompanion.calendarapi.model.Calendar;
import com.wilyra.halocompanion.calendarapi.model.User;
import com.wilyra.halocompanion.calendarapi.task.AddUserTask;
import com.wilyra.halocompanion.calendarapi.task.SearchUserTask;
import com.wilyra.halocompanion.haloapi.tasks.EmblemImageTask;

import org.apache.http.StatusLine;

/**
 * Created by wilyr on 11/25/2015.
 */
public class CalendarView extends RelativeLayout {


    private OnSelectChangeListener listener;
    private Calendar cal;
    Context mContext;

    public CalendarView(Context context) {
        super(context);
        mContext = context;
        LayoutInflater.from(context).inflate(R.layout.calendar_view, this, true);
    }

    public CalendarView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mContext = context;
        LayoutInflater.from(context).inflate(R.layout.calendar_view, this, true);
    }

    public void setCalendar(final Calendar cal)
    {
        this.cal = cal;
        CheckBox mCalendarName;
        TextView mCalendarAdmin;
        mCalendarName = (CheckBox) findViewById(R.id.calendarName);
        mCalendarAdmin = (TextView) findViewById(R.id.adminName);
        mCalendarName.setText("Show");
        mCalendarName.setChecked(true);
        mCalendarAdmin.setText(cal.getName());
        mCalendarName.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (listener != null)
                    listener.onSelectChanged(cal.getId(), isChecked);
            }
        });
        findViewById(R.id.inviteFriend).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                inviteFriend(cal);
            }
        });
        findViewById(R.id.deleteCalendar).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onCalendarDeleted(cal);
            }
        });
    }

    private void inviteFriend(final Calendar cal) {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        LayoutInflater inflater = ((Activity)mContext).getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.search_user_layout, null);
        builder.setView(dialogView);
        final EditText pattern = (EditText) dialogView.findViewById(R.id.pattern);
        final ListView listUser = (ListView) dialogView.findViewById(R.id.listUser);
        final User[][] userlist = new User[1][1];
        dialogView.findViewById(R.id.searchbutton).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pattern.getText().length() > 0) {
                    SearchUserTask searchUserTask = new SearchUserTask();
                    searchUserTask.setOnTaskFinishedListener(new SearchUserTask.OnSearchUserTaskFininishedListener() {
                        @Override
                        public void onSearchUserTaskFininishedListener(User[] result) {
                            ArrayAdapter<User> users = new UserAdapter(mContext, result);
                            userlist[0] = result;
                            listUser.setAdapter(users);
                        }

                        @Override
                        public MainActivity getMainActivity() {
                            return (MainActivity) mContext;
                        }
                    });
                    searchUserTask.execute(pattern.getText().toString());
                }
            }
        });
        listUser.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final User selected = userlist[0][position];
                ((MainActivity)mContext).setLoading(true);
                AddUserTask addUserTask = new AddUserTask();
                addUserTask.setOnTaskFinishedListener(new AddUserTask.OnAddUserTaskFininishedListener() {
                    @Override
                    public void onAddUserTaskFininishedFinished(StatusLine resultCode) {
                        listener.onFriendAdded(selected.getLogin(), cal.getName());
                        getMainActivity().setLoading(false);
                    }

                    @Override
                    public MainActivity getMainActivity() {
                        return (MainActivity) mContext;
                    }
                });
                addUserTask.execute(cal.getName(), selected.getLogin());
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void setOnSelectChangeListener(OnSelectChangeListener listener)
    {
        this.listener = listener;
    }

}