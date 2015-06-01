package com.lelyak.edu.service;

import com.lelyak.edu.database.DatabaseMockClass;
import com.lelyak.edu.exception.DataNotFoundException;
import com.lelyak.edu.model.MasterNode;
import com.lelyak.edu.model.RuntimeNode;
import com.lelyak.edu.model.enums.ApplicationStatus;
import com.lelyak.edu.model.enums.NodeAction;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MasterNodeService {

    private final static Logger logger = Logger.getLogger(MasterNodeService.class);
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

    public MasterNode flipNodeActions(MasterNode masterNode, NodeAction action) {
        String currNodeAction = masterNode.getAppStatus();

        if (currNodeAction.equalsIgnoreCase(action.getActionValue())) {
            return masterNode;
        }

        switch (action) {
            case START:
                masterNode.setAppStatus(ApplicationStatus.STOPPED);
                activateRuntimeNodes(masterNode, true);
                break;
            case STOP:
                masterNode.setAppStatus(ApplicationStatus.STARTED);
                activateRuntimeNodes(masterNode, false);
                break;
            default:
                throw new RuntimeException("Request node action has incorrect data: " + action);
        }

        /*if (currNodeAction.equals(NodeAction.STOPPED.getActionValue())) {
            masterNode.setAppStatus(NodeAction.STARTED);
            activateRuntimeNodes(masterNode, true);
        } else {
            masterNode.setAppStatus(NodeAction.STOPPED);
            activateRuntimeNodes(masterNode, false);
        }*/
        return masterNode;
    }

    private void activateRuntimeNodes(MasterNode masterNode, boolean marker) {
//        logger.info("Here is master node state: " + masterNode.getAppStatus());
        for (RuntimeNode runtimeNode : masterNode.getRuntimeNodes().values()) {
//            logger.info("Here is runtime node state: " + runtimeNode.getAction());
            if (marker) {
                runtimeNode.setAction(NodeAction.START);
//                logger.info("Node state changed to: " + NodeAction.START);
            } else {
                runtimeNode.setAction(NodeAction.STOP);
//                logger.info("Node state changed to: " + NodeAction.STOP);
            }
        }
    }
}
