package com.example.nsr.web;

import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

import java.util.List;

import com.example.nsr.dto.VendorResponseDto;
import com.example.nsr.domain.Vendor;
import com.example.nsr.dto.LocationResponseDto;
import com.example.nsr.dto.ModelResponseDto;
import com.example.nsr.service.LocationService;
import com.example.nsr.service.ModelService;
import com.example.nsr.service.VendorService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@AllArgsConstructor
public class SupplyController {

    private VendorService vendorService;
    private LocationService locationService;
    private ModelService modelService;

    @GetMapping("/api/vendor")
    public List<VendorResponseDto> findVendors() {
        return vendorService.findAllDesc();
    }

    @PostMapping("/api/vendor")
    public Vendor newVendor(@RequestBody Vendor newVendor) {
        return vendorService.save(newVendor);
    }

    @DeleteMapping("/api/vendor/{id}")
    public ResponseEntity<Void> deleteVendorById(@PathVariable("id") final Long id) {
        vendorService.deleteVendor(id);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("/api/location")
    public List<LocationResponseDto> findLocation() {
        return locationService.findAllDesc();
    }

    @GetMapping("/api/model")
    public List<ModelResponseDto> findModel() {
        return modelService.findAllDesc();
    }
}