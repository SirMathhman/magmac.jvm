package magmac;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;

class NoneTest {

    @Test
    void orElseThrow() {
        assertThrows(IOException.class, () -> new None().orElseThrow(IOException::new));
    }
}