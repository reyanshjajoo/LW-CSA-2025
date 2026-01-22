package src.tests;

import java.util.Base64;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import helpers.HelperPix;

public class A2_Tests {
    @BeforeEach
    void printInvocationDisplayName(TestInfo testInfo) {
        System.out.println(testInfo.getDisplayName());
    }

    private static Stream<Arguments> a2Provider(){
        return Stream.of(
            Arguments.of(
                /* QUESTION 1: */ "How can you make pink?",
                "255,188,193",  // TODO: Replace with your answer containing the R,G,B components, separated by comma (i.e. "1,2,3")
                "MjU1LDE5MiwyMDM="),
            Arguments.of(
                /* QUESTION 2: */ "How can you make yellow?",
                "255,255,0", // TODO: Replace with your answer containing the comma-separated "R,G,B" numbers (i.e. "1,2,3")
                "MjU1LDI1NSww"),
            Arguments.of(
                /* QUESTION 3: */ "How can you make purple?",
                "136,0,177", // TODO: Replace with your answer containing the comma-separated "R,G,B" numbers (i.e. "1,2,3")
                "MTQwLDIwLDE4OA=="),
            Arguments.of(
                /* QUESTION 4: */ "How can you make white?",
                "255,255,255", // TODO: Replace with your answer containing the comma-separated "R,G,B" numbers (i.e. "1,2,3")
                "MjU1LDI1NSwyNTU="),
            Arguments.of(
                /* QUESTION 5: */ "How can you make dark gray?",
                "50,50,50", // TODO: Replace with your answer containing the comma-separated "R,G,B" numbers (i.e. "1,2,3")
                "NjQsNjQsNjQ=")
        );
    }

    @ParameterizedTest(name = "a2_Question{index}: question={0}, answer={1}")
    @MethodSource("a2Provider")
    public void a2Questions(String question, String answer, String expected) {
        System.out.println(Base64.getEncoder().encodeToString(expected.getBytes()));
        HelperPix.checkColor(expected, answer);
    }
}
