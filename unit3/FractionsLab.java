import java.util.Scanner;

/**
 * A program converting user-inputted fractions to decimals
 * @author Reyansh Jajoo
 * @date 10/27/2025
 * @period 3
 */
public class FractionsLab {
    public static void main(String[] args){
        Scanner console = new Scanner(System.in);
        System.out.println("Hello there!");
        for (int i=0; i<5; i++){
            System.out.printf("Command_%d> ", i);
            String fraction = console.nextLine();
            double num = parseFraction(fraction);
            System.out.println(num);
        }
        System.out.println("Goodbye!");
        console.close();
    }

    /**
     * Convert a mixed number as a string to a decimal
     * @param fraction The fraction to parse as a string: whole_num/den
     * @return The fraction as a decimal: whole+num/den
     */
    public static double parseFraction(String fraction){
        int underscoreIndex = fraction.indexOf("_");
        int fractionIndex = fraction.indexOf("/");
        int whole = Integer.parseInt(fraction.substring(0, underscoreIndex));
        int numerator = Integer.parseInt(fraction.substring(underscoreIndex+1, fractionIndex));
        double denominator = (double) Integer.parseInt(fraction.substring(fractionIndex+1, fraction.length()));

        double finalNum = whole + numerator/denominator;
        return finalNum;
    }
}
