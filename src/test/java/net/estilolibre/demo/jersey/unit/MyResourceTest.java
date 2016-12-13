/**
 * 
 */
package net.estilolibre.demo.jersey.unit;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import net.estilolibre.demo.jersey.MyResource;

/**
 * @author isidromerayo
 *
 */
public class MyResourceTest extends JerseyTest {


	private static final String URI_MYRESOURCE = "myresource";
	@Override
    public Application configure() {
        ResourceConfig config = new ResourceConfig(MyResource.class);
        return config;
    }
	@Test
	public final void shouldBeGetDummyResource() {
		final String hello = target(URI_MYRESOURCE).request().get(String.class);
		assertEquals("Got it!", hello);
	}
	@Test
	public final void shouldBeSayHelloHTML() {
		final String hello = target(URI_MYRESOURCE + "/sayHi/John").request().get(String.class);
		assertEquals("Hi <b>John</b> !", hello);
	}
}
