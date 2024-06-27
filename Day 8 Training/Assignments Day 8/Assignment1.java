// sort the list of integers using bubble sort

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Assignment1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of elements: ");
        int n = scanner.nextInt();

        List<Integer> list = new ArrayList<>();
        System.out.println("Enter the elements: ");
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }

        System.out.println("Original list: " + list);
        bubbleSort(list);
        System.out.println("Sorted list: " + list);

        scanner.close();
    }

    public static void bubbleSort(List<Integer> list) {
        int n = list.size();
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    // Swap list[j] and list[j+1]
                    int temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                    swapped = true;
                }
            }
            // If no two elements were swapped by inner loop, then break
            if (!swapped) break;
        }
    }
}