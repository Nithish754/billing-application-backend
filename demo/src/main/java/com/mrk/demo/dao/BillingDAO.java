package com.mrk.demo.dao;

import com.mrk.demo.model.Billing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BillingDAO extends JpaRepository<Billing, UUID> {
}

