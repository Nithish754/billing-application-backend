package com.mrk.demo.controller;


import com.mrk.demo.constant.EndpointConstant;
import com.mrk.demo.dto.request.SeedReqDTO;
import com.mrk.demo.dto.response.SeedResDTO;
import com.mrk.demo.service.SeedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = EndpointConstant.BASE_URL, produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class SeedController {

    private final SeedService service;

    @PostMapping(EndpointConstant.SEED)
    public SeedResDTO create(@RequestBody SeedReqDTO dto) {
        return service.create(dto);
    }

    @PutMapping(EndpointConstant.UPDATE_SEED)
    public SeedResDTO update(
            @PathVariable Integer id,
            @RequestBody SeedReqDTO dto
    ) {
        return service.update(id, dto);
    }

    @GetMapping(EndpointConstant.GET_SEED_BY_ID)
    public SeedResDTO getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @GetMapping(EndpointConstant.GET_ALL_SEEDS)
    public List<SeedResDTO> getAll() {
        return service.getAll();
    }

    @DeleteMapping(EndpointConstant.DELETE_SEED)
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
