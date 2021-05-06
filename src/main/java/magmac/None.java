package magmac;

import java.io.IOException;
import java.nio.file.Path;

public class None implements Option {
    @Override
    public Path orElseThrow(SupplierE0<IOException> supplier) throws IOException {
        throw supplier.get();
    }
}
