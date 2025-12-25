package com.mrk.demo.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BillingItemResDTO {
    private String productName;
    private int quantity;
    private String unit;
    private double unitPrice;
    private double totalAmount;
}

