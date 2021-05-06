package magmac;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Application {
    public Application() {
    }

    Path run() throws IOException {
        var path = Paths.get(".", "main.c");
        Files.createFile(path);
        Files.writeString(path, "#include <stdio.h>\nint main(){return 0;}");
        return path;
    }
}