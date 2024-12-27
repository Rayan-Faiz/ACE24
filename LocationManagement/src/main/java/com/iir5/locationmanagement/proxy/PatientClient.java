package com.iir5.locationmanagement.proxy;

import com.iir5.locationmanagement.dtos.Patient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "PatientManagement", url = "${patient.service.url}")
public interface PatientClient {

    @GetMapping("/wearable/{wearableId}")
    ResponseEntity<Patient> getPatientByWearableId(@PathVariable Long wearableId);
}
