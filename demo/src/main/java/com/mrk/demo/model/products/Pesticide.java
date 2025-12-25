package com.mrk.demo.model.products;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "pesticides")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pesticide {

    @Id
    private Integer id;

    private String name;
    private LocalDate manufactureDate;
    private LocalDate expiryDate;
    private double price;
    private int quantity;
    private String unit;
    private int newStockAdded;
    private int totalStock;
}

