package dev.rfj.learning;

import io.netty.util.concurrent.EventExecutor;
import io.vertx.core.Vertx;

import java.util.Iterator;

/**
 * vert.x works with event loops
 * event loops dispatch events
 * events are handled by handlers
 * per default, there are as many event loops as there are CPU cores
 */
public class Example001EventLoops extends AbstractExample {

    @Override
    void run() throws Exception {
        Vertx vertx = Vertx.vertx();

        int numberOfEventLoops = countEventLoops(vertx);
        System.out.println(numberOfEventLoops + " event loops are active");
        // -> 32 event loops are active

        vertx.close();
    }

    private int countEventLoops(Vertx vertx) {
        int count = 0;
        Iterator<EventExecutor> iterator = vertx.nettyEventLoopGroup().iterator();

        for (; iterator.hasNext(); ++count) iterator.next();

        return count;
    }
}
