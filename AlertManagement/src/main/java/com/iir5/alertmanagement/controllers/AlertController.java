package com.iir5.alertmanagement.controllers;

import com.iir5.alertmanagement.entites.Alert;
import com.iir5.alertmanagement.services.AlertService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alerts")
public class AlertController {
    private final AlertService alertService;

    public AlertController(AlertService alertService) {
        this.alertService = alertService;
    }

    @PostMapping
    public ResponseEntity<Alert> createAlert(@RequestBody Alert alert) {
        return ResponseEntity.ok(alertService.createAlert(alert));
    }

    @GetMapping("/{patientId}")
    public ResponseEntity<List<Alert>> getAlertsByPatientId(@PathVariable Long patientId) {
        return ResponseEntity.ok(alertService.getAlertsByPatientId(patientId));
    }

    @GetMapping
    public ResponseEntity<List<Alert>> getAllAlerts() {
        return ResponseEntity.ok(alertService.getAllAlerts());
    }

    @PutMapping("/{alertId}/status")
    public ResponseEntity<Alert> updateAlertStatus(
            @PathVariable Long alertId,
            @RequestParam String status
    ) {
        return ResponseEntity.ok(alertService.updateAlertStatus(alertId, status));
    }

    @DeleteMapping("/{alertId}")
    public ResponseEntity<Void> deleteAlert(@PathVariable Long alertId) {
        alertService.deleteAlert(alertId);
        return ResponseEntity.noContent().build();
    }
}
