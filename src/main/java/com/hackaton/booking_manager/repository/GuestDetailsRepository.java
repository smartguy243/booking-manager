package com.hackaton.booking_manager.repository;

import com.hackaton.booking_manager.entity.Guest;
import com.hackaton.booking_manager.entity.GuestDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestDetailsRepository extends JpaRepository<GuestDetails, Long> {
}
