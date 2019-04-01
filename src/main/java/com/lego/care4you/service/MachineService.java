package com.lego.care4you.service;

import com.lego.care4you.domain.Machine;
import com.lego.care4you.dto.MachineRequestDTO;
import com.lego.care4you.repository.MachineRepository;
import com.lego.care4you.service.bootstrap.GenericService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MachineService extends GenericService<Machine, MachineRequestDTO> {

    private MachineRepository machineRepository;

    public MachineService(MachineRepository machineRepository) {
        this.machineRepository = machineRepository;
    }

    @Override
    public List<Machine> findAll() {
        return machineRepository.findAll();
    }

    @Override
    public Machine findById(String id) {
        return machineRepository.findOne(id);
    }

    @Override
    public Machine delete(String id) {
        Machine incident = findById(id);
        machineRepository.delete(incident);
        return incident;
    }

    @Override
    public Machine insert(MachineRequestDTO dto) {
        Machine incident = buildCreateMachine(dto);
        incident = machineRepository.save(incident);
        return incident;
    }

    @Override
    public Machine update(String id, MachineRequestDTO dto) {
        Machine incident = findById(id);
        buildUpdateMachine(incident, dto);
        incident = machineRepository.save(incident);
        return incident;
    }

    private Machine buildCreateMachine(MachineRequestDTO dto) {
        Machine incident = new Machine();
        setMachineInformation(dto, incident);

        return incident;
    }

    private void buildUpdateMachine(Machine incident, MachineRequestDTO dto) {
        setMachineInformation(dto, incident);
    }

    private void setMachineInformation(MachineRequestDTO dto, Machine machine) {
        //price
        machine.setName(dto.getName());
        machine.setPrice(dto.getPrice());
        machine.setDescription(dto.getDescription());
        machine.setMark(dto.getMark());
        machine.setModel(dto.getModel());
        machine.setCapacity(dto.getCapacity());
    }
}
