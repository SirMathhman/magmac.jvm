package magmac;

import java.io.IOException;

public interface File {
    void delete() throws IOException;

    String readString() throws IOException;

    File writeString(String content) throws IOException;
}
