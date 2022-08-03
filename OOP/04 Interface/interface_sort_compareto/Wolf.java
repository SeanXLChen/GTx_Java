import java.util.Arrays;

public class Wolf extends Canine implements Groomable, Comparable {
    //instance variables
    protected int rank;

    //constructor
    public Wolf(double size, int rank) {
        //super constructor应该在第一行invoke
        super(size);
        this.rank = rank;
    }

    // methods
    public int getRank() {
        return rank;
    }

    public void bark() {    //3 times the default Canine bark
        for (int i = 0; i < 3; i++) {
            super.bark();
        }
    }

    public void groom() {
        System.out.println("lick~lick");
    }

    public int compareTo(Object anotherWolf) {
        return -(rank - ((Wolf)anotherWolf).rank);
    }

    public static void main(String[] args) {
        Wolf sean = new Wolf(180, 1);
        Wolf alpha = new Wolf(3, 5);
        sean.bark();
        System.out.println(alpha.compareTo(sean));;

        Wolf[] pack = {
            new Wolf(17.1, 2),
            new Wolf(16.5, 1),
            new Wolf(13, 3),
            new Wolf(16, 4),
            new Wolf(7, 5),
        };
        System.out.println("Unsorted Pack: " + Arrays.toString(pack));
        Arrays.sort(pack);
        System.out.println("========================");
        System.out.println("Sorted Pack: " + Arrays.toString(pack));
    }
}
