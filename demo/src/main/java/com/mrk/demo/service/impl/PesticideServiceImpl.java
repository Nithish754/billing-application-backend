package com.mrk.demo.service.impl;

import com.mrk.demo.dao.PesticideDAO;
import com.mrk.demo.dto.request.PesticideReqDTO;
import com.mrk.demo.dto.response.PesticideResDTO;
import com.mrk.demo.mapper.PesticideMapper;
import com.mrk.demo.model.products.Pesticide;
import com.mrk.demo.service.PesticideService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PesticideServiceImpl implements PesticideService {

    private final PesticideDAO dao;
    private final PesticideMapper mapper;

    public PesticideServiceImpl(PesticideDAO dao) {
        this.dao = dao;
        this.mapper = new PesticideMapper();
    }

    @Override
    public PesticideResDTO create(PesticideReqDTO dto) {
        Pesticide entity = mapper.convert(dto);
        entity.setTotalStock(dto.getNewStockAdded());
        return mapper.convert(dao.save(entity));
    }

    @Override
    public PesticideResDTO update(Integer id, PesticideReqDTO dto) {
        Pesticide entity = dao.findById(id)
                .orElseThrow(() -> new RuntimeException("Pesticide not found"));

        entity.setName(dto.getName());
        entity.setManufactureDate(dto.getManufactureDate());
        entity.setExpiryDate(dto.getExpiryDate());
        entity.setPrice(dto.getPrice());
        entity.setQuantity(dto.getQuantity());
        entity.setUnit(dto.getUnit());
        entity.setTotalStock(entity.getTotalStock() + dto.getNewStockAdded());

        return mapper.convert(dao.save(entity));
    }

    @Override
    public PesticideResDTO getById(Integer id) {
        return mapper.convert(
                dao.findById(id).orElseThrow(() -> new RuntimeException("Pesticide not found"))
        );
    }

    @Override
    public List<PesticideResDTO> getAll() {
        return dao.findAll().stream().map(mapper::convert).toList();
    }

    @Override
    public void delete(Integer id) {
        dao.deleteById(id);
    }
}
