package com.hackaton.booking_manager.service;

import com.hackaton.booking_manager.entity.GuestDetails;
import com.hackaton.booking_manager.exceptions.GuestDetailsNotFoundException;
import com.hackaton.booking_manager.repository.GuestDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GuestDetailsService {

    private final GuestDetailsRepository guestDetailsRepository;

    public List<GuestDetails> getAllGuestDetails(){
        return guestDetailsRepository.findAll();
    }

    public GuestDetails getGuestDetailsById(Long guestDetailsId){
        return guestDetailsRepository.findById(guestDetailsId)
                .orElseThrow(()-> new GuestDetailsNotFoundException(String.format("GuestDetails with id %s not found", guestDetailsId)));
    }

    public GuestDetails saveGuestDetails(GuestDetails guestDetails){
        return guestDetailsRepository.save(guestDetails);
    }

    public GuestDetails updateGuestDetails(Long guestDetailsId, GuestDetails guestDetails){
        GuestDetails existingGuestDetails = getGuestDetailsById(guestDetailsId);
        existingGuestDetails.setAge(guestDetails.getAge());
        existingGuestDetails.setEmail(guestDetails.getEmail());
        existingGuestDetails.setPhoneNumber(guestDetails.getPhoneNumber());
        existingGuestDetails.setGuest(guestDetails.getGuest());
        return guestDetailsRepository.save(existingGuestDetails);
    }

    public String deleteGuestDetails(Long guestDetailsId){
        GuestDetails existingGuestDetails = getGuestDetailsById(guestDetailsId);
        guestDetailsRepository.delete(existingGuestDetails);
        return "GuestDetails deleted successfully";
    }
}
