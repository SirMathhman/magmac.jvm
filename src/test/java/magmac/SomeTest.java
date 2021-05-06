package magmac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

class SomeTest {

    @Test
    void isEmpty() {
        assertFalse(new Some<>("").isEmpty());
    }
}