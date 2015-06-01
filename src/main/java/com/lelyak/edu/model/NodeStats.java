package com.lelyak.edu.model;

import com.lelyak.edu.model.enums.NodeAction;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Map;

@XmlRootElement
public class NodeStats {

    private int total;
    private int upActive;
    private int upInactive;

    public NodeStats() {
    }

    public NodeStats(Map<Long, RuntimeNode> runtimeNodes) {
        total = runtimeNodes.size();
        upActive = activeRuntimeNodes(runtimeNodes);
        upInactive = total - upActive;
    }

    private int activeRuntimeNodes(Map<Long, RuntimeNode> runtimeNodes) {
        int total = 0;
        for (RuntimeNode node : runtimeNodes.values()) {
            if (node.getAction() == NodeAction.START) {
                total = total + 1;
            }
        }
        return total;
    }

    public int getTotal() {
        return total;
    }

    public int getUpActive() {
        return upActive;
    }

    public int getUpInactive() {
        return upInactive;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setUpActive(int upActive) {
        this.upActive = upActive;
    }

    public void setUpInactive(int upInactive) {
        this.upInactive = upInactive;
    }
}
