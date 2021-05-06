package magmac;

import java.io.IOException;
import java.nio.file.Path;

/**
 * Wrapper class for a value that may or not be present.
 *
 * @author SirMathhman
 * @since 1.0.0
 */
public interface Option {
    /**
     * <p>
     * Throws an exception given by this supplier if there is no wrapped value present to return.
     * This method should be used in cases in which a value is <b>expected</b> to be wrapped,
     * but is otherwise not found.
     * </p>
     *
     * @param supplier The supplier.
     * @return The returned value, if present.
     * @throws IOException The exception supplied, if not present.
     */
    Path orElseThrow(SupplierE0<IOException> supplier) throws IOException;
}
