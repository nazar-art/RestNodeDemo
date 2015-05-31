package com.lelyak.edu.resources;


import com.lelyak.edu.model.RuntimeNode;
import com.lelyak.edu.service.RuntimeNodeService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RuntimeNodeResource {

    private RuntimeNodeService runtimeNodeService = new RuntimeNodeService();

    @GET
    public List<RuntimeNode> getAllRuntimeNodes(@PathParam("masterNodeId") long masterNodeId) {
        return runtimeNodeService.getAllRuntimeNodes(masterNodeId);
    }

    @GET
    @Path("/${runtimeNodeId}")
    public RuntimeNode getRuntimeNode(@PathParam("runtimeNodeId") long runtimeNodeId) {
        return runtimeNodeService.getRuntimeNode(runtimeNodeId);
    }
}
