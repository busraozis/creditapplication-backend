package com.casestudy.creditapplicationbackend.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name="customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Size(min=11,max=11)
    @Column(name="mernis")
    private String mernis;

    @Size(max=75)
    @Column(name="name")
    private String name;

    @Size(max=75)
    @Column(name="surname")
    private String surname;

    @Column(name="salary")
    private double salary;

    @Size(max=10)
    @Column(name="phonenumtext")
    private String phoneNumText;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMernis() {
        return mernis;
    }

    public void setMernis(String mernis) {
        this.mernis = mernis;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPhoneNumText() {
        return phoneNumText;
    }

    public void setPhoneNumText(String phoneNumText) {
        this.phoneNumText = phoneNumText;
    }
}
