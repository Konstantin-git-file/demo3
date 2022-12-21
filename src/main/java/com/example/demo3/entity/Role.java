package com.example.demo3.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    Long id;

    @NotBlank
    @Column(unique = true)
    String name;

    Double maxContractValue;

}