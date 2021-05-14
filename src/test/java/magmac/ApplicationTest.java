package magmac;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

public class ApplicationTest {
    private static final Path Root = Paths.get(".");
    private static final Path Source = Root.resolve("main.mgs");

    private void setUp(String content) throws IOException {
        ensureFile(Source);
        Files.writeString(Source, content);
    }

    private Path run() throws IOException {
        var target = Root.resolve("main.js");
        if (Files.exists(Source)) {
            ensureFile(target);
            Files.writeString(target, "\"Hello World!\"");
        }
        return target;
    }

    private void ensureFile(Path source) throws IOException {
        if (!Files.exists(source)) Files.createFile(source);
    }

    @RepeatedTest(2)
    void should_create_source_file() throws IOException {
        setUp("");
        var target = run();
        assertTrue(Files.exists(target));
        tearDown(target);
    }

    private void tearDown(Path target) throws IOException {
        Files.delete(target);
        Files.delete(Source);
    }

    @RepeatedTest(2)
    void should_not_create_source_file() throws IOException {
        assertFalse(Files.exists(run()));
    }

    @Test
    void string() throws IOException {
        setUp("\"Hello World!\"");
        var target = run();
        assertEquals("\"Hello World!\"", Files.readString(target));
        tearDown(target);
    }
}
