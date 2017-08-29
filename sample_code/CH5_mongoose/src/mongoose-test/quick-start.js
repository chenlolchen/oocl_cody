/**
 * Created by yellowb on 2017/7/30.
 */

var mongoose = require('mongoose');
mongoose.Promise = global.Promise;


// Connect to mongodb
mongoose.connect(
    'mongodb://localhost:27017/test',
    {useMongoClient: true}
).then(function (db) {
    console.log('DB connected!');
}).catch(function (err) {
    console.log('DB connect failed!');
    console.log(err.stack);
});

// Build schema, model, document
var Schema = mongoose.Schema;

var kittySchema = Schema({
    name: {type: String, required: true},
    age: {type: Number, min:18, max:60},
    tags: [{type: String}]
},{
    // Options
    collection: 'cats'
});
kittySchema.index({ name: 1});
kittySchema.index({ age: 1});

var KittyModel = mongoose.model('Kitten', kittySchema);
var kitty = new KittyModel(
    {
        name: 'Kitty',
        age: 23,
        tags: ['cat', 'love']
    }
);

// Save the new document, then find out all documents after saving done.
kitty.save()
    .then(function (newKitty) {
        console.log('_id of new kitty: ' + newKitty._id);
        return KittyModel.find({}).exec();
    })
    .then(function (kitties) {
        console.log('Now we have kitties:');
        return console.log(JSON.stringify(kitties, null, 2));
    })
    .then(function () {
        // Disconnect mongodb.
        //return mongoose.disconnect();
    })
    .catch(function (err) {
        console.error(err.stack);
    });