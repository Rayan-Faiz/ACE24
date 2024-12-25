package com.iir5.patientmanagement.controllers;

import com.iir5.patientmanagement.entities.Patient;
import com.iir5.patientmanagement.services.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    // Create a new patient
    @PostMapping("/add")
    public Patient addPatient(@RequestBody Patient patient) {
        return patientService.addPatient(patient);
    }

    // Get all patients
    @GetMapping
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    // Get a specific patient by wearable ID
    @GetMapping("/wearable/{wearableId}")
    public ResponseEntity<Patient> getPatientByWearableId(@PathVariable String wearableId) {
        return patientService.findByWearableId(wearableId);
    }

    // Get a specific patient by ID
    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {
        Optional<Patient> patient = patientService.getPatientById(id);
        return patient.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // Update a patient's details
    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Long id, @RequestBody Patient updatedPatient) {
        Optional<Patient> existingPatient = patientService.getPatientById(id);

        if (existingPatient.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        updatedPatient.setId(id); // Ensure that the ID remains the same
        Patient updated = patientService.addPatient(updatedPatient); // Save the updated patient
        return ResponseEntity.ok(updated);
    }

    // Delete a patient by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
        Optional<Patient> existingPatient = patientService.getPatientById(id);

        if (existingPatient.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        patientService.deletePatient(id);
        return ResponseEntity.noContent().build();
    }
}
