package magmac;

import java.io.IOException;

public interface Target {
    NIOFile apply(String name) throws TargetException;

    void delete() throws IOException;

    boolean exists(String name);
}
