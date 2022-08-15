


//This class represents any pet that would seek consultation from the clinic.
public abstract class Pet {
    //instance variable
    private String name;
    private double health;
    private int painLevel;

    public Pet(String name, double health, int painLevel) {
        this.name = name;

        if (health > 1.0) {
            this.health = 1.0;
        }
        else if (health >= 0) {
            this.health = health;
        }
        else {
            this.health = 0.0;
        }

        if (painLevel > 10) {
            this.painLevel = 10;
        } 
        else if (painLevel >= 1) {
            this.painLevel = painLevel;
        }
        else {
            this.painLevel = 1;
        }
    }

    //getter methods
    public String getName() {
        return this.name;
    }

    public double getHealth() {
        return this.health;
    }

    public int getPainLevel() {
        return this.painLevel;
    }

    //methods
    public abstract int treat();

    public void speak() {
        String speak_text = String.format("Hello! My name is %s", this.name);
        if (painLevel > 5) {
            System.out.println(speak_text.toUpperCase());
        } else {
            System.out.println(speak_text);
        }
    }

    public boolean equals(Object o) {
        if (o instanceof Pet) {
            Pet p = (Pet)o;
            return this.name == p.getName();
        }
        return false;
    }

    protected void heal() {
        this.health = 1.0;
        this.painLevel = 1;
    }
}
