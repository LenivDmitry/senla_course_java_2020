package task_6;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BackpackFilling {
    public static void main(String[] args) {
        int backpackCapacity = -1;
        int numberOfItems = -1;

        while (backpackCapacity <= 0) {
            System.out.println("Enter integer number is backpack capacity:");
            backpackCapacity = checkInputOnPositiveInt();
        }
        while (numberOfItems <= 0) {
            System.out.println("Enter number of items:");
            numberOfItems = checkInputOnPositiveInt();
        }

        Item[] items = new Item[numberOfItems];
        for (int i = 0; i < numberOfItems; i++) {
            int weightOfItem = -1;
            int valueOfItem = -1;

            while (weightOfItem <= 0) {
                System.out.println("Enter weight " + (i + 1) + " item: ");
                weightOfItem = checkInputOnPositiveInt();
            }
            while (valueOfItem < 0) {
                System.out.println("Enter value " + (i + 1) + " item: ");
                valueOfItem = checkInputOnPositiveInt();
            }

            items[i] = new Item(weightOfItem, valueOfItem);
        }
        int[][] tableWithBestCases = createBestCasesTable(items, backpackCapacity);
        System.out.println("Maximum optimal total value = " +
                getMaxValueFromTable(tableWithBestCases));
        System.out.println("Items you should take to get maximum value:");
        write(getItemsToInclude(tableWithBestCases, items));
    }

    private static int checkInputOnPositiveInt() {
        int number = -1;
        Scanner scanner = new Scanner(System.in);
        try {
            number = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Not correct!");
        }
        return number;
    }

    private static int[][] createBestCasesTable(Item[] items, int capacity) {
        int[][] table = new int[items.length + 1][capacity + 1];

        for (int i = 0; i <= items.length; i++) {
            table[i][0] = 0;
        }
        for (int j = 1; j <= capacity; j++) {
            table[0][j] = 0;
        }

        for (int i = 1; i <= items.length; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (j < items[i - 1].getWeight()) {
                    table[i][j] = table[i - 1][j];
                } else {
                    table[i][j] = Math.max(
                            (items[i - 1].getValue() + table[i - 1][j - items[i - 1].getWeight()]),
                            (table[i - 1][j])
                    );
                }
            }
        }
        return table;
    }

    private static int getMaxValueFromTable(int[][] table) {
        return table[table.length - 1][table[0].length - 1];
    }

    private static ArrayList<Item> getItemsToInclude(int[][] table, Item[] items) {
        ArrayList<Item> itemsToInclude = new ArrayList<>();
        int currentWeight = table[0].length - 1;
        int numberOfItems = table.length - 1;
        for (int i = numberOfItems; i > 0; i--) {
            if (table[i][currentWeight] != table[i - 1][currentWeight]) {
                itemsToInclude.add(items[i - 1]);
                currentWeight -= items[i - 1].getWeight();
            }
        }
        return itemsToInclude;
    }

    private static void write(ArrayList<Item> list) {
        for (Item item : list) {
            System.out.print(item.toString());
            System.out.println();
        }
    }
}
