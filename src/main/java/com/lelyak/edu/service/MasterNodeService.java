package com.lelyak.edu.service;

import com.lelyak.edu.database.DatabaseMockClass;
import com.lelyak.edu.exception.DataNotFoundException;
import com.lelyak.edu.model.MasterNode;
import com.lelyak.edu.model.RuntimeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MasterNodeService {

    public static final int RUNTIME_NODE_COUNT = 32;

    private MasterNode masterNode = DatabaseMockClass.getMasterNode();

    public MasterNodeService() {
        // hard coded DB mock
        Map<Long, RuntimeNode> runtimeNodeMap = new HashMap<>();
        for (int i = 1; i < RUNTIME_NODE_COUNT; i++) {
            RuntimeNode runtimeNode = new RuntimeNode(i, "node # " + i);
            runtimeNodeMap.put((long) i, runtimeNode);
        }
        masterNode.setRuntimeNodes(runtimeNodeMap);
    }

    public List<RuntimeNode> getAllRuntimeNodes() {
        return new ArrayList<>(masterNode.getRuntimeNodes().values());
    }

    public RuntimeNode getRuntimeNode(long id) {
        RuntimeNode runtimeNode = masterNode.getRuntimeNodes().get(id);
        if (runtimeNode == null) {
            throw new DataNotFoundException("node with id: " + id + " not found");
        }
        return runtimeNode;
    }
}
