package com.hackaton.booking_manager.controller;

import com.hackaton.booking_manager.entity.Host;
import com.hackaton.booking_manager.service.HostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/hosts")
@RestController
public class HostController {

    private final HostService hostService;

    @GetMapping
    public ResponseEntity<List<Host>> getHosts(){
        return ResponseEntity.ok(hostService.getAllHosts());
    }

    @GetMapping("/{id}")
    public Host getHost(@PathVariable Long id){
        return hostService.getHostById(id);
    }

    @PostMapping
    public Host createHost(@RequestBody Host host){
        return hostService.saveHost(host);
    }

    @PutMapping("/{id}")
    public Host updateHost(@PathVariable Long id,@RequestBody Host host){
        return hostService.updateHost(id, host);
    }

    @DeleteMapping("/{id}")
    public String deleteHost(@PathVariable Long id){
        return hostService.deleteHost(id);
    }
}
