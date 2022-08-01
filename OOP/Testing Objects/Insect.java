public class Insect {
    
    //instance variables
    private double weight;
    private int x;
    private int y;

    //static variables/constants
    public static final int DEFAULT_X = 0;
    public static final int DEFAULT_Y = 0;
    public static final double DIST_WEIGHT_LOSSS_FACTOR = .0001;
    private static int population = 0;
    private static final String[] FACTS = {
        "The two main groups of insects are winged and wingless",
        "There are more than 1 million insect species",
        "Insects are cold-blooded",
        "Spiders are not considered insects"
    };

    //constructor - default
    // public Insect(double initWeight) {
    //     weight = initWeight;
    //     x = DEFAULT_X;
    //     y = DEFAULT_Y;
    //     population++;
    // }

    //constructor - default (call the next constructor)
    public Insect(double initWeight) {
        this(initWeight, DEFAULT_X, DEFAULT_Y);
    }

    //constructor - overload
    public Insect(double weight, int x, int y) {
        this.weight = weight;
        this.x = x;
        this.y = y;
        population++;
    }

    //Getter method for instance variable weight
    public double getWeight() {
        return weight;
    }

    //Getter method for instance variable X
    public int getX() {
        return x;
    }

    //Setter method for instance variable X
    public void setX(int x) {
        if (isLegalX(x)) {
            this.x = x;
        }
    }

    //Getter method for instance variable Y
    public int getY() {
        return y;
    }

    //Setter method for instance variable X
    public void setY(int y) {
        if (isLegalX(y)) {
            this.x = y;
        }
    }

    //Getter method for static variable
    public static int getPopulation() {
        return population;
    }

    //method - eat
    public void eat(double amount) {
        System.out.println("Nibble Nibble");
        weight = weight + amount;
    }

    //methods - move
    public void move(int newX, int newY) {
        double distance = calculateDistance(x, y, newX, newY);
        if (distance > 0) {
            x = newX;
            y = newY;
            weight = weight * DIST_WEIGHT_LOSSS_FACTOR * distance;
            System.out.printf("Moved %.2f units\n", distance);
        }
        else
            System.out.println("Staying put");
    }

    //static method (helper)
    private static double calculateDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt((y2-y1)*(y2-y1) + (x2-x1)*(x2-x1));
    }

    //static method (helper)
    public static String produceRandomFact() {
        int index = (int)(Math.random() * ((FACTS.length - 1) + 1));
        return FACTS[index];
    }

    //static method (helper)
    public static boolean isLegalX(int newX) {
        return (newX >=0 ? true : false);
    }

    //static method (helper)
    public static boolean isLegalY(int newY) {
        return (newY >=0 ? true : false);
    }

    //main
    public static void main(String[] args) {
        System.out.println("Insect Population: " + population);
        Insect bug1 = new Insect(200, 3, 6);
        System.out.println("Insect Population: " + population);
        Insect bug2 = new Insect(232, 3, 3);
        System.out.println("Insect Population: " + population);

        System.out.println(produceRandomFact());
    }
}
