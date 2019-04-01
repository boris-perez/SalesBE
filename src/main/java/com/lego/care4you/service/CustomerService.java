package com.lego.care4you.service;

import com.lego.care4you.domain.Customer;
import com.lego.care4you.dto.CustomerRequestDTO;
import com.lego.care4you.repository.CustomerRepository;
import com.lego.care4you.service.bootstrap.GenericService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerService extends GenericService<Customer, CustomerRequestDTO> {

    private CustomerRepository employeeRepository;

    public CustomerService(CustomerRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Customer> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Customer findById(String id) {
        return employeeRepository.findOne(id);
    }

    @Override
    public Customer delete(String id) {
        Customer customer = findById(id);

        employeeRepository.delete(customer);

        return customer;
    }

    @Override
    public Customer insert(CustomerRequestDTO dto) {
        Customer customer = buildCreateCustomer(dto);

        employeeRepository.save(customer);

        return customer;
    }

    @Override
    public Customer update(String id, CustomerRequestDTO dto) {
        Customer customer = findById(id);

        buildUpdateCustomer(customer, dto);
        employeeRepository.save(customer);

        return customer;
    }

    private Customer buildCreateCustomer(CustomerRequestDTO dto) {
        Customer customer = new Customer();

        setCustomerInformation(dto, customer);

        return customer;
    }

    private void buildUpdateCustomer(Customer customer, CustomerRequestDTO dto) {

        setCustomerInformation(dto, customer);
    }

    private static void setCustomerInformation(CustomerRequestDTO dto, Customer customer) {
        customer.setFirstName(dto.getFirstName());
        customer.setLastName(dto.getLastName());
        customer.setAddress(dto.getAddress());
        customer.setEmail(dto.getEmail());
        customer.setPhone(dto.getPhone());
        customer.setComment(dto.getComment());
    }
}
