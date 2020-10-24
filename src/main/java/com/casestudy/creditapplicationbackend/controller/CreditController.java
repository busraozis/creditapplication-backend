package com.casestudy.creditapplicationbackend.controller;

import com.casestudy.creditapplicationbackend.model.CreditRequest;
import com.casestudy.creditapplicationbackend.model.Customer;
import com.casestudy.creditapplicationbackend.repository.CreditRequestRepository;
import com.casestudy.creditapplicationbackend.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@RestController
@RequestMapping("/credit")
public class CreditController {

    @Autowired
    private CreditService creditService;

    @PostMapping("/applyForCredit")
    public CreditRequest applyForCredit(@RequestBody Customer customer) {

        return creditService.applyForCredit(customer);
    }
}
