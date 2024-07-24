// controllers/itemController.js
const Item = require('../models/Item');

// Create a new item
exports.createItem = async (req, res) => {
  try {
    const item = new Item(req.body);
    await item.save();
    res.status(201).send(item);
  } catch (error) {
    res.status(400).send(error);
  }
};

// Get all items
exports.getAllItems = async (req, res) => {
  try {
    const items = await Item.find({});
    res.status(200).send(items);
  } catch (error) {
    res.status(500).send(error);
  }
};

// Get item by ID
exports.getItemById = async (req, res) => {
  try {
    const item = await Item.findOne({ itemId: req.params.itemId });
    if (!item) {
      return res.status(404).send();
    }
    res.status(200).send(item);
  } catch (error) {
    res.status(500).send(error);
  }
};

// Update an item
exports.updateItem = async (req, res) => {
  const updates = Object.keys(req.body);
  const allowedUpdates = ['price', 'description', 'title', 'quantity'];
  const isValidOperation = updates.every((update) => allowedUpdates.includes(update));

  if (!isValidOperation) {
    return res.status(400).send({ error: 'Invalid updates!' });
  }

  try {
    const item = await Item.findOne({ itemId: req.params.itemId });

    if (!item) {
      return res.status(404).send();
    }

    updates.forEach((update) => (item[update] = req.body[update]));
    await item.save();
    res.status(200).send(item);
  } catch (error) {
    res.status(400).send(error);
  }
};

// Delete an item
exports.deleteItem = async (req, res) => {
  try {
    const item = await Item.findOneAndDelete({ itemId: req.params.itemId });

    if (!item) {
      return res.status(404).send();
    }

    res.status(200).send(item);
  } catch (error) {
    res.status(500).send(error);
  }
};
