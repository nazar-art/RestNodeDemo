package com.lelyak.edu.model.response;

import com.lelyak.edu.model.MasterNode;
import com.lelyak.edu.model.RuntimeNode;
import com.lelyak.edu.model.enums.NodeAction;

import java.util.Collection;

public class ActionResponse {
    private String action;
    // todo how to take response code from response
    private int status;
    private ResponseMessage response;

    public ActionResponse() {
        action = getRuntimeNodeAction();
        response = new ResponseMessage();
    }

    private String getRuntimeNodeAction() {
        Collection<RuntimeNode> runtimeNodes = MasterNode.getRuntimeNodes().values();
        NodeAction nodeAction = MasterNode.runtimeNodeAction();
        return nodeAction.getActionValue();
    }

    public String getAction() {
        return getRuntimeNodeAction();
    }

    public void setAction(String action) {
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
