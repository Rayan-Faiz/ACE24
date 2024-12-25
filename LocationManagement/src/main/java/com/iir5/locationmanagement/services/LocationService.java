package com.iir5.locationmanagement.services;

import com.iir5.locationmanagement.entities.Location;
import com.iir5.locationmanagement.repositories.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.time.LocalDateTime;


@Service
@RequiredArgsConstructor
public class LocationService {
    private final LocationRepository locationRepository;

    public Location addLocation(Location location) {
        location.setTimestamp(LocalDateTime.now());
        return locationRepository.save(location);
    }

    public List<Location> getLocationByWearableId(String wearableId) {
        return locationRepository.findByWearableId(wearableId);
    }

    public LocalDateTime getLastMovementTime(Long patientId) {
        // Fetch the last recorded movement time from the database for the patient
        Location location = locationRepository.findTopByPatientIdOrderByTimestampDesc(patientId);
        return (location != null) ? location.getTimestamp() : null;
    }

}

