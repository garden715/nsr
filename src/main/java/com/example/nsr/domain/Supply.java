package com.example.nsr.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Supply extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String name;

    @OneToOne
	@JoinColumn(name ="kind_id")
    private Kind kind;

    @OneToOne
	@JoinColumn(name ="location_id")
    private Location location;

    @OneToOne
	@JoinColumn(name ="vendor_id")
    private Vendor vendor;

    @Column
    private Long count;

    @Builder
    public Supply(String name, Kind kind, Location location, Vendor vendor, Long count) {
        this.name = name;
        this.kind = kind;
        this.location = location;
        this.vendor = vendor;
        this.count = count;
    }
}
