package magmac;

import java.io.IOException;

public interface Source {
    boolean exists();

    String read() throws IOException;
}
