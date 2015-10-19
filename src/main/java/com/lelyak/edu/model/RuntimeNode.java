package com.lelyak.edu.model;

import com.lelyak.edu.model.enums.NodeAction;

import javax.xml.bind.annotation.XmlTransient;
import java.io.File;
import java.util.List;

public class RuntimeNode {

    private long id;
    private String name;
    private String action;
    private List<File> files;

    public RuntimeNode() {
    }

    public RuntimeNode(long id, String name) {
        this.id = id;
        this.name = name;
        action = NodeAction.START.getActionValue();
    }

    @XmlTransient
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @XmlTransient
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

    public NodeAction getAction() {
        return NodeAction.fromString(action);
    }

    public void setAction(NodeAction action) {
        this.action = action.getActionValue();
    }
}
