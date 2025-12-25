package com.mrk.demo.controller;

import com.mrk.demo.constant.EndpointConstant;
import com.mrk.demo.dto.request.FertilizerReqDTO;
import com.mrk.demo.dto.response.FertilizerResDTO;
import com.mrk.demo.service.FertilizerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = EndpointConstant.BASE_URL, produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class FertilizerController {

    private final FertilizerService service;

    @PostMapping(EndpointConstant.FERTILIZER)
    public FertilizerResDTO create(@RequestBody FertilizerReqDTO dto) {
        return service.create(dto);
    }

    @PutMapping(EndpointConstant.UPDATE_FERTILIZER)
    public FertilizerResDTO update(@PathVariable Integer id, @RequestBody FertilizerReqDTO dto) {
        return service.update(id, dto);
    }

    @GetMapping(EndpointConstant.GET_FERTILIZER_BY_ID)
    public FertilizerResDTO getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @GetMapping(EndpointConstant.GET_ALL_FERTILIZERS)
    public List<FertilizerResDTO> getAll() {
        return service.getAll();
    }

    @DeleteMapping(EndpointConstant.DELETE_FERTILIZER)
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}


