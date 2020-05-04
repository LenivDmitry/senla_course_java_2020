package task_3;

import java.util.Arrays;
import java.util.Scanner;

public class WordCounting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your sentence: ");
        String sentenceOfUser = scanner.nextLine();
        String[] sortedWords = getSortedWords(sentenceOfUser);

        System.out.println("Sentence has " +
                sortedWords.length
                + " words");
        System.out.println(getFormattedResult(sortedWords));
    }

    private static String[] getSortedWords(String sentence) {
        String[] words = sentence.trim()
                .replaceAll("[^а-яёА-ЯЁa-zA-Z\\s]", " ")
                .split("\\s+");
        for (int index = 0; index < words.length; index++) {
            words[index] = firstUpperCase(words[index]);
        }
        Arrays.sort(words);
        return words;
    }

    private static String firstUpperCase(String word) {
        return word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
    }

    private static String getFormattedResult(String[] data) {
        String formattedResult = "";
        for (String word : data) {
            formattedResult += (word + " ");
        }
        return formattedResult.trim();
    }
}
