import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
public class Assignment2WithHashMap {

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
        Map<String, Integer> nameCountMap = countNameOccurrences(names);

        // Print the occurrences of each name
        System.out.println("Occurrences of each name: ");
        for (Map.Entry<String, Integer> entry : nameCountMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        scanner.close();
    }

    public static Map<String, Integer> countNameOccurrences(List<String> names) {
        Map<String, Integer> nameCountMap = new HashMap<>();

        for (String name : names) {
            if (nameCountMap.containsKey(name)) {
                nameCountMap.put(name, nameCountMap.get(name) + 1);
            } else {
                nameCountMap.put(name, 1);
            }
        }

        return nameCountMap;
    }
}

