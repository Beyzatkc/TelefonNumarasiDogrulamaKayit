package com.beyza.NumVertification.Registration;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RegistrationRepo extends JpaRepository<RegistrationEntity,Long> {
    boolean existsByPhoneNumber(String phone);
    @Query("SELECT r FROM RegistrationEntity r ORDER BY r.registerDate DESC")
    List<RegistrationEntity> findLastRegistrations(Pageable pageable);
}
