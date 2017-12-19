package com.example.admin.abcfashions.WebService;

import com.example.admin.abcfashions.WebService.pojo.Marker;
import com.example.admin.abcfashions.WebService.pojo.User;

import java.util.List;

/**
 * Created by admin on 12/17/17.
 */

public class MarkerEvent {

    private List<Marker> marker;

    public MarkerEvent(List<Marker> marker) {
        this.marker=marker;

    }

    public List<Marker> getMarker() {
        return marker;
    }

    public void setMarker(List<Marker> marker) {
        this.marker = marker;
    }
}
