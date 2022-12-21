package com.example.demo3.repository;

import com.example.demo3.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    Company findByNameIgnoreCase(String name);

}