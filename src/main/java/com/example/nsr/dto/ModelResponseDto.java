package com.example.nsr.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import com.example.nsr.domain.Model;

import lombok.Getter;

@Getter
public class ModelResponseDto {
    private Long id;
    private String name;
    private String kind_name;
    private String location_name;
    private String vendor_name;
    private Long count;
    private String createdDate;
    private String modifiedDate;

    public ModelResponseDto(Model entity) {
        id = entity.getId();
        name = entity.getName();
        kind_name = entity.getKind().getName();
        location_name = entity.getLocation().getName();
        vendor_name = entity.getVendor().getName();
        count = entity.getCount();
        createdDate = toStringDateTime(entity.getCreatedDate());
        modifiedDate = toStringDateTime(entity.getModifiedDate());
    }

    private String toStringDateTime(LocalDateTime localDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return Optional.ofNullable(localDateTime).map(formatter::format).orElse("");
    }
}