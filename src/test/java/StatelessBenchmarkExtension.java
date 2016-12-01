
import static java.lang.System.currentTimeMillis;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ExtensionContext.Namespace;
import org.junit.jupiter.api.extension.TestExtensionContext;

public class StatelessBenchmarkExtension implements
        BeforeTestExecutionCallback,
        AfterTestExecutionCallback {

    private static final Namespace NAMESPACE = Namespace.create("org", "codefx", "Benchmark");
    private static final String LAUNCH_TIME_KEY = "LaunchTime";

    private static void storeCurrentTimeAsLaunchTime(ExtensionContext context) {
        context.getStore(NAMESPACE).put(LAUNCH_TIME_KEY, currentTimeMillis());
    }

    private static long loadLaunchTime(ExtensionContext context) {
        return context.getStore(NAMESPACE).get(LAUNCH_TIME_KEY, long.class);
    }

    @Override
    public void beforeTestExecution(TestExtensionContext context) {
        storeCurrentTimeAsLaunchTime(context);
    }

    @Override
    public void afterTestExecution(TestExtensionContext context) {
        long launchTime = loadLaunchTime(context);
        long runtime = currentTimeMillis() - launchTime;
        System.out.printf("Test '%s' took %d ms.%n", context.getDisplayName(), runtime);
    }
}
