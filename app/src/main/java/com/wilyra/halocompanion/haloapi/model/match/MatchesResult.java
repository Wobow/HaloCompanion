
package com.wilyra.halocompanion.haloapi.model.match;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MatchesResult {

    @SerializedName("Start")
    @Expose
    private int Start;
    @SerializedName("Count")
    @Expose
    private int Count;
    @SerializedName("ResultCount")
    @Expose
    private int ResultCount;
    @SerializedName("Results")
    @Expose
    private Result[] Results;

    /**
     * 
     * @return
     *     The Start
     */
    public int getStart() {
        return Start;
    }

    /**
     * 
     * @param Start
     *     The Start
     */
    public void setStart(int Start) {
        this.Start = Start;
    }

    /**
     * 
     * @return
     *     The Count
     */
    public int getCount() {
        return Count;
    }

    /**
     * 
     * @param Count
     *     The Count
     */
    public void setCount(int Count) {
        this.Count = Count;
    }

    /**
     * 
     * @return
     *     The ResultCount
     */
    public int getResultCount() {
        return ResultCount;
    }

    /**
     * 
     * @param ResultCount
     *     The ResultCount
     */
    public void setResultCount(int ResultCount) {
        this.ResultCount = ResultCount;
    }

    /**
     * 
     * @return
     *     The Results
     */
    public Result[] getResults() {
        return Results;
    }

    /**
     * 
     * @param Results
     *     The Results
     */
    public void setResults(Result[] Results) {
        this.Results = Results;
    }

}
