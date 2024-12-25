package com.iir5.alertmanagement.services;

import com.iir5.alertmanagement.proxy.LocationClient;
import com.iir5.alertmanagement.proxy.PatientClient;
import com.iir5.alertmanagement.entites.Alert;
import com.iir5.alertmanagement.dtos.SafeZone;
import com.iir5.alertmanagement.dtos.Location;
import com.iir5.alertmanagement.repositories.AlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AlertService {
    @Autowired
    private final LocationClient locationClient;
    @Autowired
    private final PatientClient patientClient;
    private final AlertRepository alertRepository;

    // Create a new alert
    public Alert createAlert(Alert alert) {
        return alertRepository.save(alert);
    }

    // Get alerts for a specific patient
    public List<Alert> getAlertsByPatientId(Long patientId) {
        return alertRepository.findByPatientId(patientId);
    }

    // Get all alerts
    public List<Alert> getAllAlerts() {
        return alertRepository.findAll();
    }

    // Update alert status
    public Alert updateAlertStatus(Long alertId, String status) {
        Alert alert = alertRepository.findById(alertId).orElseThrow(() -> new RuntimeException("Alert not found"));
        alert.setStatus(status);
        return alertRepository.save(alert);
    }

    // Delete alert
    public void deleteAlert(Long alertId) {
        alertRepository.deleteById(alertId);
    }

    // Check if the patient is out of their safe zone or hasn't moved for days
    public void checkAndTriggerAlert(Long patientId) {
        Location location = locationClient.getLatestLocation(patientId);
        SafeZone safeZone = patientClient.getSafeZone(patientId);

        // Check if location is outside safe zone
        if (!isWithinSafeZone(location, safeZone)) {
            Alert alert = new Alert(null, patientId, "Patient out of safe zone", "Triggered", LocalDateTime.now(), "New");
            alertRepository.save(alert);
        }

        // Check if patient has not moved for more than 48 hours
        if (hasNotMovedForDays(patientId, 2)) {  // e.g., 2 days threshold
            Alert alert = new Alert(null, patientId, "No movement detected", "Triggered", LocalDateTime.now(), "New");
            alertRepository.save(alert);
        }
    }

    // Helper method to check if patient is within safe zone
    private boolean isWithinSafeZone(Location location, SafeZone safeZone) {
        double distance = calculateDistance(
                location.getLatitude(), location.getLongitude(),
                safeZone.getLatitude(), safeZone.getLongitude());
        return distance <= safeZone.getRadiusMeters();
    }

    // Helper method to calculate distance using the Haversine formula
    private double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        final int R = 6371000; // Earth radius in meters
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                        Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c;
    }

    // Helper method to check if patient has not moved for a specified number of days
    private boolean hasNotMovedForDays(Long patientId, int days) {
        // Get the patient's last recorded movement time
        LocalDateTime lastMovementTime = locationClient.getLastMovementTime(patientId);
        LocalDateTime now = LocalDateTime.now();
        return lastMovementTime != null && lastMovementTime.isBefore(now.minusDays(days));
    }
}
