// !!!Clean the collection!!!
db.ch2.remove({});

// Insert data before demo
db.ch2.insertMany( [
   { item: "canvas", qty: 100, size: { h: 28, w: 35.5, uom: "cm" }, status: "A" },
   { item: "journal", qty: 25, size: { h: 14, w: 21, uom: "cm" }, status: "A" },
   { item: "mat", qty: 85, size: { h: 27.9, w: 35.5, uom: "cm" }, status: "A" },
   { item: "mousepad", qty: 25, size: { h: 19, w: 22.85, uom: "cm" }, status: "P" },
   { item: "notebook", qty: 50, size: { h: 8.5, w: 11, uom: "in" }, status: "P" },
   { item: "paper", qty: 100, size: { h: 8.5, w: 11, uom: "in" }, status: "D" },
   { item: "planner", qty: 75, size: { h: 22.85, w: 30, uom: "cm" }, status: "D" },
   { item: "postcard", qty: 45, size: { h: 10, w: 15.25, uom: "cm" }, status: "A" },
   { item: "sketchbook", qty: 80, size: { h: 14, w: 21, uom: "cm" }, status: "A" },
   { item: "sketch pad", qty: 95, size: { h: 22.85, w: 30.5, uom: "cm" }, status: "A" }
]);

// Single update - sample 1
db.ch2.updateOne(
    // Filter statement
    { item: "paper" },
    // Update statement
    {
        $set: { qty: 99, status: "P" }
    }
);

// Single update - sample 2 more complex
db.ch2.updateOne(
    // Filter statement
    { item: "paper" },
    // Update statement
    {
        $set: {status: "A" },
        $inc: {qty: -1}
    }
);

// Multiple update
db.ch2.updateMany(
    // Filter statement
    { qty: {$lt: 50} },
    // Update statement
    {
        $set: { status: "P" }
    }
);

// Replace
db.ch2.replaceOne(
    // Filter statement
    { qty: {$lt: 50} },
    // Replacement
    { item: 'sb'}
);

// Upsert
db.ch2.updateOne(
    // Filter statement
    { item: "Pig" },
    // Update statement
    {
        $set: {status: "A" },
        $inc: {qty: 999}
    },
    // Options
    { upsert: true}
);

// $push: 
db.ch2.updateOne(
    // Filter statement
    { item: "Pig" },
    // Update statement
    {
        $push: {likes: 'KFC' }
    }
);
