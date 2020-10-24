package com.casestudy.creditapplicationbackend.service;

import com.casestudy.creditapplicationbackend.model.CreditRequest;
import com.casestudy.creditapplicationbackend.model.Customer;
import com.casestudy.creditapplicationbackend.repository.CreditRequestRepository;
import com.casestudy.creditapplicationbackend.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CreditService {

    @Autowired
    CreditRequestRepository creditRequestRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CreditScoreService creditScoreService;

    private static final int CREDIT_LIMIT_MULTIPLIER = 4;

    public CreditRequest applyForCredit(Customer customer){

        //if customer does not exist, create customer..
        Customer customer1 = customerRepository.findCustomerByMernis(customer.getMernis());
        if(customer1 == null){
            customer1 = new Customer();
            customer1.setMernis(customer.getMernis());
            customer1.setName(customer.getName());
            customer1.setSurname(customer.getSurname());
            customer1.setPhoneNumText(customer.getPhoneNumText());
            customer1.setSalary(customer.getSalary());
            customerRepository.save(customer1);
        }

        //get credit score
        String mernis = customer.getMernis();
        int score = creditScoreService.getScore(mernis);

        CreditRequest creditRequest = new CreditRequest();
        creditRequest.setCustomerId(customer1.getId());
        if(score < 500){
            creditRequest.setResult("F");
        }else if(score >= 500 && score < 1000){
            if(customer.getSalary() < 5000){
                creditRequest.setResult("T");
                creditRequest.setCreditLimit(1000);
            }
        }else if(score >= 1000){
            creditRequest.setResult("T");
            creditRequest.setCreditLimit(customer.getSalary() * CREDIT_LIMIT_MULTIPLIER);
        }

        sendSms(customer.getPhoneNumText());
        creditRequestRepository.save(creditRequest);

        return creditRequest;
    }

    private void sendSms(String phoneNumText){
        System.out.println("Your application has been taken.");
    }


}
