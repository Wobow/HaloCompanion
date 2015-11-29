package com.wilyra.halocompanion.calendar;

import com.wilyra.halocompanion.calendarapi.model.Calendar;

/**
 * Created by wilyr on 11/28/2015.
 */
public interface OnSelectChangeListener {
    void onSelectChanged(String calendarName, boolean isChecked);
    void onCalendarDeleted(Calendar c);
    void onFriendAdded(String login, String cName);
}
