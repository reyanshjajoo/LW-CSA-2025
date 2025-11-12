import java.util.Scanner;
/**
 * A program that outputs the sum, sum of even numbers, and maximum even number from given inputs
 * @author Reyansh Jajoo, Soren Greenawalt
 * @date 11-3-2025
 * @period 2
 */

public class ProcessingNumbers {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("How many numbers will you enter? ");

        int n = console.nextInt();
        int sum = 0;
        int evenSum = 0;
        int maxEven = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter number " + i + ": ");
            int num = console.nextInt();
            sum += num;
            if (num % 2 == 0) {
                evenSum += num;
                if (num > maxEven) {
                    maxEven = num;
                }
            }
        }

        if (evenSum == 0){
            evenSum = Integer.MIN_VALUE;
        }

        System.out.println("Total sum: " + sum);
        System.out.println("Sum of even numbers: " + evenSum);
        System.out.println("Maximum even number: " + maxEven);
        console.close();
    }
}
