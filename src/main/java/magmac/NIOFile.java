package magmac;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class NIOFile {
    private final Path source;

    public NIOFile(Path source) {
        this.source = source;
    }

    void delete() throws IOException {
        Files.delete(source);
    }

    String readString() throws IOException {
        return Files.readString(source);
    }

    NIOFile writeString(String content) throws IOException {
        return new NIOFile(Files.writeString(source, content));
    }
}
