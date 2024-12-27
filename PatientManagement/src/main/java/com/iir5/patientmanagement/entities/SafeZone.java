package com.iir5.patientmanagement.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class SafeZone {
    @Id
    private Long id;
    private double latitude;
    private double longitude;
    private float radius;
    @OneToOne
    @JoinColumn(name = "Patient_id")
    private Patient patient;
    private LocalDateTime createdAt = LocalDateTime.now();

    public SafeZone(Long id, Long patientId, double latitude, double longitude, float radius, LocalDateTime createdAt) {
        this.id = id;
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

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public SafeZone() {
    }

    public SafeZone(Long id, double latitude, double longitude, float radius, Patient patient, LocalDateTime createdAt) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.radius = radius;
        this.patient = patient;
        this.createdAt = createdAt;
    }
}

