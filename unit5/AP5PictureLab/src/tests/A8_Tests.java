package src.tests;

import org.junit.jupiter.api.Test;

import src.main.Picture;

public class A8_Tests {
    /** Method to test the collage method */
    @Test
    public void testCollage() {
        Picture canvas = new Picture("images/640x480.jpg");
        canvas.createCollage();
        canvas.explore();
    }

    /** Method to test the copy method */
    @Test
    public void e1Test_copy() {
        Picture canvas = new Picture("images/640x480.jpg");
        Picture fromPic = new Picture("images/seagull.jpg");
        fromPic.explore(false);
        canvas.copy(fromPic, 220, 330, 220, 350, 400, 600);
        canvas.copy(fromPic, 220, 330, 220, 350, 0, 0);
        canvas.explore();
    }

    /** Method to test myCollage method */
    @Test
    public void e2Test_myCollage() {
        Picture canvas = new Picture("images/640x480.jpg");
        canvas.myCollage();
        canvas.explore();
    }
}
