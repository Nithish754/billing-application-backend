package com.mrk.demo.dao;

import com.mrk.demo.model.products.Pesticide;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PesticideDAO extends JpaRepository<Pesticide, Integer> {
}
