import java.util.InputMismatchException;
import java.util.Scanner;

public class ftocExceptions {
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            boolean success = false;
            int fahrenheit = 0;

            while (!success) {
                try {
                    System.out.print("Enter a Fahrenheit value: ");
                    fahrenheit = input.nextInt();
                    success = true;
                } catch (InputMismatchException e) {
                    //吸收掉user输入时候的换行
                    input.nextLine();
                    System.out.println("Sorry, that wasn't a int");
                    System.out.println("Please try again");
                }
            }

            double celsius = (5.0 / 9) * (fahrenheit - 32);
            System.out.printf("Fahrenheit: %d\n", fahrenheit);
            System.out.printf("Celsius:    %.1f\n", celsius);
        }
}
