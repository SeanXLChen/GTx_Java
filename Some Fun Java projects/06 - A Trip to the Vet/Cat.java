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
        int time;
        if (miceCaught < 4) {
            time= (int) (Math.ceil((this.getPainLevel() * 2) / this.getHealth()));
        } else if (miceCaught <= 7) {
            time= (int) (Math.ceil(this.getPainLevel() / this.getHealth()));
        } else {
            time= (int) (Math.ceil(this.getPainLevel() / (this.getHealth() * 2)));
        }
        heal();
        return time;
    }

    public void speak() {
        super.speak();
        if (miceCaught > 0) {
            String speakText = "meow ".repeat(this.getPainLevel());
            speakText = speakText.trim();
            if (this.getPainLevel() > 5) {
                System.out.println(speakText.toUpperCase());
            } else {
                System.out.println(speakText);
            }
        }
    }

    public boolean equals(Object o) {
            return super.equals(o) && this.miceCaught == ((Cat)o).miceCaught;
    }
}
