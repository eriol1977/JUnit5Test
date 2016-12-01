
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.TestExtensionContext;

public class BenchmarkExtension implements
        BeforeTestExecutionCallback,
        AfterTestExecutionCallback {

    private long launchTime;

    @Override
    public void beforeTestExecution(
            TestExtensionContext context) {
        launchTime = System.currentTimeMillis();
    }

    @Override
    public void afterTestExecution(
            TestExtensionContext context) {
        long elapsedTime
                = System.currentTimeMillis() - launchTime;
        System.out.printf("Test '%s' took %d ms.%n",
                context.getDisplayName(), elapsedTime);
    }
}
