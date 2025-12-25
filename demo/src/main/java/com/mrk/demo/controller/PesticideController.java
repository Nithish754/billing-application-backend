package com.mrk.demo.controller;

import com.mrk.demo.constant.EndpointConstant;
import com.mrk.demo.dto.request.PesticideReqDTO;
import com.mrk.demo.dto.response.PesticideResDTO;
import com.mrk.demo.service.PesticideService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.lang.Integer;
import java.util.List;

@RestController
@RequestMapping(value = EndpointConstant.BASE_URL, produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class PesticideController {

    private final PesticideService service;

    @PostMapping(EndpointConstant.PESTICIDE)
    public PesticideResDTO create(@RequestBody PesticideReqDTO dto) {
        return service.create(dto);
    }

    @PutMapping(EndpointConstant.UPDATE_PESTICIDE)
    public PesticideResDTO update(@PathVariable Integer id, @RequestBody PesticideReqDTO dto) {
        return service.update(id, dto);
    }

    @GetMapping(EndpointConstant.GET_PESTICIDE_BY_ID)
    public PesticideResDTO getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @GetMapping(EndpointConstant.GET_ALL_PESTICIDES)
    public List<PesticideResDTO> getAll() {
        return service.getAll();
    }

    @DeleteMapping(EndpointConstant.DELETE_PESTICIDE)
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
