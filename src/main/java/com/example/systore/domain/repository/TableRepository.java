package com.example.systore.domain.repository;

import com.example.systore.domain.entity.Table;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TableRepository extends JpaRepository<Table, Long> {
}
