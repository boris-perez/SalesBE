package com.lego.care4you.service;

import com.lego.care4you.domain.Sale;
import com.lego.care4you.dto.SaleRequestDTO;
import com.lego.care4you.repository.CustomerRepository;
import com.lego.care4you.repository.MachineRepository;
import com.lego.care4you.repository.SaleRepository;
import com.lego.care4you.service.bootstrap.GenericService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SaleService extends GenericService<Sale, SaleRequestDTO> {

    private SaleRepository saleRepository;

    private CustomerRepository customerRepository;

    private MachineRepository machineRepository;

    public SaleService(SaleRepository saleRepository, CustomerRepository customerRepository, MachineRepository machineRepository) {
        this.saleRepository = saleRepository;
        this.customerRepository = customerRepository;
        this.machineRepository = machineRepository;
    }

    @Override
    public List<Sale> findAll() {
        return saleRepository.findAll();
    }

    @Override
    public Sale findById(String id) {
        return saleRepository.findOne(id);
    }

    @Override
    public Sale delete(String id) {
        Sale sale = findById(id);
        saleRepository.delete(sale);
        return sale;
    }

    @Override
    public Sale insert(SaleRequestDTO dto) {
        Sale sale = buildCreateSale(dto);
        sale = saleRepository.save(sale);
        return sale;
    }

    @Override
    public Sale update(String id, SaleRequestDTO dto) {
        Sale sale = findById(id);
        buildUpdateSale(sale, dto);
        sale = saleRepository.save(sale);
        return sale;
    }

    private Sale buildCreateSale(SaleRequestDTO dto) {
        Sale sale = new Sale();
        setSaleInformation(dto, sale);

        return sale;
    }

    private void buildUpdateSale(Sale sale, SaleRequestDTO dto) {
        setSaleInformation(dto, sale);
    }

    private void setSaleInformation(SaleRequestDTO dto, Sale sale) {
        sale.setCode(dto.getCode());
        sale.setCustomer(customerRepository.findOne(dto.getCustomerId()));
        sale.setMachine(machineRepository.findOne(dto.getMachineId()));
    }
}
