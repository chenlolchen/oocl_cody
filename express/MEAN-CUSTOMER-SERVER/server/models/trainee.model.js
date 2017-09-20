var mongoose = require('mongoose'), Schema = mongoose.Schema;

var TraineeSchema = new Schema({
    domainId    : String,
    name        : String,
    englishName : String,
    major       : String,
    gender      : String,
    teacher     : String
}, {
    collection: 'Trainee'
});

mongoose.model('Trainee', TraineeSchema);