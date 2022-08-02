public class Fly {
    
    // instance variables
    private double mass;
    private double speed;

    //static variables/constants
    public static final double DEFAULT_MASS = 5;
    public static final double DEFAULT_SPEED = 10;

    //constructor
    public Fly() {
        this(DEFAULT_MASS, DEFAULT_SPEED);
    }

    //constructor
    public Fly(double mass) {
        this(mass, DEFAULT_SPEED);
    }

    //constructor-full
    public Fly(double mass, double speed) {
        this.mass = mass;
        this.speed = speed;
    }

    //Setter & Getter Methods
    public double getMass() {
        return mass;
    }

    public double getSpeed() {
        return speed;
    }

    //!!!need to add more validation lateer!!!
    public void setMass(double mass) {
            this.mass = mass;
    }

    public void setSpeed(double speed) {
            this.speed = speed;
    }

    // methods
    public String toString() {
        if (this.mass == 0) {
            return String.format("I’m dead, but I used to be a fly with a speed of %.2f.", this.speed);
        } else {
            return String.format("I’m a speedy fly with %.2f speed and %.2f mass.", this.speed, this.mass);
        }
    }

    public void grow(int massAdd) {
        for (int i = 0; i < massAdd; i++) {
            if (this.mass < 20) {
                this.mass+=1;
                this.speed++;
            } else {
                this.mass+=1;
                this.speed-=0.5;
            }
        }
    }

    public boolean isDead() {
        if (this.mass == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        
    }
}
