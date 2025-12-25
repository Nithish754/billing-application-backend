package com.mrk.demo.service.impl;

import com.mrk.demo.dao.FertilizerDAO;
import com.mrk.demo.dto.request.FertilizerReqDTO;
import com.mrk.demo.dto.response.FertilizerResDTO;
import com.mrk.demo.mapper.FertilizerMapper;
import com.mrk.demo.model.products.Fertilizer;
import com.mrk.demo.service.FertilizerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FertilizerServiceImpl implements FertilizerService {

    private final FertilizerDAO dao;
    private final FertilizerMapper mapper;

    FertilizerServiceImpl(FertilizerDAO dao) {
        this.dao = dao;
        this.mapper = new FertilizerMapper();
    }

    @Override
    public FertilizerResDTO create(FertilizerReqDTO request) {
        Fertilizer fertilizer = mapper.convert(request);
        fertilizer.setTotalStock(request.getNewStockAdded());
        return mapper.convert(dao.save(fertilizer));
    }

    @Override
    public FertilizerResDTO update(Integer id, FertilizerReqDTO request) {
        Fertilizer fertilizer = dao.findById(id)
                .orElseThrow(() -> new RuntimeException("Fertilizer not found"));
        fertilizer.setName(request.getName());
        fertilizer.setManufactureDate(request.getManufactureDate());
        fertilizer.setExpiryDate(request.getExpiryDate());
        fertilizer.setPrice(request.getPrice());
        fertilizer.setQuantity(request.getQuantity());
        fertilizer.setUnit(request.getUnit());
        fertilizer.setTotalStock(
                fertilizer.getTotalStock() + request.getNewStockAdded()
        );

        return mapper.convert(dao.save(fertilizer));
    }

    @Override
    public FertilizerResDTO getById(Integer id) {
        return mapper.convert(
                dao.findById(id)
                        .orElseThrow(() -> new RuntimeException("Fertilizer not found"))
        );
    }

    @Override
    public List<FertilizerResDTO> getAll() {
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
