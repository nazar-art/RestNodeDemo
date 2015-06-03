package com.lelyak.edu;

import com.lelyak.edu.utils.logger.Logger;
import org.glassfish.jersey.client.ClientConfig;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;

public class RuntimeNodeTest {

    Client client;
    WebTarget target;

    @BeforeSuite(description = "initialization for client")
    public void setUp() throws Exception {
        ClientConfig config = new ClientConfig();
        client = ClientBuilder.newClient(config);
        target = client.target(getBaseUri());
    }

    private URI getBaseUri() {
        String uriTemplate = "http://localhost:8080/webapi/master/1";
        return UriBuilder.fromUri(uriTemplate).build();
    }

    @Test(description = "check GET response")
    public void checkGetResponse() {
        Logger.info(target.request().accept(MediaType.APPLICATION_JSON_TYPE).get().toString());
    }

    @Test(description = "check PUT response", dependsOnMethods = "checkGetResponse")
    public void checkPutResponse() {
        Logger.info(target.path("action")
                .request().accept(MediaType.APPLICATION_JSON_TYPE)
//                .put(PutAction.class, new PutAction("action", "stop"))
                .get(Response.class)
                .toString());
    }


}
