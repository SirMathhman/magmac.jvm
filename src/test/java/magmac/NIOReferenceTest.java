package magmac;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NIOReferenceTest {

    public static final Path TestPath = Paths.get(".", "test");
    public static final NIOReference TestReference = new NIOReference(TestPath);

    @Test
    void invalidate_exists() {
        assertFalse(TestReference.exists());
    }

    @Test
    void validate_exists() throws IOException {
        Files.createFile(TestPath);
        assertTrue(TestReference.exists());
        Files.delete(TestPath);
    }
}