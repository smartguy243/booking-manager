package com.hackaton.booking_manager.service;

import com.hackaton.booking_manager.entity.Guest;
import com.hackaton.booking_manager.exceptions.GuestNotFoundException;
import com.hackaton.booking_manager.repository.GuestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GuestService {

    private final GuestRepository guestRepository;

    public List<Guest> getAllGuests(){
        return guestRepository.findAll();
    }

    public Guest getGuestById(Long GuestId){
        return guestRepository.findById(GuestId)
                .orElseThrow(()-> new GuestNotFoundException(String.format("Guest with id %s not found", GuestId)));
    }

    public Guest saveGuest(Guest Guest){
        return guestRepository.save(Guest);
    }

    public Guest updateGuest(Long GuestId, Guest Guest){
        Guest existingGuest = getGuestById(GuestId);
        existingGuest.setName(Guest.getName());
        return guestRepository.save(existingGuest);
    }

    public String deleteGuest(Long GuestId){
        Guest existingGuest = getGuestById(GuestId);
        guestRepository.delete(existingGuest);
        return "Guest deleted successfully";
    }
}
