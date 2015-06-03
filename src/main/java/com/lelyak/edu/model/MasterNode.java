package com.lelyak.edu.model;

import com.lelyak.edu.database.DatabaseMockClass;
import com.lelyak.edu.model.enums.ApplicationStatus;
import com.lelyak.edu.model.enums.NodeAction;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.File;
import java.util.List;
import java.util.Map;

@XmlRootElement
public class MasterNode {

    private String name;

    private static Map<Long, RuntimeNode> runtimeNodes = DatabaseMockClass.runtimeNodesMock();

    private String appStatus;

    private NodeStats resourceStats;

    private List<File> files;

    public MasterNode() {
    }

    public MasterNode(String name, List<File> files) {
        this.name = name;
        this.appStatus = ApplicationStatus.STARTED.getActionValue();
        this.files = files;
        resourceStats = new NodeStats(runtimeNodes);
    }

    public static NodeAction runtimeNodeAction() {
        for (RuntimeNode node : runtimeNodes.values()) {
            if (node.getAction() != NodeAction.START) {
                return NodeAction.STOP;
            }
        }
        return NodeAction.START;
    }

    @XmlTransient
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAppStatus() {
        return appStatus;
    }

    public void setAppStatus(ApplicationStatus appStatus) {
        this.appStatus = appStatus.getActionValue();
    }

    @XmlTransient
    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

    @XmlTransient
    public static Map<Long, RuntimeNode> getRuntimeNodes() {
        return runtimeNodes;
    }

    public static void setRuntimeNodes(Map<Long, RuntimeNode> runtimeNodes) {
        MasterNode.runtimeNodes = runtimeNodes;
    }

    public void setAppStatus(String appStatus) {
        this.appStatus = appStatus;
    }

    public NodeStats getResourceStats() {
        return resourceStats;
    }

    public void setResourceStats(NodeStats resourceStats) {
        this.resourceStats = resourceStats;
    }
}
