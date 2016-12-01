
import java.util.stream.Stream;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

@DisplayName("This is my awesome test class ‰")
public class TestClass {

    @Test
    @DisplayName("This is my lonely test method")
    void simpleTestIsPassing() {
        assertTrue(true);
    }

    @Test
    void expectingArithmeticException() {
        assertThrows(ArithmeticException.class,
                () -> divideByZero());
    }

    int divideByZero() {
        return 3 / 0;
    }

    @Test
    void expectingAnotherArithmeticException() {
        StringIndexOutOfBoundsException exception
                = expectThrows(
                        StringIndexOutOfBoundsException.class,
                        () -> "JUnit5 Rocks!".substring(-2));
        assertEquals(exception.getMessage(), "String index out of range: -2");
    }

    @Test
    void groupedAssertionsAreValid() {
        assertAll(
                () -> assertTrue(true),
                () -> assertFalse(false)
        );
    }

    @TestFactory
    Stream<DynamicTest> dynamicSquareRootTest() {
        return Stream.of(
                new Object[][]{{2d, 4d}, {3d, 9d}, {4d, 16d}})
                .map(i -> dynamicTest("Square root test " + i[1],
                () -> {
                    assertEquals(i[0], Math.sqrt((double) i[1]));
                }));
    }

}
