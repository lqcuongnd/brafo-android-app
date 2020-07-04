package com.lqcuongnd.brafo_android_app.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Info {

    @SerializedName("\u0110\u1ecba ch\u1ec9")
    @Expose
    private String aCh;
    @SerializedName("\u0110i\u1ec7n tho\u1ea1i")
    @Expose
    private List<String> iNThoI = null;
    @SerializedName("website")
    @Expose
    private String website;
    @SerializedName("areas")
    @Expose
    private List<String> areas = null;

    public String getACh() {
        return aCh;
    }

    public void setACh(String aCh) {
        this.aCh = aCh;
    }

    public List<String> getINThoI() {
        return iNThoI;
    }

    public void setINThoI(List<String> iNThoI) {
        this.iNThoI = iNThoI;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public List<String> getAreas() {
        return areas;
    }

    public void setAreas(List<String> areas) {
        this.areas = areas;
    }

}
