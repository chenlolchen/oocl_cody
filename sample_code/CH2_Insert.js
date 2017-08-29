// !!!Clean the collection!!!
db.ch2.remove({});

// Normal single insert
db.ch2.insertOne({name:'Frye'});
db.ch2.insertOne({name:'Tom', age: 18});
db.ch2.insertOne({book:'Thinking In Java'});

// _id conflict smaple
db.ch2.insertOne({_id:"12345" ,name:'Jack'});
db.ch2.insertOne({_id:"12345" ,name:'Mary'});

// Multiple insert
var docs = [{name: 'Apple'}, 
        {name: 'Orange'}, 
        {name: 'Banana'}];
db.ch2.insertMany(docs);

// Old API
db.ch2.insert({name: 'Ray'});
