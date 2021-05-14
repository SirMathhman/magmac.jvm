package magmac;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static magmac.NIOReference.Root;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationTest {
    private static final Path Source = Paths.get(".").resolve("main.mgs");

    @Test
    void empty() throws IOException, ApplicationException {
        assertTargetEquals("", "");
    }

    private void assertTargetEquals(String source, String target) throws IOException, ApplicationException {
        setUp(source);
        var reference = run();
        var written = reference.apply("main");
        var content = written.readString();
        assertEquals(target, content);
        tearDown(reference);
    }

    private void setUp(String content) throws IOException {
        new NIOReference(Source).ensureFile();
        new NIOFile(Source).writeString(content);
    }

    private Target run() throws ApplicationException {
        try {
            return runExceptionally();
        } catch (IOException e) {
            throw new ApplicationException("Failed to run application.", e);
        }
    }

    private void tearDown(Target target) throws IOException {
        target.delete();
        Files.delete(Source);
    }

    private Target runExceptionally() throws IOException, ApplicationException {
        var target = Root.resolve("main.js");
        if (Files.exists(Source)) {
            return writeTarget(target);
        } else {
            return EmptyTarget.EmptyTarget_;
        }
    }

    private Target writeTarget(NIOReference target) throws IOException, ApplicationException {
        var input = Files.readString(Source);
        var targetFile = target.ensureFile();
        if (!input.isBlank()) {
            NIOFile result = writeOutput(input, targetFile);
            return new SingletonTarget("main", result);
        } else {
            return new SingletonTarget("main", targetFile.writeString(""));
        }
    }

    private NIOFile writeOutput(String input, NIOFile target) throws ApplicationException, IOException {
        if (input.equals("log(\"Hello World!\"")) {
            throw new ApplicationException("'log' is not defined.");
        }
        return target.writeString("\"Hello World!\"");
    }

    @Test
    void invalidateInvocation() throws IOException {
        setUp("log(\"Hello World!\"");
        assertThrows(ApplicationException.class, this::run);
    }

    @RepeatedTest(2)
    void should_create_source_file() throws IOException, ApplicationException {
        setUp("");
        var target = run();
        assertTrue(target.exists("main"));
        tearDown(target);
    }

    @RepeatedTest(2)
    void should_not_create_source_file() throws ApplicationException {
        assertFalse(run().exists("main"));
    }

    @Test
    void string() throws IOException, ApplicationException {
        assertTargetEquals("\"Hello World!\"", "\"Hello World!\"");
    }

    @Test
    void validateInvocation() {

    }
}
