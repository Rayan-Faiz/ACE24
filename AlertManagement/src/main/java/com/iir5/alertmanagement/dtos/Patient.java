package com.iir5.alertmanagement.dtos;


import java.time.LocalDateTime;

public class Patient {
    private Long id;
    private String name;
    private int age;
    private String medicalCondition;
    private Long wearableId;
    private LocalDateTime createdAt = LocalDateTime.now();

    public Long getId() {
        return id;
    }

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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Patient() {
    }

    public Patient(Long id, String name, int age, String medicalCondition, Long wearableId, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.medicalCondition = medicalCondition;
        this.wearableId = wearableId;
        this.createdAt = createdAt;
    }
}
