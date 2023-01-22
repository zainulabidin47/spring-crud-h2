package com.zdevs.web.springcrudh2.entity;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int srNo;

    String id;

    String name;

    String email;

    String contactNo;

    String address;

}
