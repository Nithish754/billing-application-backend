package com.mrk.demo.model;

import com.mrk.demo.enums.ProductType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "billing_items")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BillingItem {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID billingItemId;

    private UUID billingId;

    @Enumerated(EnumType.STRING)
    private ProductType productType;

    private Integer productId;
    private String productName;
    private int quantity;
    private String unit;
    private double unitPrice;
    private double totalAmount;
}

