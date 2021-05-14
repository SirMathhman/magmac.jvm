package magmac;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static magmac.NIOReference.Root;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationTest {
    public static final Reference SourceReference = Root.resolve("main.mgs");
    public static final ReferenceSource Source = new ReferenceSource(SourceReference);
    public static final Application Application_ = new Application(Source);

    @RepeatedTest(2)
    void empty() throws IOException, ApplicationException {
        assertTargetEquals("", "");
    }

    private void assertTargetEquals(String input, String output) throws IOException, ApplicationException {
        var sourceFile = setUp(input);
        var source = new FileSource(sourceFile);
        var application = new Application(source);
        var reference = application.run();
        var targetFile = reference.apply("main");
        var content = targetFile.readString();
        assertEquals(output, content);
        tearDown(reference);
    }

    private File setUp(String content) throws IOException {
        return SourceReference.ensureFile().writeString(content);
    }

    private void tearDown(Target target) throws IOException {
        target.delete();
        SourceReference.asFile().delete();
    }

    @RepeatedTest(2)
    void invalidateInvocation() throws IOException {
        setUp("log(\"Hello World!\"");
        assertThrows(ApplicationException.class, Application_::run);
        SourceReference.asFile().delete();
    }

    @RepeatedTest(2)
    void should_create_source_file() throws IOException, ApplicationException {
        setUp("");
        var target = Application_.run();
        assertTrue(target.exists("main"));
        tearDown(target);
    }

    @RepeatedTest(2)
    void should_not_create_source_file() throws ApplicationException {
        assertFalse(Application_.run().exists("main"));
    }

    @RepeatedTest(2)
    void string() throws IOException, ApplicationException {
        assertTargetEquals("\"Hello World!\"", "\"Hello World!\"");
    }

    @Test
    void validateInvocation() {

    }
}
