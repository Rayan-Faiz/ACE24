package com.iir5.alertmanagement.repositories;

import com.iir5.alertmanagement.entites.Alert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlertRepository extends JpaRepository<Alert, Long> {
    List<Alert> findByPatientId(Long patientId);
}
