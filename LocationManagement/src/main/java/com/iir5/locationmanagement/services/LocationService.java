package com.iir5.locationmanagement.services;

import com.iir5.locationmanagement.dtos.Patient;
import com.iir5.locationmanagement.entities.Location;
import com.iir5.locationmanagement.repositories.LocationRepository;
import com.iir5.locationmanagement.proxy.PatientClient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.time.LocalDateTime;

@Service
public class LocationService {

    private final LocationRepository locationRepository;
    private final PatientClient patientClient;

    public LocationService(LocationRepository locationRepository, PatientClient patientClient) {
        this.locationRepository = locationRepository;
        this.patientClient = patientClient;
    }

    public Location addLocation(Location location) {
        location.setTimestamp(LocalDateTime.now());
        return locationRepository.save(location);
    }

    public List<Location> getLocationByWearableId(Long wearableId) {
        return locationRepository.findByWearableId(wearableId);
    }

    public LocalDateTime getLastMovementTime(Long wearableId) {
        Location location = locationRepository.findTopByWearableIdOrderByTimestampDesc(wearableId);
        return (location != null) ? location.getTimestamp() : null;
    }

    public String processLocationUpdate(Location locationUpdate) {
        // Retrieve patient by wearableId
        Patient patient = patientClient.getPatientByWearableId(locationUpdate.getWearableId()).getBody();

        // Process location data for the patient
        if (patient != null) {
            System.out.println("Location update for patient: " + patient.getName());
            return "Location update processed for patient: " + patient.getId();
        }
        return "Patient not found for wearable ID: " + locationUpdate.getWearableId();
    }
}
