package com.iir5.patientmanagement.services;

import com.iir5.patientmanagement.entities.SafeZone;
import com.iir5.patientmanagement.repositories.SafeZoneRepository;
import org.springframework.stereotype.Service;

@Service
public class SafeZoneService {
    public SafeZoneService(SafeZoneRepository safeZoneRepository) {
        this.safeZoneRepository = safeZoneRepository;
    }

    private final SafeZoneRepository safeZoneRepository;

    public SafeZone addSafeZone(SafeZone safeZone) {
        return safeZoneRepository.save(safeZone);
    }

    public SafeZone getSafeZoneByPatientId(Long patientId) {
        return safeZoneRepository.findByPatientId(patientId);
    }
}
