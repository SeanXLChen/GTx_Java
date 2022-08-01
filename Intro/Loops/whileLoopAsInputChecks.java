import java.util.Scanner;

public class whileLoopAsInputChecks {
    public static void main(String[] args) {
        
        final int MAX_TEMP = 140;
        final int MIN_PARK_TEMP = 70;
        final int MAX_PARK_TEMP = 90;

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a Fahrenheit value: ");
        int fahrenheit = input.nextInt();

        while (fahrenheit >= MAX_TEMP) {
            System.out.println("Error: value must be lower than " + MAX_TEMP);
            System.out.print("Retry: Enter a Fahrenheit value: ");
            fahrenheit = input.nextInt();
        }

        System.out.print("Enter a day of the week: ");
        String day = input.next();

        double celsius = (5.0/9) * (fahrenheit - 32);
        System.out.println(day + " Fahrenheit: " + fahrenheit);
    }
}
