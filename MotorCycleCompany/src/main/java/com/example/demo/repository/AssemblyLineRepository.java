package com.example.demo.repository;

import com.example.demo.model.AssemblyLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface AssemblyLineRepository extends JpaRepository<AssemblyLine, Long> {
}
