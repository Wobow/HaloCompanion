
package com.wilyra.halocompanion.haloapi.model.match;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.UUID;

public class MapVariant {

    @SerializedName("ResourceType")
    @Expose
    private int ResourceType;
    @SerializedName("ResourceId")
    @Expose
    private UUID ResourceId;
    @SerializedName("OwnerType")
    @Expose
    private int OwnerType;
    @SerializedName("Owner")
    @Expose
    private String Owner;

    /**
     * 
     * @return
     *     The ResourceType
     */
    public int getResourceType() {
        return ResourceType;
    }

    /**
     * 
     * @param ResourceType
     *     The ResourceType
     */
    public void setResourceType(int ResourceType) {
        this.ResourceType = ResourceType;
    }

    /**
     * 
     * @return
     *     The ResourceId
     */
    public UUID getResourceId() {
        return ResourceId;
    }

    /**
     * 
     * @param ResourceId
     *     The ResourceId
     */
    public void setResourceId(UUID ResourceId) {
        this.ResourceId = ResourceId;
    }

    /**
     * 
     * @return
     *     The OwnerType
     */
    public int getOwnerType() {
        return OwnerType;
    }

    /**
     * 
     * @param OwnerType
     *     The OwnerType
     */
    public void setOwnerType(int OwnerType) {
        this.OwnerType = OwnerType;
    }

    /**
     * 
     * @return
     *     The Owner
     */
    public String getOwner() {
        return Owner;
    }

    /**
     * 
     * @param Owner
     *     The Owner
     */
    public void setOwner(String Owner) {
        this.Owner = Owner;
    }

}
