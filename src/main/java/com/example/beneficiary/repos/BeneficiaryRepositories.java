package com.example.beneficiary.repos;

import com.example.beneficiary.model.Beneficiary;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Upperlink Digital PC on 14/01/2020.
 */
public interface BeneficiaryRepositories extends JpaRepository<Beneficiary, Long> {
}
