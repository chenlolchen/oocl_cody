/**
 * Created by CHENCO7 on 8/28/2017.
 */
const _ = require('lodash');
const userInfoModel = require('../../app/models/userInfo.json');
const fs = require('fs');

module.exports = {
    addUser : addUser,
    getUserInfoByName: getUserInfoByName
};

function addUser(user, callback) {
    let result = null;
    result = _.concat(userInfoModel, user);
    fs.writeFile('app/models/userInfo.json', JSON.stringify(result), function () {
        callback(null, result);
    });
}

function getUserInfoByName(userId, callback) {
    let result = null;
    _.forEach(userInfoModel, (item) => {
        if(_.isEqual(item.userId, userId)){
            result = item;
        }
    });
    callback(null, result)
}

