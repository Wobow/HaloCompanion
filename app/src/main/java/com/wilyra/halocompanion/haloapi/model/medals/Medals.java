
package com.wilyra.halocompanion.haloapi.model.medals;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Medals {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("classification")
    @Expose
    private String classification;
    @SerializedName("difficulty")
    @Expose
    private int difficulty;
    @SerializedName("spriteLocation")
    @Expose
    private SpriteLocation spriteLocation;
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
     *     The classification
     */
    public String getClassification() {
        return classification;
    }

    /**
     * 
     * @param classification
     *     The classification
     */
    public void setClassification(String classification) {
        this.classification = classification;
    }

    /**
     * 
     * @return
     *     The difficulty
     */
    public int getDifficulty() {
        return difficulty;
    }

    /**
     * 
     * @param difficulty
     *     The difficulty
     */
    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    /**
     * 
     * @return
     *     The spriteLocation
     */
    public SpriteLocation getSpriteLocation() {
        return spriteLocation;
    }

    /**
     * 
     * @param spriteLocation
     *     The spriteLocation
     */
    public void setSpriteLocation(SpriteLocation spriteLocation) {
        this.spriteLocation = spriteLocation;
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
