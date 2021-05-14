package magmac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class FileSourceTest {

    @Test
    void exists() {
        assertTrue(new FileSource(new VirtualFile()).exists());
    }
}