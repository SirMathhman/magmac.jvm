package magmac;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NIOReference implements Reference {
    public static final Reference Root = new NIOReference(Paths.get("."));
    private final Path source;

    public NIOReference(Path source) {
        this.source = source;
    }

    @Override
    public File asFile() throws IOException {
        if(Files.exists(source) && Files.isRegularFile(source)) {
            return new NIOFile(source);
        } else {
            throw new IOException("'%s' is not a file.".formatted(source.toAbsolutePath().toString()));
        }
    }

    @Override
    public File ensureFile() throws IOException {
        if (!Files.exists(source)) Files.createFile(source);
        return new NIOFile(source);
    }

    @Override
    public boolean exists() {
        return Files.exists(source);
    }

    @Override
    public Reference resolve(String name) {
        return new NIOReference(source.resolve(name));
    }
}
