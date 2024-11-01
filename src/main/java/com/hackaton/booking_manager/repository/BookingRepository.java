package com.hackaton.booking_manager.repository;

import com.hackaton.booking_manager.entity.Booking;
import com.hackaton.booking_manager.entity.Host;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
}
