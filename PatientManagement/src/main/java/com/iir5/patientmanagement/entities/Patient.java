package com.iir5.patientmanagement.entities;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    private String medicalCondition;
    private Long wearableId;
    private Long caregiverId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "safezone_id")
    private SafeZone safeZone;

    public Patient(String name, int age, String medicalCondition, Long wearableId, Long caregiverId) {
        this.name = name;
        this.age = age;
        this.medicalCondition = medicalCondition;
        this.wearableId = wearableId;
        this.caregiverId = caregiverId;
    }

    public Patient() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SafeZone getSafeZone() {
        return safeZone;
    }

    public void setSafeZone(SafeZone safeZone) {
        this.safeZone = safeZone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMedicalCondition() {
        return medicalCondition;
    }

    public void setMedicalCondition(String medicalCondition) {
        this.medicalCondition = medicalCondition;
    }

    public Long getWearableId() {
        return wearableId;
    }

    public void setWearableId(Long wearableId) {
        this.wearableId = wearableId;
    }

    public Long getCaregiverId() {
        return caregiverId;
    }

    public void setCaregiverId(Long userId) {
        this.caregiverId = userId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    private final LocalDateTime createdAt = LocalDateTime.now();

}
