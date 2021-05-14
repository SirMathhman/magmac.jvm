package magmac;

import java.io.IOException;

public class SingletonTarget implements Target {
    private final NIOFile value;
    private final String name;

    public SingletonTarget(String name, NIOFile value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public void delete() throws IOException {
        value.delete();
    }

    @Override
    public NIOFile apply(String name) throws TargetException {
        if (this.name.equals(name)) {
            return value;
        } else {
            throw new TargetException("Expected a name of '%s' but was actually '%s'.".formatted(this.name, name));
        }
    }

    @Override
    public boolean exists(String name) {
        return this.name.equals(name);
    }
}
