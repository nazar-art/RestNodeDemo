package com.lelyak.edu.model.enums;

import org.apache.log4j.Logger;

public enum NodeAction {

    START("start"),
    STOP("stop");

    private static final Logger LOGGER = Logger.getLogger(NodeAction.class);

    private String actionValue;

    private NodeAction(String name) {
        actionValue = name;
    }

    public String getActionValue() {
        return actionValue;
    }

    public static NodeAction fromString(String actionName) {
        LOGGER.info("HERE IS NODE ACTION: " + actionName);
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
