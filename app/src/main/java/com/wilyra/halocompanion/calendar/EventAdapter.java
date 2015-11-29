package com.wilyra.halocompanion.calendar;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.wilyra.halocompanion.R;
import com.wilyra.halocompanion.calendarapi.model.Event;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Created by wilyr on 11/27/2015.
 */
public class EventAdapter extends ArrayAdapter<Event>{
    private final Context context;
    private final Event[] values;
    private EventListener listener;

    public EventAdapter(Context context, Event[] values) {
        super(context, R.layout.event_layout, values);
        this.context = context;
        this.values = values;
    }

    public void setEventListener(EventListener listener) {
        this.listener = listener;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.event_layout, parent, false);
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault());
        ((TextView)(rowView.findViewById(R.id.name))).setText(values[position].getName());
        try {
            ((TextView)(rowView.findViewById(R.id.date))).setText(dateformat.parse(values[position].getDebut()).toString());
        } catch (ParseException e) {
            ((TextView)(rowView.findViewById(R.id.date))).setText(":" + values[position].getDebut());
            e.printStackTrace();
        }
        ((TextView)(rowView.findViewById(R.id.friends))).setText(String.valueOf(values[position].getParticipants().length) + " subscribed  ");


        if (listener.isSubscribed(values[position])) {
            rowView.findViewById(R.id.subscribe).setVisibility(View.GONE);
        } else {
            rowView.findViewById(R.id.unsubscribe).setVisibility(View.GONE);
            rowView.findViewById(R.id.layout_event).setBackgroundColor(Color.GRAY);
        }
        if (!listener.isAdmin(values[position]))
            rowView.findViewById(R.id.delete).setVisibility(View.GONE);
        rowView.findViewById(R.id.unsubscribe).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onUnsubscribeEvent(values[position]);
            }
        });
        rowView.findViewById(R.id.subscribe).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onSubscribeEvent(values[position]);
            }
        });
        rowView.findViewById(R.id.details).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onInfoEvent(values[position]);
            }
        });
        rowView.findViewById(R.id.delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onDeleteEvent(values[position]);
            }
        });
        return rowView;
    }



}