package com.lego.care4you.web;

import com.lego.care4you.domain.Machine;
import com.lego.care4you.dto.MachineRequestDTO;
import com.lego.care4you.service.MachineService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api(value = "machines", description = "Operations over machines")
@RestController
@RequestMapping("/machines")
public class MachineController {

    private MachineService machineService;

    public MachineController(MachineService machineService) {
        this.machineService = machineService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Machine> findAll() {
        return machineService.findAll();
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET)
    public Machine findById(@PathVariable String id) {
        return machineService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Machine insert(@RequestBody MachineRequestDTO dto) {
        return machineService.insert(dto);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE)
    public Machine delete(@PathVariable String id) {
        return machineService.delete(id);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.PUT)
    public Machine update(@PathVariable String id, @RequestBody MachineRequestDTO dto) {
        return machineService.update(id, dto);
    }
}
