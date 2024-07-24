const express = require('express');
const mongoose = require('mongoose');

const app = express();
app.use(express.json());

// MongoDB connection
const dbURI = 'mongodb://localhost:27017/items';
mongoose.connect(dbURI, {
    useNewUrlParser: true,
    useUnifiedTopology: true
})
    .then(() => console.log('MongoDB connected'))
    .catch(err => console.log(err));

// Define your Item model
const itemSchema = new mongoose.Schema({
    itemId: String,
    price: Number,
    description: String,
    title: String,
    quantity: Number
});

const Item = mongoose.model('Item', itemSchema);

// CRUD endpoints
app.post('/items', async (req, res) => {
    try {
        const item = new Item(req.body);
        await item.save();
        res.status(201).send(item);
    } catch (err) {
        res.status(400).send(err);
    }
});

app.get('/items', async (req, res) => {
    try {
        const items = await Item.find();
        res.send(items);
    } catch (err) {
        res.status(500).send(err);
    }
});

app.get('/items/:id', async (req, res) => {
    try {
        const item = await Item.findById(req.params.id);
        if (!item) return res.status(404).send();
        res.send(item);
    } catch (err) {
        res.status(500).send(err);
    }
});

app.put('/items/:id', async (req, res) => {
    try {
        const item = await Item.findByIdAndUpdate(req.params.id, req.body, { new: true, runValidators: true });
        if (!item) return res.status(404).send();
        res.send(item);
    } catch (err) {
        res.status(400).send(err);
    }
});

app.delete('/items/:id', async (req, res) => {
    try {
        const item = await Item.findByIdAndDelete(req.params.id);
        if (!item) return res.status(404).send();
        res.send(item);
    } catch (err) {
        res.status(500).send(err);
    }
});

// Start server
const port = process.env.PORT || 3000;
app.listen(port, () => {
    console.log(`Server running on port ${port}`);
});
