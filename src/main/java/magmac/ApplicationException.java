package magmac;

import java.io.IOException;

public class ApplicationException extends Exception {
    public ApplicationException(String message) {
        super(message);
    }

    public ApplicationException(String message, IOException e) {
        super(message, e);
    }
}
