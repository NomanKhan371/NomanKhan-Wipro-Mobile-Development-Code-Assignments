package org.example

import org.litote.kmongo.eq
import org.litote.kmongo.findOne
import org.litote.kmongo.updateOne

class Warehouse {
    private val collection = Database.itemCollection

    fun addItem(item: Item): Boolean {
        return try {
            collection.insertOne(item)
            true
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }

    fun updateItem(itemId: String, price: Double, description: String, title: String, quantity: Int): Boolean {
        val item = collection.findOne(Item::itemId eq itemId) ?: return false
        item.price = price
        item.description = description
        item.title = title
        item.quantity = quantity
        return try {
            collection.updateOne(Item::itemId eq itemId, item)
            true
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }

    fun deleteItem(itemId: String): Boolean {
        return try {
            collection.deleteOne(Item::itemId eq itemId)
            true
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }

    fun getItemById(itemId: String): Item? {
        return try {
            collection.findOne(Item::itemId eq itemId)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    fun getItems(): List<Item> {
        return try {
            collection.find().toList()
        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }
    }
}



//
//import org.example.Database
//import org.example.Item
//import org.litote.kmongo.eq
//import org.litote.kmongo.findOne
//import org.litote.kmongo.updateOne
//
//class Warehouse {
//    private val collection = Database.itemCollection
//
//    fun addItem(item: Item): Boolean {
//        return try {
//            collection.insertOne(item)
//            true
//        } catch (e: Exception) {
//            e.printStackTrace()
//            false
//        }
//    }
//
//    fun updateItem(itemId: String, price: Double, description: String, title: String, quantity: Int): Boolean {
//        val item = collection.findOne(Item::itemId eq itemId) ?: return false
//        item.price = price
//        item.description = description
//        item.title = title
//        item.quantity = quantity
//        return try {
//            collection.updateOne(Item::itemId eq itemId, item)
//            true
//        } catch (e: Exception) {
//            e.printStackTrace()
//            false
//        }
//    }
//
//    fun deleteItem(itemId: String): Boolean {
//        return try {
//            collection.deleteOne(Item::itemId eq itemId)
//            true
//        } catch (e: Exception) {
//            e.printStackTrace()
//            false
//        }
//    }
//
//    fun getItemById(itemId: String): Item? {
//        return try {
//            collection.findOne(Item::itemId eq itemId)
//        } catch (e: Exception) {
//            e.printStackTrace()
//            null
//        }
//    }
//
//    fun getItems(): List<Item> {
//        return try {
//            collection.find().toList()
//        } catch (e: Exception) {
//            e.printStackTrace()
//            emptyList()
//        }
//    }
//}
