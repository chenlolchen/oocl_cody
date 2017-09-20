var $ = require('jquery');

// $(function() {
//   //添加动作
//   console.log("aaaaaa2");
// $('.show-carticon-btn').on('click', function() {
//   $('#cart-body').slideToggle(1000);
// });
// });

module.exports = {
  shake: shake,
  cartClick: cartClick
};

function cartClick() {
  $('.show-carticon-btn').on('click', function() {
    $('#cart-body').slideToggle(1000);
  });
}

function shake() {
  $('.show-carticon-btn').animate({
    opacity: 1,
    left: '-=20px'
  }, 500);
  $('.show-carticon-btn').animate({
    opacity: 1,
    left: '+=20px'
  }, 500);
  $('#cart-body').animate({
    opacity: 1,
    right: '+=20px'
  }, 500);
  $('#cart-body').animate({
    opacity: 1,
    right: '-=20px'
  }, 500);
}