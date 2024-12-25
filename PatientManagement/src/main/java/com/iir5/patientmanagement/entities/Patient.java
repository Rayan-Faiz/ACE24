package com.iir5.patientmanagement.entities;

import com.iir5.patientmanagement.dtos.Caregiver;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    private String medicalCondition;
    @Column(unique = true)
    private String wearableId;
    ManyToOne
    @Column(unique = true)
    private Caregiver caregiver;
    @OneToOne
    @JoinColumn(name = "Safezone_id")
    private SafeZone safeZone;

    public Patient() {

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

    public String getWearableId() {
        return wearableId;
    }

    public void setWearableId(String wearableId) {
        this.wearableId = wearableId;
    }

    public Caregiver getCaregiver() {
        return caregiver;
    }

    public void setCaregiver(Caregiver caregiver) {
        this.caregiver = caregiver;
    }

    public SafeZone getSafeZone() {
        return safeZone;
    }

    public void setSafeZone(SafeZone safeZone) {
        this.safeZone = safeZone;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    private final LocalDateTime createdAt = LocalDateTime.now();

    public Patient(Long id, String name, int age, String medicalCondition, String wearableId, Caregiver caregiver) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.medicalCondition = medicalCondition;
        this.wearableId = wearableId;
        this.caregiver = caregiver;
    }
}
