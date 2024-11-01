package com.hackaton.booking_manager.service;

import com.hackaton.booking_manager.entity.Accommodation;
import com.hackaton.booking_manager.entity.Host;
import com.hackaton.booking_manager.exceptions.AccommodationNotFoundException;
import com.hackaton.booking_manager.exceptions.HostNotFoundException;
import com.hackaton.booking_manager.repository.AccommodationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AccommodationService {

    private final AccommodationRepository accommodationRepository;

    public List<Accommodation> getAllAccommodations(){
        return accommodationRepository.findAll();
    }

    public Accommodation getAccommodationById(Long id){
        return accommodationRepository.findById(id)
                .orElseThrow(()-> new AccommodationNotFoundException(String.format("Accommodation with id %s not found", id)));
    }

    public Accommodation saveAccommodation(Accommodation accommodation){
        return accommodationRepository.save(accommodation);
    }

    public Accommodation updateAccommodation(Long id, Accommodation accommodation){
        Accommodation existingAccommodation = getAccommodationById(id);
        existingAccommodation.setAddress(accommodation.getAddress());
        existingAccommodation.setAccommodationType(accommodation.getAccommodationType());
        existingAccommodation.setPrice(accommodation.getPrice());
        existingAccommodation.setRoomsQuantity(accommodation.getRoomsQuantity());
        existingAccommodation.setHostId(accommodation.getHostId());
        return accommodationRepository.save(existingAccommodation);
    }

    public String deleteAccommodation(Long id){
        Accommodation existingAccommodation = getAccommodationById(id);
        accommodationRepository.delete(existingAccommodation);
        return "Accommodation deleted successfully";
    }
}
