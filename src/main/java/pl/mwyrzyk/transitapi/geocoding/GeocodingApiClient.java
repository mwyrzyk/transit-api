package pl.mwyrzyk.transitapi.geocoding;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import pl.mwyrzyk.transitapi.config.ApplicationProperties;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

@ApplicationScoped
public class GeocodingApiClient {

    private ResteasyClient client;

    @Inject
    ApplicationProperties applicationProperties;


    @PostConstruct
    public void init() {
         client  = new ResteasyClientBuilder().build();
    }

    @PreDestroy
    public void destroy() {
        client.close();
    }

    @Produces
    GeocodingResource createClient() {
        ResteasyWebTarget target =  client.target(applicationProperties.getProperty("geocoding-api-url"));
        return target.proxy(GeocodingResource.class);
    }
}
