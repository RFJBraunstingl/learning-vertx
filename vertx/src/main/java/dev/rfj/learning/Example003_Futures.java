package dev.rfj.learning;

// https://vertx.io/docs/vertx-core/java/#_future_results

import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.file.FileProps;

/**
 * vert.x works with Futures, which are a reference to a result that can be read in the future
 */
public class Example003_Futures extends AbstractExample {

    @Override
    void run() throws Exception {
        Vertx vertx = Vertx.vertx();

        // get the FileProps asynchronously
        Future<FileProps> filePropsFuture = vertx.fileSystem().props(".gitignore");
        filePropsFuture.onComplete(asyncResult -> {
            if (!asyncResult.succeeded()) {
                System.out.println(asyncResult.cause().getMessage());
                return;
            }

            FileProps result = asyncResult.result();
            System.out.println("File size: " + result.size());
        });

        vertx.close();
    }
}
