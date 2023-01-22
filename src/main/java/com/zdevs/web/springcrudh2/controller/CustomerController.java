package com.zdevs.web.springcrudh2.controller;

import com.zdevs.web.springcrudh2.entity.Customer;
import com.zdevs.web.springcrudh2.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/api")
public class CustomerController {

    CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/")
    ResponseEntity<List<Customer>> getAllCustomers(){
        List<Customer> customers = customerService.getAllCustomers();
        List<Customer> empty = new ArrayList<>();
        if(customers.get(0).getName().equals("Zain")) {
            return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(empty, HttpStatus.BAD_REQUEST);
        }
    }
}
