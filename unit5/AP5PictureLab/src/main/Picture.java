package src.main;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * A class that represents a picture. This class inherits from
 * SimplePicture and allows the student to add functionality to
 * the Picture class.
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture {

    // #region - Constructors and overloads
    /**
     * Constructor that takes no arguments
     */
    public Picture() {
        /*
         * not needed but use it to show students the implicit call to super()
         * child constructors always call a parent constructor
         */
        super();
    }

    /**
     * Constructor that takes a file name and creates the picture
     * 
     * @param fileName the name of the file to create the picture from
     */
    public Picture(String fileName) {
        // let the parent class handle this fileName
        super(fileName);
    }

    /**
     * Constructor that takes the width and height
     * 
     * @param height the height of the desired picture
     * @param width  the width of the desired picture
     */
    public Picture(int height, int width) {
        // let the parent class handle this width and height
        super(width, height);
    }

    /**
     * Constructor that takes a picture and creates a
     * copy of that picture
     * 
     * @param copyPicture the picture to copy
     */
    public Picture(Picture copyPicture) {
        // let the parent class do the copy
        super(copyPicture);
    }

    /**
     * Constructor that takes a buffered image
     * 
     * @param image the buffered image to use
     */
    public Picture(BufferedImage image) {
        super(image);
    }

    /**
     * Method to return a string with information about this picture.
     * 
     * @return a string with information about the picture such as fileName,
     *         height and width.
     */
    public String toString() {
        String output = "Picture, filename " + getFileName() + " height " + getHeight() + " width " + getWidth();
        return output;

    }
    // #endregion - Constructors and overloads

    // #region - Activity 5 methods
    /** Method to set the blue to 0 */
    public void zeroBlue() {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels) {
            for (Pixel pixelObj : rowArray) {
                pixelObj.setBlue(0);
            }
        }
    }

    /**
     * TODO: Activity 5, Exercise 4.
     * Method to negate the color of all pixels
     */
    public void negate() {
        Pixel[][] pixels = getPixels2D();

        for (Pixel[] row : pixels) {
            for (Pixel p : row) {
                p.setRed(255 - p.getRed());
                p.setGreen(255 - p.getGreen());
                p.setBlue(255 - p.getBlue());
            }
        }
    }

    /**
     * TODO: Activity 5, Exercise 5.
     * Method to greyscale all pixels
     */
    public void grayscale() {
        Pixel[][] pixels = getPixels2D();

        for (Pixel[] row : pixels) {
            for (Pixel p : row) {
                int average = (p.getRed() + p.getGreen() + p.getBlue()) / 3;
                p.setRed(average);
                p.setGreen(average);
                p.setBlue(average);
            }
        }
    }

    /**
     * TODO: Activity 5, Exercise 6.
     * Method to negate the color of all pixels
     */
    public void fixUnderwater() {
        Pixel[][] pixels = getPixels2D();
        for (Pixel[] row : pixels) {
            for (Pixel p : row) {
                if (p.getBlue() > 160 && p.getGreen() < 100) {
                    p.setRed(p.getRed() + 50);
                    p.setGreen(p.getGreen() + 50);
                    p.setBlue(p.getBlue() - 50);
                }
            }
        }
    }
    // #endregion - Activity 5 methods

    // #region - Activity 6 methods
    /**
     * Method that mirrors the picture around a vertical mirror in the center
     * of the picture from left to right.
     */
    public void mirrorVertical() {
        Pixel[][] pixels = this.getPixels2D();
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int width = pixels[0].length;
        for (int row = 0; row < pixels.length; row++) {
            for (int col = 0; col < width / 2; col++) {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][width - 1 - col];
                rightPixel.setColor(leftPixel.getColor());
            }
        }
    }

    /**
     * TODO: Activity 6, Exercise 1.
     * Method that mirrors the picture around a vertical mirror in the center
     * of the picture from right to left
     */
    public void mirrorVerticalRightToLeft() {
        Pixel[][] pixels = this.getPixels2D();
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int width = pixels[0].length;
        for (int row = 0; row < pixels.length; row++) {
            for (int col = 0; col < width / 2; col++) {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][width - 1 - col];
                leftPixel.setColor(rightPixel.getColor());
            }
        }
    }

    /**
     * TODO: Activity 6, Exercise 2.
     * Method that mirrors the picture around a horizontal mirror in the center
     * of the picture from top to bottom
     */
    public void mirrorHorizontal() {
        Pixel[][] pixels = this.getPixels2D();
        Pixel topPixel = null;
        Pixel bottomPixel = null;
        int height = pixels.length;
        for (int row = 0; row < height / 2; row++) {
            for (int col = 0; col < pixels[0].length; col++) {
                topPixel = pixels[row][col];
                bottomPixel = pixels[height - 1 - row][col];
                bottomPixel.setColor(topPixel.getColor());
            }
        }
    }

    /**
     * TODO: Activity 6, Exercise 3.
     * Method that mirrors the picture around a vertical mirror in the center
     * of the picture from right to left
     */
    public void mirrorHorizontalBotToTop() {
        Pixel[][] pixels = getPixels2D();
        int height = pixels.length;
        for (int row = 0; row < height / 2; row++) {
            for (int col = 0; col < pixels[0].length; col++) {
                Pixel topPixel = pixels[row][col];
                Pixel bottomPixel = pixels[height - 1 - row][col];

                topPixel.setColor(bottomPixel.getColor());
            }
        }
    }

    /**
     * TODO: Activity 6, Exercise 4.
     * Method that mirrors the picture around the top-left to bottom-right diagonal
     * line,
     * mirroring the lower-triangle pixels into upper-triangle
     */
    public void mirrorDiagonal() {
        Pixel[][] pixels = getPixels2D();
        int maxLength = Math.min(pixels.length, pixels[0].length);
        for (int row = 0; row < maxLength; row++) {
            for (int col = 0; col < row; col++) {
                Pixel topPixel = pixels[row][col];
                Pixel bottomPixel = pixels[col][row];

                bottomPixel.setColor(topPixel.getColor());
            }
        }
    }
    // #endregion - Activity 6 methods

    // #region - Activity 7 methods
    /**
     * TODO: Activity 7, Exercise 1.
     * Mirror just part of a picture of a temple
     */
    public int mirrorTemple() {
        Pixel[][] pixels = getPixels2D();
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int mirrorPoint = 276;
        int count = 0;
        for (int row = 27; row < 97; row++) {
            for (int col = 13; col < mirrorPoint; col++) {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][mirrorPoint + (mirrorPoint - col)];
                rightPixel.setColor(leftPixel.getColor());
                count++;
            }
        }
        return count;
    }

    /**
     * TODO: Activity 7, Exercise 2.
     * Mirror the arms of the snowman
     */
    public void mirrorArms() {
        Pixel[][] pixels = getPixels2D();
        Pixel topPixel = null;
        Pixel bottomPixel = null;
        for (int row = 158; row < 191; row++) {
            for (int col = 103; col < 170; col++) {
                topPixel = pixels[row][col];
                bottomPixel = pixels[191 - row + 191][col];
                bottomPixel.setColor(topPixel.getColor());
            }
        }
        for (int row = 171; row < 196; row++) {
            for (int col = 239; col < 294; col++) {
                topPixel = pixels[row][col];
                bottomPixel = pixels[196 - row + 196][col];
                bottomPixel.setColor(topPixel.getColor());
            }
        }
    }

    /**
     * TODO: Activity 7, Exercise 3.
     * Mirror the seagull
     */
    public void mirrorGull() {
        Pixel[][] pixels = getPixels2D();
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int mirrorPoint = 345;
        for (int row = 235; row < 323; row++) {
            for (int col = 238; col < mirrorPoint; col++) {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][mirrorPoint + (mirrorPoint - col)];
                rightPixel.setColor(leftPixel.getColor());
            }
        }
    }
    // #endregion - Activity 7 region

    // #region - Activity 8 methods
    /**
     * copy from the passed fromPic to the
     * specified startRow and startCol in the
     * current picture
     * 
     * @param fromPic  the picture to copy from
     * @param startRow the start row to copy to
     * @param startCol the start col to copy to
     */
    public void copy(Picture fromPic, int startRow, int startCol) {
        Pixel fromPixel = null;
        Pixel toPixel = null;
        Pixel[][] toPixels = this.getPixels2D();
        Pixel[][] fromPixels = fromPic.getPixels2D();
        for (int fromRow = 0, toRow = startRow; fromRow < fromPixels.length &&
                toRow < toPixels.length; fromRow++, toRow++) {
            for (int fromCol = 0, toCol = startCol; fromCol < fromPixels[0].length &&
                    toCol < toPixels[0].length; fromCol++, toCol++) {
                fromPixel = fromPixels[fromRow][fromCol];
                toPixel = toPixels[toRow][toCol];
                toPixel.setColor(fromPixel.getColor());
            }
        }
    }

    /** Method to create a collage of several pictures */
    public void createCollage() {
        Picture flower1 = new Picture("images/flower1.jpg");
        Picture flower2 = new Picture("images/flower2.jpg");
        this.copy(flower1, 0, 0);
        this.copy(flower2, 100, 0);
        this.copy(flower1, 200, 0);
        Picture flowerNoBlue = new Picture(flower2);
        flowerNoBlue.zeroBlue();
        this.copy(flowerNoBlue, 300, 0);
        this.copy(flower1, 400, 0);
        this.copy(flower2, 500, 0);
        this.mirrorVertical();
        this.write("images/collage.jpg");
    }

    /**
     * TODO: Activity 8, Exercise 1.
     * Copy from the fromPic an area of pixels given by their start/end row and
     * column
     * into this picture, in the area of same size, given by its start row and
     * column.
     * 
     * @param fromPic     the picture to copy from
     * @param srcStartRow the start row to copy from
     * @param srcEndRow   the end row to copy from
     * @param srcStartCol the start col to copy from
     * @param srcEndCol   the end col to copy from
     * @param startRow    the start row to copy to
     * @param startCol    the start col to copy to
     */
    public void copy(Picture fromPic,
            int srcStartRow, int srcEndRow,
            int srcStartCol, int srcEndCol,
            int startRow, int startCol) {
        Pixel fromPixel = null;
        Pixel toPixel = null;
        Pixel[][] toPixels = this.getPixels2D();
        Pixel[][] fromPixels = fromPic.getPixels2D();
        for (int fromRow = srcStartRow, toRow = startRow; fromRow < srcEndRow &&
                toRow < toPixels.length; fromRow++, toRow++) {
            for (int fromCol = srcStartCol, toCol = startCol; fromCol < srcEndCol &&
                    toCol < toPixels[0].length; fromCol++, toCol++) {
                fromPixel = fromPixels[fromRow][fromCol];
                toPixel = toPixels[toRow][toCol];
                toPixel.setColor(fromPixel.getColor());
            }
        }
    }

    /**
     * TODO: Activity 8, Exercise 2.
     * Method to create a custom collage of several pictures
     */
    public void myCollage() {
        Picture flower1 = new Picture("images/flower1.jpg");
        Picture flower2 = new Picture("images/flower2.jpg");
        this.copy(flower1, 0, 0);
        this.copy(flower2, 100, 0);
        Picture flowerNoBlue = new Picture(flower2);
        flowerNoBlue.zeroBlue();
        this.copy(flowerNoBlue, 200, 0);
        this.copy(flower1, 0, 100);
        this.copy(flower2, 100, 100);
        this.copy(flowerNoBlue, 200, 100);
        this.mirrorVertical();
        this.write("images/myCollage.jpg");
    }
    // #endregion - Activity 8 methods

    // #region - Activity 9 methods
    /**
     * Method to show large changes in color
     * 
     * @param edgeDist the distance for finding edges
     */
    public void edgeDetection(int edgeDist) {
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        Pixel[][] pixels = this.getPixels2D();
        Color rightColor = null;
        for (int row = 0; row < pixels.length; row++) {
            for (int col = 0; col < pixels[0].length - 1; col++) {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][col + 1];
                rightColor = rightPixel.getColor();
                if (leftPixel.colorDistance(rightColor) > edgeDist)
                    leftPixel.setColor(Color.BLACK);
                else
                    leftPixel.setColor(Color.WHITE);
            }
        }
    }

    /**
     * TODO: Activity 9, Exercise 2.
     * Alternative method to show large changes in color
     * 
     * @param edgeDist the distance for finding edges
     */
    public void edgeDetection2(int edgeDist) {
        Pixel currentPixel = null;
        Pixel bottomPixel = null;
        Pixel[][] pixels = this.getPixels2D();
        Color bottomColor = null;
        for (int row = 0; row < pixels.length - 1; row++) {
            for (int col = 0; col < pixels[0].length; col++) {
                currentPixel = pixels[row][col];
                bottomPixel = pixels[row + 1][col];
                bottomColor = bottomPixel.getColor();
                if (currentPixel.colorDistance(bottomColor) > edgeDist)
                    currentPixel.setColor(Color.BLACK);
                else
                    currentPixel.setColor(Color.WHITE);
            }
        }
    }
    // #endregion - Activity 9 methods

    /*
     * Main method for testing - each class in Java can have a main
     * method
     */
    public static void main(String[] args) {
        Picture beach = new Picture("images/beach.jpg");
        beach.explore(false);
        beach.zeroBlue();
        beach.explore();
    }

} // this } is the end of class Picture, put all new methods before this
