package com.iir5.patientmanagement;

import com.iir5.patientmanagement.entities.Patient;
import com.iir5.patientmanagement.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;

@FeignClient
@SpringBootApplication
public class PatientManagementApplication {
    private final PatientRepository patientRepository;

    public PatientManagementApplication(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Bean
    public CommandLineRunner initializeDatabase() {
        return args -> {

            // Add patients linked to caregivers
            Patient patient1 = new Patient(null, "Alice Johnson", 65, "Alzheimer's", "wearable_001", 1L);
            Patient patient2 = new Patient(null, "Bob Brown", 72, "Dementia", "wearable_002", 2L);
            Patient patient3 = new Patient(null, "Charlie Davis", 70, "Alzheimer's", "wearable_003", 1L);

            patientRepository.save(patient1);
            patientRepository.save(patient2);
            patientRepository.save(patient3);

            System.out.println("Database initialized with caregivers and patients.");
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(PatientManagementApplication.class, args);
    }
}
