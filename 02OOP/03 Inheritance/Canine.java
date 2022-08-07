public class Canine {
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

    //method
    public void groom() {
        System.out.println("Canine Default Grooming");
    }
}
