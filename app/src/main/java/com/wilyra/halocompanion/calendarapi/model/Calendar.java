package com.wilyra.halocompanion.calendarapi.model;

import java.util.ArrayList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Calendar {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("_id")
    @Expose
    private String Id;
    @SerializedName("__v")
    @Expose
    private Integer V;
    @SerializedName("users")
    @Expose
    private String[] users;
    @SerializedName("events")
    @Expose
    private String[] events;
    @SerializedName("admins")
    @Expose
    private String[] admins;

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
     * The users
     */
    public String[] getUsers() {
        return users;
    }

    /**
     *
     * @param users
     * The users
     */
    public void setUsers(String[] users) {
        this.users = users;
    }

    /**
     *
     * @return
     * The events
     */
    public String[] getEvents() {
        return events;
    }

    /**
     *
     * @param events
     * The events
     */
    public void setEvents(String[] events) {
        this.events = events;
    }

    /**
     *
     * @return
     * The admins
     */
    public String[] getAdmins() {
        return admins;
    }

    /**
     *
     * @param admins
     * The admins
     */
    public void setAdmins(String[] admins) {
        this.admins = admins;
    }

}