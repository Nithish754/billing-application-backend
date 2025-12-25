package com.mrk.demo.dao;

import com.mrk.demo.model.products.Seed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeedDAO extends JpaRepository<Seed, Integer> {
}
