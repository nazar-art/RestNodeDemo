package com.lelyak.edu.database;

import com.lelyak.edu.model.MasterNode;

public final class DatabaseMock {

    private static MasterNode masterNode = new MasterNode();

    public static MasterNode getMasterNode() {
        return masterNode;
    }
}
