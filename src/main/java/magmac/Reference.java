package magmac;

import java.io.IOException;

public interface Reference {
    File asFile() throws IOException;

    File ensureFile() throws IOException;

    boolean exists();

    Reference resolve(String name);
}
