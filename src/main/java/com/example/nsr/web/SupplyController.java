package com.example.nsr.web;

import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

import java.util.List;

import com.example.nsr.dto.VendorResponseDto;
import com.example.nsr.domain.Location;
import com.example.nsr.domain.Supply;
import com.example.nsr.domain.Vendor;
import com.example.nsr.dto.LocationResponseDto;
import com.example.nsr.dto.SupplyResponseDto;
import com.example.nsr.service.LocationService;
import com.example.nsr.service.SupplyService;
import com.example.nsr.service.VendorService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@AllArgsConstructor
public class SupplyController {

    private VendorService vendorService;
    private LocationService locationService;
    private SupplyService supplyService;

    @GetMapping("/api/vendor")
    public List<VendorResponseDto> findVendors() {
        return vendorService.findAllDesc();
    }

    @PostMapping("/api/vendor")
    public Vendor newVendor(@RequestBody Vendor newVendor) {
        return vendorService.save(newVendor);
    }

    @PutMapping("/api/vendor")
    public Vendor updateVendor(@RequestBody Vendor vendor) {
        return vendorService.save(vendor);
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

    @PostMapping("/api/location")
    public Location newLocation(@RequestBody Location newLocation) {
        return locationService.save(newLocation);
    }

    @PutMapping("/api/location")
    public Location updateLocation(@RequestBody Location location) {
        return locationService.save(location);
    }

    @DeleteMapping("/api/location/{id}")
    public ResponseEntity<Void> deleteLocationById(@PathVariable("id") final Long id) {
        locationService.deleteLocation(id);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("/api/supply")
    public List<SupplyResponseDto> findSupply() {
        return supplyService.findAllDesc();
    }

    @PostMapping("/api/supply")
    public Supply newSupply(@RequestBody Supply newSupply) {
        return supplyService.save(newSupply);
    }

    @PutMapping("/api/supply")
    public Supply updateSupply(@RequestBody Supply supply) {
        return supplyService.save(supply);
    }

    @DeleteMapping("/api/supply/{id}")
    public ResponseEntity<Void> deleteSupplyById(@PathVariable("id") final Long id) {
        supplyService.deleteSupply(id);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}