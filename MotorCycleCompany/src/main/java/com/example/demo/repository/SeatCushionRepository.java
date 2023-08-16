package com.example.demo.repository;

import com.example.demo.model.SeatCushion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatCushionRepository extends JpaRepository<SeatCushion, Long> {
}
