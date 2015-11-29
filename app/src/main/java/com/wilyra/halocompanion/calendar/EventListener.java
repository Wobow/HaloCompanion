package com.wilyra.halocompanion.calendar;

import com.wilyra.halocompanion.calendarapi.model.Event;

/**
 * Created by wilyr on 11/28/2015.
 */
public interface EventListener {
    void onDeleteEvent(Event e);
    void onInfoEvent(Event e);
    void onSubscribeEvent(Event e);
    void onUnsubscribeEvent(Event e);
    boolean isAdmin(Event e);
    boolean isSubscribed(Event e);
}
