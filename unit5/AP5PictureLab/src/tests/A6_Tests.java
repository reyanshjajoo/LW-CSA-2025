package src.tests;

import org.junit.jupiter.api.Test;

import src.main.Picture;

public class A6_Tests {
    /** Method to test mirrorVertical */
    @Test
    public void testMirrorVertical()
    {
        Picture caterpillar = new Picture("images/caterpillar.jpg");
        caterpillar.explore(false);
        caterpillar.mirrorVertical();
        caterpillar.explore();
    }

    /** Method to test mirrorVerticalRightToLeft */
    @Test
    public void e1Test_mirrorVerticalRightToLeft() {
        Picture retMotor = new Picture("images/redMotorcycle.jpg");
        retMotor.explore(false);
        retMotor.mirrorVerticalRightToLeft();
        retMotor.explore();
    }

    /** Method to test mirrorHorizontal */
    @Test
    public void e2Test_mirrorHorizontal() {
        Picture retMotor = new Picture("images/redMotorcycle.jpg");
        retMotor.explore(false);
        retMotor.mirrorHorizontal();
        retMotor.explore();
    }

    /** Method to test mirrorHorizontal */
    @Test
    public void e3Test_mirrorHorizontalBotToTop() {
        Picture retMotor = new Picture("images/redMotorcycle.jpg");
        retMotor.explore(false);
        retMotor.mirrorHorizontalBotToTop();
        retMotor.explore();
    }

    /** Method to test mirrorHorizontal */
    @Test
    public void e4Test_mirrorDiagonal() {
        Picture retMotor = new Picture("images/beach.jpg");
        retMotor.explore(false);
        retMotor.mirrorDiagonal();
        retMotor.explore();
    }
}
