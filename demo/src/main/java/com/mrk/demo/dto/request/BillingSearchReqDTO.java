package com.mrk.demo.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BillingSearchReqDTO {

    private String buyerName;
    private String aadharNo;
    private String phoneNumber;
    private String village;

    private Boolean today;
    private LocalDate fromDate;
    private LocalDate toDate;

    private int page = 0;
    private int size = 10;
}
