package com.iir5.patientmanagement;

import com.iir5.patientmanagement.entities.Patient;
import com.iir5.patientmanagement.entities.SafeZone;
import com.iir5.patientmanagement.repositories.PatientRepository;
import com.iir5.patientmanagement.repositories.SafeZoneRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@EnableFeignClients
@SpringBootApplication
public class PatientManagementApplication {
    private final PatientRepository patientRepository;
    private final SafeZoneRepository safeZoneRepository;

    public PatientManagementApplication(PatientRepository patientRepository, SafeZoneRepository safeZoneRepository) {
        this.patientRepository = patientRepository;
        this.safeZoneRepository = safeZoneRepository;
    }

    @Bean
    public CommandLineRunner initializeDatabase() {
        return args -> {
            //Add Safezone to link to patients
            SafeZone safeZone1 = new SafeZone(31.6225, 7.9898, 600, LocalDateTime.now());
            SafeZone safeZone2 = new SafeZone(24.6225, 19.9898, 500, LocalDateTime.now());
            SafeZone safeZone3 = new SafeZone(39.6225, 12.9898, 500, LocalDateTime.now());

            safeZoneRepository.save(safeZone1);
            safeZoneRepository.save(safeZone2);
            safeZoneRepository.save(safeZone3);
            // Add patients linked to caregivers
            Patient patient1 = new Patient("Alice Johnson", 65, "Alzheimer's", 1L, 1L);
            Patient patient2 = new Patient("Bob Brown", 72, "Dementia", 2L, 2L);
            Patient patient3 = new Patient("Charlie Davis", 70, "Alzheimer's", 3L, 1L);

            patientRepository.save(patient1);
            patientRepository.save(patient2);
            patientRepository.save(patient3);

            // Assign SafeZone to the patients
            patient1.setSafeZone(safeZone1);
            patient2.setSafeZone(safeZone2);
            patient3.setSafeZone(safeZone3);

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
