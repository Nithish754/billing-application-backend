package com.mrk.demo.mapper;

import com.mrk.demo.dto.request.FertilizerReqDTO;
import com.mrk.demo.dto.response.FertilizerResDTO;
import com.mrk.demo.model.products.Fertilizer;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class FertilizerMapper {

    public  Fertilizer convert(FertilizerReqDTO request) {
        return Fertilizer.builder()
                .name(request.getName())
                .manufactureDate(request.getManufactureDate())
                .expiryDate(request.getExpiryDate())
                .price(request.getPrice())
                .quantity(request.getQuantity())
                .unit(request.getUnit())
                .newStockAdded(request.getNewStockAdded())
                .build();
    }

    public  FertilizerResDTO convert(Fertilizer entity) {
        return FertilizerResDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .manufactureDate(entity.getManufactureDate())
                .expiryDate(entity.getExpiryDate())
                .price(entity.getPrice())
                .quantity(entity.getQuantity())
                .unit(entity.getUnit())
                .totalStock(entity.getTotalStock())
                .build();
    }
}
