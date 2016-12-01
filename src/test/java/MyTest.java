
import static java.lang.annotation.ElementType.METHOD;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Target(METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Benchmark
@Tag("mytest")
@Test
public @interface MyTest {
}
