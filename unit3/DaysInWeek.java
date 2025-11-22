import java.util.Scanner;
public class DaysInWeek {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Enter year (YYYY): ");
        int year = console.nextInt();
        System.out.println("Enter month (1-12): ");
        int month = console.nextInt();
        System.out.println("Enter day (1-31): ");
        int day = console.nextInt();

        String dayOfWeek = dayInWeek(year, month, day);
        System.out.println("The day of the week is: " + dayOfWeek);
        console.close();
    }

    /**
     * Returns the day of the week
     * @param year Year as 4 digits
     * @param month Month as 1-12
     * @param day Day as 1-31
     * @return Day of the week as a String (e.g., "Monday")
     */
    public static String dayInWeek(int year, int month, int day) {
        String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}; 
        int totalDays = daysFrom2000(year);
        for (int m = 1; m < month; m++) {
            totalDays += dayOfYear(m);
            if (m == 2 && booleanisLeap(year)) {
                totalDays += 1;
            }
        }
        totalDays += day - 1;
        int dayIndex = (totalDays + 6) % 7; // January 1, 2000 was a Saturday
        return days[dayIndex];
    }

    private static boolean booleanisLeap(int year){
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    private static int dayOfYear(int month){
        int[] daysInMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        return daysInMonths[month - 1];
    }

    private static int daysFrom2000(int year){
        int yearsDiff = year - 2000;
        int days = yearsDiff * 365;
        for (int y = 2000; y < year; y++){
            if (booleanisLeap(y)){
                days += 1;
            }
        }
        return days;
    }
}