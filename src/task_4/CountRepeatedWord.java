package task_4;

import java.util.Scanner;

public class CountRepeatedWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your sentence");
        String sentence = scanner.nextLine();

        System.out.println("Enter a word for counting repetitions");
        String wordForCounting = scanner.nextLine();

        int numberOfRepeatedWord = searchWord(sentence, wordForCounting);

        System.out.println("Your word repeated " + numberOfRepeatedWord + " times");
    }

    public static int searchWord(String sentence, String word) {
        String[] words = sentence.trim()
                .split("\\s+");
        word = word.trim();
        int counter = 0;
        for (String wordOfSentence : words) {
            if (word.equalsIgnoreCase(wordOfSentence)) {
                counter++;
            }
        }
        return counter;
    }
}
