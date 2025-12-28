package com.mrk.demo.mapper;

import com.mrk.demo.dto.request.PesticideReqDTO;
import com.mrk.demo.dto.response.PesticideResDTO;
import com.mrk.demo.model.products.Pesticide;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PesticideMapper {

    public Pesticide convert(PesticideReqDTO request) {
        return Pesticide.builder()
                .name(request.getName())
                .manufactureDate(request.getManufactureDate())
                .expiryDate(request.getExpiryDate())
                .price(request.getPrice())
                .quantity(request.getQuantity())
                .unit(request.getUnit())
                .newStockAdded(request.getNewStockAdded())
                .build();
    }

    public PesticideResDTO convert(Pesticide entity) {
        return PesticideResDTO.builder()
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

