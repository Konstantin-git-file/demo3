package com.example.demo3.service;


import com.example.demo3.entity.Contract;
import com.example.demo3.entity.User;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo3.repository.ContractRepository;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class ContractService {
    @Autowired
    private ContractRepository contractRepository;
    @Autowired
    private UserService userService;

    public ContractService(ContractRepository contractRepository, UserService userService) {
        this.contractRepository = contractRepository;
        this.userService = userService;
    }

    /**
     * Seeks first supervisor in command tree who will be able to accept the contract.
     * Sets "acceptedBy" field in contract as found supervisor.
     *
     * @param contract
     * @param user     who is not permitted to accept this contract
     * @return true if correct supervisor found
     */
    public boolean sendToSupervisor(Contract contract, User user) {
        User supervisor;
        while (true) {
            log.info("inside the loop");
            supervisor = user.getSupervisor();
            user = supervisor;
            if (supervisor == null) {
                return false;
            }
            log.info(contract.getValue());
            log.info(userService.getMaxContractValue(supervisor));
            if (contract.getValue() <= userService.getMaxContractValue(supervisor)) {
                contract.setAcceptedBy(supervisor);
                this.save(contract);
                return true;
            }
        }
    }

    /**
     * Accepts contract if logged user is permitted to accept it
     *
     * @param contract
     */
    public void acceptContract(Contract contract) {
        User user = new User();
        log.info(user);
        log.info(contract.getAcceptedBy());
        if (contract.getAcceptedBy().equals(user)) {
            contract.setAccepted(true);
            this.save(contract);
        }
    }

    /**
     * Returns contract with given id
     *
     * @param id
     * @return Contract object
     */
    public Optional<Contract> findById(Long id) {
        return contractRepository.findById(id);
    }

    /**
     * Saves given contract to database
     *
     * @param contract
     */
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    /**
     * Returns list of Contracts for given User who is responsible for accepting contract
     *
     * @param user responsible for accepting contract
     * @return list of Contracts
     */
    public List<Contract> findByAcceptedBy(User user) {
        return contractRepository.findByAcceptedBy(user);
    }
}
