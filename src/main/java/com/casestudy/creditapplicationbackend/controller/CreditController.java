package com.casestudy.creditapplicationbackend.controller;

import com.casestudy.creditapplicationbackend.model.CreditRequest;
import com.casestudy.creditapplicationbackend.repository.CreditRequestRepository;
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
    private CreditRequestRepository creditRequestRepository;

    @GetMapping("/creditRequests")
    public List<CreditRequest> findAllRequests() {

        List<CreditRequest> creditRequests = creditRequestRepository.findAll();
        return creditRequests;
    }
}
