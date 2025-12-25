package com.mrk.demo.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillingReqDTO {

    // Buyer
    private String buyerName;
    private LocalDate dob;
    private String aadharNo;
    private String phoneNumber;
//    private String address;
    private String village;
    private String district;

    // Products
    private List<BillingItemReqDTO> items;

    // Billing inputs from UI
    private double gstPercentage;
    private double serviceFee;
    private double convenienceFee;
}

