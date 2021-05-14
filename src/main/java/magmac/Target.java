package magmac;

import java.io.IOException;

public class Target {
    private final NIOFile value;

    public Target(NIOFile value) {
        this.value = value;
    }

    public NIOFile apply() {
        return value;
    }

    void delete() throws IOException {
        apply().delete();
    }

    public boolean exists(String name) {
        throw new UnsupportedOperationException();
    }
}
