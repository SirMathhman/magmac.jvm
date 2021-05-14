package magmac;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class NIOFile implements File {
    private final Path source;

    public NIOFile(Path source) {
        this.source = source;
    }

    @Override
    public void delete() throws IOException {
        Files.delete(source);
    }

    @Override
    public String readString() throws IOException {
        return Files.readString(source);
    }

    @Override
    public File writeString(String content) throws IOException {
        return new NIOFile(Files.writeString(source, content));
    }
}
