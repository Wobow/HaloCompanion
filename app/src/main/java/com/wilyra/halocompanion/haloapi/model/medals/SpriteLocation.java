
package com.wilyra.halocompanion.haloapi.model.medals;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SpriteLocation {

    @SerializedName("spriteSheetUri")
    @Expose
    private String spriteSheetUri;
    @SerializedName("left")
    @Expose
    private int left;
    @SerializedName("top")
    @Expose
    private int top;
    @SerializedName("width")
    @Expose
    private int width;
    @SerializedName("height")
    @Expose
    private int height;
    @SerializedName("spriteWidth")
    @Expose
    private int spriteWidth;
    @SerializedName("spriteHeight")
    @Expose
    private int spriteHeight;

    /**
     * 
     * @return
     *     The spriteSheetUri
     */
    public String getSpriteSheetUri() {
        return spriteSheetUri;
    }

    /**
     * 
     * @param spriteSheetUri
     *     The spriteSheetUri
     */
    public void setSpriteSheetUri(String spriteSheetUri) {
        this.spriteSheetUri = spriteSheetUri;
    }

    /**
     * 
     * @return
     *     The left
     */
    public int getLeft() {
        return left;
    }

    /**
     * 
     * @param left
     *     The left
     */
    public void setLeft(int left) {
        this.left = left;
    }

    /**
     * 
     * @return
     *     The top
     */
    public int getTop() {
        return top;
    }

    /**
     * 
     * @param top
     *     The top
     */
    public void setTop(int top) {
        this.top = top;
    }

    /**
     * 
     * @return
     *     The width
     */
    public int getWidth() {
        return width;
    }

    /**
     * 
     * @param width
     *     The width
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * 
     * @return
     *     The height
     */
    public int getHeight() {
        return height;
    }

    /**
     * 
     * @param height
     *     The height
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * 
     * @return
     *     The spriteWidth
     */
    public int getSpriteWidth() {
        return spriteWidth;
    }

    /**
     * 
     * @param spriteWidth
     *     The spriteWidth
     */
    public void setSpriteWidth(int spriteWidth) {
        this.spriteWidth = spriteWidth;
    }

    /**
     * 
     * @return
     *     The spriteHeight
     */
    public int getSpriteHeight() {
        return spriteHeight;
    }

    /**
     * 
     * @param spriteHeight
     *     The spriteHeight
     */
    public void setSpriteHeight(int spriteHeight) {
        this.spriteHeight = spriteHeight;
    }

}
