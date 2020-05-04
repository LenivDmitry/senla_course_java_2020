package task_5;

import java.util.Scanner;

public class SearchPalindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter sequence length from 0 to 100");

        if (scanner.hasNextInt()) {
            int sequenceLength = scanner.nextInt();
            if (sequenceLength >= 0 & sequenceLength <= 100) {
                System.out.println("Number of palindromes = " + getCountOfPalindromes(sequenceLength));
            } else {
                System.out.println("You didn't enter from 0 to 100");
            }
        } else {
            System.out.println("You didn't enter from 0 to 100");
        }
    }

    private static int getCountOfPalindromes(int sequenceLength) {
        int counter = 0;
        for (int currentNumber = 0; currentNumber <= sequenceLength; currentNumber++) {
            if (isPalindrome(currentNumber)) {
                counter++;
            }
        }
        return counter;
    }

    private static boolean isPalindrome(int number) {
        String numberAsString = String.valueOf(number);
        int leftIndex = 0;
        int rightIndex = numberAsString.length() - 1;

        while (rightIndex > leftIndex) {
            if (numberAsString.charAt(leftIndex) != numberAsString.charAt(rightIndex)) {
                return false;
            }
            leftIndex++;
            rightIndex--;
        }
        return true;
    }
}
