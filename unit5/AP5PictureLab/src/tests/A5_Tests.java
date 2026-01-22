package src.tests;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import helpers.HelperPix;
import src.main.Picture;

public class A5_Tests {
    @BeforeEach
    void printInvocationDisplayName(TestInfo testInfo) {
        System.out.println(testInfo.getDisplayName());
    }

    private static Stream<Arguments> a5Provider(){
        return Stream.of(
            Arguments.of(
                /* QUESTION 1: */ "Open Picture.java and look for the method getPixels2D. Is it there?",
                "No", // TODO: Replace with your answer containing either "Yes" or "No"
                "7fa3b767c460b54a2be4d490"),
            Arguments.of(
                /* QUESTION 2: */ "Open SimplePicture.java and look for the method getPixels2D. Is it there?",
                "Yes", // TODO: Replace with your answer containing either "Yes" or "No"
                "5c0a611b41b08f1209506350"),
            Arguments.of(
                /* QUESTION 3: */ "Does the following code compile?> DigitalPicture p = new DigitalPicture();",
                "Yes", // TODO: Replace with your answer containing either "Yes" or "No"
                "a6105c0a611b41b08f120950"),
            Arguments.of(
                /* QUESTION 4: */ "Does the following code compile?> DigitalPicture p = new SimplePicture();",
                "Yes", // TODO: Replace with your answer containing either "Yes" or "No"
                "611b41b08f1209506350279e"),
            Arguments.of(
                /* QUESTION 5: */ "Does the following code compile?> DigitalPicture p = new Picture();",
                "Yes", // TODO: Replace with your answer containing either "Yes" or "No"
                "c0a611b41b08f12095063502"),
            Arguments.of(
                /* QUESTION 6: */ "Does the following code compile?> SimplePicture p = new Picture();",
                "Yes", // TODO: Replace with your answer containing either "Yes" or "No"
                "105c0a611b41b08f12095063"),
            Arguments.of(
                /* QUESTION 7: */ "Does the following code compile?> Picture p = new SimplePicture();",
                "No", // TODO: Replace with your answer containing either "Yes" or "No"
                "c460b54a2be4d49030b349c7")
        );
    }

    @ParameterizedTest(name = "a5_Question{index}: question={0}, answer={1}")
    @MethodSource("a5Provider")
    public void a5Questions(String question, String answer, String expected) {
        HelperPix.checkAnswer(expected, answer);
    }

    /** Method to test zeroBlue */
    @Test
    public void testZeroBlue() {
        Picture beach = new Picture("images/beach.jpg");
        beach.explore(false);
        beach.zeroBlue();
        beach.explore();
    }

    /** Method to test negate */
    @Test
    public void e4Test_negate() {
        Picture beach = new Picture("images/butterfly1.jpg");
        beach.explore(false);
        beach.negate();
        beach.explore();
    }

    /** Method to test grayscale */
    @Test
    public void e5Test_grayscale() {
        Picture beach = new Picture("images/wall.jpg");
        beach.explore(false);
        beach.grayscale();
        beach.explore();
    }

    /** Method to test fixUnderwater */
    @Test
    public void e6Test_fixUnderwater() {
        Picture beach = new Picture("images/water.jpg");
        beach.explore(false);
        beach.fixUnderwater();
        beach.explore();
    }
}
