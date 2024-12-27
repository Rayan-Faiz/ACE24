package com.iir5.patientmanagement.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Patient {
    @Id
    private Long id;
    private String name;
    private int age;
    private String medicalCondition;
    @Column(unique = true)
    private Long wearableId;
    private Long userId;

    public Patient() {}

    public void setId(Long id) {
        this.id = id;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    private final LocalDateTime createdAt = LocalDateTime.now();

    public Patient(Long id, String name, int age, String medicalCondition, Long wearableId, Long userId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.medicalCondition = medicalCondition;
        this.wearableId = wearableId;
        this.userId = userId;
    }
}
