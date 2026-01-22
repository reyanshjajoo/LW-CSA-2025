package src.main;

public class IntArrayWorker {
    /** two dimensional matrix */
    private int[][] matrix = null;

    /**
     * set the matrix to the passed one
     * 
     * @param theMatrix the one to use
     */
    public void setMatrix(int[][] theMatrix) {
        matrix = theMatrix;
    }

    /**
     * Method returning a textual representation (String) of the matrix
     */
    @Override
    public String toString() {
        String output = "";
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                output += matrix[row][col] + " ";
            }
            output = output.trim() + "\n";
        }
        return output;
    }

    /**
     * Method to return the total
     * 
     * @return the total of the values in the array
     */
    public int getTotal() {
        int total = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                total = total + matrix[row][col];
            }
        }
        return total;
    }

    /**
     * Method to return the total using a nested for-each loop
     * 
     * @return the total of the values in the array
     */
    public int getTotalNested() {
        int total = 0;
        for (int[] rowArray : matrix) {
            for (int item : rowArray) {
                total = total + item;
            }
        }
        return total;
    }

    /**
     * Method to fill the matrix with an increasing count, in row-by-row order
     */
    public void fillCount() {
        int numCols = matrix[0].length;
        int count = 1;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < numCols; col++) {
                matrix[row][col] = count;
                count++;
            }
        }
    }

    /**
     * fill the array with a pattern
     */
    public void fillPattern1() {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (row < col)
                    matrix[row][col] = 1;
                else if (row == col)
                    matrix[row][col] = 2;
                else
                    matrix[row][col] = 3;
            }
        }
    }

    /**
     * TODO: Activity 4, Exercise 1.
     * Method returning the count of the number of times a passed integer value is found in the matrix.
     * @param num - number to search for
     * @return the count of the number of times the number was found in the matrix.
     */
    public int getCount(int num) {
        throw new RuntimeException("Replace with your code for Activity 4, Exercise 1.");
    }

    /**
     * TODO: Activity 4, Exercise 2.
     * Method returning the largest value in the matrix.
     * @return the largest value in the matrix.
     */
    public int getLargest() {
        throw new RuntimeException("Replace with your code for Activity 4, Exercise 2.");
    }

    /**
     * TODO: Activity 4, Exercise 3.
     * Method returning the total of all integers in a specified column.
     * @param col - the column for which to calculate the total.
     * @return the total of all 
     */
    public int getColTotal(int col) {
        throw new RuntimeException("Replace with your code for Activity 4, Exercise 2.");
    }
}