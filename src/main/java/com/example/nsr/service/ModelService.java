package com.example.nsr.service;

import java.util.List;
import java.util.stream.Collectors;

import com.example.nsr.domain.ModelRepository;
import com.example.nsr.dto.ModelResponseDto;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ModelService {
    private ModelRepository modelRepository;

    @Transactional(readOnly = true)
    public List<ModelResponseDto> findAllDesc() {
        return modelRepository.findAllDesc().map(ModelResponseDto::new).collect(Collectors.toList());
    }
}
