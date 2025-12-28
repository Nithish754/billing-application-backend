package com.mrk.demo.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    private String name;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate manufactureDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate expiryDate;
    private double price;
    private int quantity;
    private String unit;
    private int newStockAdded;
}

