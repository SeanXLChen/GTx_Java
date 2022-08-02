import java.util.Random;

public class Die {
    
    // declare static variables
    public static final int SIDES = 6;

    // declare instance variables
    private int faceValue;
    private Random rand;

    // constructor
    public Die() {
        // default faceValue int is 0 which is invalid logically
        faceValue = 1;
        rand = new Random();
    }

    public int roll() {
        faceValue = rand.nextInt(SIDES) + 1;
        return faceValue;

                /* We could also use the Math.random method
                   low + (int)(Math.random() * ((high - low) + 1))
                 */
    }

    public int getFaceValue() {
        return faceValue;
    }

    public String toString() {
        return "Die with face value: " + faceValue;
    }

    public static void main(String[] args) {

    }
}
