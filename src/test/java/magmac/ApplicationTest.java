package magmac;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
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
    void should_exist(String parent, String child) throws IOException {
        var dist = Paths.get(".", "dist");
        ensureDirectory(dist);

        var js = dist.resolve("js");
        ensureDirectory(js);
        var jsTarget = js.resolve("Main.js");
        ensureFile(jsTarget);
        var jsHeader = js.resolve("Main.d.ts");
        ensureFile(jsHeader);

        var c = dist.resolve("c");
        ensureDirectory(c);
        var cTarget = c.resolve("Main.c");
        ensureFile(cTarget);
        var cHeader = c.resolve("Main.h");
        ensureFile(cHeader);

        assertFalse(Files.exists(dist.resolve(parent).resolve(parent).resolve(child)));

        Files.walkFileTree(dist, new FileVisitor<>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                Files.deleteIfExists(file);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) {
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                Files.deleteIfExists(dir);
                return FileVisitResult.CONTINUE;
            }
        });
    }

    private void ensureDirectory(Path dist) throws IOException {
        if (!Files.exists(dist)) Files.createDirectory(dist);
    }

    private void ensureFile(Path child) throws IOException {
        if (!Files.exists(child)) Files.createFile(child);
    }

    @ParameterizedTest
    @MethodSource("createTargets")
    void should_not_initially_exist(String parent, String child) {
        var dist = Paths.get(".", "dist").resolve(parent).resolve(child);
        assertFalse(Files.exists(dist.resolve("js").resolve("Main.js")));
    }
}
