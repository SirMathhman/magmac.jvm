package magmac;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Application {
    public Application() {
    }

    Option<Path> run() throws IOException {
        var source = Paths.get(".", "main.mgs");
        if (Files.exists(source)) {
            var path = Paths.get(".", "main.c");
            if (!Files.exists(path)) Files.createFile(path);
            Files.writeString(path, "#include <stdio.h>\nint main(){return 0;}");
            return new Some<>(path);
        } else {
            return new None();
        }
    }
}