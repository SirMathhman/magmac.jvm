package magmac;

import org.junit.jupiter.api.Test;

import static magmac.EmptyTarget.EmptyTarget_;
import static org.junit.jupiter.api.Assertions.*;

class EmptyTargetTest {

    @Test
    void exists() {
        assertFalse(EmptyTarget_.exists(""));
    }
}