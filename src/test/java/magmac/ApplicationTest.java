package magmac;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ApplicationTest {
    @Test
    void should_create_source_file() throws IOException {
        var source = Paths.get(".", "main.mgs");
        Files.createFile(source);
        var target = run();
        assertTrue(Files.exists(target));
        Files.delete(target);
        Files.delete(source);
    }

    private Path run() throws IOException {
        var target = Paths.get(".", "main.js");
        if (Files.exists(Paths.get(".", "main.mgs"))) {
            if (!Files.exists(target)) {
                Files.createFile(target);
            }
        }
        return target;
    }

    @Test
    void should_not_create_source_file() throws IOException {
        assertFalse(Files.exists(run()));
    }
}
