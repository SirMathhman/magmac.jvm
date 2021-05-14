package magmac;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class ApplicationTest {
    private static Stream<Arguments> createTargets() {
        return Stream.of(
                arguments("js", "Main.js"),
                arguments("js", "Main.d.ts"),
                arguments("c", "Main.c"),
                arguments("c", "Main.h")
        );
    }

    @ParameterizedTest
    @MethodSource("createTargets")
    void should_not_initially_exist(String parent, String child) {
        var dist = Paths.get(".", "dist").resolve(parent).resolve(child);
        assertFalse(Files.exists(dist.resolve("js").resolve("Main.js")));
    }
}
