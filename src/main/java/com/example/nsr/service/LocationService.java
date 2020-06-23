package com.example.nsr.service;

import java.util.List;
import java.util.stream.Collectors;

import com.example.nsr.domain.Location;
import com.example.nsr.domain.LocationRepository;
import com.example.nsr.dto.LocationResponseDto;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class LocationService {
    private LocationRepository locationRepository;

    @Transactional(readOnly = true)
    public List<LocationResponseDto> findAllDesc() {
        return locationRepository.findAllDesc().map(LocationResponseDto::new).collect(Collectors.toList());
    }

    @Transactional
    public void deleteLocation(Long id) {
        locationRepository.deleteById(id);
    }

    @Transactional
    public Location save(Location newLocation) {
        return locationRepository.save(newLocation);
    }
}
