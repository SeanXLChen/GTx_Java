public class Dog extends Pet {
    // variables
    private double droolRate;


    public Dog(String name, double health, int painLevel) {
        this(name, health, painLevel, 5.0);
    }

    public Dog(String name, double health, int painLevel, double droolRate) {
        super(name, health, painLevel);
        if (droolRate <= 0) {
            this.droolRate = 0.5;
        } else {
            this.droolRate = droolRate;
        }
    }

    // getters
    public double getDroolRate() {
        return droolRate;
    }

    // methods
    public int treat() {
        int time;
        if (droolRate < 3.5) {
            time =  (int) (Math.ceil((this.getPainLevel() * 2) / this.getHealth()));
        } else if (droolRate <= 7.5) {
            time =  (int) (Math.ceil(this.getPainLevel() / this.getHealth()));
        } else {
            time = (int) (Math.ceil(this.getPainLevel() / (this.getHealth() * 2)));
        }
        heal();
        return time;
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
        return super.equals(o) && this.droolRate == ((Dog)o).droolRate;
    }
}
