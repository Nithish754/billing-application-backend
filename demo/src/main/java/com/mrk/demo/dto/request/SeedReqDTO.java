package com.mrk.demo.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SeedReqDTO {

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
