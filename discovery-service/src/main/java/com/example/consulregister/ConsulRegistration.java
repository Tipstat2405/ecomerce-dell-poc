package com.example.consulregister;

import io.quarkus.runtime.StartupEvent;
import io.vertx.ext.consul.ConsulClientOptions;
import io.vertx.ext.consul.ServiceOptions;
import io.vertx.mutiny.core.Vertx;
import io.vertx.mutiny.ext.consul.ConsulClient;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import org.eclipse.microprofile.config.inject.ConfigProperty;


@ApplicationScoped
public class ConsulRegistration {


    @ConfigProperty(name = "consul.host") String host;
    @ConfigProperty(name = "consul.port") int port;

    @ConfigProperty(name = "order-service.host") String orderHost;
    @ConfigProperty(name = "order-service.port") int orderPort;


    @ConfigProperty(name = "inventory-service.host") String inventoryHost;
    @ConfigProperty(name = "inventory-service.port") int inventoryPort;


    @ConfigProperty(name = "user-service.host") String userHost;
    @ConfigProperty(name = "user-service.port") int userPort;

    @ConfigProperty(name = "notification-service.host") String notificationHost;
    @ConfigProperty(name = "notification-service.port") int notificationPort;




    public void init(@Observes StartupEvent ev, Vertx vertx) {
        ConsulClient client = ConsulClient.create(vertx, new ConsulClientOptions().setHost(host).setPort(port));

        client.registerServiceAndAwait(new ServiceOptions().setPort(8080).setAddress("localhost").setName("discovery-service").setId("discovery-service"));
        client.registerServiceAndAwait(new ServiceOptions().setPort(orderPort).setAddress(orderHost).setName("order-service").setId("order-service"));
        client.registerServiceAndAwait(new ServiceOptions().setPort(inventoryPort).setAddress(inventoryHost).setName("inventory-service").setId("inventory-service"));
        client.registerServiceAndAwait(new ServiceOptions().setPort(notificationPort).setAddress(notificationHost).setName("notofication-service").setId("notification-service"));
        client.registerServiceAndAwait(new ServiceOptions().setPort(userPort).setAddress(userHost).setName("user-service").setId("user-service"));

    }


}
