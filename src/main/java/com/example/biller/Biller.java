package com.example.biller;

import com.example.util.enums.EnabledStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * Created by Osagie Erhabor on 14/01/2020.
 */
@Getter
@Setter
@Entity
@Table(name = "billers")
public class Biller {

    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    @Column(length = 100)
    private String name;

    @NotNull
    @Column(length = 100)
    private String email;

    @NotNull
    @Column(length = 50)
    private String slug;

    @NotNull
    private EnabledStatus enabledStatus = EnabledStatus.DISABLED;

    @NotNull
    private LocalDateTime createdAt = LocalDateTime.now();

    @NotNull
    private LocalDateTime updatedAt = LocalDateTime.now();


}
