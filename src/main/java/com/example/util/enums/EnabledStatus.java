package com.example.util.enums;

/**
 * Created by Osagie Erhabor on 14/01/2020.
 */
public enum EnabledStatus {
    DISABLED(0),
    ENABLED(1),
    PENDING_ENABLED(2),
    PENDING_DISABLED(3),
    BACK_OFFICE_DISABLED(4);

    Integer value;
    EnabledStatus(Integer value){this.value = value;}
}
