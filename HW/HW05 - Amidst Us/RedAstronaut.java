import java.util.Arrays;

public class RedAstronaut extends Player implements Impostor {
    // variables
    private String skill;

    // static variables
    private static String DEFAULT_skill = "experienced";
    private static int DEFAULT_susLevel = 15;

    public RedAstronaut(String name) {
        this(name, DEFAULT_susLevel, DEFAULT_skill);
    }

    public RedAstronaut(String name, int susLevel, String skill) {
        super(name, susLevel);
        this.skill = skill.toLowerCase();
    }

    // method
    public void emergencyMeeting() {
        if (!this.isFrozen()) {
            Player[] players = this.getPlayers();
            Arrays.sort(players);
            int first = players.length - 1;
            int second = 0;
            while (players[first].isFrozen() || this.equals(players[first])) {
                first--;
            }
            second = first - 1;
            while (players[second].isFrozen() || this.equals(players[first])) {
                second--;
            }
            if (players[first].getSusLevel() != players[second].getSusLevel()) {
                players[first].setFrozen(true);
            }
        }
        this.gameOver();
    }

    public void freeze(Player p) {
        if (!(p instanceof Impostor) && !p.isFrozen()) {
            if (this.compareTo(p) < 0) {
                p.setFrozen(true);
            } else {
                this.setSusLevel(this.getSusLevel() * 2);
            }
            this.gameOver();
        }
    }

    public void sabotage(Player p) {
        if (!(p instanceof Impostor) && !this.isFrozen() && !p.isFrozen()) {
            if (this.getSusLevel() < 20) {
                p.setSusLevel((int) (p.getSusLevel() * 1.5));
            } else {
                p.setSusLevel((int) (p.getSusLevel() * 1.25));
            }
        }
    }

    public boolean equals(Object o) {
        if (o instanceof RedAstronaut) {
            RedAstronaut r = (RedAstronaut) o;
            return this.getName().equals(r.getName()) && this.isFrozen() == r.isFrozen()
                    && this.getSusLevel() == r.getSusLevel();
        }
        return false;
    }

    public String toString() {
        String output = super.toString() + " I am an " + this.skill + " player!";
        if (this.getSusLevel() > 15) {
            return output.toUpperCase();
        } else {
            return output;
        }
    }

}
