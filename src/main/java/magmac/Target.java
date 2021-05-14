package magmac;

import java.io.IOException;

public class Target {
    private final NIOFile value;
    private final String name;

    public Target(String name, NIOFile value) {
        this.name = name;
        this.value = value;
    }

    void delete() throws IOException {
        value.delete();
    }

    public NIOFile apply(String name) throws TargetException {
        if (this.name.equals(name)) {
            return value;
        } else {
            throw new TargetException("Expected a name of '%s' but was actually '%s'.".formatted(this.name, name));
        }
    }

    public boolean exists(String name) {
        return this.name.equals(name);
    }
}
