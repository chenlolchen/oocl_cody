/********************  Index  ************************/
// !!!Clean the collection!!!
db.ch3.remove({});
// Insert data before demo
db.ch3.insertMany([
    {a: 3, b: 2, c: 1},
    {a: 1, b: 1, c: 3},
    {a: 1, b: 2, c: 3},
    {a: 2, b: 2, c: 1},
    {a: 3, b: 1, c: 3},
    {a: 1, b: 3, c: 1},
    {a: 2, b: 3, c: 3},
    {a: 3, b: 1, c: 1},
    {a: 1, b: 2, c: 1},
    {a: 2, b: 1, c: 3},
    {a: 2, b: 2, c: 2},
    {a: 3, b: 2, c: 3},
]);

// Only default index
db.ch3.getIndexes();

// Create new index
db.ch3.createIndex({ "a": 1, "b": 1, "c": 1 });

// Check new index
db.ch3.getIndexes();

// Good query
db.ch3.find({ "a": 1}).sort({ "b": 1, "c": 1 });

// Execution plan of good query
db.ch3.find({ "a": 1}).sort({ "b": 1, "c": 1 }).explain("executionStats");

// Bad query
db.ch3.find( { "a": { $gt: 1 }} ).sort( { "b": 1, "c": 1 } );

// Execution plan of bad query
db.ch3.find( { "a": { $gt: 1 }} ).sort( { "b": 1, "c": 1 } ).explain("executionStats");