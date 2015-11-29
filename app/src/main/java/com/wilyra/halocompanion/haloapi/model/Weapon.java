
package com.wilyra.halocompanion.haloapi.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Weapon {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("largeIconImageUrl")
    @Expose
    private String largeIconImageUrl;
    @SerializedName("smallIconImageUrl")
    @Expose
    private String smallIconImageUrl;
    @SerializedName("isUsableByPlayer")
    @Expose
    private String isUsableByPlayer;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("contentId")
    @Expose
    private String contentId;

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The description
     */
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @param description
     *     The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 
     * @return
     *     The type
     */
    public String getType() {
        return type;
    }

    /**
     * 
     * @param type
     *     The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 
     * @return
     *     The largeIconImageUrl
     */
    public String getLargeIconImageUrl() {
        return largeIconImageUrl;
    }

    /**
     * 
     * @param largeIconImageUrl
     *     The largeIconImageUrl
     */
    public void setLargeIconImageUrl(String largeIconImageUrl) {
        this.largeIconImageUrl = largeIconImageUrl;
    }

    /**
     * 
     * @return
     *     The smallIconImageUrl
     */
    public String getSmallIconImageUrl() {
        return smallIconImageUrl;
    }

    /**
     * 
     * @param smallIconImageUrl
     *     The smallIconImageUrl
     */
    public void setSmallIconImageUrl(String smallIconImageUrl) {
        this.smallIconImageUrl = smallIconImageUrl;
    }

    /**
     * 
     * @return
     *     The isUsableByPlayer
     */
    public String getIsUsableByPlayer() {
        return isUsableByPlayer;
    }

    /**
     * 
     * @param isUsableByPlayer
     *     The isUsableByPlayer
     */
    public void setIsUsableByPlayer(String isUsableByPlayer) {
        this.isUsableByPlayer = isUsableByPlayer;
    }

    /**
     * 
     * @return
     *     The id
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The contentId
     */
    public String getContentId() {
        return contentId;
    }

    /**
     * 
     * @param contentId
     *     The contentId
     */
    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

}
