package com.example.nsr.domain;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    @Query("SELECT p " + "FROM Location p " + "ORDER BY p.id DESC")
    Stream<Vendor> findAllDesc();
}