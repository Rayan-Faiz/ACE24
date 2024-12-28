package com.iir5.patientmanagement.services;

import com.iir5.patientmanagement.entities.Patient;
import com.iir5.patientmanagement.entities.SafeZone;
import com.iir5.patientmanagement.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    // Add a new patient
    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    // Get all patients
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    // Find a patient by wearable ID
    public ResponseEntity<Patient> findByWearableId(Long wearableId) {
        Optional<Patient> patient = patientRepository.findByWearableId(wearableId);
        return patient.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // Get a patient by ID
    public Optional<Patient> getPatientById(Long id) {
        return patientRepository.findById(id);
    }

    // Delete a patient by ID
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

    // Get SafeZone by Patient ID
    public ResponseEntity<SafeZone> getSafeZoneByPatientId(Long patientId) {
        Optional<Patient> patient = patientRepository.findById(patientId);
        if (patient.isPresent()) {
            SafeZone safeZone = patient.get().getSafeZone();
            if (safeZone != null) {
                return ResponseEntity.ok(safeZone);
            } else {
                return ResponseEntity.notFound().build();
            }
        }
        return ResponseEntity.notFound().build();
    }
}
