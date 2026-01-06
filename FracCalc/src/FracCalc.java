package src;
import java.util.Scanner;

/**
 * @author Reyansh Jajoo
 * @period 3
 * @date 12/5/2025
 * This program performs calculations on fractions.
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
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input)
    { 
        // Break input into three parts: first operand, operator, second operand
        String[] parts = input.trim().split("\\s+");
        String firstOperand = "";
        String operator = "";
        String secondOperand = "";

        if (parts.length >= 3) {
            firstOperand = parts[0];
            operator = parts[1];
            secondOperand = parts[2];
        } else if (parts.length == 2) {
            firstOperand = parts[0];
            operator = parts[1];
            secondOperand = "";
        }

        // Parse second operand -> whole, numerator, denominator
        int whole = 0;
        int numerator = 0;
        int denominator = 1;

        // Only parse if second operand is not empty
        if (!secondOperand.isEmpty()) {
            if (secondOperand.contains("_")) {
                String[] mixedParts = secondOperand.split("_");
                whole = Integer.parseInt(mixedParts[0]);
                String[] fractionParts = mixedParts[1].split("/");
                numerator = Integer.parseInt(fractionParts[0]);
                denominator = Integer.parseInt(fractionParts[1]);
            }
            else if (secondOperand.contains("/")) {
                String[] fractionParts = secondOperand.split("/");
                numerator = Integer.parseInt(fractionParts[0]);
                denominator = Integer.parseInt(fractionParts[1]);
            }
            else {
                whole = Integer.parseInt(secondOperand);
            }
        }

        // return parsed values
        return "whole:" + whole + " numerator:" + numerator + " denominator:" + denominator;
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
}
