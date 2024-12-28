package com.iir5.patientmanagement.repositories;

import com.iir5.patientmanagement.entities.SafeZone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SafeZoneRepository extends JpaRepository<SafeZone, Long> {
}
