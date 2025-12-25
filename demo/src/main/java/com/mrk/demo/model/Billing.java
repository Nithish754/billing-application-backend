package com.mrk.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "billing")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Billing {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID billingId;

    private LocalDateTime billDate;

    // Buyer details
    private String buyerName;
    private LocalDate dob;
    private String aadharNo;
    private String phoneNumber;
    private String address;
    private String village;
    private String district;

    // Amounts
    private double subTotal;
    private double gstPercentage;
    private double cgst;
    private double sgst;
    private double serviceFee;
    private double convenienceFee;
    private double grandTotal;
}

