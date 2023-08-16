package com.example.demo.repository;

import com.example.demo.model.FrontLights;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface FrontLightsRepository extends JpaRepository<FrontLights, Long> {
}
