package com.lelyak.edu.model.response;

import com.lelyak.edu.model.enums.NodeAction;

public class ActionResponse {
    private NodeAction action;
    private int status;
    private ResponseMessage response;

    public class ResponseMessage {
        private String message;

        public String getMessage() {
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

    public NodeAction getAction() {
        return action;
    }

    public void setAction(NodeAction action) {
        this.action = action;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public ResponseMessage getResponse() {
        return response;
    }

    public void setResponse(ResponseMessage response) {
        this.response = response;
    }
}
