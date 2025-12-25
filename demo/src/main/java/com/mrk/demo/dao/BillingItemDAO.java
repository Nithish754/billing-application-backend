package com.mrk.demo.dao;

import com.mrk.demo.model.BillingItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BillingItemDAO extends JpaRepository<BillingItem, UUID> {}

