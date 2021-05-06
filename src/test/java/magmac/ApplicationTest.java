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
        var source = writeSource();
        var target = run();
        var actual = Files.readString(target);
        var expected = "#include <stdio.h>\nint main(){return 0;}";
        assertEquals(expected, actual);
        tearDown(source, target);
    }

    private Path writeSource() throws IOException {
        var source = Paths.get(".", "main.mgs");
        Files.writeString(source, "import native stdio\ndef main() : I16 => {return 0;}");
        return source;
    }

    private Path run() throws IOException {
        return new Application()
                .run().orElseThrow(() -> new IOException("No target was written."));
    }

    private void tearDown(Path source, Path target) throws IOException {
        Files.delete(target);
        Files.delete(source);
    }

    @Test
    void should_write_file_if_not_exist() throws IOException {
        var source = writeSource();
        var target = run();
        assertTrue(Files.exists(target));
        tearDown(source, target);
    }
}
