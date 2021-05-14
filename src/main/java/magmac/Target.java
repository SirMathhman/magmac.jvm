package magmac;

import java.io.IOException;

public interface Target {
    File apply(String name) throws TargetException;

    void delete() throws IOException;

    boolean exists(String name);
}
