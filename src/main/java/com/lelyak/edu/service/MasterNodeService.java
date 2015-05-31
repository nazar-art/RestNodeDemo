package com.lelyak.edu.service;

import com.lelyak.edu.database.DatabaseMockClass;
import com.lelyak.edu.exception.DataNotFoundException;
import com.lelyak.edu.model.MasterNode;
import com.lelyak.edu.model.RuntimeNode;
import com.lelyak.edu.model.enums.NodeAction;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MasterNodeService {

    private Map<Long, MasterNode> masterNodes = DatabaseMockClass.getMasterNodes();

    public List<MasterNode> getAllMasterNodes() {
        return new ArrayList<>(masterNodes.values());
    }

    public MasterNode getMasterNode(long masterNodeId) {
        MasterNode masterNode = masterNodes.get(masterNodeId);
        if (masterNode == null) {
            throw new DataNotFoundException(masterNodeId, "master");
        }
        return masterNode;
    }

    public MasterNode flipNodeActions(MasterNode masterNode) {
        String currStatus = masterNode.getAppStatus();
        if (currStatus.equals(NodeAction.STOP.getActionValue())) {
            masterNode.setAppStatus(NodeAction.START);
            activateRuntimeNodes(masterNode, true);
        } else {
            masterNode.setAppStatus(NodeAction.STOP);
            activateRuntimeNodes(masterNode, false);
        }
        return masterNode;
    }

    private void activateRuntimeNodes(MasterNode masterNode, boolean marker) {
        for (RuntimeNode runtimeNode : masterNode.getRuntimeNodes().values()) {
            if (marker) {
                runtimeNode.setNodeCondition(NodeAction.START);
            } else {
                runtimeNode.setNodeCondition(NodeAction.STOP);
            }
        }
    }
}
