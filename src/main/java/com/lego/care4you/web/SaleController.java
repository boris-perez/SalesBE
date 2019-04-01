package com.lego.care4you.web;

import com.lego.care4you.domain.Sale;
import com.lego.care4you.dto.SaleRequestDTO;
import com.lego.care4you.service.SaleService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/sales")
@Api(value = "sales", description = "Operations over sales")
public class SaleController {

    private SaleService saleService;

    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Sale> findAll() {
        return saleService.findAll();
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET)
    public Sale findById(@PathVariable String id) {
        return saleService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Sale insert(@RequestBody SaleRequestDTO dto) {
        return saleService.insert(dto);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE)
    public Sale delete(@PathVariable String id) {
        return saleService.delete(id);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.PUT)
    public Sale update(@PathVariable String id, @RequestBody SaleRequestDTO dto) {
        return saleService.update(id, dto);
    }
}
