package magmac;

import org.junit.jupiter.api.RepeatedTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ApplicationTest {
    private static final Path Root = Paths.get(".");
    private static final Path Source = Root.resolve("main.mgs");
    private static final Path Target = Root.resolve("main.js");

    @RepeatedTest(2)
    void should_create_source_file() throws IOException {
        Files.createFile(Source);
        var target = run();
        assertTrue(Files.exists(target));
        Files.delete(target);
        Files.delete(Source);
    }

    private Path run() throws IOException {
        if (Files.exists(Source)) {
            if (!Files.exists(Target)) {
                Files.createFile(Target);
            }
        }
        return Target;
    }

    @RepeatedTest(2)
    void should_not_create_source_file() throws IOException {
        assertFalse(Files.exists(run()));
    }
}
