package com.example.demo3.repository;

import com.example.demo3.entity.Contract;
import com.example.demo3.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Long> {
    List<Contract> findByAcceptedBy(User user);
}