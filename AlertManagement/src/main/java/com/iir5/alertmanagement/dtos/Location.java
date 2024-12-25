package com.iir5.alertmanagement.dtos;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public class Location {
    @Id
    private String id;
    private String wearableId;
    private double latitude;
    private double longitude;
    private LocalDateTime timestamp;

    public Location() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWearableId() {
        return wearableId;
    }

    public void setWearableId(String wearableId) {
        this.wearableId = wearableId;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Location(String id, String wearableId, double latitude, double longitude, LocalDateTime timestamp) {
        this.id = id;
        this.wearableId = wearableId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.timestamp = timestamp;
    }
}
