package com.mrk.demo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PesticideResDTO {

    private Integer id;
    private String name;
    private LocalDate manufactureDate;
    private LocalDate expiryDate;
    private double price;
    private int quantity;
    private String unit;
    private int totalStock;
}

