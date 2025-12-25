package com.mrk.demo.service;

import com.mrk.demo.dto.request.SeedReqDTO;
import com.mrk.demo.dto.response.SeedResDTO;

import java.util.List;

public interface SeedService {

    SeedResDTO create(SeedReqDTO dto);

    SeedResDTO update(Integer id, SeedReqDTO dto);

    SeedResDTO getById(Integer id);

    List<SeedResDTO> getAll();

    void delete(Integer id);
}
