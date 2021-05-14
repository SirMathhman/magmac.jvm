package magmac;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NIOReference {
    public static final NIOReference Root = new NIOReference(Paths.get("."));
    private final Path source;

    public NIOReference(Path source) {
        this.source = source;
    }

    NIOFile ensureFile() throws IOException {
        if (!Files.exists(source)) Files.createFile(source);
        return new NIOFile(source);
    }

    NIOReference resolve(String name) {
        return new NIOReference(source.resolve(name));
    }
}
