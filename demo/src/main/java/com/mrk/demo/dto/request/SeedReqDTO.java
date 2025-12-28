package com.mrk.demo.dto.request;

import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SeedReqDTO {

    private String name;
    private LocalDate manufactureDate;
    private LocalDate expiryDate;
    private double price;
    private int quantity;
    private String unit;
    private int newStockAdded;
}
