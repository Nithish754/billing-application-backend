package com.mrk.demo.controller;

import com.mrk.demo.constant.EndpointConstant;
import com.mrk.demo.dto.request.BillingReqDTO;
import com.mrk.demo.dto.response.BillingResDTO;
import com.mrk.demo.service.BillingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = EndpointConstant.BASE_URL,produces = "application/json")
@RequiredArgsConstructor
public class BillingController {

    private final BillingService service;

    @PostMapping(EndpointConstant.GENERATE_BILL)
    public BillingResDTO generate(@RequestBody BillingReqDTO request) {
        return service.generateBill(request);
    }
}

