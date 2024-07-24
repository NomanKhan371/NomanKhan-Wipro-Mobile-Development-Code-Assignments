package org.example

import java.util.Scanner

class WarehouseManager {
    private val warehouse = Warehouse()
    private val scanner = Scanner(System.`in`)

    fun start() {
        while (true) {
            showMenu()
            when (scanner.nextInt()) {
                1 -> addItem()
                2 -> updateItem()
                3 -> deleteItem()
                4 -> showItems()
                5 -> showItemQuantity()
                6 -> {
                    println("Exiting...")
                    return
                }
                else -> println("Invalid choice. Please try again.")
            }
        }
    }

    private fun showMenu() {
        println("Warehouse Management System")
        println("1. Add Item")
        println("2. Update Item")
        println("3. Delete Item")
        println("4. Show All Items")
        println("5. Show Item Quantity")
        println("6. Exit")
        print("Enter your choice: ")
    }

    private fun addItem() {
        println("Enter Item ID: ")
        val itemId = scanner.next()
        scanner.nextLine() // Clear the newline character from the buffer
        println("Enter Item Title: ")
        val title = scanner.nextLine()
        println("Enter Item Price: ")
        val price = scanner.nextDouble()
        scanner.nextLine() // Clear the newline character from the buffer
        println("Enter Item Description: ")
        val description = scanner.nextLine()
        println("Enter Item Quantity: ")
        val quantity = scanner.nextInt()

        val item = Item(itemId, price, description, title, quantity)
        if (warehouse.addItem(item)) {
            println("Item added successfully!")
        } else {
            println("Failed to add item.")
        }
    }

    private fun updateItem() {
        println("Enter Item ID to update: ")
        val itemId = scanner.next()

        val item = warehouse.getItemById(itemId)
        if (item == null) {
            println("Item not found!")
            return
        }

        scanner.nextLine() // Clear the newline character from the buffer
        println("Enter new Item Title (current: ${item.title}): ")
        val titleInput = scanner.nextLine()
        val title = if (titleInput.isBlank()) item.title else titleInput

        println("Enter new Item Price (current: ${item.price}): ")
        val priceInput = scanner.nextLine()
        val price = if (priceInput.isBlank()) item.price else priceInput.toDouble()

        println("Enter new Item Description (current: ${item.description}): ")
        val descriptionInput = scanner.nextLine()
        val description = if (descriptionInput.isBlank()) item.description else descriptionInput

        println("Enter new Item Quantity (current: ${item.quantity}): ")
        val quantityInput = scanner.nextLine()
        val quantity = if (quantityInput.isBlank()) item.quantity else quantityInput.toInt()

        if (warehouse.updateItem(itemId, price, description, title, quantity)) {
            println("Item updated successfully!")
        } else {
            println("Failed to update item.")
        }
    }

    private fun deleteItem() {
        println("Enter Item ID to delete: ")
        val itemId = scanner.next()

        if (warehouse.deleteItem(itemId)) {
            println("Item deleted successfully!")
        } else {
            println("Failed to delete item.")
        }
    }

    private fun showItems() {
        val items = warehouse.getItems()
        if (items.isEmpty()) {
            println("No items found.")
        } else {
            println("Items in the warehouse:")
            items.forEach { println(it) }
        }
    }

    private fun showItemQuantity() {
        println("Enter Item ID to check quantity: ")
        val itemId = scanner.next()

        val item = warehouse.getItemById(itemId)
        if (item == null) {
            println("Item not found!")
        } else {
            println("Quantity of Item ID $itemId: ${item.quantity}")
        }
    }
}

fun main() {
    WarehouseManager().start()
}



