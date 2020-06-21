package com.example.nsr.domain;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends JpaRepository<Model, Long> {
    @Query("SELECT m FROM Model m")
    // @Query("SELECT m.*, k.name kind_name, l.name location_name, v.name vendor_name FROM model m LEFT JOIN kind k ON m.kind_id = k.id LEFT JOIN location l ON m.location_id = l.id LEFT JOIN vendor v ON m.vendor_id = v.id;")
    Stream<Model> findAllDesc();
}