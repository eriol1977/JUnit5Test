
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.expectThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class NestedTest {

    private Queue<String> items;

    @BeforeEach
    void setup() {
        items = new LinkedList<>();
    }

    @Test
    void isEmpty() {
        assertTrue(items.isEmpty());
    }

    @Nested
    class WhenEmpty {

        @Test
        public void removeShouldThrowException() {
            expectThrows(
                    NoSuchElementException.class,
                    items::remove);
        }
    }

    @Nested
    class WhenWithOneElement {

        @Test
        void addingOneElementShouldIncreaseSize() {
            items.add("Item");
            assertEquals(items.size(), 1);
        }
    }
}
