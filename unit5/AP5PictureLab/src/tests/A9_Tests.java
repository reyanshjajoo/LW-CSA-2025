package src.tests;

import org.junit.jupiter.api.Test;

import src.main.Picture;

public class A9_Tests {
    /** Method to test edgeDetection */
    @Test
    public void testEdgeDetection() {
        Picture swan = new Picture("images/swan.jpg");
        swan.explore(false);
        swan.edgeDetection(10);
        swan.explore();
    }

    /** Method to test edgeDetection2 */
    @Test
    public void e2Test_edgeDetection2() {
        Picture image = new Picture("images/thrudoor.jpg");
        image.explore(false);
        image.edgeDetection2(20);
        image.explore();
    }
}
