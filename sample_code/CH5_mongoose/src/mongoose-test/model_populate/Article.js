/**
 * Created by HUANGYE2 on 8/30/2017.
 */
/** Model for Person **/

var mongoose = require('mongoose');

var schema = mongoose.Schema({
    title: String,
    text: String,
    author: {
        type: mongoose.Schema.Types.ObjectId,
        ref: 'Person'
    },
    likedBy: [{
        type: mongoose.Schema.Types.ObjectId,
        ref: 'Person'
    }]
}, {
    collection: 'articles'
});

var articleModel = mongoose.model('Article', schema);

module.exports = articleModel;