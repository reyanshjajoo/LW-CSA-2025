package src.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import helpers.HelperPix;
import src.main.Picture;

public class A7_Tests {
    @BeforeEach
    void printInvocationDisplayName(TestInfo testInfo) {
        System.out.println(testInfo.getDisplayName());
    }

    private static Stream<Arguments> a7Provider(){
        return Stream.of(
            Arguments.of(
                /* QUESTION 1: */ "How many times would the first nested for() loop execute? (see spec)",
                "<your answer>", // TODO: Replace with your answer as a string containing the number (i.e "0")
                "8613985ec49eb8f757ae6439e879bb2a"),
            Arguments.of(
                /* QUESTION 2: */ "How many times would the second nested for() loop execute? (see spec)",
                "<your answer>", // TODO: Replace with your answer as a string containing the number (i.e "0")
                "7f6ffaa6bb0b408017b62254211691b5")
        );
    }

    @ParameterizedTest(name = "a7_Question{index}: question={0}, answer={1}")
    @MethodSource("a7Provider")
    public void a7Questions(String question, String answer, String expected) {
        HelperPix.checkAnswer(expected, answer);
    }

    /** Method to test mirrorTemple */
    @Test
    public void testMirrorTemple() {
        Picture temple = new Picture("images/temple.jpg");
        temple.explore(false);
        temple.mirrorTemple();
        temple.explore();
    }

    /** Method to test the iterations count of mirrorTemple */
    @Test
    public void e1Test_mirrorTemple() {
        Picture temple = new Picture("images/temple.jpg");
        int count = temple.mirrorTemple();
        assertEquals(18410, count);
    }

    /** Method to test mirrorArms */
    @Test
    public void e2Test_mirrorArms() {
        Picture snowman = new Picture("images/snowman.jpg");
        snowman.explore(false);
        snowman.mirrorArms();
        snowman.explore();
    }

    /** Method to test mirrorGull */
    @Test
    public void e3Test_mirrorGull() {
        Picture snowman = new Picture("images/seagull.jpg");
        snowman.explore(false);
        snowman.mirrorGull();
        snowman.explore();
    }
}
