package com.lelyak.edu.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public enum ApplicationStatus {

    STARTED("started"),
    STOPPED("stopped");

    private final String actionValue;

    public static ApplicationStatus fromString(String statusName) {
        for (ApplicationStatus applicationStatus : ApplicationStatus.values()) {
            if (applicationStatus.getActionValue().equalsIgnoreCase(statusName)) {
                return applicationStatus;
            }
        }
        throw new IllegalArgumentException("Invalid app status name " + statusName);
    }

//    @Override
//    public String toString() {
//        return actionValue;
//    }
}
