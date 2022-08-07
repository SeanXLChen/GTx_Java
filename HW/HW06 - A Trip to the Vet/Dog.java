public class Dog extends Pet {
    // variables
    private double droolRate;

    private static double DEFAULT_droolRate = 5.0;

    public Dog(String name, double health, int painLevel) {
        this(name, health, painLevel, DEFAULT_droolRate);
    }

    public Dog(String name, double health, int painLevel, double droolRate) {
        super(name, health, painLevel);
        if (droolRate <= 0) {
            this.droolRate = 0.5;
        }
    }

    // getters
    public double getDroolRate() {
        return droolRate;
    }

    // methods
    public int treat() {
        heal();
        if (droolRate < 3.5) {
            return (int) (Math.ceil((this.getPainLevel() * 2) / this.getHealth()));
        } else if (droolRate <= 7.5) {
            return (int) (Math.ceil(this.getPainLevel() / this.getHealth()));
        } else {
            return (int) (Math.ceil(this.getPainLevel() / (this.getHealth() * 2)));
        }
    }

    public void speak() {
        super.speak();
        String speakText = "bark ".repeat(this.getPainLevel());
        speakText = speakText.trim();
        if (this.getPainLevel() > 5) {
            System.out.println(speakText.toUpperCase());
        } else {
            System.out.println(speakText);
        }
    }

    public boolean equals(Object o) {
        if (o instanceof Dog) {
            Dog d = (Dog) o;
            return this.getName() == d.getName() && this.droolRate == d.getDroolRate();
        }
        return false;
    }
}
