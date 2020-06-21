package com.example.nsr.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import com.example.nsr.domain.Vendor;

import lombok.Getter;

@Getter
public class LocationResponseDto {
    private Long id;
    private String name;
    private String createdDate;
    private String modifiedDate;

    public LocationResponseDto(Vendor entity) {
        id = entity.getId();
        name = entity.getName();
        createdDate = toStringDateTime(entity.getCreatedDate());
        modifiedDate = toStringDateTime(entity.getModifiedDate());
    }

    private String toStringDateTime(LocalDateTime localDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return Optional.ofNullable(localDateTime).map(formatter::format).orElse("");
    }
}