package com.example.systore.domain.repository;

import com.example.systore.domain.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MenuRepository extends JpaRepository<Menu, Long> {
    @Query("SELECT DISTINCT m1.category from Menu m1")
    Optional<List<String>> findDistinctCategory();

    Optional<List<String>> findAllByCategory(String category);
}
