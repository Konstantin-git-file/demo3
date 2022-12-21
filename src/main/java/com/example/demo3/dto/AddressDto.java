package com.example.demo3.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class AddressDto implements Serializable {
    private final Long id;
    private final String country;
    private final String city;
}
