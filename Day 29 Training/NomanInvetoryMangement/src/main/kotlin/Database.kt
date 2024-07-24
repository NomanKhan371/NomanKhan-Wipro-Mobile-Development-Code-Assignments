package org.example


import com.mongodb.client.MongoClients
import org.litote.kmongo.KMongo
import org.litote.kmongo.getCollection

object Database {
    private val client = KMongo.createClient("mongodb://localhost:27017")
    private val database = client.getDatabase("items")
    val itemCollection = database.getCollection<Item>()
}
