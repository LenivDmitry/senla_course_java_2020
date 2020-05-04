package task_1;

import java.util.Scanner;

public class NumberDescription {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter integer number and press \"Enter\": ");

        if (scanner.hasNextInt()) {
            int numberOfUser = scanner.nextInt();
            System.out.println(checkEvenOdd(numberOfUser));
            System.out.println(checkPrimeComposite(numberOfUser));
        } else {
            System.out.println("You didn't enter an integer number.");
        }
    }

    private static String checkEvenOdd(int number) {
        if (number % 2 == 0) {
            return number + " is even number";
        } else {
            return number + " is odd number";
        }
    }

    private static String checkPrimeComposite(int number) {
        if (number < 2) {
            return number + " does not apply to prime and composite number";
        } else {
            for (int tmp = 2; tmp * tmp <= number; tmp++) {
                if (number % tmp == 0) {
                    return number + " is composite number";
                }
            }
            return number + " is prime number";
        }
    }
}





