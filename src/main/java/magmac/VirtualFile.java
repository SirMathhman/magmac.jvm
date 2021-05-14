package magmac;

import java.io.IOException;

public class VirtualFile implements File {
    @Override
    public void delete() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String readString() throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public File writeString(String content) throws IOException {
        throw new UnsupportedOperationException();
    }
}
