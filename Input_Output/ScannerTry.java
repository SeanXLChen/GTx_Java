import java.util;
public class ScannerTry {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a F value and day of the week: ");
        int fa = input.nextInt();

        //Use trim() method to clean the leading space
        String day = input.nextLine().trim();
        double cel = (5.0/9) * (fa - 32);
        System.out.println(day + " Fahrenheit: " + fa);
        System.out.println(day + " Celsius: " + cel);
    }
}
