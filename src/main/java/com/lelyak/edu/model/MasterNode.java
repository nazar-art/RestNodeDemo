package com.lelyak.edu.model;

import com.lelyak.edu.database.DatabaseMockClass;
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
        this.appStatus = NodeAction.START.getActionValue();
        this.files = files;
        resourceStats = new NodeStats(runtimeNodes);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAppStatus() {
        return appStatus;
    }

    public void setAppStatus(NodeAction appStatus) {
        this.appStatus = appStatus.getActionValue();
    }

    @XmlTransient
    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

//    @XmlTransient
    public Map<Long, RuntimeNode> getRuntimeNodes() {
        return runtimeNodes;
    }

    public void setRuntimeNodes(Map<Long, RuntimeNode> runtimeNodes) {
        this.runtimeNodes = runtimeNodes;
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
