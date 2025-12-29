package com.mrk.demo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BillingListResDTO {

    private UUID billingId;
    private LocalDateTime billDate;

    private String buyerName;
    private String phoneNumber;
    private String aadharNo;
    private String village;

    private double grandTotal;
}
