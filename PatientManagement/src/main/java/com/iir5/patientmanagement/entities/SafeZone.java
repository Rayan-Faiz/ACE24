package com.iir5.patientmanagement.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class SafeZone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double latitude;
    private double longitude;
    private float radius;
    private LocalDateTime createdAt = LocalDateTime.now();

    public SafeZone() {
    }

    public SafeZone(double latitude, double longitude, float radius, LocalDateTime createdAt) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.radius = radius;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}

