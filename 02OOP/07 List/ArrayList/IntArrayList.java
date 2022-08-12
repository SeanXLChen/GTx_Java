import java.util.ArrayList;

public class IntArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> scores = new ArrayList<>();
        scores.add(90); //autoboxing
        scores.add(95);
        scores.add(97);
        scores.add(86);
        scores.add(72);
        System.out.println(scores.toString());

        int sum = 0;
        for (Integer score : scores) { //for each loop
            sum += score; //autounboxing
        }
        System.out.println("Average points: " + sum/scores.size());
    }
}
