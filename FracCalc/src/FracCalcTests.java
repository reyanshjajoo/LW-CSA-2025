package src;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class FracCalcTests {

    // #region: Checkpoint_1 tests
    private static Stream<Arguments> checkpoint1Args(){
        return Stream.of(
            Arguments.of( "5_3/4 + 6_5/8", Arrays.asList("6_5/8",  "whole:6 numerator:5 denominator:8",   "396/32",  "12_3/8")),
            Arguments.of( "-3/7 - 20",     Arrays.asList("20",     "whole:20 numerator:0 denominator:1",  "-143/7",  "-20_3/7")),
            Arguments.of( "-32 - 27/21",   Arrays.asList("27/21",  "whole:0 numerator:27 denominator:21", "-699/21", "-33_2/7"))
        );
    }

    /**
     * Tests produceAnswer() method for the Checkpoint_1 stage output.
     * Tests are also forward-compatible for the later stages.
     * @param expression - expression being evaluated.
     * @param acceptedAnswers - the set of answers accepted as valid.
     */
    @ParameterizedTest(name="Checkpoint_1 [{index}] {0}")
    @MethodSource("checkpoint1Args")
    public void checkpoint1Tests(String expression, List<String> acceptedAnswers) {
        String actualAnswer = FracCalc.produceAnswer(expression);
        assertThat(acceptedAnswers).as("Expression {%s}", expression).contains(actualAnswer);
    }
    // #endregion: Checkpoint_1 tests

    // #region: Checkpoint_2 tests
    private static Stream<Arguments> checkpoint2Args(){
        return Stream.of(
            Arguments.of( "5_3/4 + 6_5/8", Arrays.asList("whole:6 numerator:5 denominator:8",   "396/32",  "12_3/8")),
            Arguments.of( "-3/7 - 20",     Arrays.asList("whole:20 numerator:0 denominator:1",  "-143/7",  "-20_3/7")),
            Arguments.of( "-32 - 27/21",   Arrays.asList("whole:0 numerator:27 denominator:21", "-699/21", "-33_2/7")
            )
        );
    }

    /**
     * Tests produceAnswer() method for the Checkpoint_2 stage output.
     * Tests are also forward-compatible for the later stages.
     * @param expression - expression being evaluated.
     * @param acceptedAnswers - the set of answers accepted as valid.
     */
    @ParameterizedTest(name="Checkpoint_2 [{index}] {0}")
    @MethodSource("checkpoint2Args")
    public void checkpoint2Tests(String expression, List<String> acceptedAnswers) {
        String actualAnswer = FracCalc.produceAnswer(expression);
        assertThat(acceptedAnswers).as("Expression {%s}", expression).contains(actualAnswer);
    }
    // #endregion: Checkpoint_2 tests

    // #region: Checkpoint_3 tests
    private static Stream<Arguments> checkpoint3Args(){
        return Stream.of(
            Arguments.of( "1_1/7 + 3_2/7",       Arrays.asList("217/49",     "4_3/7")),
            Arguments.of( "-3_3/4 + 2_2/4",      Arrays.asList("-20/16",     "-1_1/4")),
            Arguments.of( "4_1/2 - 4_1/2",       Arrays.asList("0/4",        "0")),
            Arguments.of( "27/41 * 14/23",       Arrays.asList("378/943",    "378/943")),
            Arguments.of( "-12/3 * 2/1",         Arrays.asList("-24/3",      "-8")),
            Arguments.of( "1_27/41 * -3_140/23", Arrays.asList("-14212/943", "-15_67/943")),
            Arguments.of( "3/4 / 4/3",           Arrays.asList("9/16",       "9/16")),
            Arguments.of( "-3_3/4 / -2_2/3",     Arrays.asList("45/32",      "1_13/32")),
            Arguments.of( "0 / 46/27",           Arrays.asList("0/46",       "0")),
            Arguments.of( "16/4 / -3/2",         Arrays.asList("-32/12",     "-2_2/3"))
        );
    }

    /**
     * Tests produceAnswer() method for the Checkpoint_3 stage output.
     * Tests are also forward-compatible for the later stages.
     * @param label - a label describing the intent of the test.
     * @param expression - expression being evaluated.
     * @param acceptedAnswers - the set of answers accepted as valid.
     */
    @ParameterizedTest(name="Checkpoint_3 [{index}]: {0}")
    @MethodSource("checkpoint3Args")
    public void checkpoint3Tests(String expression, List<String> acceptedAnswers) {
        String actualAnswer = FracCalc.produceAnswer(expression);
        assertThat(acceptedAnswers).as("{%s}", expression).contains(actualAnswer);
    }
    // #endregion: Checkpoint_3 tests

    // #region: Checkpoint_4 tests
    private static Stream<Arguments> checkpoint4Args(){
        return Stream.of(
            Arguments.of("AdditionSimple3",                         "1_1/7 + 3_2/7",         "4_3/7"),
            Arguments.of("AdditionWholeNumbers2",                   "2/3 + 1/3",             "1"),
            Arguments.of("AdditionWholeNumbers7",                   "124543 + 897235",       "1021778"),
            Arguments.of("AdditionWithNegatives4",                  "-3_3/4 + 2_2/4",        "-1_1/4"),
            Arguments.of("AdditionImproperFractionsAndReductions2", "4/5 + 2/8",             "1_1/20"),
            Arguments.of("AdditionCombined4",                       "0 + 34_543/19",         "62_11/19"),
            Arguments.of("SubtractionSimple3",                      "4_1/2 - 4_1/2",         "0"),
            Arguments.of("SubtractionWithNegatives3",               "-3_3/4 - -2_2/4",       "-1_1/4"),
            Arguments.of("SubtractionCombined2",                    "-12_3/7 - -20_2/3",     "8_5/21"),
            Arguments.of("MultiplicationBasic1",                    "1_1/2 * 2",             "3"),
            Arguments.of("MultiplicationBasic10",                   "27/41 * 14/23",         "378/943"),
            Arguments.of("MultiplicationBasic3",                    "234 * 702",             "164268"),
            Arguments.of("MultiplicationWithNegatives2",            "-12/3 * 2/1",           "-8"),
            Arguments.of("MultiplicationWithNegatives6",            "-3_2/3 * -4_2/7",       "15_5/7"),
            Arguments.of("MultiplicationByZero2",                   "0 * 0",                 "0"),
            Arguments.of("MultiplicationByZero3",                   "0 * 9321",              "0"),
            Arguments.of("MultiplicationByZero4",                   "0 * -5902",             "0"),
            Arguments.of("MultiplicationCombined1",                 "-32_75/16 * -27_43/21", "1065_115/168"),
            Arguments.of("MultiplicationCombined2",                 "1_27/41 * -3_140/23", 	 "-15_67/943"),
            Arguments.of("DivisionBasic1",                          "3/4 / 4/3",             "9/16"),
            Arguments.of("DivisionBasic2",                          "3/2 / 2/3",             "2_1/4"),
            Arguments.of("DivisionWithNegatives5",                  "-20 / 7",               "-2_6/7"),
            Arguments.of("DivisionWithNegatives6",                  "-3_3/4 / -2_2/3",       "1_13/32"),
            Arguments.of("DivisionWithZero5",                       "0 / 46/27",             "0"),
            Arguments.of("DivisionWithZero6",                       "0/24 / 1/46",           "0"),
            Arguments.of("DivisionCombined2",                       "16/4 / -3/2",           "-2_2/3"),
            Arguments.of("DivisionCombined3",                       "-38_3/72 / -4_82/37",   "6_661/5520")
        );
    }

    /**
     * Tests produceAnswer() method for the Checkpoint_3 stage output.
     * @param label - a label describing the intent of the test.
     * @param expression - expression being evaluated.
     * @param acceptedAnswer - the one and only answer accepted as valid.
     */
    @ParameterizedTest(name="Checkpoint_4 [{index}] {0}: {1}")
    @MethodSource("checkpoint4Args")
    public void checkpoint4Tests(String label, String expression, String acceptedAnswer) {
        String actualAnswer = FracCalc.produceAnswer(expression);
        assertThat(acceptedAnswer).as("%s: {%s}", label, expression).isEqualTo(actualAnswer);
    }
    // #endregion: Checkpoint_4 tests

    // #region: Extra_1 tests
    private static Stream<Arguments> extra1Args(){
        return Stream.of(
            Arguments.of("1 / 0"),          // ERROR: DivByZero!
            Arguments.of("1_1 + 2_3/4"),    // ERROR: Invalid operand format '1_1'
            Arguments.of("5_3/0 + 4_2/5"),  // ERROR: Invalid fraction: 'DivByZero'
            Arguments.of("3/0 + 4_2/5"),    // ERROR: Invalid fraction: 'DivByZero'
            Arguments.of("1_1/2 % 4_5/6"),  // ERROR: Unrecognized operator '%'
            Arguments.of("1 + 2 +")         // ERROR: Invalid operand/operator/operand sequence.
        );
    }

    /**
     * Tests produceAnswer() method for the Extra_1 stage output.
     * @param expression - expression being evaluated.
     */
    @ParameterizedTest(name="Extra_1 [{index}]: {0}")
    @MethodSource("extra1Args")
    public void extra1Tests(String expression) {
        String actualAnswer = FracCalc.produceAnswer(expression);
        boolean isError = actualAnswer.startsWith("ERROR:");
        assertThat(isError).as("{%s}", expression).isTrue();
    }
    // #endregion: Extra_1 tests

    // #region: Extra_2 tests
    private static Stream<Arguments> extra2Args(){
        return Stream.of(
            Arguments.of("1_2/3 + 5/4 + 5_5/4 - 2_2/4 / -5_6/3",        "-20/21"),
            Arguments.of("1 + 3 + -3 - -3",                             "4"),
            Arguments.of("12 * 18 * 18 * 0",                            "0"),
            Arguments.of("20/8 + 3_1/3 - 4/5 - 5/4",                    "3_47/60"),
            Arguments.of("12345 - 12345 + 12345 - 12345 + 1",           "1"),
            Arguments.of("0 * 0 / 1 / 4/6 / 2_3/4",                     "0"),
            Arguments.of("1/5 + 1/5 + 1/5 + 1/5 + 1/5 - 2",             "-1"),
            Arguments.of("-4 + 1 + 1 + 1 + 1",                          "0"),
            Arguments.of("16/4 / 3/2 * 3/2 + 1/2",                      "4_1/2"),
            Arguments.of("12457 / -1 + 12457",                          "0"),
            Arguments.of("5_3/4 - -6_8/8 - 5_3/4",                      "7"),
            Arguments.of("2 * 3 - 6 + 1_1/2 + 1/2 - 1/2 - 1/2 + 3",     "4"),
            Arguments.of("2 * 3 - 6 + -1_1/2 + -1/2 - -1/2 - -1/2 - 3", "-4"),
            Arguments.of("20 / 5 * -1 + 8",                             "4")
        );
    }

    /**
     * Tests produceAnswer() method for the Extra_1 stage output.
     * @param expression - expression being evaluated.
     * @param acceptedAnswer - the one and only answer accepted as valid.
     */
    @ParameterizedTest(name="Extra_2 [{index}]: {1}")
    @MethodSource("extra2Args")
    public void extra2Tests(String expression, String acceptedAnswer) {
        String actualAnswer = FracCalc.produceAnswer(expression);
        assertThat(acceptedAnswer).as("{%s}", expression).isEqualTo(actualAnswer);
    }
    // #endregion: Extra_2 tests
}
