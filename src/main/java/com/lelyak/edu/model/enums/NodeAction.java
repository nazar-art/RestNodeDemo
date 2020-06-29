package com.lelyak.edu.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public enum NodeAction {

    START("start"),
    STOP("stop");

    private final String actionValue;

    public static NodeAction fromString(String actionName) {
        for (NodeAction nodeAction : NodeAction.values()) {
            if (nodeAction.getActionValue().equalsIgnoreCase(actionName)) {
                return nodeAction;
            }
        }
        throw new IllegalArgumentException("Invalid node action: " + actionName);
    }

//    @Override
//    public String toString() {
//        return actionValue;
//    }

}
