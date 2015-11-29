
package com.wilyra.halocompanion.haloapi.model.arenastats;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("Id")
    @Expose
    private String Id;
    @SerializedName("ResultCode")
    @Expose
    private String ResultCode;
    @SerializedName("Result")
    @Expose
    private Result_ Result;

    /**
     * 
     * @return
     *     The Id
     */
    public String getId() {
        return Id;
    }

    /**
     * 
     * @param Id
     *     The Id
     */
    public void setId(String Id) {
        this.Id = Id;
    }

    /**
     * 
     * @return
     *     The ResultCode
     */
    public String getResultCode() {
        return ResultCode;
    }

    /**
     * 
     * @param ResultCode
     *     The ResultCode
     */
    public void setResultCode(String ResultCode) {
        this.ResultCode = ResultCode;
    }

    /**
     * 
     * @return
     *     The Result
     */
    public Result_ getResult() {
        return Result;
    }

    /**
     * 
     * @param Result
     *     The Result
     */
    public void setResult(Result_ Result) {
        this.Result = Result;
    }

}
