public class Frog {
    //instance variables
    private String name;
    private int age;
    private double tongueSpeed;
    //Whenever age is changed, this variable must be updated accordingly.
    private boolean isFroglet = false;
    
    //static variable
    private static String species = "Rare Pepe";
    public static final int DEFAULT_AGE = 5;
    public static final double DEFAULT_TONGUESPEED = 5;

    //constructors
    public Frog(String name) {
        this(name, DEFAULT_AGE, DEFAULT_TONGUESPEED);
    }

    public Frog(String name, double ageInYears, double tongueSpeed) {
        this(name, (int)(ageInYears * 12), tongueSpeed);
    }

    public Frog(String name, int age, double tongueSpeed) {
        this.name = name;
        this.age = age;
        this.tongueSpeed = tongueSpeed;
    }

    //getter & setter for species
    public String getSpecies() {
        return species;
    }

    public void setSpecies(String newName) {
        species = newName;
    }

    //method
    private boolean isFroglet() {
        if (this.age > 1 && this.age < 7) {
            isFroglet = true;
            return isFroglet;
        } else {
            isFroglet = false;
            return isFroglet;
        }
    }

    public void grow(int ageAdd) {
        for (int i = 0; i < ageAdd; i++) {
            if (this.age < 12) {
                if (this.age > 1 && this.age < 7) {
                    this.isFroglet = true;
                    this.age++;
                    this.tongueSpeed++;
                } else {
                    this.isFroglet = false;
                    this.age++;
                    this.tongueSpeed++;
                }
            } 
            // else if (this.age < 30) {
            //     this.age++;
            // }
            else if (this.age >= 30 && this.tongueSpeed > 5) {
                this.age++;
                this.tongueSpeed--;
            } 
            else {
                this.age++;
            }
        }
    }

    public void grow() {
        if (this.age < 12) {
            if (this.isFroglet()) {
                this.age++;
                this.tongueSpeed++;
            } else {
                this.age++;
                this.tongueSpeed++;
            }
        } 
        else if (this.age > 30 && this.tongueSpeed > 5) {
            this.age++;
            this.tongueSpeed--;
        } 
        else {
            this.age++;
        }
    }

    public void eat(Fly fly) {
        if (fly.isDead() == false) {
            if (this.tongueSpeed > fly.getSpeed()) {
                if (fly.getMass() > this.age * 0.5 ) {
                    this.grow();
                    fly.setMass(0);
                } else {
                    fly.setMass(0);
                }
            } else {
                fly.grow(1);
            }
        } 
    }

    public String toString() {
        if (this.isFroglet()) {
            return String.format("My name is %s and I’m a rare froglet! I’m %d months old and my tongue has a speed of %.2f.", this.name, this.age, this.tongueSpeed);
        } else {
            return String.format("My name is %s and I’m a rare frog. I’m %d months old and my tongue has a speed of %.2f.", this.name, this.age, this.tongueSpeed);
        }
    }

    public static void main(String[] args) {
    }
}
