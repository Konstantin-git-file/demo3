package com.example.demo3.service;

import com.example.demo3.entity.Address;
import org.springframework.stereotype.Service;
import com.example.demo3.repository.AddressRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<String> getCitiesList() {
        var addresses = addressRepository.findAll();
        List<String> cityList = addresses.stream()
                .map(Address::getCity)
                .distinct()
                .collect(Collectors.toList());

        return cityList;
    }

}