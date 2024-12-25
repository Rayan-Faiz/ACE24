package com.iir5.patientmanagement.controllers;

import com.iir5.patientmanagement.entities.Patient;
import com.iir5.patientmanagement.services.PatientService;
import lombok.RequiredArgsConstructor;
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

    @PostMapping("/add")
    public Patient addPatient(@RequestBody Patient patient) {
        return patientService.addPatient(patient);
    }

    @GetMapping
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/wearable/{wearableId}")
    public ResponseEntity<Patient> getPatientByWearableId(@PathVariable String wearableId) {
        return  patientService.findByWearableId(wearableId);
    }
}
