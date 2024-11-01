package com.hackaton.booking_manager.service;

import com.hackaton.booking_manager.entity.Host;
import com.hackaton.booking_manager.exceptions.HostNotFoundException;
import com.hackaton.booking_manager.repository.HostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class HostService {

    private final HostRepository hostRepository;

    public List<Host> getAllHosts(){
        return hostRepository.findAll();
    }

    public Host getHostById(Long hostId){
        return hostRepository.findById(hostId)
                .orElseThrow(()-> new HostNotFoundException(String.format("Host with id %s not found", hostId)));
    }

    public Host saveHost(Host host){
        return hostRepository.save(host);
    }

    public Host updateHost(Long hostId, Host host){
        Host existingHost = getHostById(hostId);
        existingHost.setName(host.getName());
        existingHost.setEmail(host.getEmail());
        existingHost.setPhoneNumber(host.getPhoneNumber());
        return hostRepository.save(existingHost);
    }

    public String deleteHost(Long hostId){
        Host existingHost = getHostById(hostId);
        hostRepository.delete(existingHost);
        return "Host deleted successfully";
    }
}
