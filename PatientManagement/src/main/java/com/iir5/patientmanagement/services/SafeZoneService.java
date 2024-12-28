package com.iir5.patientmanagement.services;

import com.iir5.patientmanagement.entities.SafeZone;
import com.iir5.patientmanagement.repositories.SafeZoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SafeZoneService {
    @Autowired
    private final SafeZoneRepository safeZoneRepository;

    public SafeZoneService(SafeZoneRepository safeZoneRepository) {
        this.safeZoneRepository = safeZoneRepository;
    }

    public SafeZone addSafeZone(SafeZone safeZone) {
        return safeZoneRepository.save(safeZone);
    }
}
