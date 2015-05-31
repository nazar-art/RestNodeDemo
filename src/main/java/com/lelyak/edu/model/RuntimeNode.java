package com.lelyak.edu.model;

import com.lelyak.edu.model.enums.NodeAction;

import java.io.File;
import java.util.List;

public class RuntimeNode {

    private long id;
    private String name;
    private NodeAction nodeCondition = NodeAction.START;
    private List<File> files;

    public RuntimeNode() {
    }

    public RuntimeNode(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

    public NodeAction getNodeAction() {
        return nodeCondition;
    }

    public void setNodeCondition(NodeAction nodeCondition) {
        this.nodeCondition = nodeCondition;
    }
}
