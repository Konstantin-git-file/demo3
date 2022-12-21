package com.example.demo3.service;

import com.example.demo3.entity.Company;
import com.example.demo3.entity.User;

import java.util.List;
import java.util.Optional;


public interface CompanyService {

    Long saveCompany(Company company);

    Optional<Company> findById(Long id);

    Company findByName (String name);

    List<Company> findAll();

    List<Company> findByUser(User user);

    void deleteCompany(Long id);
}
