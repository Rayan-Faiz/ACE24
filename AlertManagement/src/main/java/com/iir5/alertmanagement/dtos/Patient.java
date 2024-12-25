package com.iir5.alertmanagement.dtos;


import java.time.LocalDateTime;

public class Patient {
    private Long id;
    private String name;
    private int age;
    private String medicalCondition;
    private String wearableId;
    private LocalDateTime createdAt = LocalDateTime.now();
}
