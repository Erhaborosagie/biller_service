package com.example.beneficiary.controller;

import com.example.beneficiary.model.Beneficiary;
import com.example.beneficiary.service.BeneficiaryService;
import com.example.biller.Biller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Osagie Erhabor on 14/01/2020.
 */

@RestController
@RequestMapping("beneficiaries")
public class BeneficiaryController {

    @Autowired
    private BeneficiaryService beneficiaryService;

    @GetMapping("")
    public List<Beneficiary> getAll(){
        return beneficiaryService.getAllBeneficiary();
    }

    @PostMapping("")
    public Beneficiary createBeneficiary(@RequestBody Beneficiary beneficiary){
        return beneficiaryService.createBeneficiary(beneficiary);
    }

    @GetMapping("/{id}")
    public Beneficiary findBeneficiaryByID(@PathVariable Long id){
        return beneficiaryService.findById(id);
    }

    @PutMapping("/{id}")
    public Beneficiary updateBeneficiary(@RequestBody Beneficiary beneficiary, @PathVariable Long id){
        beneficiary.setId(id);
        return beneficiaryService.updateBeneficiary(beneficiary);
    }


}
