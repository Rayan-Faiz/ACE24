package com.iir5.locationmanagement;

import com.iir5.locationmanagement.entities.Location;
import com.iir5.locationmanagement.repositories.LocationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.time.LocalDateTime;

@EnableFeignClients
@SpringBootApplication
public class LocationManagementApplication {

    private final LocationRepository locationRepository;

    public LocationManagementApplication(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Bean
    public CommandLineRunner initializeLocations() {
        return args -> {
            // Add some initial location data
            Location location1 = new Location(null, 1L, 34.052235, -118.243683, LocalDateTime.now());
            Location location2 = new Location(null, 2L, 37.774929, -122.419418, LocalDateTime.now().minusMinutes(5));
            Location location3 = new Location(null, 3L, 40.712776, 7.005974, LocalDateTime.now().minusMinutes(10));

            locationRepository.save(location1);
            locationRepository.save(location2);
            locationRepository.save(location3);

            System.out.println("Initialized location data.");
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(LocationManagementApplication.class, args);
    }

}
