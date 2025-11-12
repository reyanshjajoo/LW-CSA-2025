package unit2;
public class ParamterPractice {
    public static void main(String args[]){
        drawBox(3, 5);
    }
    /**
     * Draws string multiple times
     * @param reps <-- Times to draw the string
     * @param str <-- The string to repeat
     */
    public static void drawNStr(int reps, String str){
        for (int i=0; i<reps; i++){
            System.out.print(str);
        }
    }

    /**
     * Draw a box
     * @param width <-- Width of the box
     * @param height <--- Height of the box
     */
    public static void drawBox(int width, int height){
        drawNStr(width, "*");
        System.out.println();
        
        for (int i=0; i<height-2; i++){
            System.out.print("*");
            drawNStr(width-2, " ");
            System.out.print("*");
            System.out.println();
        }

        drawNStr(width, "*");
    }
}
