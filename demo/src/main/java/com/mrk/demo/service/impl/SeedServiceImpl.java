package com.mrk.demo.service.impl;

import com.mrk.demo.dao.SeedDAO;
import com.mrk.demo.dto.request.SeedReqDTO;
import com.mrk.demo.dto.response.SeedResDTO;
import com.mrk.demo.mapper.SeedMapper;
import com.mrk.demo.model.products.Seed;
import com.mrk.demo.service.SeedService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeedServiceImpl implements SeedService {

    private final SeedDAO dao;
    private final SeedMapper mapper;

    SeedServiceImpl(SeedDAO dao) {
        this.dao = dao;
        this.mapper = new SeedMapper();
    }

    @Override
    public SeedResDTO create(SeedReqDTO dto) {
        Seed entity = mapper.convert(dto);
        entity.setTotalStock(dto.getNewStockAdded());
        return mapper.convert(dao.save(entity));
    }

    @Override
    public SeedResDTO update(Integer id, SeedReqDTO dto) {
        Seed entity = dao.findById(id)
                .orElseThrow(() -> new RuntimeException("Seed not found"));

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
    public SeedResDTO getById(Integer id) {
        return mapper.convert(
                dao.findById(id)
                        .orElseThrow(() -> new RuntimeException("Seed not found"))
        );
    }

    @Override
    public List<SeedResDTO> getAll() {
        return dao.findAll()
                .stream()
                .map(mapper::convert)
                .toList();
    }

    @Override
    public void delete(Integer id) {
        dao.deleteById(id);
    }
}

