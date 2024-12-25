package com.iir5.alertmanagement.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class Alert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long patientId;
    private String type; // e.g., "Safe Zone Breach", "Unusual Movement"
    private String message;
    private LocalDateTime timestamp = LocalDateTime.now();
    private String status; // e.g., "New", "Acknowledged", "Resolved"

    public Alert(Long id, Long patientId, String type, String message, LocalDateTime timestamp, String status) {
        this.id = id;
        this.patientId = patientId;
        this.type = type;
        this.message = message;
        this.timestamp = timestamp;
        this.status = status;
    }
}

