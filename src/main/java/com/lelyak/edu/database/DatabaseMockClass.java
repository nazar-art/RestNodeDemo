package com.lelyak.edu.database;

import com.lelyak.edu.model.MasterNode;
import com.lelyak.edu.model.RuntimeNode;
import com.lelyak.edu.utils.logger.Logger;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class DatabaseMockClass {

    private DatabaseMockClass() {
    }

    public static final int RUNTIME_NODE_COUNT = 33;

    private static Map<Long, MasterNode> masterNodes = new HashMap<>();

    public static final long MASTER_NODE_KEY = 1L;
    public static final String RUNTIME_NODES_EXCEPTION = "runtime nodes are missed for first master node - at getRuntimeNodes()";
    public static final String MANAGE_NODE_FIRST_FILE_PATH = "src/main/resources/nodes/manage/first_manage_node_file.txt";

    static {
        // hard coded DB mock
        Logger.operation("start master node initialization");
        List<File> runNodesList = Arrays.asList(new File(MANAGE_NODE_FIRST_FILE_PATH));
        MasterNode firstMasterNode = new MasterNode("#1 master node", runNodesList);
        //
        masterNodes.put(MASTER_NODE_KEY, firstMasterNode);
        Logger.operation("first master node created");
    }

    public static Map<Long, RuntimeNode> runtimeNodesMock() {
        Map<Long, RuntimeNode> runtimeNodeMap = new HashMap<>();
        for (int i = 1; i < RUNTIME_NODE_COUNT; i++) {
            RuntimeNode runtimeNode = new RuntimeNode(i, "node_name_#" + i);
            runtimeNodeMap.put((long) i, runtimeNode);
        }
        return runtimeNodeMap;
    }

    public static Map<Long, MasterNode> getMasterNodes() {
        return masterNodes;
    }

    public static Map<Long, RuntimeNode> getRuntimeNodes() {
        Map<Long, RuntimeNode> runtimeNodes = masterNodes.get(MASTER_NODE_KEY).getRuntimeNodes();
        if (runtimeNodes == null) {
            Logger.error(RUNTIME_NODES_EXCEPTION);
            throw new RuntimeException(RUNTIME_NODES_EXCEPTION);
        }
        return runtimeNodes;
    }

    public static Map<Long, RuntimeNode> getRuntimeNodes(long nodeId) {
        Map<Long, RuntimeNode> runtimeNodes = masterNodes.get(nodeId).getRuntimeNodes();
        if (runtimeNodes == null) {
            Logger.error(RUNTIME_NODES_EXCEPTION);
            throw new RuntimeException(RUNTIME_NODES_EXCEPTION);
        }
        return runtimeNodes;
    }
}
