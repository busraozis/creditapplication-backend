package com.casestudy.creditapplicationbackend.service;

import com.casestudy.creditapplicationbackend.model.CreditRequest;
import com.casestudy.creditapplicationbackend.model.Customer;
import com.casestudy.creditapplicationbackend.repository.CreditRequestRepository;
import com.casestudy.creditapplicationbackend.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class CreditServiceTest {

    @InjectMocks
    CreditService creditService;

    @Mock
    CreditScoreService creditScoreService;

    @Mock
    CreditRequestRepository creditRequestRepository;

    @Mock
    CustomerRepository customerRepository;

    private Customer customer;
    private static final int CREDIT_LIMIT_MULTIPLIER = 4;

    @BeforeEach
    void setup(){
        customer = new Customer();
        customer.setMernis("11111111111");
        customer.setName("Marc");
        customer.setSurname("Federer");
    }

    @Test
    public void approveCreditAndSetLimitIfScoreGreaterThanThousand(){
        customer.setSalary(11000);
        Mockito.when(creditScoreService.getScore(customer.getMernis())).thenReturn(1200);
        CreditRequest actual = creditService.applyForCredit(customer);
        CreditRequest expected = new CreditRequest();
        expected.setCreditLimit(CREDIT_LIMIT_MULTIPLIER * customer.getSalary());
        expected.setResult("T");
        assertEquals(expected.getCreditLimit(),actual.getCreditLimit());
        assertEquals(expected.getResult(),actual.getResult());
    }

    @Test
    public void disapproveCreditRequestIfScoreLessThanFiveHundred(){
        customer.setSalary(1000);
        Mockito.when(creditScoreService.getScore(customer.getMernis())).thenReturn(400);
        CreditRequest actual = creditService.applyForCredit(customer);
        CreditRequest expected = new CreditRequest();
        expected.setCreditLimit(0);
        expected.setResult("F");
        assertEquals(expected.getCreditLimit(),actual.getCreditLimit());
        assertEquals(expected.getResult(),actual.getResult());
    }

    @Test
    public void approveCreditRequestIfScoreBetweenFiveHundredAndThousandIfSalaryLessThanFiveThousand(){
        customer.setSalary(1000);
        Mockito.when(creditScoreService.getScore(customer.getMernis())).thenReturn(700);
        CreditRequest actual = creditService.applyForCredit(customer);
        CreditRequest expected = new CreditRequest();
        expected.setCreditLimit(10000);
        expected.setResult("T");
        assertEquals(expected.getCreditLimit(),actual.getCreditLimit());
        assertEquals(expected.getResult(),actual.getResult());
    }

    @Test
    public void noCreateCreditRequestIfScoreBetweenFiveHundredAndThousandIfSalaryGreaterThanEqualFiveThousand(){
        customer.setSalary(6000);
        Mockito.when(creditScoreService.getScore(customer.getMernis())).thenReturn(700);
        CreditRequest actual = creditService.applyForCredit(customer);
        CreditRequest expected = new CreditRequest();
        expected.setCreditLimit(0);
        expected.setResult(null);
        assertEquals(expected.getCreditLimit(),actual.getCreditLimit());
        assertEquals(expected.getResult(),actual.getResult());
    }
}