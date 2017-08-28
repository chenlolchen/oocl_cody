let _ = require('lodash');

_.forEach([1, 2], function(value) {
    console.log(value);
});
// => Logs `1` then `2`.

_.forEach({ 'a': 1, 'b': 2 }, function(value, key) {
    console.log(key);
});