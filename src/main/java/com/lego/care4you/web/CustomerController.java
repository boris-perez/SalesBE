package com.lego.care4you.web;

import com.lego.care4you.domain.Customer;
import com.lego.care4you.dto.CustomerRequestDTO;
import com.lego.care4you.service.CustomerService;
import com.lego.care4you.service.SenderEmailService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/customer")
@Api(value = "customer", description = "Operations over customers")
public class CustomerController {

    private CustomerService customerService;

    private SenderEmailService senderEmailService;

    public CustomerController(CustomerService customerService, SenderEmailService senderEmailService) {
        this.customerService = customerService;
        this.senderEmailService = senderEmailService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Customer> findAll() {
        return customerService.findAll();
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET)
    public Customer findById(@PathVariable String id) {
        return customerService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Customer insert(@RequestBody CustomerRequestDTO dto) {
        Customer customer = customerService.insert(dto);
        senderEmailService.sendEmail(customer);
        return customer;
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE)
    public Customer delete(@PathVariable String id) {
        return customerService.delete(id);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.PUT)
    public Customer update(@PathVariable String id, @RequestBody CustomerRequestDTO dto) {
        return customerService.update(id, dto);
    }
}
