package com.iir5.patientmanagement.services;

import com.iir5.patientmanagement.entities.Patient;
import com.iir5.patientmanagement.repositories.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public ResponseEntity<Patient> findByWearableId(@PathVariable String wearableId) {
        Optional<Patient> patient = patientRepository.findByWearableId(wearableId);
        return patient.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
