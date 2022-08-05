package dev.rfj.learning;

import io.vertx.core.Vertx;

// https://vertx.io/docs/vertx-core/java/#golden_rule
/**
 * One should NEVER block the event loop - the application will come to a halt
 * This is an example of what NOT TO DO
 */
public class Example002_Blocking_Event_Loops extends AbstractExample {

    @Override
    void run() throws Exception {
        Vertx vertx = Vertx.vertx();

        vertx.setPeriodic(1_000, timerID -> {
            try {
                /* !!! DON'T DO THIS !!! */
                System.out.println("tick"); // this is logged once every 20s
                Thread.sleep(20_000); // vert.x complains in the logs that the event loop is blocked
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
