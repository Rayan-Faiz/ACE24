package com.iir5.locationmanagement.repositories;

import com.iir5.locationmanagement.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, String> {
    List<Location> findByWearableId(Long wearableId);

    Location findTopByWearableIdOrderByTimestampDesc(Long wearableId);
}

