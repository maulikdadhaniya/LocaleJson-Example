package com.example.myapplication;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class DetailsListPojo {
    @SerializedName("Details")
    @Expose
    private ArrayList<Detail> detailList = null;

    public ArrayList<Detail> getDetailList() {
        return detailList;
    }

    public void setdetailList(ArrayList<Detail> detailList) {
        this.detailList = detailList;
    }
}
