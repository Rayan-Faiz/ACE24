package com.iir5.patientmanagement.controllers;

import com.iir5.patientmanagement.entities.SafeZone;
import com.iir5.patientmanagement.services.SafeZoneService;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/safe-zones")
public class SafeZoneController {
    public SafeZoneController(SafeZoneService safeZoneService) {
        this.safeZoneService = safeZoneService;
    }

    private final SafeZoneService safeZoneService;

    @PostMapping
    public SafeZone addSafeZone(@RequestBody SafeZone safeZone) {
        return safeZoneService.addSafeZone(safeZone);
    }

    @GetMapping("/{patientId}")
    public SafeZone getSafeZone(@PathVariable Long patientId) {
        return safeZoneService.getSafeZoneByPatientId(patientId);
    }
}

