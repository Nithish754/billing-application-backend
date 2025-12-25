package com.mrk.demo.service;

import com.mrk.demo.dto.request.PesticideReqDTO;
import com.mrk.demo.dto.response.PesticideResDTO;

import java.lang.Integer;
import java.util.List;

public interface PesticideService {

    PesticideResDTO create(PesticideReqDTO dto);

    PesticideResDTO update(Integer id, PesticideReqDTO dto);

    PesticideResDTO getById(Integer id);

    List<PesticideResDTO> getAll();

    void delete(Integer id);
}

