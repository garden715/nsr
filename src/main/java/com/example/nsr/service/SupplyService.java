package com.example.nsr.service;

import java.util.List;
import java.util.stream.Collectors;

import com.example.nsr.domain.Supply;
import com.example.nsr.domain.SupplyRepository;
import com.example.nsr.dto.SupplyResponseDto;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SupplyService {
    private SupplyRepository modelRepository;

    @Transactional(readOnly = true)
    public List<SupplyResponseDto> findAllDesc() {
        return modelRepository.findAllDesc().map(SupplyResponseDto::new).collect(Collectors.toList());
    }

    @Transactional
    public void deleteSupply(Long id) {
        modelRepository.deleteById(id);
    }

    @Transactional
    public Supply save(Supply newModel) {
        return modelRepository.save(newModel);
    }
}
