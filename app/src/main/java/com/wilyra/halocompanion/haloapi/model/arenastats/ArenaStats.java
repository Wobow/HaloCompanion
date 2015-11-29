
package com.wilyra.halocompanion.haloapi.model.arenastats;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ArenaStats {

    @SerializedName("Results")
    @Expose
    private Result[] Results;
    @SerializedName("Links")
    @Expose
    private Object Links;

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

    /**
     * 
     * @return
     *     The Links
     */
    public Object getLinks() {
        return Links;
    }

    /**
     * 
     * @param Links
     *     The Links
     */
    public void setLinks(Object Links) {
        this.Links = Links;
    }

}
