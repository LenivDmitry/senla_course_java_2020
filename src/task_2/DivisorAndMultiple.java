package task_2;

import java.util.Scanner;

public class DivisorAndMultiple {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstNumber, secondNumber;
        System.out.println("Enter two integer numbers");

        if (scanner.hasNextInt()) {
            firstNumber = scanner.nextInt();
            secondNumber = scanner.nextInt();
            if (firstNumber == 0 & secondNumber == 0) {
                System.out.println("You didn't enter an integer number.");
            } else {
                System.out.println("Greatest common divisor is " +
                        Math.abs(greatestCommonDivisor(firstNumber, secondNumber)));
                System.out.println("Least common multiple is " +
                        Math.abs(leastCommonMultiple(firstNumber, secondNumber)));
            }
        } else {
            System.out.println("You didn't enter an integer number.");
        }
    }

    private static int greatestCommonDivisor(int firstNumber, int secondNumber) {
        // by Euclidean Algorithm
        if (secondNumber == 0) {
            return firstNumber;
        } else {
            return greatestCommonDivisor(secondNumber, firstNumber % secondNumber);
        }
    }

    private static int leastCommonMultiple(int firstNumber, int secondNumber) {
        return firstNumber / greatestCommonDivisor(firstNumber, secondNumber) * secondNumber;
    }
}
