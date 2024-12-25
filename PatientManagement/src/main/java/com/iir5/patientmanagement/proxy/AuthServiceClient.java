package com.iir5.patientmanagement.proxy;

import com.iir5.patientmanagement.dtos.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "AuthManagement", url = "{auth.service.url}")
public interface AuthServiceClient {
    @GetMapping("/api/users/{userId}")
    UserDto getUserById(@PathVariable("userId") Long userId);
}

