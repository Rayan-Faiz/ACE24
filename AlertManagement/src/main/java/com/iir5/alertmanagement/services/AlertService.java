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

@Service
@RequiredArgsConstructor
public class AlertService {
    @Autowired
    private final LocationClient locationClient;
    @Autowired
    private final PatientClient patientClient;
    private final AlertRepository alertRepository;

    public void checkAndTriggerAlert(Long patientId) {
        // Fetch location
        Location location = locationClient.getLatestLocation(patientId);

        // Fetch safe zone
        SafeZone safeZone = patientClient.getSafeZone(patientId);

        // Check if location is outside safe zone
        if (!isWithinSafeZone(location, safeZone)) {
            Alert alert = new Alert(null, patientId, "Patient out of safe zone", "Triggered", LocalDateTime.now(), "New");
            alertRepository.save(alert);
        }
    }

    private boolean isWithinSafeZone(Location location, SafeZone safeZone) {
        double distance = calculateDistance(
                location.getLatitude(), location.getLongitude(),
                safeZone.getLatitude(), safeZone.getLongitude());
        return distance <= safeZone.getRadiusMeters();
    }

    private double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        // Haversine formula to calculate distance between two GPS coordinates
        final int R = 6371000; // Earth radius in meters
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                        Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c;
    }

}
