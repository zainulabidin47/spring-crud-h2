package com.zdevs.web.springcrudh2.service;

import com.zdevs.web.springcrudh2.entity.Customer;
import com.zdevs.web.springcrudh2.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CustomerService {
    CustomerRepo customerRepo;

    @Autowired
    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }


    public List<Customer> getAllCustomers(){
        return customerRepo.findAll();
    }

    public Customer saveCustomer(Customer customer){
        return customerRepo.save(customer);
    }

    public void deleteCustomer(@PathVariable("id") int srNo){
        customerRepo.deleteById(srNo);
    }

    public Optional<Customer> updateCustomer(Customer customer, int srNo) {
        Optional<Customer> customerOptional = customerRepo.findById(srNo);

        if (customerOptional.isPresent()) {
            Customer customerDb=customerOptional.get();
            if (Objects.nonNull(customer.getId()) && !"".equalsIgnoreCase(customer.getId())) {
                customerDb.setId(customer.getId());
            }
            if (Objects.nonNull(customer.getName()) && !"".equalsIgnoreCase(customer.getName())) {
                customerDb.setName(customer.getName());
            }
            if (Objects.nonNull(customer.getEmail()) && !"".equalsIgnoreCase(customer.getEmail())) {
                customerDb.setEmail(customer.getEmail());
            }
            if (Objects.nonNull(customer.getAddress()) && !"".equalsIgnoreCase(customer.getAddress())) {
                customerDb.setAddress(customer.getAddress());
            }
            if (Objects.nonNull(customer.getContactNo()) && !"".equalsIgnoreCase(customer.getContactNo())) {
                customerDb.setContactNo(customer.getContactNo());
            }

            return Optional.of(customerRepo.save(customer));
        }

        return Optional.empty();
    }
}
