package com.lelyak.edu.model;

import com.lelyak.edu.model.enums.ManagementNodeAction;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@XmlRootElement
public class MasterNode {

    private String name;

    private Map<Long, RuntimeNode> runtimeNodes = new HashMap<>();

    private ManagementNodeAction managementNodeAction = ManagementNodeAction.STOP;

    private List<File> files;

    public MasterNode() {
    }

    public MasterNode(String name, ManagementNodeAction managementNodeAction, List<File> files) {
        this.name = name;
        this.managementNodeAction = managementNodeAction;
        this.files = files;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ManagementNodeAction getManagementNodeAction() {
        return managementNodeAction;
    }

    public void setManagementNodeAction(ManagementNodeAction managementNodeAction) {
        this.managementNodeAction = managementNodeAction;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

    @XmlTransient
    public Map<Long, RuntimeNode> getRuntimeNodes() {
        return runtimeNodes;
    }

    public void setRuntimeNodes(Map<Long, RuntimeNode> runtimeNodes) {
        this.runtimeNodes = runtimeNodes;
    }
}
