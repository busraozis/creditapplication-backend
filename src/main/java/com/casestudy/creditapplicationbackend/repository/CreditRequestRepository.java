package com.casestudy.creditapplicationbackend.repository;

import com.casestudy.creditapplicationbackend.model.CreditRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreditRequestRepository extends JpaRepository<CreditRequest, Integer> {
}
