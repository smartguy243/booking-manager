package com.hackaton.booking_manager.repository;

import com.hackaton.booking_manager.entity.Booking;
import com.hackaton.booking_manager.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Long> {
}
