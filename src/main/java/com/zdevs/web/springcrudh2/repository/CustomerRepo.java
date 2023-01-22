package com.zdevs.web.springcrudh2.repository;

import com.zdevs.web.springcrudh2.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {
}
