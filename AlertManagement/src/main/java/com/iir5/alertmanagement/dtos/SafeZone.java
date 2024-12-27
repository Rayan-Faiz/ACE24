package com.iir5.alertmanagement.dtos;

public class SafeZone {
    private double latitude;
    private double longitude;
    private double radius;

    // Constructors
    public SafeZone() {}

    public SafeZone(double latitude, double longitude, double radius) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.radius = radius;
    }

    // Getters and Setters
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

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radiusMeters) {
        this.radius = radiusMeters;
    }

    @Override
    public String toString() {
        return "SafeZone{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                ", radius=" + radius +
                '}';
    }

}

