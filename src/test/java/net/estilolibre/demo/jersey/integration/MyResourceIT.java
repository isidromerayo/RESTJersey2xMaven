package net.estilolibre.demo.jersey.integration;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.junit.Test;

/**
 * @author isidromerayo
 *
 */
public class MyResourceIT {

	private static final String URL_TO_DUMMY_INTEGRATION_TEST = "http://localhost:7001/dummy-jersey/webapi/myresource";

	@Test
	public final void dummyJAXRSClient() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL_TO_DUMMY_INTEGRATION_TEST);
		// Building the request i.e a GET request to the RESTful Webservice
		// defined
		// by the URI in the WebTarget instance.
		Invocation invocation = target.request().buildGet();
		// Invoking the request to the RESTful API and capturing the Response.
		Response response = invocation.invoke();
		assertThatHTTPResponseIsOk(response);
		String expected = "Got it!";
		assertThat(expected, is(equalTo(response.readEntity(String.class))));

	}

	@Test
	public final void shouldBeResponseHTMLSayHelloName() {
		String expected = "Hi <b>John</b> !";
		
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL_TO_DUMMY_INTEGRATION_TEST + "/sayHi/John");
		Invocation invocation = target.request().buildGet();
		Response response = invocation.invoke();
		
		String result = response.readEntity(String.class);
		
		assertThatHTTPResponseIsOk(response);
		assertThat("Expected " + expected + " but " + result + " " , expected, is(equalTo(result)));

	}
	private void assertThatHTTPResponseIsOk(Response response) {
		assertThat("Response status is NOT ok",response.getStatus(), is(equalTo((Response.Status.OK.getStatusCode()))));
	}
}
