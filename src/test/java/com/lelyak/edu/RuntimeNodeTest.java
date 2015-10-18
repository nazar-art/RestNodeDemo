package com.lelyak.edu;

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
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.net.URI;

public class RuntimeNodeTest {

    private WebTarget target;
    private ObjectMapper mapper;

    @BeforeSuite(description = "initialization for client")
    public void setUp() throws Exception {
        ClientConfig config = new ClientConfig();
        Client client = ClientBuilder.newClient(config);
        target = client.target(getMasterNodeUri());
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
        // todo sent PUT to - http://localhost:8080/webapi/master/1/action + with body - {"action":"stop"}
    }

    private URI getMasterNodeUri() {
        String uriTemplate = "http://localhost:8080/webapi/master/1";
        return UriBuilder.fromUri(uriTemplate).build();
    }

    //    @Test(description = "check PUT response", dependsOnMethods = "checkGetResponse")
    public void checkPutResponse() { // todo compare with expected response
        Logger.info(
                target.path("action")
                        .queryParam("action", "stop")
                        .request()
                        /*.accept(MediaType.APPLICATION_JSON_TYPE)*/
//                        .put(PutAction.class, new PutAction("action", "stop"))
                        .get(String.class));
    }
}
