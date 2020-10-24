package com.casestudy.creditapplicationbackend.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name="creditrequest")
public class CreditRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="customerid")
    private Integer customerId;
    @Size(max=1)
    @Column(name="result")
    private String result;
    @Column(name="creditlimit")
    private double creditLimit;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }
}
