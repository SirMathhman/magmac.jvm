package magmac;

import java.io.IOException;

public class VirtualFile implements File {
    private final String content;

    public VirtualFile(String content) {
        this.content = content;
    }

    @Override
    public void delete() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String readString() {
        return content;
    }

    @Override
    public File writeString(String content) throws IOException {
        throw new UnsupportedOperationException();
    }
}
