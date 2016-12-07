package net.estilolibre.demo.jersey.integration;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.junit.Test;

/**
 * @author isidromerayo
 *
 */
public class MyResourceIT {

	@Test
	public final void dummyJAXRSClient2Weblogic() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:7001/dummy-jersey/webapi/myresource");
		// Building the request i.e a GET request to the RESTful Webservice
		// defined
		// by the URI in the WebTarget instance.
		Invocation invocation = target.request().buildGet();
		// Invoking the request to the RESTful API and capturing the Response.
		Response response = invocation.invoke();
		
		assertThat(response.getStatus(), is(equalTo((Response.Status.OK.getStatusCode()))));
		assertThat("Got it!", is(equalTo(response.readEntity(String.class))));

	}
}
