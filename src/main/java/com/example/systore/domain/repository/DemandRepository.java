package com.example.systore.domain.repository;

import com.example.systore.domain.entity.Demand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemandRepository extends JpaRepository<Demand, Long> {
}
