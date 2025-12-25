package com.mrk.demo.dto.request;

import com.mrk.demo.enums.ProductType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillingItemReqDTO {
    private ProductType productType;
    private Integer productId;
    private int quantity;
}

