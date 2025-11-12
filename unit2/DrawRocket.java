package unit2;

/**
 * Project 2: This program will print out ASCII art and a rocket ship
 * @author Reyansh Jajoo
 * @date: 10-1-2025
 * @period: 3
 */

public class DrawRocket {
    // Controls how tall each section of the rocket is
    public static final int SIZE = 3;
    /**
     * Draws the ASCII art and rocket ship with some spacing in between
     */
    public static void main(String[] args){
        asciiDrawing();
        System.out.println("\n\n\n");
        rocketShip();
    }

    /**
     * Controls the order in which rocket parts are drawn
     */
    public static void rocketShip(){
        triangle();
        border();
        sectionOne();
        sectionTwo();
        border();
        sectionTwo();
        sectionOne();
        border();
        triangle();
    }

    /**
     * Prints an ASCII drawing of a face
     */
    public static void asciiDrawing(){
        System.out.println("   __________");
        System.out.println("  /          \\");
        System.out.println(" /  _      _  \\");
        System.out.println("|  |_|    |_|  |");
        System.out.println("|              |");
        System.out.println("|   |      |   |");
        System.out.println("|    \\____/    |");
        System.out.println(" \\            /");
        System.out.println("  \\__________/");
    }

    /**
     * Draws the triangle at the top and bottom of the rocket
     */
    public static void triangle(){
        for (int i=1; i < SIZE*2; i++){
            for (int j=0; j < 2*SIZE-i; j++){
                System.out.print(" ");
            }
            for (int j=0; j < i; j++){
                System.out.print("/");
            }
            System.out.print("**");
            for (int j=0; j < i; j++){
                System.out.print("\\");
            }
            System.out.println();
        }
    }

    /**
     * Draws the border between sections of the rocket
     */
    public static void border(){
        System.out.print("+");
        for (int i=0; i<SIZE*2; i++){
                System.out.print("=*");
        }
        System.out.print("+");
        System.out.println();
    }

    /**
     * Draws the first subsection of the rocket
     */
    public static void sectionOne(){
        for (int i=1; i<SIZE+1; i++){
            System.out.print("|");
            for (int j=0; j < SIZE-i; j++){
                System.out.print(".");
            }
            for (int j=0; j < i; j++){
                System.out.print("/\\");
            }
            for (int j=0; j < (SIZE-i)*2; j++){
                System.out.print(".");
            }
            for (int j=0; j < i; j++){
                System.out.print("/\\");
            }
            for (int j=0; j < SIZE-i; j++){
                System.out.print(".");
            }
            System.out.print("|");
            System.out.println();
        }    
    }

    /**
     * Draws the second subsection of the rocket
     */
    public static void sectionTwo(){
        for (int i=SIZE; i>0; i--){
            System.out.print("|");
            for (int j=0; j < SIZE-i; j++){
                System.out.print(".");
            }
            for (int j=0; j < i; j++){
                System.out.print("\\/");
            }
            for (int j=0; j < (SIZE-i)*2; j++){
                System.out.print(".");
            }
            for (int j=0; j < i; j++){
                System.out.print("\\/");
            }
            for (int j=0; j < SIZE-i; j++){
                System.out.print(".");
            }
            System.out.print("|");
            System.out.println();
        }
    }
}
    