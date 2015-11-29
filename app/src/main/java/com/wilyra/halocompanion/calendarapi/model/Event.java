package com.wilyra.halocompanion.calendarapi.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Event {

    @SerializedName("__v")
    @Expose
    private Integer V;
    @SerializedName("_id")
    @Expose
    private String Id;
    @SerializedName("calendar")
    @Expose
    private Calendar calendar;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("debut")
    @Expose
    private String debut;
    @SerializedName("participants")
    @Expose
    private String[] participants;

    /**
     *
     * @return
     * The V
     */
    public Integer getV() {
        return V;
    }

    /**
     *
     * @param V
     * The __v
     */
    public void setV(Integer V) {
        this.V = V;
    }

    /**
     *
     * @return
     * The Id
     */
    public String getId() {
        return Id;
    }

    /**
     *
     * @param Id
     * The _id
     */
    public void setId(String Id) {
        this.Id = Id;
    }

    /**
     *
     * @return
     * The calendar
     */
    public Calendar getCalendar() {
        return calendar;
    }

    /**
     *
     * @param calendar
     * The calendar
     */
    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The debut
     */
    public String getDebut() {
        return debut;
    }

    /**
     *
     * @param debut
     * The debut
     */
    public void setDebut(String debut) {
        this.debut = debut;
    }

    /**
     *
     * @return
     * The participants
     */
    public String[] getParticipants() {
        return participants;
    }

    /**
     *
     * @param participants
     * The participants
     */
    public void setParticipants(String[] participants) {
        this.participants = participants;
    }

}