var mongoose = require('mongoose');
var Schema = mongoose.Schema;
mongoose.Promise = global.Promise;

// Connect to mongodb
mongoose.set('debug', true);
mongoose.connect(
    'mongodb://localhost:27017/testPopulate',
    {useMongoClient: true}
).then(function (db) {
    console.log('DB connected!');
}).catch(function (err) {
    console.log('DB connect failed!');
    console.log(err.stack);
});

var personSchema = Schema({
    _id: Schema.Types.ObjectId,
    name: String,
    age: Number,
    stories: [{ type: Schema.Types.ObjectId, ref: 'Story' }]
});

var storySchema = Schema({
    author: { type: Schema.Types.ObjectId, ref: 'Person' },
    title: String,
    fans: [{ type: Schema.Types.ObjectId, ref: 'Person' }]
});

var Story = mongoose.model('Story', storySchema);
var Person = mongoose.model('Person', personSchema);

// var author = new Person({
//     _id: new mongoose.Types.ObjectId(),
//     name: 'cccc',
//     age: 50
// });

// author.save(function (err) {
    // if (err) return handleError(err);
    //
    // var story1 = new Story({
    //     title: 'Casino Royale',
    //     author: author._id    // assign the _id from the person
    // });
    //
    // story1.fans.push(author._id);
    //
    // story1.save(function (err) {
    //     if (err) return handleError(err);
    //     // thats it!
    // });
// });

// var story1 = new Story({
//     title: 'story1',
//     author: "59a8fd242e7b611d88b82a16"    // assign the _id from the person
// });
//
// story1.fans.push("59a8fd242e7b611d88b82a16");
//
// story1.save(function (err, data) {
//     console.log(data);
//     // thats it!
// });

Story.
findOne({ title: 'story1' }).
populate('author').
exec(function (err, story) {
    console.log("***********");
    console.log(story);
    // prints "The author is Ian Fleming"
});

// Story.findOne({ title: 'Casino Royale' }, function(error, story) {
//     story.author = author;
//     console.log(story.author.name); // prints "Ian Fleming"
// });




