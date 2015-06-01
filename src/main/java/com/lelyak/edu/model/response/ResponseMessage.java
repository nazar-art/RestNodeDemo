package com.lelyak.edu.model.response;

import com.lelyak.edu.model.MasterNode;
import com.lelyak.edu.model.enums.NodeAction;

public class ResponseMessage {

    private String message;

    public String getMessage() {
        NodeAction action = MasterNode.runtimeNodeAction();
        if (action == NodeAction.STOP) {
            message = "Stopping resources has triggered successfully";
        } else if (action == NodeAction.START) {
            message = "Starting resources has triggered successfully";
        }
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
