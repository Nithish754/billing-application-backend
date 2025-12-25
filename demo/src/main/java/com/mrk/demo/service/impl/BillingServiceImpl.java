package com.mrk.demo.service.impl;

import com.mrk.demo.dao.*;
import com.mrk.demo.dto.request.BillingItemReqDTO;
import com.mrk.demo.dto.request.BillingReqDTO;
import com.mrk.demo.dto.response.BillingItemResDTO;
import com.mrk.demo.dto.response.BillingResDTO;
import com.mrk.demo.model.Billing;
import com.mrk.demo.model.BillingItem;
import com.mrk.demo.model.products.Fertilizer;
import com.mrk.demo.model.products.Pesticide;
import com.mrk.demo.model.products.Seed;
import com.mrk.demo.service.BillingService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class BillingServiceImpl implements BillingService {

    private final BillingDAO billingDAO;
    private final BillingItemDAO billingItemDAO;

    private final FertilizerDAO fertilizerDAO;
    private final PesticideDAO pesticideDAO;
    private final SeedDAO seedDAO;

    public BillingServiceImpl(
            BillingDAO billingDAO,
            BillingItemDAO billingItemDAO,
            FertilizerDAO fertilizerDAO,
            PesticideDAO pesticideDAO,
            SeedDAO seedDAO
    ) {
        this.billingDAO = billingDAO;
        this.billingItemDAO = billingItemDAO;
        this.fertilizerDAO = fertilizerDAO;
        this.pesticideDAO = pesticideDAO;
        this.seedDAO = seedDAO;
    }

    @Override
    @Transactional
    public BillingResDTO generateBill(BillingReqDTO request) {

        // 🔐 Basic validation
        if (request.getGstPercentage() < 0 || request.getGstPercentage() > 28) {
            throw new RuntimeException("Invalid GST percentage");
        }
        if (request.getServiceFee() < 0 || request.getConvenienceFee() < 0) {
            throw new RuntimeException("Invalid fee values");
        }

        // 1️⃣ Create Billing Header
        Billing billing = Billing.builder()
                .billDate(LocalDateTime.now())
                .buyerName(request.getBuyerName())
                .dob(request.getDob())
                .aadharNo(request.getAadharNo())
                .phoneNumber(request.getPhoneNumber())
               // .address(request.getAddress())
                .village(request.getVillage())
                .district(request.getDistrict())
                .build();

        billing = billingDAO.save(billing);

        double subTotal = 0.0;
        List<BillingItemResDTO> itemResponses = new ArrayList<>();

        // 2️⃣ Process each item
        for (BillingItemReqDTO item : request.getItems()) {

            String productName;
            String unit;
            double unitPrice;

            switch (item.getProductType()) {

                case FERTILIZER -> {
                    Fertilizer f = fertilizerDAO.findById(item.getProductId())
                            .orElseThrow(() -> new RuntimeException("Fertilizer not found"));

                    if (f.getTotalStock() < item.getQuantity()) {
                        throw new RuntimeException("Insufficient fertilizer stock");
                    }

                    productName = f.getName();
                    unit = f.getUnit();
                    unitPrice = f.getPrice();
                    f.setTotalStock(f.getTotalStock() - item.getQuantity());
                }

                case PESTICIDE -> {
                    Pesticide p = pesticideDAO.findById(item.getProductId())
                            .orElseThrow(() -> new RuntimeException("Pesticide not found"));

                    if (p.getTotalStock() < item.getQuantity()) {
                        throw new RuntimeException("Insufficient pesticide stock");
                    }

                    productName = p.getName();
                    unit = p.getUnit();
                    unitPrice = p.getPrice();
                    p.setTotalStock(p.getTotalStock() - item.getQuantity());
                }

                case SEED -> {
                    Seed s = seedDAO.findById(item.getProductId())
                            .orElseThrow(() -> new RuntimeException("Seed not found"));

                    if (s.getTotalStock() < item.getQuantity()) {
                        throw new RuntimeException("Insufficient seed stock");
                    }

                    productName = s.getName();
                    unit = s.getUnit();
                    unitPrice = s.getPrice();
                    s.setTotalStock(s.getTotalStock() - item.getQuantity());
                }

                default -> throw new RuntimeException("Invalid product type");
            }

            double totalAmount = unitPrice * item.getQuantity();
            subTotal += totalAmount;

            // 3️⃣ Save Billing Item
            BillingItem billingItem = BillingItem.builder()
                    .billingId(billing.getBillingId())
                    .productType(item.getProductType())
                    .productId(item.getProductId())
                    .productName(productName)
                    .quantity(item.getQuantity())
                    .unit(unit)
                    .unitPrice(unitPrice)
                    .totalAmount(totalAmount)
                    .build();

            billingItemDAO.save(billingItem);

            itemResponses.add(
                    BillingItemResDTO.builder()
                            .productName(productName)
                            .quantity(item.getQuantity())
                            .unit(unit)
                            .unitPrice(unitPrice)
                            .totalAmount(totalAmount)
                            .build()
            );
        }

        // 4️⃣ GST & Fees (Dynamic)
        double gstRate = request.getGstPercentage() / 100.0;
        double cgst = subTotal * (gstRate / 2);
        double sgst = subTotal * (gstRate / 2);

        double serviceFee = request.getServiceFee();
        double convenienceFee = request.getConvenienceFee();

        double grandTotal =
                subTotal + cgst + sgst + serviceFee + convenienceFee;

        // 5️⃣ Update billing totals
        billing.setSubTotal(subTotal);
        billing.setGstPercentage(request.getGstPercentage());
        billing.setCgst(cgst);
        billing.setSgst(sgst);
        billing.setServiceFee(serviceFee);
        billing.setConvenienceFee(convenienceFee);
        billing.setGrandTotal(grandTotal);

        billingDAO.save(billing);

        // 6️⃣ Build response
        return BillingResDTO.builder()
                .billingId(billing.getBillingId())
                .buyerName(billing.getBuyerName())
                .items(itemResponses)
                .subTotal(subTotal)
                .cgst(cgst)
                .sgst(sgst)
                .serviceFee(serviceFee)
                .convenienceFee(convenienceFee)
                .grandTotal(grandTotal)
                .build();
    }
}
