package com.mrk.demo.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PesticideReqDTO {
    private Integer id;
    private String name;
    private LocalDate manufactureDate;
    private LocalDate expiryDate;
    private double price;
    private int quantity;
    private String unit;
    private int newStockAdded;
}

