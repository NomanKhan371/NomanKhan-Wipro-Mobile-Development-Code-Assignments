// models/Item.js
const mongoose = require('mongoose');

const ItemSchema = new mongoose.Schema({
  itemId: { type: String, required: true, unique: true },
  price: { type: Number, required: true },
  description: { type: String, required: true },
  title: { type: String, required: true },
  quantity: { type: Number, required: true }
});

module.exports = mongoose.model('Item', ItemSchema);
