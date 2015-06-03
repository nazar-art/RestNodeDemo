package com.lelyak.edu.resources;

import com.lelyak.edu.model.MasterNode;
import com.lelyak.edu.model.enums.NodeAction;
import com.lelyak.edu.model.response.ActionResponse;
import com.lelyak.edu.service.MasterNodeService;
import org.json.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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
    @Path("/{masterNodeId}/action")
    public /*MasterNode*/ Response updateMasterNode(@PathParam("masterNodeId") long masterNodeId,
                                                    String action) {
        MasterNode masterNode = masterNodeService.getMasterNode(masterNodeId);
        String actionString = processActionJson(action);
        NodeAction nodeAction = NodeAction.fromString(actionString);

        masterNodeService.flipNodeActions(masterNode, nodeAction);

        // todo create
        ActionResponse actionResponse = new ActionResponse();
        return Response
                .status(Response.Status.OK)
                .entity(actionResponse)
                .build();
    }

    private String processActionJson(String actionJson) {
        JSONObject jsonObject = new JSONObject(actionJson);
        return jsonObject.getString("action");
    }

    @Path("/{masterNodeId}/runtime")
    public RuntimeNodeResource getRuntimeNodesResource(@PathParam("masterNodeId") long id) {
        return new RuntimeNodeResource();
    }
}
