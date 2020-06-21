package com.example.nsr.web;

import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

import java.util.List;

import com.example.nsr.dto.VendorResponseDto;
import com.example.nsr.dto.LocationResponseDto;
import com.example.nsr.dto.ModelResponseDto;
import com.example.nsr.service.LocationService;
import com.example.nsr.service.ModelService;
import com.example.nsr.service.VendorService;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
@AllArgsConstructor
public class SupplyController {

    private VendorService vendorService;
    private LocationService locationService;
    private ModelService modelService;

    @GetMapping(value="/api/vendor")
    public List<VendorResponseDto> findVendors() {
        return vendorService.findAllDesc();
    }
    
    @GetMapping(value="/api/location")
    public List<LocationResponseDto> findLocation() {
        return locationService.findAllDesc();
    }

    @GetMapping(value="/api/model")
    public List<ModelResponseDto> findModel() {
        return modelService.findAllDesc();
    }
}