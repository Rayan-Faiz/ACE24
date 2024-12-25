package com.iir5.patientmanagement;

import com.iir5.patientmanagement.entities.Caregiver;
import com.iir5.patientmanagement.entities.Patient;
import com.iir5.patientmanagement.repositories.CaregiverRepository;
import com.iir5.patientmanagement.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class PatientManagementApplication {
    private final CaregiverRepository caregiverRepository;
    private final PatientRepository patientRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public PatientManagementApplication(CaregiverRepository caregiverRepository, PatientRepository patientRepository, PasswordEncoder passwordEncoder) {
        this.caregiverRepository = caregiverRepository;
        this.patientRepository = patientRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public CommandLineRunner initializeDatabase() {
        return args -> {

            // Add patients linked to caregivers
            Patient patient1 = new Patient(null, "Alice Johnson", 65, "Alzheimer's", "wearable_001");
            Patient patient2 = new Patient(null, "Bob Brown", 72, "Dementia", "wearable_002");
            Patient patient3 = new Patient(null, "Charlie Davis", 70, "Alzheimer's", "wearable_003");

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
