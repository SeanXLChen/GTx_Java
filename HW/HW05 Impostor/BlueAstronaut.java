import java.util.Arrays;

public class BlueAstronaut extends Player implements Crewmate {
    // instance variable
    private int numTasks;
    private int taskSpeed;
    private int firstReach = 0;

    // static variables
    private static int DEFAULT_susLevel = 15;
    private static int DEFAULT_numTasks = 6;
    private static int DEFAULT_taskSpeed = 10;

    // constructors
    public BlueAstronaut(String name, int DEFAULT_susLevel, int DEFAULT_numTasks, int DEFAULT_taskSpeed) {
        this(name, DEFAULT_susLevel, DEFAULT_numTasks, DEFAULT_taskSpeed);
    }

    public BlueAstronaut(String name, int susLevel, int numTasks, int taskSpeed) {

        super(name, susLevel);
        this.numTasks = numTasks;
        this.taskSpeed = taskSpeed;
    }

    // method
    public void emergencyMeeting() {
        if (!this.isFrozen()) {
            Player[] players = this.getPlayers();
            Arrays.sort(players);
            int first = players.length - 1;
            int second = 0;
            while (players[first].isFrozen()) {
                first--;
            }
            second = first - 1;
            while (players[second].isFrozen()) {
                second--;
            }
            if (players[first].getSusLevel() != players[second].getSusLevel()) {
                players[first].setFrozen(true);
            }
        }
        this.gameOver();
    }

    public void completeTask() {
        if (!this.isFrozen()) {

            if (this.taskSpeed > 20) {
                this.numTasks -= 2;
            } else {
                this.numTasks -= 1;
            }

            if (this.numTasks <= 0) {
                this.numTasks = 0;
                firstReach++;
            }
        }

        if (firstReach == 1) {
            System.out.println("I have completed all my tasks");
            this.setSusLevel((int) (this.getSusLevel() * 0.5));
        }
    }

    public boolean equals(Object o){
        if (o instanceof BlueAstronaut) {
            BlueAstronaut b = (BlueAstronaut)o;
            return this.name.equals(b.getName()) && this.isFrozen() == b.isFrozen() 
            && this.getSusLevel()==b.getSusLevel() && this.numTasks==b.numTasks 
            && this.taskSpeed==b.taskSpeed;
        }
    }

}