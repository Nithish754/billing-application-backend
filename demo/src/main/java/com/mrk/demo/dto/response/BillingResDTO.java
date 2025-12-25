package com.mrk.demo.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class BillingResDTO {

    private UUID billingId;
    private String buyerName;
    private List<BillingItemResDTO> items;

    private double subTotal;
    private double cgst;
    private double sgst;
    private double serviceFee;
    private double convenienceFee;
    private double grandTotal;
}

