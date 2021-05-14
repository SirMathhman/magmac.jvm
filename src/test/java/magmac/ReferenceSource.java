package magmac;

import java.io.IOException;

public class ReferenceSource implements Source {
    private final NIOReference source;

    public ReferenceSource(NIOReference source) {
        this.source = source;
    }

    @Override
    public boolean exists() {
        return source.exists();
    }

    @Override
    public String read() throws IOException {
        return source.ensureFile().readString();
    }
}
