import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("List of operations: add subtract multiply divide alphabetize");
        System.out.println("Enter an operation:");
        String operation = input.next().toLowerCase();

        int operationNum = 0;
        if (operation.compareTo("add") == 0) {
            operationNum = 1;
        } else if (operation.compareTo("subtract") == 0) {
            operationNum = 2;
        } else if (operation.compareTo("multiply") == 0) {
            operationNum = 3;
        } else if (operation.compareTo("divide") == 0) {
            operationNum = 4;
        } else if (operation.compareTo("alphabetize") == 0) {
            operationNum = 5;
        } else {
            operationNum = 6;
        }

        switch (operationNum) {
            case 1:
                System.out.println("Enter two integers:");
                // check if input is int
                try {
                    int int1 = input.nextInt();
                    int int2 = input.nextInt();
                    int total = int1 + int2;
                    System.out.println("Answer: " + total);
                } catch (Exception e) {
                    System.out.println("Invalid input entered. Terminating...");
                }
                break;
            case 2:
                System.out.println("Enter two integers:");
                // check if input is int
                try {
                    int int1 = input.nextInt();
                    int int2 = input.nextInt();
                    int total = int1 - int2;
                    System.out.println("Answer: " + total);
                } catch (Exception e) {
                    System.out.println("Invalid input entered. Terminating...");
                }
                break;
            case 3:
                System.out.println("Enter two doubles:");
                // check if input is int
                try {
                    double d1 = input.nextDouble();
                    double d2 = input.nextDouble();
                    double total = d1 * d2;
                    System.out.printf("Answer: %.2f", total);
                } catch (Exception e) {
                    System.out.println("Invalid input entered. Terminating...");
                }
                break;
            case 4:
                System.out.println("Enter two doubles:");
                // check if input is int
                try {
                    double d1 = input.nextDouble();
                    double d2 = input.nextDouble();
                    if (d2 == 0) {
                        throw new Exception("value can't be zero!");
                    }
                    double total = d1 / d2;
                    System.out.printf("Answer: %.2f", total);
                } catch (Exception e) {
                    System.out.println("Invalid input entered. Terminating...");
                }
                break;
            case 5:
                System.out.println("Enter two words:");
                // check if input is int
                try {
                    String s1 = input.next();
                    String s2 = input.next();
                    int result = s1.toLowerCase().compareTo(s2.toLowerCase());
                    if (result == 0) {
                        System.out.println("Answer: Chicken or Egg.");
                    } else if (result > 0) {
                        System.out.println("Answer: " + s2 + " comes before " + s1 + " alphabetically.");
                    } else {
                        System.out.println("Answer: " + s1 + " comes before " + s2 + " alphabetically.");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input entered. Terminating...");
                }
                break;
            default:
                // incorrect operation input
                System.out.println("Invalid input entered. Terminating...");
                break;
        }
    }
}

// // correct enter
// if (operation.compareTo("add") == 0
// || operation.compareTo("subtract") == 0
// || operation.compareTo("multiply") == 0
// || operation.compareTo("divide") == 0
// || operation.compareTo("alphabetize") == 0) {

// // add
// if (operation.compareTo("add") == 0) {
// System.out.println("Enter two integers:");
// // check if input is int
// try {
// int int1 = input.nextInt();
// int int2 = input.nextInt();
// int total = int1 + int2;
// System.out.println("Answer: " + total);
// } catch (Exception e) {
// System.out.println("Invalid input entered. Terminating...");
// }
// } else if (operation.compareTo("subtract") == 0) {
// System.out.println("Enter two integers:");
// // check if input is int
// try {
// int int1 = input.nextInt();
// int int2 = input.nextInt();
// int total = int1 - int2;
// System.out.printf("Answer: %.2f", total);
// } catch (Exception e) {
// System.out.println("Invalid input entered. Terminating...");
// }
// } else if (operation.compareTo("divide") == 0) {
// System.out.println("Enter two doubles:");
// // check if input is int
// try {
// double d1 = input.nextInt();
// double d2 = input.nextInt();
// if (d2 == 0) {
// throw new Exception("value can't be zero!");
// }
// double total = d1 / d2;
// System.out.printf("Answer: %.2f", total);
// } catch (Exception e) {
// System.out.println("Invalid input entered. Terminating...");
// }
// } else if (operation.compareTo("multiply") == 0) {
// System.out.println("Enter two doubles:");
// // check if input is int
// try {
// double d1 = input.nextInt();
// double d2 = input.nextInt();
// double total = d1 * d2;
// System.out.println("Answer: " + total);
// } catch (Exception e) {
// System.out.println("Invalid input entered. Terminating...");
// }
// } else if (operation.compareTo("alphabetize") == 0) {
// System.out.println("Enter two words:");
// // check if input is int
// try {
// String s1 = input.next();
// String s2 = input.next();
// int result = s1.toLowerCase().compareTo(s2.toLowerCase());
// if (result == 0) {
// System.out.println("Answer: Chicken or Egg.");
// } else if (result > 0) {
// System.out.println("Answer: " + s2 + " comes before " + s1 + "
// alphabetically.");
// } else {
// System.out.println("Answer: " + s1 + " comes before " + s2 + "
// alphabetically.");
// }
// } catch (Exception e) {
// System.out.println("Invalid input entered. Terminating...");
// }
// }
// }
// // incorrect operation input
// else {
// System.out.println("Invalid input entered. Terminating...");
// }
// }
// }
