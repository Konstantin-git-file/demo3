package com.example.demo3.service;

import com.example.demo3.entity.Company;
import com.example.demo3.entity.User;
import org.springframework.stereotype.Service;
import com.example.demo3.repository.AddressRepository;
import com.example.demo3.repository.CompanyRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService{

    private final CompanyRepository companyRepository;
    private final AddressRepository addressRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository, AddressRepository addressRepository) {
        this.companyRepository = companyRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public Optional<Company> findById(Long id) {
        return companyRepository.findById(id);
    }

    @Override
    public Company findByName(String name) {
        return null;
    }
    @Override
    public Long saveCompany(Company company) {
        companyRepository.save(company);
        return company.getId();
    }

    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public List<Company> findByUser(User user) {
        return null;
    }

    @Override
    public void deleteCompany(Long id) {
        companyRepository.deleteById(id);

    }
}
