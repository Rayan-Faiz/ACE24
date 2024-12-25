package com.iir5.locationmanagement.repositories;

import com.iir5.locationmanagement.entities.Location;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends MongoRepository<Location, String> {
    List<Location> findByWearableId(String wearableId);

    Location findTopByPatientIdOrderByTimestampDesc(Long patientId);
}

