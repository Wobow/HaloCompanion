
package com.wilyra.halocompanion.haloapi.model.common;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FlexibleStats {

    @SerializedName("MedalStatCounts")
    @Expose
    private MedalStatCount[] MedalStatCounts;
    @SerializedName("ImpulseStatCounts")
    @Expose
    private ImpulseStatCount[] ImpulseStatCounts;
    @SerializedName("MedalTimelapses")
    @Expose
    private MedalTimelapse[] MedalTimelapses;
    @SerializedName("ImpulseTimelapses")
    @Expose
    private ImpulseTimelapse[] ImpulseTimelapses;

    /**
     * 
     * @return
     *     The MedalStatCounts
     */
    public MedalStatCount[] getMedalStatCounts() {
        return MedalStatCounts;
    }

    /**
     *
     * @param MedalStatCounts
     *     The MedalStatCounts
     */
    public void setMedalStatCounts(MedalStatCount[] MedalStatCounts) {
        this.MedalStatCounts = MedalStatCounts;
    }

    /**
     * 
     * @return
     *     The ImpulseStatCounts
     */
    public ImpulseStatCount[] getImpulseStatCounts() {
        return ImpulseStatCounts;
    }

    /**
     *
     * @param ImpulseStatCounts
     *     The ImpulseStatCounts
     */
    public void setImpulseStatCounts(ImpulseStatCount[] ImpulseStatCounts) {
        this.ImpulseStatCounts = ImpulseStatCounts;
    }

    /**
     * 
     * @return
     *     The MedalTimelapses
     */
    public MedalTimelapse[] getMedalTimelapses() {
        return MedalTimelapses;
    }

    /**
     *
     * @param MedalTimelapses
     *     The MedalTimelapses
     */
    public void setMedalTimelapses(MedalTimelapse[] MedalTimelapses) {
        this.MedalTimelapses = MedalTimelapses;
    }

    /**
     * 
     * @return
     *     The ImpulseTimelapses
     */
    public ImpulseTimelapse[] getImpulseTimelapses() {
        return ImpulseTimelapses;
    }

    /**
     *
     * @param ImpulseTimelapses
     *     The ImpulseTimelapses
     */
    public void setImpulseTimelapses(ImpulseTimelapse[] ImpulseTimelapses) {
        this.ImpulseTimelapses = ImpulseTimelapses;
    }

}
