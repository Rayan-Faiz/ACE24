package com.iir5.alertmanagement.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Location {
    @Id
    private String id;
    private String wearableId;
    private double latitude;
    private double longitude;
    private LocalDateTime timestamp;
}
