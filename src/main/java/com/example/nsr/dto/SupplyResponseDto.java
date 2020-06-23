package com.example.nsr.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import com.example.nsr.domain.Supply;

import lombok.Getter;

@Getter
public class SupplyResponseDto {
    private Long id;
    private String name;
    private Long kind_id;
    private String kind_name;
    private Long location_id;
    private String location_name;
    private Long vendor_id;
    private String vendor_name;
    private Long count;
    private String createdDate;
    private String modifiedDate;

    public SupplyResponseDto(Supply entity) {
        id = entity.getId();
        name = entity.getName();
        kind_id = entity.getKind().getId();
        kind_name = entity.getKind().getName();
        location_id = entity.getLocation().getId();
        location_name = entity.getLocation().getName();
        vendor_id = entity.getVendor().getId();
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