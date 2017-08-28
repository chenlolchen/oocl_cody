var express = require('express');

// var router = express.Router();
//
// /* GET home page. */
// router.get('/', function(req, res, next) {
//   res.render('index', { title: 'Express' });
// });
//
// module.exports = router;

module.exports = (app) => {
  var router = express.Router();
  router.route('/users').get((req, res, next) => {
    res.send('respond with a aaa');
  });
  app.use('/helloExpress', router)
};
