package com.hackaton.booking_manager.controller;

import com.hackaton.booking_manager.entity.Guest;
import com.hackaton.booking_manager.service.GuestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/guests")
@RestController
public class GuestController {

    private final GuestService GuestService;

    @GetMapping
    public ResponseEntity<List<Guest>> getGuests(){
        return ResponseEntity.ok(GuestService.getAllGuests());
    }

    @GetMapping("/{id}")
    public Guest getGuest(@PathVariable Long id){
        return GuestService.getGuestById(id);
    }

    @PostMapping
    public Guest createGuest(@RequestBody Guest guest){
        return GuestService.saveGuest(guest);
    }

    @PutMapping("/{id}")
    public Guest updateGuest(@PathVariable Long id,@RequestBody Guest guest){
        return GuestService.updateGuest(id, guest);
    }

    @DeleteMapping("/{id}")
    public String deleteGuest(@PathVariable Long id){
        return GuestService.deleteGuest(id);
    }
}
