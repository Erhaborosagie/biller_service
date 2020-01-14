package com.example.beneficiary.service;

import com.example.beneficiary.model.Beneficiary;
import com.example.biller.Biller;

import java.util.List;

/**
 * Created by Upperlink Digital PC on 14/01/2020.
 */
public interface BeneficiaryService {
    Beneficiary createBeneficiary(Beneficiary beneficiary);

    List<Beneficiary> getAllBeneficiary();

    Beneficiary findById(Long id);

    List<Biller> findBillersByBeneficiaryId(Long id);

    Beneficiary updateBeneficiary(Beneficiary beneficiary);


}
