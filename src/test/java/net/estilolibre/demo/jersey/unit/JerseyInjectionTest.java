package net.estilolibre.demo.jersey.unit;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;
 
import org.glassfish.hk2.api.Factory;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.process.internal.RequestScoped;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

public class JerseyInjectionTest extends JerseyTest {
	private static final String EXPECTED_CONTENT = "any string :P";
	 
    /**
     * Checks that the Resource uses Impl1.class
     */
    @Test
    public void invokeImpl1(){
        invoke(Impl1.class);
    }
     
    /**
     * Checks that the Resource uses Impl2.class
     */
    @Test
    public void invokeImpl2(){
        invoke(Impl2.class);
    }
     
    /**
     * Checks that Resource.anyContent has always the value of EXPECTED_CONTENT
     */
    @Test
    public void checkContent(){
        Response response = target("example/content").request().get();
        assertEquals(EXPECTED_CONTENT, response.readEntity(String.class));
    }
     
    private <T extends Service> void invoke(Class<T> service){
        final String serviceName = service.getName();
        Response response = target("example/"+serviceName).request().get();
        assertEquals(service.getName(), response.readEntity(String.class));
    }
     
    /**
     * Register the Resource and TestBinder in the Application
     */
    @Override
    protected Application configure() {
        return new ResourceConfig() {
            {
                register(new TestBinder());
                register(Resource.class);
            }
        };
    }
 
    @Path("/example")
    public static class Resource {
 
        @Inject
        Service service;
        @Inject
        String anyContent;
 
        /**
         * Returns the name of the Service's implementation
         */
        @GET
        @Path("/{serviceClass}")
        public Response getDynamicInvokedService() {
            return Response.ok(service.getClass().getName()).build();
        }
 
        /**
         * Returns always the value of anyContent
         */
        @GET
        @Path("/content")
        public Response getStaticContent() {
            return Response.ok(anyContent).build();
        }
 
    }
     
    /**
     * This class will help Resource to set the @Inject fields.
     */
    public static class TestBinder extends AbstractBinder{
 
        @Override
        protected void configure() {
            bindFactory(ServiceProvider.class).to(Service.class);
            bind(EXPECTED_CONTENT).to(String.class);
        }
         
    }
 
    /**
     * This class will instance a Services's implementation
     * per each time that the Resource is called.
     */
    @RequestScoped
    public static class ServiceProvider implements Factory<Service> {
 
        private final String serviceName;
 
        public ServiceProvider(@PathParam("serviceClass") String serviceName) {
            this.serviceName = serviceName;
        }
 
        @Override
        public void dispose(Service arg0) {}
 
        @Override
        public Service provide() {
            try {
                return (Service) Class.forName(serviceName).newInstance();
            } catch (Exception e) {
                return null;
            }
        }
 
    }
 
    /**
     * Dummy services
     */
    public static interface Service {}
    public static class Impl1 implements Service {}
    public static class Impl2 implements Service {}
}
