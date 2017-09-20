var $ = require('jquery');

$(function(){
  function getFileName(o){
    var pos=o.lastIndexOf("\\");
    return o.substring(pos+1);
  }
  $("#avatarPic").on("change",function(){
    console.log($(this).val());
    $("#avatar_name").text(getFileName($(this).val()));
  });
});