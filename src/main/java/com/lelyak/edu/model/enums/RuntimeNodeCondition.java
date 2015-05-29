package com.lelyak.edu.model.enums;

public enum RuntimeNodeCondition {
    STARTED("started"), STOPPPED("stoppped");

    private String state;

    private RuntimeNodeCondition(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public RuntimeNodeCondition fromString(String name) {
        for (RuntimeNodeCondition nodeCondition : RuntimeNodeCondition.values()) {
            if (nodeCondition.getState().equals(name)) {
                return nodeCondition;
            }
        }
        throw new IllegalArgumentException("Illegal argument " + name + " for RuntimeNodeCondition");
    }

    @Override
    public String toString() {
        return "RuntimeNodeCondition{" +
                "state='" + state + '\'' +
                '}';
    }
}
