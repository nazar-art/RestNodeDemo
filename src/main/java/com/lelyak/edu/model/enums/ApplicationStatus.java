package com.lelyak.edu.model.enums;

public enum ApplicationStatus {

    STARTED("started"),
    STOPPED("stopped");

    private String actionValue;

    private ApplicationStatus(String name) {
        actionValue = name;
    }

    public String getActionValue() {
        return actionValue;
    }

    public static ApplicationStatus fromString(String statusName) {
        for (ApplicationStatus applicationStatus : ApplicationStatus.values()) {
            if (applicationStatus.getActionValue().equalsIgnoreCase(statusName)) {
                return applicationStatus;
            }
        }
        throw new IllegalArgumentException("Invalid app status name " + statusName);
    }

    @Override
    public String toString() {
        return actionValue;
    }
}
