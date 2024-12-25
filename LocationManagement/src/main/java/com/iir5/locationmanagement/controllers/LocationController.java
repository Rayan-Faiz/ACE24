package com.iir5.locationmanagement.controllers;

import com.iir5.locationmanagement.dtos.Patient;
import com.iir5.locationmanagement.proxy.PatientClient;
import com.iir5.locationmanagement.entities.Location;
import com.iir5.locationmanagement.services.LocationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

@RestController
@RequestMapping("/api/locations")
@RequiredArgsConstructor
public class LocationController {
    private final LocationService locationService;
    @Autowired
    private PatientClient patientClient;

    @PostMapping("/update")
    public ResponseEntity<String> updateLocation(@RequestBody Location locationUpdate) {
        // Retrieve patient by wearableId
        Patient patient = patientClient.getPatientByWearableId(locationUpdate.getWearableId()).getBody();

        if (patient == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Patient not found for wearableId");
        }

        // Process location data for the patient
        System.out.println("Location update for patient: " + patient.getName());
        return ResponseEntity.ok("Location update processed for patient: " + patient.getId());
    }

    @PostMapping
    public ResponseEntity<Location> addLocation(@RequestBody Location location) {
        return ResponseEntity.ok(locationService.addLocation(location));
    }

    @GetMapping("/{wearableId}")
    public ResponseEntity<List<Location>> getLocations(@PathVariable String wearableId) {
        return ResponseEntity.ok(locationService.getLocationByWearableId(wearableId));
    }
}

