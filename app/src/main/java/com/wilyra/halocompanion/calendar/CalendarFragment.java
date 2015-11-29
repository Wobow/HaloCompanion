package com.wilyra.halocompanion.calendar;

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.InputType;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.wilyra.halocompanion.IBackPressed;
import com.wilyra.halocompanion.MainActivity;
import com.wilyra.halocompanion.R;
import com.wilyra.halocompanion.apicommon.OnTaskFinishedListener;
import com.wilyra.halocompanion.calendarapi.model.Calendar;
import com.wilyra.halocompanion.calendarapi.model.Event;
import com.wilyra.halocompanion.calendarapi.task.AllEventTask;
import com.wilyra.halocompanion.calendarapi.task.CalendarRemoveTask;
import com.wilyra.halocompanion.calendarapi.task.CalendarTask;
import com.wilyra.halocompanion.calendarapi.task.EventRemoveTask;
import com.wilyra.halocompanion.calendarapi.task.NewCalendarTask;
import com.wilyra.halocompanion.calendarapi.task.NewEventTask;
import com.wilyra.halocompanion.calendarapi.task.SubscribeEventTask;
import com.wilyra.halocompanion.calendarapi.task.UnsubscribeEventTask;

import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by wilyr on 11/28/2015.
 */
public class CalendarFragment extends Fragment implements IBackPressed,
        CalendarTask.OnCalendarTaskFininishedListener,
        NewCalendarTask.OnNewCalendarTaskFininishedListener,
        AllEventTask.OnAllEventTaskFininishedListener,
        OnSelectChangeListener,
        NewEventTask.OnNewEventTaskFininishedListener,
        SubscribeEventTask.OnSubscribeEventTaskFininishedListener,
        CalendarRemoveTask.OnCalendarRemoveTaskFininishedListener,
        EventListener,
        OnTaskFinishedListener{
    LinearLayout calendarList;
    ListView eventList;
    Calendar[] calendars;
    Event[] allEvents;
    List<Event> currentEvents = new ArrayList<>();
    List<String> calendarsId = new ArrayList<>();

    public CalendarFragment()
    {}

    public static CalendarFragment newInstance()
    {
        CalendarFragment me = new CalendarFragment();
        return (me);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        refreshCalendar();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.calendarlayout, container, false);
        calendarList = (LinearLayout) view.findViewById(R.id.calendarList);
        eventList = (ListView) view.findViewById(R.id.eventList);
        view.findViewById(R.id.newCalendar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newCalendar();
            }
        });
        view.findViewById(R.id.newEven).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newEvent();
            }
        });
        return (view);
    }

    private void newCalendar() {
        final AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
        alert.setTitle("New Calendar");
        alert.setMessage("Enter the name of the new Calendar");
        final EditText input = new EditText (getActivity());
        input.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);
        input.setHint("Calendar name (>5 characters)");
        alert.setView(input);

        alert.setPositiveButton("Create", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                createNewCalendar(input.getText().toString());
            }
        });

        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {

            }
        });
        final AlertDialog dialog = alert.create();
        dialog.show();
        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setEnabled(false);
        View.OnKeyListener keyListener = new View.OnKeyListener() {

            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_UP) {
                    dialog.getButton(AlertDialog.BUTTON_POSITIVE).setEnabled(input.getText().length() >= 5);
                }
                return false;
            }
        };
        input.setOnKeyListener(keyListener);
    }

    private void newEvent()
    {
        final AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
        alert.setTitle("Create Event");
        alert.setMessage("Enter the following informations");

        final List<Calendar> mCalendars = new ArrayList<>();
        List<String> mCalendarsNames = new ArrayList<>();
        final String[] startDate = new String[1];
        final String[] endDate = new String[1];
        for (Calendar c : calendars) {
            if (isCalendarAdmin(c)) {
                mCalendars.add(c);
                mCalendarsNames.add(c.getName());
            }
        }
        if (mCalendars.size() == 0) {
            Toast.makeText(getActivity(), "You don't own any calendar. Create one to add events", Toast.LENGTH_LONG).show();
            return;
        }
        else {
            final int[] mYear = {-1};
            final int[] mMonth = {-1};
            final int[] mDay = {-1};
            final int[] sHour = {-1};
            final int[] sMinute = {-1};
            final int[] eHour = {-1};
            final int[] eMinute = {-1};

            alert.setPositiveButton("Create Event", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            alert.setNegativeButton("Cancel", null);
            LayoutInflater inflater = getActivity().getLayoutInflater();
            View dialogView = inflater.inflate(R.layout.create_event_layout, null);
            alert.setView(dialogView);
            final AlertDialog alertDialog = alert.create();

            final java.util.Calendar cal = java.util.Calendar.getInstance();

            final Spinner spinnerCalendar = (Spinner) dialogView.findViewById(R.id.calendarSpinner);
            spinnerCalendar.setAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, mCalendarsNames.toArray(new String[mCalendarsNames.size()])));

            final EditText dateText = (EditText) dialogView.findViewById(R.id.date);
            final EditText startText = (EditText) dialogView.findViewById(R.id.start);
            final EditText endText = (EditText) dialogView.findViewById(R.id.end);


            final DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    dateText.setText(String.format("%02d / %02d / %04d", monthOfYear, dayOfMonth, year));
                    mYear[0] = year;
                    mDay[0] = dayOfMonth;
                    mMonth[0] = monthOfYear;
                }
            };
            dateText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if (hasFocus) {
                        DatePickerDialog dialog = new DatePickerDialog(getActivity(), onDateSetListener, cal.get(java.util.Calendar.YEAR), cal.get(java.util.Calendar.MONTH), cal.get(java.util.Calendar.DAY_OF_MONTH));
                        dialog.show();
                    }
                }
            });
            dialogView.findViewById(R.id.dateButton).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DatePickerDialog dialog = new DatePickerDialog(getActivity(), onDateSetListener, cal.get(java.util.Calendar.YEAR), cal.get(java.util.Calendar.MONTH), cal.get(java.util.Calendar.DAY_OF_MONTH));
                    dialog.show();
                }
            });

            startText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if (hasFocus) {
                        TimePickerDialog dialog = new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                startText.setText(String.format("%02d:%02d", hourOfDay, minute));
                                sHour[0] = hourOfDay;
                                sMinute[0] = minute;
                            }
                        }, cal.get(java.util.Calendar.HOUR_OF_DAY), cal.get(java.util.Calendar.MINUTE), true);
                        dialog.show();
                    }
                }
            });
            dialogView.findViewById(R.id.startButton).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TimePickerDialog dialog = new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                            startText.setText(String.format("%02d:%02d", hourOfDay, minute));
                            sHour[0] = hourOfDay;
                            sMinute[0] = minute;
                        }
                    }, cal.get(java.util.Calendar.HOUR_OF_DAY), cal.get(java.util.Calendar.MINUTE), true);
                    dialog.show();
                }
            });


            endText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if (hasFocus) {
                        TimePickerDialog dialog = new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                endText.setText(String.format("%02d:%02d", hourOfDay, minute));
                                eHour[0] = hourOfDay;
                                eMinute[0] = minute;
                            }
                        }, cal.get(java.util.Calendar.HOUR_OF_DAY), cal.get(java.util.Calendar.MINUTE), true);
                        dialog.show();
                    }
                }
            });

            dialogView.findViewById(R.id.endButton).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TimePickerDialog dialog = new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                            endText.setText(String.format("%02d:%02d", hourOfDay, minute));
                            eHour[0] = hourOfDay;
                            eMinute[0] = minute;
                        }
                    }, cal.get(java.util.Calendar.HOUR_OF_DAY), cal.get(java.util.Calendar.MINUTE), true);
                    dialog.show();
                }
            });

            final EditText eventName = (EditText) dialogView.findViewById(R.id.eventName);

            alertDialog.show();
            alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mYear[0] == -1 || mMonth[0] == -1 || mDay[0] == -1 || sHour[0] == -1 || sMinute[0] == -1 || eHour[0] == -1 || eMinute[0] == -1) {
                        Toast.makeText(getActivity(), "All fields must be filled", Toast.LENGTH_LONG).show();
                        return;
                    }
                    if (eHour[0] < sHour[0] || (eHour[0] == sHour[0] && eMinute[0] <= sMinute[0])) {
                        Toast.makeText(getActivity(), "End time cannot be before start time", Toast.LENGTH_LONG).show();
                        return;
                    }
                    startDate[0] = String.format("%04d-%02d-%02dT%02d:%02d:00Z", mYear[0], mMonth[0], mDay[0], sHour[0], sMinute[0]);
                    endDate[0] = String.format("%04d-%02d-%02dT%02d:%02d:00Z", mYear[0], mMonth[0], mDay[0], eHour[0], eMinute[0]);

                    createNewEvent(eventName.getText().toString(), mCalendars.get(spinnerCalendar.getSelectedItemPosition()), startDate[0], endDate[0]);
                    alertDialog.dismiss();
                }
            });
        }

    }

    private void createNewEvent(String s, Calendar calendar, String startDate, String endDate) {
        Log.e("Debug", "Creatin event " + s + " in calendar " + calendar.getName() + "(" + calendar.getId() + ") starting " + startDate + " and ending " + endDate);
        NewEventTask newEventTask = new NewEventTask();
        newEventTask.setOnTaskFinishedListener(this);
        newEventTask.execute(s, calendar.getId(), startDate, endDate);
    }

    private boolean isCalendarAdmin(Calendar c)
    {
        String log = ((MainActivity)getActivity()).getCurrentLog();
        for (String s : c.getAdmins()) {
            if (s.compareTo(log) == 0)
                return (true);
        }
        return (false);
    }

    private void createNewCalendar(String s) {
        NewCalendarTask newCalendarTask = new NewCalendarTask();
        newCalendarTask.setOnTaskFinishedListener(this);
        newCalendarTask.execute(s);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onCalendarTaskFininishedListener(Calendar[] result) {
        if (result == null) {
            FragmentManager fm = getActivity().getFragmentManager();
            LoginFragment f = LoginFragment.newInstance();
            fm.beginTransaction()
                    .replace(R.id.container, f, getResources().getString(R.string.logincalendar_frag))
                    .commit();
            return ;
        }
        this.calendars = result;
        displayCalendars();
        AllEventTask eventTask = new AllEventTask();
        eventTask.setOnTaskFinishedListener(this);
        eventTask.execute("");
    }

    private void displayCalendars() {
        calendarsId = new ArrayList<>();
        calendarList.removeAllViews();
        for (Calendar c : calendars)
        {
            CalendarView view = new CalendarView(getActivity());
            view.setCalendar(c);
            view.setOnSelectChangeListener(this);
            calendarList.addView(view);
            calendarsId.add(c.getId());
        }
    }

    @Override
    public void onNewCalendarTaskFininishedFinished(StatusLine resultCode) {
        Toast.makeText(getActivity(), "Calendar successfully created", Toast.LENGTH_LONG).show();
        refreshCalendar();
    }

    private void refreshCalendar() {
        CalendarTask calendarTask = new CalendarTask();
        calendarTask.setOnTaskFinishedListener(this);
        calendarTask.execute("");
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
    public void onAllEventTaskFininishedListener(Event[] result) {
        allEvents = result;
        if (allEvents != null)
            displayEvents();
    }

    private boolean isInCalendarById(String id)
    {
        for (String c : calendarsId) {
            if (id != null && c.compareTo(id) == 0)
                return (true);
        }
        return (false);
    }

    private void displayEvents() {
        currentEvents = new ArrayList<>();
        for (Event e : allEvents) {
            if (e.getCalendar() != null && isInCalendarById(e.getCalendar().getId()))
                currentEvents.add(e);
        }
        Collections.sort(currentEvents, new EventNameComparator());
        EventAdapter adapter = new EventAdapter(getActivity(), currentEvents.toArray(new Event[currentEvents.size()]));
        adapter.setEventListener(this);
        eventList.setAdapter(adapter);
    }

    @Override
    public void onSelectChanged(String calendarId, boolean isChecked) {
        if (isChecked == false)
            calendarsId.remove(calendarId);
        else
            calendarsId.add(calendarId);
        displayEvents();
    }

    @Override
    public void onCalendarDeleted(final Calendar c) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Remove Calendar");
        builder.setMessage(String.format("Are you sure you want to remove %s (%d events)", c.getName(), c.getEvents().length));
        final CalendarRemoveTask.OnCalendarRemoveTaskFininishedListener me = this;
        builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                CalendarRemoveTask calendarRemoveTask = new CalendarRemoveTask();
                calendarRemoveTask.setOnTaskFinishedListener(me);
                calendarRemoveTask.execute(c.getId());
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public void onFriendAdded(String login, String cName) {
        Toast.makeText(getActivity(), login + "successfully added to your calendar " + cName, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNewEventTaskFininishedFinished(StatusLine resultCode) {
        if (resultCode.getStatusCode() == HttpStatus.SC_OK) {
            Toast.makeText(getActivity(), "New Event Created", Toast.LENGTH_LONG).show();
            refreshCalendar();
        }
        else
            Toast.makeText(getActivity(), "Can't create new event : " + resultCode.getReasonPhrase() + " (" + resultCode.getStatusCode() + " )", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDeleteEvent(final Event e) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Remove Event");
        builder.setMessage(String.format("Are you sure you want to remove this event (%s)", e.getName()));
        builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                EventRemoveTask eventRemoveTask = new EventRemoveTask();
                eventRemoveTask.setOnTaskFinishedListener(new EventRemoveTask.OnEventRemoveTaskFininishedListener() {
                    @Override
                    public void onEventRemoveTaskFininishedFinished(StatusLine resultCode) {
                        Toast.makeText(getActivity(), "Event removed", Toast.LENGTH_SHORT).show();
                        refreshCalendar();
                    }

                    @Override
                    public MainActivity getMainActivity() {
                        return (MainActivity) getActivity();
                    }
                });
                eventRemoveTask.execute(e.getId());
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public void onInfoEvent(final Event e) {
        AlertDialog.Builder diagBuilder = new AlertDialog.Builder(getActivity());
        diagBuilder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.envent_detail_layout, null);
        diagBuilder.setView(dialogView);

        ((TextView)dialogView.findViewById(R.id.eventName)).setText(e.getName());
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault());
        try {
            ((TextView)(dialogView.findViewById(R.id.date))).setText(dateformat.parse(e.getDebut()).toString());
        } catch (ParseException e1) {
            e1.printStackTrace();
            ((TextView)(dialogView.findViewById(R.id.date))).setText(e.getDebut());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, e.getParticipants());
        ((ListView)dialogView.findViewById(R.id.listView)).setAdapter(adapter);

        Button sub = (Button) dialogView.findViewById(R.id.subscribe);
        final AlertDialog alertDialog = diagBuilder.create();
        sub.setText(isSubscribed(e) ? "Unsubscribe" : "Subscribe");
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isSubscribed(e))
                    onUnsubscribeEvent(e);
                else
                    onSubscribeEvent(e);
                alertDialog.dismiss();
            }
        });

        Button reminder = (Button) dialogView.findViewById(R.id.reminder);
        reminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setReminder(e);
            }
        });

        Button delete = (Button) dialogView.findViewById(R.id.delete);
        delete.setEnabled(isAdmin(e));
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDeleteEvent(e);
                alertDialog.dismiss();
            }
        });

        alertDialog.show();
    }

    private void setReminder(Event e) {
        Intent myIntent = new Intent(getActivity() , NotificationService.class);
        AlarmManager alarmManager = (AlarmManager)getActivity().getSystemService(Context.ALARM_SERVICE);
        PendingIntent pendingIntent = PendingIntent.getService(getActivity(), 0, myIntent, 0);

        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault());
        try {
            Date date = dateformat.parse(e.getDebut());
            java.util.Calendar calendar = java.util.Calendar.getInstance();
            calendar.setTime(date);
            alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
        } catch (ParseException e1) {
            e1.printStackTrace();
        }



    }

    @Override
    public void onSubscribeEvent(Event e) {
        SubscribeEventTask subscribeEventTask = new SubscribeEventTask();
        subscribeEventTask.setOnTaskFinishedListener(this);
        subscribeEventTask.execute(e.getId());
    }

    @Override
    public void onUnsubscribeEvent(Event e) {
        UnsubscribeEventTask unSubscribeEventTask = new UnsubscribeEventTask();
        unSubscribeEventTask.setOnTaskFinishedListener(new UnsubscribeEventTask.OnUnsubscribeEventTaskFininishedListener() {
            @Override
            public void onUnsubscribeEventTaskFininishedFinished(StatusLine resultCode) {
                refreshCalendar();
            }

            @Override
            public MainActivity getMainActivity() {
                return (MainActivity) getActivity();
            }
        });
        unSubscribeEventTask.execute(e.getId());
    }

    @Override
    public boolean isAdmin(Event e) {
        for (Calendar c : calendars) {
            if (c.getId().compareTo(e.getCalendar().getId()) == 0)
                return (isCalendarAdmin(c));
        }
        return false;
    }

    @Override
    public boolean isSubscribed(Event e)
    {
        for (String s : e.getParticipants()) {
            if (s.compareTo(((MainActivity)getActivity()).getCurrentLog()) == 0)
                return (true);
        }
        return false;
    }

    @Override
    public void onSubscribeEventTaskFininishedFinished(StatusLine resultCode) {
        if (resultCode.getStatusCode() == HttpStatus.SC_OK) {
            Toast.makeText(getActivity(), "Registered to event", Toast.LENGTH_SHORT).show();
            refreshCalendar();
        }
        else {
            Log.e("HaloCompanion", resultCode.getStatusCode() + " : " + resultCode.getReasonPhrase());
            Toast.makeText(getActivity(), "Failed to register to event", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onCalendarRemoveTaskFininishedFinished(StatusLine resultCode) {
        Toast.makeText(getActivity(), "Calendar removed", Toast.LENGTH_SHORT).show();
        refreshCalendar();
    }

    private class EventNameComparator implements java.util.Comparator<Event> {

        @Override
        public int compare(Event lhs, Event rhs) {
            return lhs.getDebut().compareTo(rhs.getDebut());
        }
    }

    @Override
    public MainActivity getMainActivity()
    {
        return (MainActivity) getActivity();
    }
}
