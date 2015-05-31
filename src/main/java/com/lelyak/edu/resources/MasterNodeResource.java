package com.lelyak.edu.resources;

import com.lelyak.edu.model.MasterNode;
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
    public List<MasterNode> getAllMasterNodes() {
        return masterNodeService.getAllMasterNodes();
    }

    @GET
    @Path("/{masterNodeId}")
    public MasterNode getRuntimeNode(@PathParam("masterNodeId") long id) {
        return masterNodeService.getMasterNode(id);
    }

    @PUT
    @Path("/{masterNodeId}")
    public MasterNode updateMasterNode(@PathParam("masterNodeId") long masterNodeId) {
        MasterNode masterNode = masterNodeService.getMasterNode(masterNodeId);
        masterNodeService.flipNodeActions(masterNode);

        return masterNode;
    }

    @Path("/{masterNodeId}/runtime")
    public RuntimeNodeResource getRuntimeNodesResource(@PathParam("masterNodeId") long id) {
        return new RuntimeNodeResource();
    }
}
