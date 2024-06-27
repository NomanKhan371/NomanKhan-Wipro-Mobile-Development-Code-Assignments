package com.example;
import java.util.List;
import java.util.Scanner;

public class WarehouseManager {
    private Warehouse warehouse;
    private Scanner scanner;

    public WarehouseManager() {
        warehouse = new Warehouse();
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addItem();
                    break;
                case 2:
                    updateItem();
                    break;
                case 3:
                    deleteItem();
                    break;
                case 4:
                    showItems();
                    break;
                case 5:
                    showItemQuantity();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void showMenu() {
        System.out.println("Warehouse Management System");
        System.out.println("1. Add Item");
        System.out.println("2. Update Item");
        System.out.println("3. Delete Item");
        System.out.println("4. Show All Items");
        System.out.println("5. Show Item Quantity");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    private void addItem() {
        System.out.print("Enter Item ID: ");
        String itemId = scanner.nextLine();
        System.out.print("Enter Item Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Item Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Item Description: ");
        String description = scanner.nextLine();
        System.out.print("Enter Item Quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Item item = new Item(itemId, price, description, title);
        warehouse.addItem(item, quantity);
        System.out.println("Item added successfully!");
    }

    private void updateItem() {
        System.out.print("Enter Item ID to update: ");
        String itemId = scanner.nextLine();

        Item existingItem = warehouse.getItemById(itemId);
        if (existingItem == null) {
            System.out.println("Item not found!");
            return;
        }

        System.out.print("Enter new Item Title (leave blank to keep " + existingItem.getTitle() + "): ");
        String title = scanner.nextLine();
        if (title.isEmpty()) {
            title = existingItem.getTitle();
        }

        System.out.print("Enter new Item Price (leave blank to keep " + existingItem.getPrice() + "): ");
        String priceInput = scanner.nextLine();
        double price = priceInput.isEmpty() ? existingItem.getPrice() : Double.parseDouble(priceInput);

        System.out.print("Enter new Item Description (leave blank to keep " + existingItem.getDescription() + "): ");
        String description = scanner.nextLine();
        if (description.isEmpty()) {
            description = existingItem.getDescription();
        }

        System.out.print("Enter new Item Quantity (leave blank to keep " + warehouse.getItemQuantity(itemId) + "): ");
        String quantityInput = scanner.nextLine();
        int quantity = quantityInput.isEmpty() ? warehouse.getItemQuantity(itemId) : Integer.parseInt(quantityInput);

        boolean updated = warehouse.updateItem(itemId, price, description, title, quantity);
        if (updated) {
            System.out.println("Item updated successfully!");
        } else {
            System.out.println("Item not found!");
        }
    }

    private void deleteItem() {
        System.out.print("Enter Item ID to delete: ");
        String itemId = scanner.nextLine();

        boolean deleted = warehouse.deleteItem(itemId);
        if (deleted) {
            System.out.println("Item deleted successfully!");
        } else {
            System.out.println("Item not found!");
        }
    }

    private void showItems() {
        List<Item> items = warehouse.getItems();
        if (items.isEmpty()) {
            System.out.println("No items found.");
        } else {
            System.out.println("Items in the warehouse:");
            for (Item item : items) {
                System.out.println(item);
            }
        }
    }

    private void showItemQuantity() {
        System.out.print("Enter Item ID to check quantity: ");
        String itemId = scanner.nextLine();

        int quantity = warehouse.getItemQuantity(itemId);
        if (quantity == -1) {
            System.out.println("Item not found!");
        } else {
            System.out.println("Quantity of Item ID " + itemId + ": " + quantity);
        }
    }

    public static void main(String[] args) {
        WarehouseManager manager = new WarehouseManager();
        manager.start();
    }
}
