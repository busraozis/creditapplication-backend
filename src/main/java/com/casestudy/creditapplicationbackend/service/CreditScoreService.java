package com.casestudy.creditapplicationbackend.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class CreditScoreService {

    public int getScore(String mernis){
        Random random = new Random();
        return random.nextInt(1500);
    }
}
