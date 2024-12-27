package com.iir5.alertmanagement.proxy;

import com.iir5.alertmanagement.dtos.Patient;
import com.iir5.alertmanagement.dtos.SafeZone;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "PatientManagement", url = "${patient.service.url}")
public interface PatientClient {
    @GetMapping("/api/safe-zone/{patientId}")
     SafeZone getSafeZone(@PathVariable Long patientId);

    @GetMapping("/api/patients/")
    List<Patient> getAllPatients();
}
