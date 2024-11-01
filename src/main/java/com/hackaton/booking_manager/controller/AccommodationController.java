package com.hackaton.booking_manager.controller;

import com.hackaton.booking_manager.entity.Accommodation;
import com.hackaton.booking_manager.entity.Host;
import com.hackaton.booking_manager.service.AccommodationService;
import com.hackaton.booking_manager.service.HostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/accommodations")
@RestController
public class AccommodationController {

    private final AccommodationService accommodationService;

    @GetMapping
    public ResponseEntity<List<Accommodation>> getAccommodations(){
        return ResponseEntity.ok(accommodationService.getAllAccommodations());
    }

    @GetMapping("/{id}")
    public Accommodation getAccommodation(@PathVariable Long id){
        return accommodationService.getAccommodationById(id);
    }

    @PostMapping
    public Accommodation createAccommodation(@RequestBody Accommodation accommodation){
        return accommodationService.saveAccommodation(accommodation);
    }

    @PutMapping("/{id}")
    public Accommodation updateAccommodation(@PathVariable Long id,@RequestBody Accommodation accommodation){
        return accommodationService.updateAccommodation(id, accommodation);
    }

    @DeleteMapping("/{id}")
    public String deleteAccommodation(@PathVariable Long id){
        return accommodationService.deleteAccommodation(id);
    }
}
