
public class Averager {
    public static void main(String[] args) {
        double sum = 0;
        // iterate / convert each String to double
        for (String arg : args) {
            sum += Double.parseDouble(arg);
        }
        double average;
        if (args.length > 0) {
            average = sum / args.length;
        } else {
            average = (double) 0;
        }
        System.out.println("Average is: " + average);
    }
}
