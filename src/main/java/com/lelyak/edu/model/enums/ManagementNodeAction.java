package com.lelyak.edu.model.enums;

public enum ManagementNodeAction {
    START("start"), STOP("stop");

    private String actionName;

    private ManagementNodeAction(String name) {
        actionName = name;
    }

    public String getActionName() {
        return actionName;
    }

    @Override
    public String toString() {
        return actionName;
    }

    public ManagementNodeAction fromString(String action) {
        for (ManagementNodeAction nodeAction : ManagementNodeAction.values()) {
            if (nodeAction.getActionName().equals(action)) {
                return nodeAction;
            }
        }
        throw new IllegalArgumentException("Invalid action name " + action + "for ManagementNodeAction");
    }
}
