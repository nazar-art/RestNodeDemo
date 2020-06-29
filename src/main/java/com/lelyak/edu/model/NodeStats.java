package com.lelyak.edu.model;

import com.lelyak.edu.model.enums.NodeAction;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Map;

@Getter
@XmlRootElement
@NoArgsConstructor
public class NodeStats {

    @XmlTransient
    private Map<Long, RuntimeNode> runtimeNodes;
    private int total;
    private int upActive;
    private int upInactive;


    public NodeStats(Map<Long, RuntimeNode> runtimeNodes) {
        this.runtimeNodes = runtimeNodes;
        total = runtimeNodes.size();
        upActive = countActiveNodes(runtimeNodes);
        upInactive = total - upActive;
    }

    private int countActiveNodes(Map<Long, RuntimeNode> runtimeNodes) {
        int result = 0;
        for (RuntimeNode node : runtimeNodes.values()) {
            if (node.getAction() == NodeAction.START) {
                result = result + 1;
            }
        }
        return result;
    }

//    public int getTotal() {
//        return runtimeNodes.size();
//    }
//
//    public int getUpActive() {
//        return countActiveNodes(runtimeNodes);
//    }
//
//    public int getUpInactive() {
//        return runtimeNodes.size() - countActiveNodes(runtimeNodes);
//    }
//
//    @XmlTransient
//    public Map<Long, RuntimeNode> getRuntimeNodes() {
//        return runtimeNodes;
//    }
//
//    public void setTotal(int total) {
//        this.total = total;
//    }
//
//    public void setUpActive(int upActive) {
//        this.upActive = upActive;
//    }
//
//    public void setUpInactive(int upInactive) {
//        this.upInactive = upInactive;
//    }
//
//    public void setRuntimeNodes(Map<Long, RuntimeNode> runtimeNodes) {
//        this.runtimeNodes = runtimeNodes;
//    }
}
