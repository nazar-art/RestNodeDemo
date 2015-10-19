package com.lelyak.edu;

import com.lelyak.edu.database.DatabaseMockClass;
import com.lelyak.edu.model.MasterNode;
import com.lelyak.edu.model.RuntimeNode;
import com.lelyak.edu.utils.FileLocations;
import com.lelyak.edu.utils.IOUtils;
import com.lelyak.edu.utils.logger.Logger;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.glassfish.jersey.client.ClientConfig;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.Arrays;
import java.util.Map;

public class RuntimeNodeTest {

    private Client client;
    private WebTarget target;
    private ObjectMapper mapper;

    @BeforeSuite(description = "initialization for client")
    public void setUp() throws Exception {
        ClientConfig config = new ClientConfig();
        client = ClientBuilder.newClient(config);
        target = client.target(getMasterNodeUri(false));
        mapper = new ObjectMapper();
    }

    @Test(description = "check GET response")
    public void checkGetResponse() throws IOException {
        String getResponse = target.request().get(String.class);

        JsonNode actualGetResponse = mapper.readTree(getResponse);
        JsonNode expectedGetResponse = mapper.readTree(
                IOUtils.readFileIntoString(
                        FileLocations.EXPECTED_GET_RESPONSE.getFileLocation()));

        Logger.info("EXPECTED RESPONSE: " + expectedGetResponse);
        Logger.info("ACTUAL RESPONSE: " + actualGetResponse);

        Assert.assertEquals(actualGetResponse, expectedGetResponse,
                "actual GET response isn't equal with expected");

        // todo sent PUT to - http://localhost:8080/webapi/master/1/action
        // + with body - {"action":"stop"}

        target = client.target(getMasterNodeUri(true));
        Response response = target.request().put(Entity.json("{action:stop}"));
        String strRes = response.readEntity(String.class);
        Logger.info(strRes);
        response.close();
        // todo
        MasterNode masterNode = DatabaseMockClass.getMasterNodes().get(DatabaseMockClass.MASTER_NODE_KEY);
        Map<Long, RuntimeNode> runtimeNodes = DatabaseMockClass.getRuntimeNodes();

        for (RuntimeNode aNode : runtimeNodes.values()) {
            String runNodeFilePath = new StringBuilder().append(FileLocations.NODES_RESOURCE_PATH).append("runtime/#").append(aNode.getId()).append("_node_file.txt").toString();

            File masterFile = masterNode.getFiles().get(0);
            IOUtils.copyFile(masterFile.getAbsolutePath(), runNodeFilePath);
            File runNodeFile = new File(runNodeFilePath);
            aNode.setFiles(Arrays.asList(runNodeFile));
            Logger.debug(aNode.getId() + " " + aNode.getFiles());
        }
    }

    private URI getMasterNodeUri(boolean action) {
        String uriTemplate;
        if (action) {
            uriTemplate = "http://localhost:8080/webapi/master/1/action";
        } else {
            uriTemplate = "http://localhost:8080/webapi/master/1";
        }
        return UriBuilder.fromUri(uriTemplate).build();
    }

}
