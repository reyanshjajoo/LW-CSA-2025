/**
 * Project 1: This Program will print out a song: "There was an old woman who swallowed a fly"
 * @author Reyansh Jajoo
 * @date: 9-17-2025
 * @period: 3
 */

package unit1;

public class Song {
    public static void main(String[] args){
        verse1();
        verse2();
        verse3();
        verse4();
        verse5();
        verse6();
        verse7();
    }

    /**
     *  Repeated lines for swalling fly
     *  Called in verse 1
     */
    public static void swallowedFly(){
        System.out.println("I don't know why she swallowed that fly,");
        System.out.println("Perhaps she'll die.\n");
    }
    /**
     *  Repeated lines for swalling spider
     *  Called in verse 2
     */
    public static void swallowedSpider(){
        System.out.println("She swallowed the spider to catch the fly,");
        swallowedFly();
    }

    /**
     *  Repeated lines for swalling bird
     *  Called in verse 3
     */
    public static void swallowedBird(){
        System.out.println("She swallowed the bird to catch the spider,");
        swallowedSpider();
    }

    /**
     *  Repeated lines for swalling cat
     *  Called in verse 4
     */
    public static void swallowedCat(){
        System.out.println("She swallowed the cat to catch the bird,");
        swallowedBird();
    }

    /**
     *  Repeated lines for swalling dog
     *  Called in verse 5
     */
    public static void swallowedDog(){
        System.out.println("She swallowed the dog to catch the cat,");
        swallowedCat();
    }

    /**
     *  Repeated lines for swalling bull
     *  Called in verse 6
     */
    public static void swallowedBull(){
        System.out.println("She swallowed the bull to catch the dog,");
        swallowedCat();
    }

    /**
     *  Verse for swallowing fly
     */
    public static void verse1(){
        System.out.println("There was an old woman who swallowed a fly.");
        swallowedFly();
    }

    /**
     *  Verse for swallowing spider
     */
    public static void verse2(){
        System.out.println("There was an old woman who swallowed a spider,");
        System.out.println("That wiggled and iggled and jiggled inside her.");
        swallowedSpider();
    }

    /**
     *  Verse for swallowing bird
     */
    public static void verse3(){
        System.out.println("There was an old woman who swallowed a bird,");
        System.out.println("How absurd to swallow a bird.");
        swallowedBird();
    }

    /**
     *  Verse for swallowing cat
     */
    public static void verse4(){
        System.out.println("There was an old woman who swallowed a cat,");
        System.out.println("Imagine that to swallow a cat.");
        swallowedCat();
    }

    /**
     *  Verse for swallowing dog
     */
    public static void verse5(){
        System.out.println("There was an old woman who swallowed a dog,");
        System.out.println("What a hog to swallow a dog.");
        swallowedDog();
    }

    /**
     *  Verse for swallowing bull
     */
    public static void verse6(){
        System.out.println("There was an old woman who swallowed a bull,");
        System.out.println("What a handfull to swallow a bull.");
        swallowedBull();
    }

    /**
     *  Verse for swallowing horse
     */
    public static void verse7(){
        System.out.println("There was an old woman who swallowed a horse, She");
        System.out.println("died of course.");
    }
}
