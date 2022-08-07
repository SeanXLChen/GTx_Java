public class Dog extends Canine {
    // instance variable (inheritance possible)
    protected String name;

    // constructor
    public Dog(String name, double size) {
        super(size);
        this.name = name;
    }

    public void fetch() {
        System.out.println("Run");
        System.out.println("Clinch");
        System.out.println("Return, WangWang!");
    }

    public boolean equals(Object o) {
        if (!(o instanceof Dog)) {
            return false;
        }
        Dog doggy = (Dog) o;
        return ((doggy.size == size) && (doggy.name.equals(name)));
    }


    public static void main(String[] args) {
        Dog riddle = new Dog("Riddle", 171);
        Dog riddleCopy = new Dog("Riddle", 175);
        riddle.bark();
        System.out.println(riddle.equals(riddleCopy));
    }

}
