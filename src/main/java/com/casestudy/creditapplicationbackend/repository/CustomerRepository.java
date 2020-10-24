package com.casestudy.creditapplicationbackend.repository;

import com.casestudy.creditapplicationbackend.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
