package com.lelyak.edu.model;

import java.io.File;
import java.util.List;

public class RuntimeNode {

    private long id;
    private String name;
    private List<File> files;

    public RuntimeNode() {
    }

    public RuntimeNode(long id, String name, List<File> files) {
        this.id = id;
        this.name = name;
        this.files = files;
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
}
