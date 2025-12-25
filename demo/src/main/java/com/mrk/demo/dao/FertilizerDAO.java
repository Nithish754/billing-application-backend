package com.mrk.demo.dao;

import com.mrk.demo.model.products.Fertilizer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FertilizerDAO extends JpaRepository<Fertilizer, Integer> {
}

