// !!!Clean the collection!!!
db.ch2.remove({});

// Insert data before demo
db.ch2.insertMany( [
   { item: "journal", qty: 25, size: { h: 14, w: 21, uom: "cm" }, status: "A" },
   { item: "notebook", qty: 50, size: { h: 8.5, w: 11, uom: "in" }, status: "P" },
   { item: "paper", qty: 100, size: { h: 8.5, w: 11, uom: "in" }, status: "D" },
   { item: "planner", qty: 75, size: { h: 22.85, w: 30, uom: "cm" }, status: "D" },
   { item: "postcard", qty: 45, size: { h: 10, w: 15.25, uom: "cm" }, status: "A" },
]);

// Delete all docs with status = 'A'
db.ch2.deleteMany(
    // Query statement
    { status: 'A' }
);

// Delete docs with status = 'A' AND qty > 30
db.ch2.deleteMany(
    // Query statement
    {$and: [
        { status: 'A' },
        { qty: {$gt: 30} }
    ]}
);

// Delete docs with status = 'A' OR qty > 30
db.ch2.deleteMany(
    // Query statement
    {$or: [
        { status: 'A' },
        { qty: {$gt: 30} }
    ]}
);

// Delete all docs
db.ch2.deleteMany({});

// Drop collection
db.ch2.drop();
