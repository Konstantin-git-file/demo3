package com.example.demo3.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @NotBlank
    String fullName;

    public enum Status {
        NEW, EXISTS
    }

    @OneToOne
    Address mainAddress;

    @Pattern(regexp = "^(\\d{3}[- .]?){2}\\d{4}$")
    String phone;

}