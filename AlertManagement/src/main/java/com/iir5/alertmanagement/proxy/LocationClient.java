package com.iir5.alertmanagement.proxy;

import com.iir5.alertmanagement.dtos.Location;
import jakarta.websocket.server.PathParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@FeignClient(name = "LocationManagement", url = "${location.service.url}")
public interface LocationClient {
    @GetMapping("/api/locations/latest")
    Location getLatestLocation(@RequestParam("patientId") Long patientId);

    @GetMapping("/api/locations/{patientId}/last-movement-time")
    LocalDateTime getLastMovementTime(@PathParam("patientId") Long patientId);  // Method to get last movement time

}

