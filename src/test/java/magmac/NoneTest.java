package magmac;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NoneTest {

    @Test
    void isEmpty() {
        assertTrue(new None().isEmpty());
    }

    @Test
    void orElseThrow() {
        assertThrows(IOException.class, () -> new None().orElseThrow(IOException::new));
    }
}