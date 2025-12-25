package com.mrk.demo.mapper;

import com.mrk.demo.dto.request.SeedReqDTO;
import com.mrk.demo.dto.response.SeedResDTO;
import com.mrk.demo.model.products.Seed;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class SeedMapper {

    public Seed convert(SeedReqDTO request) {
        return Seed.builder()
                .id(request.getId())
                .name(request.getName())
                .manufactureDate(request.getManufactureDate())
                .expiryDate(request.getExpiryDate())
                .price(request.getPrice())
                .quantity(request.getQuantity())
                .unit(request.getUnit())
                .newStockAdded(request.getNewStockAdded())
                .build();
    }

    public SeedResDTO convert(Seed entity) {
        return SeedResDTO.builder()
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

