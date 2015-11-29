package com.wilyra.halocompanion.haloapi.model;

import android.graphics.Bitmap;

import java.util.UUID;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Map {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("supportedGameModes")
    @Expose
    private String[] supportedGameModes;
    @SerializedName("imageUrl")
    @Expose
    private String imageUrl;
    @SerializedName("id")
    @Expose
    private UUID id;
    @SerializedName("contentId")
    @Expose
    private String contentId;

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    private Bitmap image = null;

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
     * The description
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     * The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return
     * The supportedGameModes
     */
    public String[] getSupportedGameModes() {
        return supportedGameModes;
    }

    /**
     *
     * @param supportedGameModes
     * The supportedGameModes
     */
    public void setSupportedGameModes(String[] supportedGameModes) {
        this.supportedGameModes = supportedGameModes;
    }

    /**
     *
     * @return
     * The imageUrl
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     *
     * @param imageUrl
     * The imageUrl
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     *
     * @return
     * The id
     */
    public UUID getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(UUID id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The contentId
     */
    public String getContentId() {
        return contentId;
    }

    /**
     *
     * @param contentId
     * The contentId
     */
    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

}