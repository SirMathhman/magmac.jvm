package magmac;

import java.io.IOException;

public class EmptyTarget implements Target {
    @Override
    public NIOFile apply(String name) throws TargetException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete() throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean exists(String name) {
        throw new UnsupportedOperationException();
    }
}
