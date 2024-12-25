package com.iir5.locationmanagement.services;

import com.iir5.locationmanagement.entities.Location;
import com.iir5.locationmanagement.repositories.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.time.LocalDateTime;


@Service
public class LocationService {
    private final LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public Location addLocation(Location location) {
        location.setTimestamp(LocalDateTime.now());
        return locationRepository.save(location);
    }

    public List<Location> getLocationByWearableId(String wearableId) {
        return locationRepository.findByWearableId(wearableId);
    }

    public LocalDateTime getLastMovementTime(String wearableId) {
        // Fetch the last recorded movement time from the database for the patient
        Location location = locationRepository.findTopByWearableIdOrderByTimestampDesc(wearableId);
        return (location != null) ? location.getTimestamp() : null;
    }

}

