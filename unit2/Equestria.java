 package unit2;

public class Equestria{
    /**
     * Main method to test the functions
     * @param args  Command line arguments
     */
    public static void main(String[] args){
        System.out.println("Road trip distance: " + roadTrip(10));
        System.out.println("Distance from Baltimare to Manehatten: " + distance(29,16,34, 8));
        System.out.println("Distance from Los Pegasus to Neighagra Falls: " + distance(6,19,22, 7));
        System.out.println("Distance from the Badlands to Ponyville: " + distance(25,24,16, 14));
        System.out.println("Distance from the Badlands to Los Pegasus to Manehatten: " + distance2(25,24,6,19,34,8));
        System.out.println("Distance from the Badlands to Los Pegasus to Manehatten back to the Badlands: " + totalTrip(25,24,6,19,34,8));
        System.out.println("Distance from the Badlands to Los Pegasus to Manehatten to Ponyville back to the Badlands: " + longTrip(25,24,6,19,34,8,16,14));
    }

    /**
     * Calculates the distance of a road trip on a circular route, given the diameter.
     * @param diameter  Diameter of the circular route
     * @return  Distance of the road trip
     */
    public static double roadTrip(double diameter){
        return diameter * Math.PI;
    }

    /**
     * Calculates the distance between two points
     * @param x1  x-coordinate of the first point
     * @param y1  y-coordinate of the first point
     * @param x2  x-coordinate of the second point
     * @param y2  y-coordinate of the second point
     * @return Distance between the two points
     */
    public static double distance(int x1, int y1, int x2, int y2){
        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    }

    /**
     * Calculates the distance of a trip with a stop
     * @param x1  x-coordinate of the first point
     * @param y1  y-coordinate of the first point
     * @param x2  x-coordinate of the second point
     * @param y2  y-coordinate of the second point
     * @param x3  x-coordinate of the third point
     * @param y3  y-coordinate of the third point
     * @return  Total distance for the trip
     */
    public static double distance2(int x1, int y1, int x2, int y2, int x3, int y3){
        return distance(x1, y1, x2, y2) + distance(x2, y2, x3, y3);
    }

    /**
     * Calculates the total distance of a trip with stop and returning to the starting point
     * @param x1  x-coordinate of the first point
     * @param y1  y-coordinate of the first point
     * @param x2  x-coordinate of the second point
     * @param y2  y-coordinate of the second point
     * @param x3  x-coordinate of the third point
     * @param y3  y-coordinate of the third point
     * @return  Total distance for the trip
     */
    public static double totalTrip(int x1, int y1, int x2, int y2, int x3, int y3){
        return distance2(x1, y1, x2, y2, x3, y3) + distance(x3, y3, x1, y1);
    }

    /**
     * Calculates the total distance of a trip with two stops and returning to the starting point
     * @param x1  x-coordinate of the first point
     * @param y1  y-coordinate of the first point
     * @param x2  x-coordinate of the second point
     * @param y2  y-coordinate of the second point
     * @param x3  x-coordinate of the third point
     * @param y3  y-coordinate of the third point
     * @param x4  x-coordinate of the fourth point
     * @param y4  y-coordinate of the fourth point
     * @return  Total distance for the trip
     */
    public static double longTrip(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4){
        return totalTrip(x1, y1, x2, y2, x3, y3) + distance(x3, y3, x4, y4) + distance(x4, y4, x1, y1);
    }
}