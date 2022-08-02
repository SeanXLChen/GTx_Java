public abstract class Canine {
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
    public abstract void groom();
}
