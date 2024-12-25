package com.iir5.patientmanagement.services;

import com.iir5.patientmanagement.repositories.CaregiverRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CaregiverDetailsService implements UserDetailsService {

    private final CaregiverRepository caregiverRepository;

    public CaregiverDetailsService(CaregiverRepository caregiverRepository) {
        this.caregiverRepository = caregiverRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return caregiverRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Caregiver not found: " + username));
    }
}
