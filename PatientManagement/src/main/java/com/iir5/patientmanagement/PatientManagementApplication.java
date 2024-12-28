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
            // Add SafeZones
            SafeZone safeZone1 = new SafeZone(31.6225, 7.9898, 600, LocalDateTime.now());
            SafeZone safeZone2 = new SafeZone(24.6225, 19.9898, 500, LocalDateTime.now());
            SafeZone safeZone3 = new SafeZone(39.6225, 12.9898, 500, LocalDateTime.now());
            SafeZone safeZone4 = new SafeZone(40.7128, -74.0060, 700, LocalDateTime.now());
            SafeZone safeZone5 = new SafeZone(51.5074, -0.1278, 800, LocalDateTime.now());
            SafeZone safeZone6 = new SafeZone(48.8566, 2.3522, 900, LocalDateTime.now());
            SafeZone safeZone7 = new SafeZone(34.0522, -118.2437, 600, LocalDateTime.now());
            SafeZone safeZone8 = new SafeZone(35.6895, 139.6917, 700, LocalDateTime.now());
            SafeZone safeZone9 = new SafeZone(55.7558, 37.6173, 500, LocalDateTime.now());
            SafeZone safeZone10 = new SafeZone(37.7749, -122.4194, 800, LocalDateTime.now());

            safeZoneRepository.save(safeZone1);
            safeZoneRepository.save(safeZone2);
            safeZoneRepository.save(safeZone3);
            safeZoneRepository.save(safeZone4);
            safeZoneRepository.save(safeZone5);
            safeZoneRepository.save(safeZone6);
            safeZoneRepository.save(safeZone7);
            safeZoneRepository.save(safeZone8);
            safeZoneRepository.save(safeZone9);
            safeZoneRepository.save(safeZone10);

            // Add Patients
            Patient patient1 = new Patient("Alice Johnson", 65, "Alzheimer's", 1L, 1L);
            Patient patient2 = new Patient("Bob Brown", 72, "Dementia", 2L, 1L);
            Patient patient3 = new Patient("Charlie Davis", 70, "Alzheimer's", 3L, 1L);
            Patient patient4 = new Patient("Diana Smith", 68, "Parkinson's", 4L, 1L);
            Patient patient5 = new Patient("Edward Wilson", 75, "Dementia", 5L, 2L);
            Patient patient6 = new Patient("Fiona White", 67, "Stroke Recovery", 6L, 3L);
            Patient patient7 = new Patient("George Adams", 73, "Dementia", 7L, 1L);
            Patient patient8 = new Patient("Hannah Clark", 66, "Parkinson's", 8L, 2L);
            Patient patient9 = new Patient("Ian Miller", 74, "Alzheimer's", 9L, 3L);
            Patient patient10 = new Patient("Jessica Taylor", 71, "Stroke Recovery", 10L, 1L);

            patientRepository.save(patient1);
            patientRepository.save(patient2);
            patientRepository.save(patient3);
            patientRepository.save(patient4);
            patientRepository.save(patient5);
            patientRepository.save(patient6);
            patientRepository.save(patient7);
            patientRepository.save(patient8);
            patientRepository.save(patient9);
            patientRepository.save(patient10);

            // Assign SafeZones to Patients
            patient1.setSafeZone(safeZone1);
            patient2.setSafeZone(safeZone2);
            patient3.setSafeZone(safeZone3);
            patient4.setSafeZone(safeZone4);
            patient5.setSafeZone(safeZone5);
            patient6.setSafeZone(safeZone6);
            patient7.setSafeZone(safeZone7);
            patient8.setSafeZone(safeZone8);
            patient9.setSafeZone(safeZone9);
            patient10.setSafeZone(safeZone10);

            patientRepository.save(patient1);
            patientRepository.save(patient2);
            patientRepository.save(patient3);
            patientRepository.save(patient4);
            patientRepository.save(patient5);
            patientRepository.save(patient6);
            patientRepository.save(patient7);
            patientRepository.save(patient8);
            patientRepository.save(patient9);
            patientRepository.save(patient10);

            System.out.println("Database initialized with caregivers and patients.");
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(PatientManagementApplication.class, args);
    }
}
