package com.lelyak.edu;

import com.lelyak.edu.utils.logger.Logger;
import org.glassfish.jersey.client.ClientConfig;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;

public class RuntimeNodeTest {

    private Client client;
    private WebTarget target;

    @BeforeSuite(description = "initialization for client")
    public void setUp() throws Exception {
        ClientConfig config = new ClientConfig();
        client = ClientBuilder.newClient(config);
        target = client.target(getBaseUri());
    }

    @Test(description = "check GET response")
    public void checkGetResponse() { // todo compare with expected response
        String getResponse = target.request().get(String.class);
        Logger.info(getResponse);
    }

    @Test(description = "check PUT response", dependsOnMethods = "checkGetResponse")
    public void checkPutResponse() { // todo compare with expected response
        Logger.info(
                target.path("action")
                        .queryParam("action", "stop")
                        .request()
                        /*.accept(MediaType.APPLICATION_JSON_TYPE)
                        .put(PutAction.class, new PutAction("action", "stop"))
                        .get(Response.class)*/
                        .get(String.class));
    }

    private URI getBaseUri() {
        String uriTemplate = "http://localhost:8080/webapi/master/1";
        return UriBuilder.fromUri(uriTemplate).build();
    }


}
