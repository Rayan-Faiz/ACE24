package com.iir5.alertmanagement.controllers;

import com.iir5.alertmanagement.entites.Alert;
import com.iir5.alertmanagement.services.AlertService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/api/alerts")
@RequiredArgsConstructor
public class AlertController {
    private final AlertService alertService;

    @PostMapping
    public ResponseEntity<Alert> createAlert(@RequestBody Alert alert) {
        return ResponseEntity.ok(alertService.createAlert(alert));
    }

    @GetMapping("/{patientId}")
    public ResponseEntity<List<Alert>> getAlertsByPatientId(@PathVariable Long patientId) {
        return ResponseEntity.ok(alertService.getAlertsByPatientId(patientId));
    }

    @PutMapping("/{alertId}/status")
    public ResponseEntity<Alert> updateAlertStatus(
            @PathVariable Long alertId,
            @RequestParam String status
    ) {
        return ResponseEntity.ok(alertService.updateAlertStatus(alertId, status));
    }
}

