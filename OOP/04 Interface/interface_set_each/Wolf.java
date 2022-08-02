public class Wolf extends Canine implements Groomable {
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

    public static void main(String[] args) {
        Wolf sean = new Wolf(180, 1);
        sean.bark();
    }
}
