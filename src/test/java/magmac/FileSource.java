package magmac;

import java.io.IOException;

public class FileSource implements Source {
    private final File file;

    public FileSource(File file) {
        this.file = file;
    }

    @Override
    public boolean exists() {
        return true;
    }

    @Override
    public String read() throws IOException {
        throw new UnsupportedOperationException();
    }
}
