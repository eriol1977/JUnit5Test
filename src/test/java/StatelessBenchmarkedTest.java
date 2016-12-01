
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

// this is the way all methods are benchmarked
@ExtendWith(StatelessBenchmarkExtension.class)
class StatelessBenchmarkedTest {

    @Test
    void benchmarked() throws InterruptedException {
        Thread.sleep(1000);
    }
}
