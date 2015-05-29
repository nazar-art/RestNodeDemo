package com.lelyak.edu.resources;

import com.lelyak.edu.model.RuntimeNode;
import com.lelyak.edu.service.MasterNodeService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/master")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MasterNodeResource {
    private MasterNodeService masterNodeService = new MasterNodeService();

    @GET
    public List<RuntimeNode> getAllRuntimeNodes() {
        return masterNodeService.getAllRuntimeNodes();
    }

    @GET
    @Path("/{runtimeNodeId}")
    public RuntimeNode getRuntimeNode(@PathParam("runtimeNodeId") long id) {
        return masterNodeService.getRuntimeNode(id);
    }
}
