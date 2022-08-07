public abstract class Canine implements Groomable {
    //instance variable
    protected double size;
    
    //constructor
    public Canine(double size) {
        this.size = size;
    }

    //method
    public void bark() {
        System.out.println("Woof Woof");
    }
}
