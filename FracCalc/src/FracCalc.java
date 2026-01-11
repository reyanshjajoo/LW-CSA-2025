package src;
import java.util.Scanner;

/**
 * @author Saanvi Tiwari
 * @period 3
 * @date 1-10-2026
 * This program performs fraction calculations such as adding and subtracting fractions.
 */

public class FracCalc {

    public static void main(String[] args)
    {
        // create scanner
        Scanner console = new Scanner(System.in);
        String input;

        // Read input until "quit" entered
        while (true) {
            input = console.nextLine();
            if (input.equalsIgnoreCase("quit")) {
                break;
            }
            String result = produceAnswer(input);
            System.out.println(result);
        }
        console.close();
    }

    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    public static String produceAnswer(String input)
    {
        String[] parts = input.trim().split("\\s+");
        String firstOperand = "";
        String operator = "";
        String secondOperand = "";

        if (parts.length >= 3) {
            firstOperand = parts[0];
            operator = parts[1];
            secondOperand = parts[2];
        } else {
            return "0/1";
        }

        int[] f1 = parseOperand(firstOperand);
        int[] f2 = parseOperand(secondOperand);

        int n1 = f1[0];
        int d1 = f1[1];
        int n2 = f2[0];
        int d2 = f2[1];

        int resultNum;
        int resultDen;

        switch (operator) {
            case "+":
                resultNum = n1 * d2 + n2 * d1;
                resultDen = d1 * d2;
                break;
            case "-":
                resultNum = n1 * d2 - n2 * d1;
                resultDen = d1 * d2;
                break;
            case "*":
                resultNum = n1 * n2;
                resultDen = d1 * d2;
                break;
            case "/":
                resultNum = n1 * d2;
                resultDen = d1 * n2;
                break;
            default:
                return "0/1";
        }

        if (resultDen < 0) {
            resultDen = -resultDen;
            resultNum = -resultNum;
        }

        return resultNum + "/" + resultDen;
    }

    /**
     * Parses a string operand into its numerator and denominator.
     * @param operand the string operand
     * @return an array: first element is numerator, second is denominator
     */
    private static int[] parseOperand(String operand) {
        int whole = 0;
        int numerator = 0;
        int denominator = 1;

        if (operand.contains("_")) {
            String[] mixed = operand.split("_");
            whole = Integer.parseInt(mixed[0]);

            String[] fraction = mixed[1].split("/");
            numerator = Integer.parseInt(fraction[0]);
            denominator = Integer.parseInt(fraction[1]);

            int sign = (whole < 0) ? -1 : 1;
            int absWhole = Math.abs(whole);
            int improper = sign * (absWhole * denominator + numerator);
            return new int[] { improper, denominator };
        }
        else if (operand.contains("/")) {
            String[] fraction = operand.split("/");
            numerator = Integer.parseInt(fraction[0]);
            denominator = Integer.parseInt(fraction[1]);

            return new int[] { numerator, denominator };
        }
        else {
            whole = Integer.parseInt(operand);
            return new int[] { whole, 1 };
        }
    }
}
