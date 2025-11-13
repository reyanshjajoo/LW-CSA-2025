package src;

import edu.ftdev.CafeArt.CafeWall;

/**
 * CafeArt class - displays the CafeWall canvas and draws on it the cafe art.
 * At the same time it calculates the area covered by the art and its percentage
 * of the entire surface of the wall.
 */
public class CafeArt {
    // Mortar size in pixels
    public static final int mortar = 2;

    /**
     * Draws a row of alternating dark and bright squares on the CafeWall canvas.
     * @param startX the x-coordinate of the top left corner of the first square
     * @param startY the y-coordinate of the top left corner of the first square
     * @param pairs the number of pairs of squares to draw
     * @param size the size of the squares to be drawn
     * @param wall the CafeWall to draw on
     * @return the area covered by the drawn squares
     */
    public static int row(int startX, int startY, int pairs, int size, CafeWall wall) {
        int area = 0;
        for (int i = startX; i <= startX + (pairs - 1) * 2 * size; i += 2 * size) {
            wall.drawDarkSquare(i, startY, size);
            wall.drawBrightSquare(i + size, startY, size);
            area += size * size * 2;
        }
        return area;
    }


    /**
     * Draws a grid of squares on the CafeWall canvas.
     * @param startX the x-coordinate of the top left corner of the first square
     * @param startY the y-coordinate of the top left corner of the first square
     * @param number the number of rows and columns in the grid
     * @param size the size of the squares to be drawn
     * @param offset the horizontal offset for every second row
     * @param wall the CafeWall to draw on
     * @return the area covered by the drawn squares
     */
    public static int grid(int startX, int startY, int pairs, int size, int offset, CafeWall wall) {
        int area = 0;
        for (int j = 0; j < pairs*2; j++) {
            for (int i = startX; i <= startX + (pairs - 1) * 2 * size; i += 2 * size) {
                wall.drawDarkSquare(i + (j % 2) * offset, startY + j * (size + mortar), size);
                wall.drawBrightSquare(i + size + (j % 2) * offset, startY + j * (size + mortar), size);
                area += size * size * 2;
            }
        }
        return area;
    }

    /**
     * Calculates the area of the entire CafeWall canvas.
     * @param wall the CafeWall
     * @return the area of the CafeWall canvas
     */
    public static int area(CafeWall wall) {
        return wall.getWidth() * wall.getHeight();
    }


    /**
     * Main method to draw the CafeArt.
     * @param args command-line arguments (unused)
     * @throws InterruptedException if the sequence is interrupted
     */
    public static void main(String[] args) throws InterruptedException {
        CafeWall wall = new CafeWall();
        wall.open();
        int row1Area = row(0, 0, 4, 20, wall);
        int row2Area = row(50, 70, 5, 30, wall);
        int grid1Area = grid(10, 150, 4, 25, 0, wall);
        int grid2Area = grid(250, 200, 3, 25, 10, wall);
        int grid3Area = grid(425,180,5, 20,10, wall);
        int grid4Area = grid(400,20,2,35,35, wall);
        int totalArea = row1Area + row2Area + grid1Area + grid2Area + grid3Area + grid4Area;
        int wallArea = area(wall);


        System.out.println("Row 1 Area: " + row1Area);
        System.out.println("Row 2 Area: " + row2Area);
        System.out.println("Grid 1 Area: " + grid1Area);
        System.out.println("Grid 2 Area: " + grid2Area);
        System.out.println("Grid 3 Area: " + grid3Area);
        System.out.println("Grid 4 Area: " + grid4Area);
        System.out.println("Total Area: " + totalArea);
        System.out.println("Wall Area: " + wallArea);
        System.out.printf("Percentage of Wall Covered: %.2f%%", (totalArea / (double) wallArea) * 100);

        wall.breakStep();
        wall.close();
    }
}
