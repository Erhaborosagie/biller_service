package com.example.beneficiary.enums;

/**
 * Created by Osagie Erhabor on 14/01/2020.
 */
public enum BeneficiaryType {
    GLOBAL(0),
    REGULAR(1),
    VAT(2);

    Integer value;

    BeneficiaryType(Integer value) {
        this.value = value;
    }
}
