package com.lelyak.edu.service;

import com.lelyak.edu.database.DatabaseMockClass;
import com.lelyak.edu.exception.DataNotFoundException;
import com.lelyak.edu.model.RuntimeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RuntimeNodeService {

    private final Map<Long, RuntimeNode> runtimeNodes = DatabaseMockClass.getRuntimeNodes();

    public List<RuntimeNode> getAllRuntimeNodes() {
        return new ArrayList<>(runtimeNodes.values());
    }

    public List<RuntimeNode> getAllRuntimeNodes(long masterNodeId) {
        if (masterNodeId < 0 || masterNodeId > 1) {
            throw new DataNotFoundException(masterNodeId, "master");
        }
        return getAllRuntimeNodes();
    }

    public RuntimeNode getRuntimeNode(long runtimeNodeId) {
        if (runtimeNodeId < 0 || runtimeNodeId >= DatabaseMockClass.RUNTIME_NODE_COUNT) {
            throw new DataNotFoundException(runtimeNodeId, "runtime");
        }
        return runtimeNodes.get(runtimeNodeId);
    }
}
