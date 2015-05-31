package com.lelyak.edu.model.enums;

public enum NodeAction {
    START("started"), STOP("stopped");

    private String actionValue;

    private NodeAction(String name) {
        actionValue = name;
    }

    public String getActionValue() {
        return actionValue;
    }

    @Override
    public String toString() {
        return actionValue;
    }

    public NodeAction fromString(String actionName) {
        for (NodeAction nodeAction : NodeAction.values()) {
            if (nodeAction.getActionValue().equalsIgnoreCase(actionName)) {
                return nodeAction;
            }
        }
        throw new IllegalArgumentException("Invalid action name " + actionName + "for ManagementNodeAction");
    }
}
