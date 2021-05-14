package magmac;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FileSourceTest {
    public static final FileSource Source = new FileSource(new VirtualFile("test"));

    @Test
    void exists() {
        assertTrue(Source.exists());
    }

    @Test
    void read() throws IOException {
        assertEquals("test", Source.read());
    }
}