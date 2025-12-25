package com.mrk.demo.service;

import com.mrk.demo.dto.request.FertilizerReqDTO;
import com.mrk.demo.dto.response.FertilizerResDTO;

import java.util.List;

public interface FertilizerService {

    FertilizerResDTO create(FertilizerReqDTO dto);

    FertilizerResDTO update(Integer id, FertilizerReqDTO dto);

    FertilizerResDTO getById(Integer id);

    List<FertilizerResDTO> getAll();

    void delete(Integer id);

}
