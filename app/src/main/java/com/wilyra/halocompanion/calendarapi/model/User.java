package com.wilyra.halocompanion.calendarapi.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Created by wilyr on 11/29/2015.
 */
public class User {

    @SerializedName("gamerTagNormalized")
    @Expose
    private String gamerTagNormalized;
    @SerializedName("gamerTag")
    @Expose
    private String gamerTag;
    @SerializedName("passwd")
    @Expose
    private String passwd;
    @SerializedName("loginNormalized")
    @Expose
    private String loginNormalized;
    @SerializedName("login")
    @Expose
    private String login;
    @SerializedName("_id")
    @Expose
    private String Id;
    @SerializedName("__v")
    @Expose
    private Integer V;

    /**
     *
     * @return
     * The gamerTagNormalized
     */
    public String getGamerTagNormalized() {
        return gamerTagNormalized;
    }

    /**
     *
     * @param gamerTagNormalized
     * The gamerTagNormalized
     */
    public void setGamerTagNormalized(String gamerTagNormalized) {
        this.gamerTagNormalized = gamerTagNormalized;
    }

    /**
     *
     * @return
     * The gamerTag
     */
    public String getGamerTag() {
        return gamerTag;
    }

    /**
     *
     * @param gamerTag
     * The gamerTag
     */
    public void setGamerTag(String gamerTag) {
        this.gamerTag = gamerTag;
    }

    /**
     *
     * @return
     * The passwd
     */
    public String getPasswd() {
        return passwd;
    }

    /**
     *
     * @param passwd
     * The passwd
     */
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    /**
     *
     * @return
     * The loginNormalized
     */
    public String getLoginNormalized() {
        return loginNormalized;
    }

    /**
     *
     * @param loginNormalized
     * The loginNormalized
     */
    public void setLoginNormalized(String loginNormalized) {
        this.loginNormalized = loginNormalized;
    }

    /**
     *
     * @return
     * The login
     */
    public String getLogin() {
        return login;
    }

    /**
     *
     * @param login
     * The login
     */
    public void setLogin(String login) {
        this.login = login;
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

}

