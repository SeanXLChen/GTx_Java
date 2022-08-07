public class Cat extends Pet {
    // variables
    private int miceCaught;
    private static int DEFAULT_miceCaught = 0;

    public Cat(String name, double health, int painLevel) {
        this(name, health, painLevel, DEFAULT_miceCaught);
    }

    public Cat(String name, double health, int painLevel, int miceCaught) {
        super(name, health, painLevel);
        if (miceCaught < 0) {
            this.miceCaught = 0;
        } else {
            this.miceCaught = miceCaught;
        }
    }

    // getter
    public int getMiceCaught() {
        return miceCaught;
    }

    // method
    public int treat() {
        heal();
        if (miceCaught < 4) {
            return (int) (Math.ceil((this.getPainLevel() * 2) / this.getHealth()));
        } else if (miceCaught <= 7) {
            return (int) (Math.ceil(this.getPainLevel() / this.getHealth()));
        } else {
            return (int) (Math.ceil(this.getPainLevel() / (this.getHealth() * 2)));
        }
    }

    public void speak() {
        super.speak();
        if (miceCaught > 0) {
            String speakText = "meow ".repeat(this.getPainLevel());
            speakText = speakText.trim();
            if (this.getPainLevel() > 5) {
                System.out.println(speakText.toUpperCase());
            } else {
                System.out.println();
            }
        }
    }

    public boolean equals(Object o) {
        if (o instanceof Cat) {
            Cat c = (Cat) o;
            return this.getName() == c.getName() && this.miceCaught == c.getMiceCaught();
        }
        return false;
    }
}
