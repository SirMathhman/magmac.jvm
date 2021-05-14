package magmac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VirtualFileTest {

    @Test
    void delete() {
    }

    @Test
    void readString() {
        assertEquals("test", new VirtualFile("test").readString());
    }

    @Test
    void writeString() {
    }
}