// create a list of names and find the number of occurrence of each name
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Assignment2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a list of names
        List<String> names = new ArrayList<>();
        System.out.println("Enter the number of names: ");
        int n = scanner.nextInt();
        scanner.nextLine();  // Consume the newline

        System.out.println("Enter the names: ");
        for (int i = 0; i < n; i++) {
            names.add(scanner.nextLine());
        }

        // Count the occurrences of each name
        List<String> uniqueNames = new ArrayList<>();
        List<Integer> counts = new ArrayList<>();

        for (String name : names) {
            int index = uniqueNames.indexOf(name);
            if (index != -1) {
                counts.set(index, counts.get(index) + 1);
            } else {
                uniqueNames.add(name);
                counts.add(1);
            }
        }

        // Print the occurrences of each name
        System.out.println("Occurrences of each name: ");
        for (int i = 0; i < uniqueNames.size(); i++) {
            System.out.println(uniqueNames.get(i) + ": " + counts.get(i));
        }

        scanner.close();
    }
}
