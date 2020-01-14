package com.example.beneficiary.service.impl;

import com.example.beneficiary.model.Beneficiary;
import com.example.beneficiary.repos.BeneficiaryRepositories;
import com.example.beneficiary.service.BeneficiaryService;
import com.example.biller.Biller;
import com.example.util.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by Osagie Erhabor on 14/01/2020.
 */
@Service
public class BeneficiaryServiceImpl implements BeneficiaryService{
    @Autowired
    private BeneficiaryRepositories beneficiaryRepositories;

    @Override
    public Beneficiary createBeneficiary(Beneficiary beneficiary) {
        beneficiaryRepositories.save(beneficiary);
        return beneficiary;
    }

    @Override
    public List<Beneficiary> getAllBeneficiary() {
        return beneficiaryRepositories.findAll();
    }

    @Override
    public Beneficiary findById(Long id) {
        Optional<Beneficiary> beneficiary = beneficiaryRepositories.findById(id);
        if(beneficiary.isPresent()){
            return beneficiary.get();
        }
        throw new ResourceNotFoundException("No Beneficiary with ID " + id);
    }

    @Override
    public List<Biller> findBillersByBeneficiaryId(Long id) {
        return null;
    }

    @Override
    public Beneficiary updateBeneficiary(Beneficiary beneficiary) {
        Optional<Beneficiary> beneficiaryDb = beneficiaryRepositories.findById(beneficiary.getId());
        if(beneficiaryDb.isPresent()){
            Beneficiary beneficiaryUpdate = beneficiaryDb.get();
            beneficiaryUpdate.setId(beneficiary.getId());
            beneficiaryUpdate.setAccountNumber(beneficiary.getAccountNumber());
            beneficiaryUpdate.setEmail(beneficiary.getEmail());
            beneficiaryUpdate.setName(beneficiary.getName());
            beneficiaryRepositories.save(beneficiaryUpdate);
            return beneficiaryUpdate;
        }
        throw new ResourceNotFoundException("No Beneficiary with ID " + beneficiary.getId());
    }
}
