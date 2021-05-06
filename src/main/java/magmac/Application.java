package magmac;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Application {
    public Application() {
    }

    Option run() throws IOException {
        var path = Paths.get(".", "main.c");
        Files.createFile(path);
        Files.writeString(path, "#include <stdio.h>\nint main(){return 0;}");
        return new Some(path);
    }
}