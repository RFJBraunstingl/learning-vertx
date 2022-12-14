package dev.rfj.learning;

import io.vertx.core.Vertx;

// https://vertx.io/docs/vertx-core/java/#_dont_call_us_well_call_you
/**
 * Simplest vert.x example - start an application and let the event loop call a tick once a second
 */
public class Example000_Tick extends AbstractExample {
    public void run() {
        // setup vert.x instance
        Vertx vertx = Vertx.vertx();

        // note: this would be the place to alter the defaults
        // Vertx vertx = Vertx.vertx(new VertxOptions().setWorkerPoolSize(40));

        // setting up a timer
        vertx.setPeriodic(1_000, id -> {
            // this will run once a second
            System.out.println("a second has passed!");
        });
    }
}
