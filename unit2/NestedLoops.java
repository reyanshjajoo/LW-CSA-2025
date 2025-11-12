package unit2;

public class NestedLoops {
    public static void main(String[] args){
        test1();
    }
    public static void test1(){
        for (int i = 1; i <= 5; i++){
            for (int j = 1; j <= i; j++) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
