package magmac;

import java.io.IOException;

public class Some<T> implements Option<T> {
    private final T value;

    public Some(T value) {
        this.value = value;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public T orElseThrow(SupplierE0<IOException> supplier) {
        return value;
    }
}
