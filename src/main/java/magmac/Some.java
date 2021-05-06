package magmac;

import java.io.IOException;
import java.nio.file.Path;

public class Some implements Option {
    private final Path value;

    public Some(Path value) {
        this.value = value;
    }

    @Override
    public Path orElseThrow(SupplierE0<IOException> supplier) throws IOException {
        return value;
    }
}
