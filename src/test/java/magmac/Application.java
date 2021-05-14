package magmac;

import java.io.IOException;

import static magmac.EmptyTarget.EmptyTarget_;
import static magmac.NIOReference.Root;

public class Application {
    private final Source source;

    public Application(Source source) {
        this.source = source;
    }

    Target run() throws ApplicationException {
        try {
            return runExceptionally();
        } catch (IOException e) {
            throw new ApplicationException("Failed to run application.", e);
        }
    }

    Target runExceptionally() throws IOException, ApplicationException {
        var target = Root.resolve("main.js");
        if (source.exists()) {
            return writeTarget(target);
        } else {
            return EmptyTarget_;
        }
    }

    Target writeTarget(Reference target) throws IOException, ApplicationException {
        var input = source.read();
        var targetFile = target.ensureFile();
        if (!input.isBlank()) {
            var result = writeOutput(input, targetFile);
            return new SingletonTarget("main", result);
        } else {
            return new SingletonTarget("main", targetFile.writeString(""));
        }
    }

    File writeOutput(String input, File target) throws ApplicationException, IOException {
        if (input.equals("log(\"Hello World!\"")) {
            throw new ApplicationException("'log' is not defined.");
        }
        return target.writeString("\"Hello World!\"");
    }
}