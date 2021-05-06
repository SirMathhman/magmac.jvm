package magmac;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ApplicationTest {
    @Test
    void should_write_content() throws IOException {
        var path = run();
        var actual = Files.readString(path);
        var expected = "#include <stdio.h>\nint main(){return 0;}";
        assertEquals(expected, actual);
        Files.delete(path);
    }

    private Path run() throws IOException {
        var path = Paths.get(".", "main.c");
        Files.createFile(path);
        Files.writeString(path, "#include <stdio.h>\nint main(){return 0;}");
        return path;
    }

    @Test
    void should_write_file_if_not_exist() throws IOException {
        var path = run();
        assertTrue(Files.exists(path));
        Files.delete(path);
    }
}
