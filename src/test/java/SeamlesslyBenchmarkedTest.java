
import org.junit.jupiter.api.Test;

@Benchmark
class SeamlesslyBenchmarkedTest {

    @Test
    void benchmarked() throws InterruptedException {
        Thread.sleep(1000);
    }
}
