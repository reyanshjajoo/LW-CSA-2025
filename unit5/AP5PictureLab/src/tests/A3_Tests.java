package src.tests;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import helpers.HelperPix;
import src.main.Picture;

public class A3_Tests {
    @BeforeEach
    void printInvocationDisplayName(TestInfo testInfo) {
        System.out.println(testInfo.getDisplayName());
    }

    private static Stream<Arguments> a3Provider(){
        return Stream.of(
            Arguments.of(
                /* QUESTION 1: */ "What is the row index for the top left corner of the picture?",
                "<your answer>",  // TODO: Replace with your answer containing a number as a string (i.e. "32")
                "cfcd208495d565ef66e7dff9f98764da"),
            Arguments.of(
                /* QUESTION 2: */ "What is the column index for the top left corner of the picture?",
                "<your answer>", // TODO: Replace with your answer containing a number as a string (i.e. "32")
                "cfcd208495d565ef66e7dff9f98764da"),
            Arguments.of(
                /* QUESTION 3: */ "The width of this picture is 640. What is the right most column index?",
                "<your answer>", // TODO: Replace with your answer containing a number as a string (i.e. "32")
                "0f96613235062963ccde717b18f97592"),
            Arguments.of(
                /* QUESTION 4: */ "The height of this picture is 480. What is the bottom most row index?",
                "<your answer>", // TODO: Replace with your answer containing a number as a string (i.e. "32")
                "d18f655c3fce66ca401d5f38b48c89af"),
            Arguments.of(
                /* QUESTION 5: */ "Does the row index increase from left to right (A) or top to bottom (B)?",
                "<your answer>", // TODO: Replace with your answer containing either "A" or "B"
                "92eb5ffee6ae2fec3ad71c777531578f"),
            Arguments.of(
                /* QUESTION 6: */ "Does the column index increase from left to right (A) or top to bottom (B)?",
                "<your answer>", // TODO: Replace with your answer containing either "A" or "B"
                "0cc175b9c0f1b6a831c399e269772661"),
            Arguments.of(
                /* QUESTION 7: */ "Set the zoom to 500%. Can you see squares of color? (Yes/No)",
                "<your answer>", // TODO: Replace with your answer containing either "Yes" or "No"
                "a6105c0a611b41b08f1209506350279e")
        );
    }

    @ParameterizedTest(name = "a3_Question{index}: question={0}, answer={1}")
    @MethodSource("a3Provider")
    public void a3Questions(String question, String answer, String expected) {
        HelperPix.checkAnswer(expected, answer);
    }

    @Test
    public void e1Test() {
        // Demonstrates Activity 3, Exercise 1.
        Picture pix = new Picture("images/beach.jpg");
        pix.explore();
    }

    @Test
    public void e2Test() {
        // TODO: Replace with your code for Activity 3, Exercise 2.
        fail("Replace with your code for Activity 3, Exercise 2");
    }
}
