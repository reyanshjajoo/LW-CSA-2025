package src.tests;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import helpers.HelperPix;

public class A1_Tests {
    @BeforeEach
    void printInvocationDisplayName(TestInfo testInfo) {
        System.out.println(testInfo.getDisplayName());
    }

    private static Stream<Arguments> a1Provider(){
        return Stream.of(
            Arguments.of(
                /* QUESTION 1: */ "How many bits does it take to represent the values from 0 to 255?",
                "8",  // TODO: Replace with your answer as a string containing the number (i.e "0")
                "c9f0f895fb98ab9159f51fd0297e236d"),
            Arguments.of(
                /* QUESTION 2: */ "How many bytes does it take to represent a color in the RGB color model?",
                "4", // TODO: Replace with your answer as a string containing the number (i.e "0")
                "a87ff679a2f3e71d9181a67b7542122c"),
            Arguments.of(
                /* QUESTION 3: */ "How many pixels are in a picture that is 640 pixels wide and 480 pixels high?",
                "307200", // TODO: Replace with your answer as a string containing the number (i.e "0")
                "8624b0a6670e42d51952dd8da3df746a")
        );
    }

    @ParameterizedTest(name = "a1_Question{index}: question={0}, answer={1}")
    @MethodSource("a1Provider")
    public void a1Questions(String question, String answer, String expected) {
        HelperPix.checkAnswer(expected, answer);
    }
}
