package dev.rfj.learning;

public class AbstractExampleRunner {

    public static void run(Class<? extends AbstractExample> exampleClass) throws Exception {
        AbstractExample example = exampleClass.getConstructor().newInstance();
        example.run();
    }
}
