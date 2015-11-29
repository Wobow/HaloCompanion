package com.wilyra.halocompanion.haloapi.model.gamevariant;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.UUID;

public class GameVariant {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("gameBaseVariantId")
    @Expose
    private UUID gameBaseVariantId;
    @SerializedName("iconUrl")
    @Expose
    private String iconUrl;
    @SerializedName("id")
    @Expose
    private UUID id;
    @SerializedName("contentId")
    @Expose
    private UUID contentId;

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
     * The gameBaseVariantId
     */
    public UUID getGameBaseVariantId() {
        return gameBaseVariantId;
    }

    /**
     *
     * @param gameBaseVariantId
     * The gameBaseVariantId
     */
    public void setGameBaseVariantId(UUID gameBaseVariantId) {
        this.gameBaseVariantId = gameBaseVariantId;
    }

    /**
     *
     * @return
     * The iconUrl
     */
    public String getIconUrl() {
        return iconUrl;
    }

    /**
     *
     * @param iconUrl
     * The iconUrl
     */
    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
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
    public UUID getContentId() {
        return contentId;
    }

    /**
     *
     * @param contentId
     * The contentId
     */
    public void setContentId(UUID contentId) {
        this.contentId = contentId;
    }

}