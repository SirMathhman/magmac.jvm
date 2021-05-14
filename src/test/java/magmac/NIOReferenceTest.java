package magmac;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class NIOReferenceTest {

    public static final Path TestPath = Paths.get(".", "test");
    public static final Reference TestReference = new NIOReference(TestPath);

    @Test
    void invalidate_as_file_not_exist() {
        assertThrows(IOException.class, TestReference::asFile);
    }

    @Test
    void invalidate_as_file_not_file() throws IOException {
        Files.createDirectory(TestPath);
        assertThrows(IOException.class, TestReference::asFile);
        Files.delete(TestPath);
    }

    @Test
    void invalidate_exists() {
        assertFalse(TestReference.exists());
    }

    @Test
    void validate_as_file() throws IOException {
        Files.createFile(TestPath);
        assertThrows(IOException.class, TestReference::asFile);
        Files.delete(TestPath);
    }

    @Test
    void validate_exists() throws IOException {
        Files.createFile(TestPath);
        assertTrue(TestReference.exists());
        Files.delete(TestPath);
    }
}