package com.mrk.demo.service;

import com.mrk.demo.dto.request.BillingReqDTO;
import com.mrk.demo.dto.response.BillingResDTO;

public interface BillingService {

    BillingResDTO generateBill(BillingReqDTO request);
}
