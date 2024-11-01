package com.hackaton.booking_manager.repository;

import com.hackaton.booking_manager.entity.Accommodation;
import com.hackaton.booking_manager.entity.Host;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccommodationRepository extends JpaRepository<Accommodation, Long> {
}
