/**
 * Created by HUANGYE2 on 8/30/2017.
 *
 *  Sample for mongoose.populate()
 *  Article ---link---> Persons
 */

var mongoose = require('mongoose');
mongoose.Promise = global.Promise;

// Connect to mongodb
mongoose.set('debug', true);
mongoose.connect(
    'mongodb://localhost:27017/test',
    {useMongoClient: true}
).then(function (db) {
    console.log('DB connected!');
}).catch(function (err) {
    console.log('DB connect failed!');
    console.log(err.stack);
});

var personModel = require('./model_populate/Person');
var articleModel = require('./model_populate/Article');

// Person 1
var person_1 = new personModel({
    _id: new mongoose.Types.ObjectId(),
    name: 'Tom',
    age: 18
});

// Person 2
var person_2 = new personModel({
    _id: new mongoose.Types.ObjectId(),
    name: 'Billy',
    age: 30
});

// Article 1
var article_1 = new articleModel({
    title: "Tom's 1st Post",
    text: 'Ha ha ha!',
    author: person_1._id,   // Author is person 1
    likedBy: []
});

person_1.save()  // Save Person 1
    .then(function (newPerson) {
        console.log('Saved Person: %s', newPerson._id);
        return person_2.save();  // Save person 2
    })
    .then(function (newPerson) {
        console.log('Saved Person: %s', newPerson._id);
        article_1.likedBy.push(newPerson._id);
        return article_1.save();  // Save article 1
    })
    .then(function (newArticle) {
        // Find out the article with person data in it
        console.log('Saved Article: %s', newArticle._id);
        return articleModel
            .find({title: newArticle.title})
            .populate('author')
            .populate('likedBy')
            .exec()
    })
    .then(function (articles) {
        console.log('Now we have articles:');
        return console.log(JSON.stringify(articles, null, 2));
    })
    .then(function () {
        // Disconnect mongodb.
        return mongoose.disconnect();
    })
    .catch(function (err) {
        console.error(err.stack);
    });

//    DB connected!
//    Saved Person: 59a666be0824794d243435e1
//    Saved Person: 59a666be0824794d243435e2
//    Saved Article: 59a666be0824794d243435e3
//    Now we have articles:
//    [
//        {
//            "_id": "59a666be0824794d243435e3",
//            "title": "Tom's 1st Post",
//            "text": "Ha ha ha!",
//            "author": {
//                "_id": "59a666be0824794d243435e1",
//                "name": "Tom",
//                "age": 18,
//                "__v": 0
//            },
//            "__v": 0,
//            "likedBy": [
//                {
//                    "_id": "59a666be0824794d243435e2",
//                    "name": "Billy",
//                    "age": 30,
//                    "__v": 0
//                }
//            ]
//        }
//    ]