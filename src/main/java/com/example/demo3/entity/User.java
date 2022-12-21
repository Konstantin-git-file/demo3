package com.example.demo3.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;


@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @NotBlank
    @Column(unique = true)
    String email;

    @NotBlank
    String password;

    @NotBlank
    @Size(min = 3, max = 10)
    String firstname;

    @NotBlank
    @Size(min = 3, max = 10)
    String lastname;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinTable
    Set <Role> roles;

    @Pattern(regexp = "^(\\d{3}[- .]?){2}\\d{4}$")
    String phone;

    @ManyToOne
    @JoinColumn(name = "supervisor_id")
    User supervisor;

    public String getName() {
        return getFirstname() +" "+ getLastname();
    }

}
