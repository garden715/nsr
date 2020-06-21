package com.example.nsr.service;

import java.util.List;
import java.util.stream.Collectors;

import com.example.nsr.domain.VendorRepository;
import com.example.nsr.dto.VendorResponseDto;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class VendorService {
    private VendorRepository vendorRepository;

    @Transactional(readOnly = true)
    public List<VendorResponseDto> findAllDesc() {
        return vendorRepository.findAllDesc().map(VendorResponseDto::new).collect(Collectors.toList());
    }

}