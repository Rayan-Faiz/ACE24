package com.iir5.locationmanagement.controllers;

import com.iir5.locationmanagement.dtos.Patient;
import com.iir5.locationmanagement.entities.Location;
import com.iir5.locationmanagement.services.LocationService;
import com.iir5.locationmanagement.proxy.PatientClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/locations")
public class LocationController {

    @Autowired
    private final LocationService locationService;
    @Autowired
    private final PatientClient patientClient;

    public LocationController(LocationService locationService, PatientClient patientClient) {
        this.locationService = locationService;
        this.patientClient = patientClient;
    }

    @GetMapping("/{wearableId}/last-movement-time")
    public LocalDateTime getLastMovementTime(@PathVariable("wearableId") Long wearableId) {
        return locationService.getLastMovementTime(wearableId);
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateLocation(@RequestBody Location locationUpdate) {
        String response = locationService.processLocationUpdate(locationUpdate);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Location> addLocation(@RequestBody Location location) {
        Location addedLocation = locationService.addLocation(location);
        return ResponseEntity.ok(addedLocation);
    }

    @GetMapping("/{wearableId}")
    public ResponseEntity<List<Location>> getLocations(@PathVariable Long wearableId) {
        List<Location> locations = locationService.getLocationByWearableId(wearableId);
        return ResponseEntity.ok(locations);
    }
}
