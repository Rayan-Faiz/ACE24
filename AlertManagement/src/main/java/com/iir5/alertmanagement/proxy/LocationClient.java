package com.iir5.alertmanagement.proxy;

import com.iir5.alertmanagement.dtos.Location;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "LocationManagement", url = "${location.service.url}")
public interface LocationClient {
    @GetMapping("/api/locations/latest")
    Location getLatestLocation(@RequestParam("patientId") Long patientId);
}

