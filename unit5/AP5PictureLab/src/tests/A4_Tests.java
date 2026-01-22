package src.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import src.main.IntArrayWorker;

public class A4_Tests {
    /** Method to test setMatrix */
    @Test
    public void testSetMatrix() {
        IntArrayWorker worker = new IntArrayWorker();
        int[][] nums = { { 1, 1, 1 }, { 2, 2, 2 } };
        worker.setMatrix(nums);
        String expected = "1 1 1\n"
                        + "2 2 2\n";
        // worker should have all 1's on the first row and all 2's on the second
        assertEquals(expected, worker.toString());
    }

    /** Method to test fillPattern1 */
    @Test
    public void testFillPattern1() {
        IntArrayWorker worker = new IntArrayWorker();
        int[][] nums = new int[3][4];
        worker.setMatrix(nums);
        // fills with 2's on diagonal, 3's to left, and 1's to right
        worker.fillPattern1();
        String expected = "2 1 1 1\n"
                        + "3 2 1 1\n"
                        + "3 3 2 1\n";
        assertEquals(expected, worker.toString());
    }

    /** Method to test getTotal */
    @Test
    public void testGetTotal() {
        IntArrayWorker worker = new IntArrayWorker();
        int[][] nums2 = { { 1, 2, 3 }, { 4, 5, 6 } };
        worker.setMatrix(nums2);
        String expected = "1 2 3\n"
                        + "4 5 6\n";
        assertEquals(expected, worker.toString());
        int total = worker.getTotal();
        assertEquals(21, total);
    }

    /** Method to test getTotalNested */
    @Test
    public void testGetTotalNested() {
        IntArrayWorker worker = new IntArrayWorker();
        int[][] nums2 = { { 1, 2, 3 }, { 4, 5, 6 } };
        worker.setMatrix(nums2);
        String expected = "1 2 3\n"
                        + "4 5 6\n";
        assertEquals(expected, worker.toString());
        int total = worker.getTotalNested();
        assertEquals(21, total);
    }

    /** Method to test Activity 4, Exercise 1: getCount */
    @Test
    public void e1Test_getCount() {
        IntArrayWorker worker = new IntArrayWorker();
        int[][] nums = new int[3][4];
        worker.setMatrix(nums);
        // fills with 2's on diagonal, 3's to left, and 1's to right
        worker.fillPattern1();
        String expected = "2 1 1 1\n"
                        + "3 2 1 1\n"
                        + "3 3 2 1\n";
        assertEquals(expected, worker.toString());
        int count = worker.getCount(1);
        assertEquals(6, count);
        count = worker.getCount(2);
        assertEquals(3, count);
        count = worker.getCount(3);
        assertEquals(3, count);
    }

    /** Method to test Activity 4, Exercise 2: getLargest */
    @Test
    public void e2Test_getLargest() { 
        // test when largest is last
        IntArrayWorker worker = new IntArrayWorker();
        int[][] nums2 = { { 1, 2, 3 }, { 4, 5, 6 } };
        worker.setMatrix(nums2);
        String expected = "1 2 3\n"
                        + "4 5 6\n";
        assertEquals(expected, worker.toString());
        int largest = worker.getLargest();
        assertEquals(6, largest);
        // test when largest is first
        int[][] nums3 = { { 6, 2, 3 }, { 4, 5, 1 } };
        worker.setMatrix(nums3);
        expected = "6 2 3\n"
                +  "4 5 1\n";
        assertEquals(expected, worker.toString());
        largest = worker.getLargest();
        assertEquals(6, largest);
        // test when largest is in the middle
        int[][] nums4 = { { 1, 2, 3 }, { 6, 5, 1 } };
        worker.setMatrix(nums4);
        expected = "1 2 3\n"
                +  "6 5 1\n";
        assertEquals(expected, worker.toString());
        largest = worker.getLargest();
        assertEquals(6, largest);
        // test when duplicate largest
        int[][] nums5 = { { 6, 2, 6 }, { 4, 5, 1 } };
        worker.setMatrix(nums5);
        expected = "6 2 6\n"
                +  "4 5 1\n";
        assertEquals(expected, worker.toString());
        largest = worker.getLargest();
        assertEquals(6, largest);
    }

    /** Method to test getColTotal */
    @Test
    public void e3Test_getColTotal() {
        IntArrayWorker worker = new IntArrayWorker();
        int[][] nums2 = { { 1, 2, 3 }, { 4, 5, 6 } };
        worker.setMatrix(nums2);
        String expected = "1 2 3\n"
                        + "4 5 6\n";
        assertEquals(expected, worker.toString());
        int total = worker.getColTotal(0);
        // Total for column 0 should be 5 and is
        assertEquals(5, total);
        total = worker.getColTotal(1);
        // Total for column 1 should be 7 and is
        assertEquals(7, total);
        total = worker.getColTotal(2);
        assertEquals(9, total);
    }
}
