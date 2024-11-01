package com.hackaton.booking_manager.controller;

import com.hackaton.booking_manager.entity.GuestDetails;
import com.hackaton.booking_manager.service.GuestDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/guestDetails")
@RestController
public class GuestDetailsController {

    private final GuestDetailsService guestDetailsService;

    @GetMapping
    public ResponseEntity<List<GuestDetails>> getGuestDetailss(){
        return ResponseEntity.ok(guestDetailsService.getAllGuestDetails());
    }

    @GetMapping("/{id}")
    public GuestDetails getGuestDetails(@PathVariable Long id){
        return guestDetailsService.getGuestDetailsById(id);
    }

    @PostMapping
    public GuestDetails createGuestDetails(@RequestBody GuestDetails guestDetails){
        return guestDetailsService.saveGuestDetails(guestDetails);
    }

    @PutMapping("/{id}")
    public GuestDetails updateGuestDetails(@PathVariable Long id,@RequestBody GuestDetails guestDetails){
        return guestDetailsService.updateGuestDetails(id, guestDetails);
    }

    @DeleteMapping("/{id}")
    public String deleteGuestDetails(@PathVariable Long id){
        return guestDetailsService.deleteGuestDetails(id);
    }
}
