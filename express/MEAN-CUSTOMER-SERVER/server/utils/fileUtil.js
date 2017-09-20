/**
 * Created by CHENCO7 on 9/2/2017.
 */
const fs = require('fs');
const restler = require('restler');
const config = require('./../config/env/config_development.json');

function uploadFile(posterData, divPath) {
  let timestamp = Date.now();
  let type = posterData.type.split('/')[1];
  let uploadPath = divPath + "/" + timestamp + '.' + type;
  let filePath = posterData.path;
  let originalFilename = posterData.originalFilename;
  console.log("uploadPath == " + uploadPath);

  if (originalFilename) {
    fs.stat(filePath, function(err, stats) {
      restler.post(config.fileUpload.uploadPath + divPath, {
        multipart: true,
        data: {
          'img': restler.file(filePath, null, stats.size, null, 'image/jpg'),
          'key': uploadPath
        }
      }).on('complete', function(data) {

      });
    });
  }
  return config.fileUpload.readPath + uploadPath;
}

module.exports = {
  uploadFile: uploadFile
};