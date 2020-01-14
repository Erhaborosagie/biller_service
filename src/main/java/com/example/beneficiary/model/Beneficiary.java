package com.example.beneficiary.model;

import com.example.beneficiary.enums.BeneficiaryType;
import com.example.util.enums.EnabledStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * Created by Upperlink Digital PC on 14/01/2020.
 */
@Getter
@Setter
@Entity
@Table(name = "beneficiaries", uniqueConstraints = @UniqueConstraint(columnNames =
        {"account_provider_id", "accountNumber", "name"}))
public class Beneficiary {
    public Beneficiary() {
        super();
    }

//    public Beneficiary(@NotNull String name, @NotNull String accountNumber,
//                       @NotNull String email, @NotNull BeneficiaryType type) {
//        super();
//        this.name = name;
//        this.accountNumber = accountNumber;
//        this.email = email;
//        this.type = type;
//    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(length = 100)
    private String name;

    @NotNull
    @Column(length = 20)
    private String accountNumber;

    @NotNull
    @Column(unique = true, length = 100)
    private String email;

    @NotNull
    private EnabledStatus enabled = EnabledStatus.ENABLED;

    @NotNull
    private BeneficiaryType type = BeneficiaryType.REGULAR;

    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();
}
