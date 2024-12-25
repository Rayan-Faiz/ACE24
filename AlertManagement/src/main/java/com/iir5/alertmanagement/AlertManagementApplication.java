package com.iir5.alertmanagement;

import com.iir5.alertmanagement.entites.Alert;
import com.iir5.alertmanagement.repositories.AlertRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@EnableFeignClients
@SpringBootApplication
public class AlertManagementApplication {

    private final AlertRepository alertRepository;

    public AlertManagementApplication(AlertRepository alertRepository) {
        this.alertRepository = alertRepository;
    }

    @Bean
    public CommandLineRunner initializeAlerts() {
        return args -> {
            // Add some initial alert data
            Alert alert1 = new Alert(null, 1L, "Safe Zone Breach", "Patient left the safe zone.", LocalDateTime.now().minusMinutes(15), "New");
            Alert alert2 = new Alert(null, 2L, "Unusual Movement", "Patient has been stationary for too long.", LocalDateTime.now().minusMinutes(10), "Acknowledged");
            Alert alert3 = new Alert(null, 3L, "Safe Zone Breach", "Patient entered a restricted area.", LocalDateTime.now().minusMinutes(5), "Resolved");

            alertRepository.save(alert1);
            alertRepository.save(alert2);
            alertRepository.save(alert3);

            System.out.println("Initialized alert data in the database.");
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(AlertManagementApplication.class, args);
    }

}
