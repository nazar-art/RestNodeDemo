package com.lelyak.edu.model.enums;

import com.lelyak.edu.utils.logger.Logger;

public enum NodeAction {

    START("start"),
    STOP("stop");

    private String actionValue;

    private NodeAction(String name) {
        actionValue = name;
    }

    public String getActionValue() {
        return actionValue;
    }

    public static NodeAction fromString(String actionName) {
        Logger.operation("HERE IS NODE ACTION INITIALIZATION: " + actionName);

        for (NodeAction nodeAction : NodeAction.values()) {
            if (nodeAction.getActionValue().equalsIgnoreCase(actionName)) {
                return nodeAction;
            }
        }
        throw new IllegalArgumentException("Invalid node action: " + actionName);
    }

    @Override
    public String toString() {
        return actionValue;
    }

}
