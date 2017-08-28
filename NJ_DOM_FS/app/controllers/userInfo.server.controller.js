/**
 * Created by CHENCO7 on 8/28/2017.
 */
const _ = require('lodash');
const userInfoFacade = require('../../app/facade/userInfo.server.facade.js');
const uuidv4 = require('uuid/v4');

module.exports = {
    addUser: addUser,
    searchUserByName: searchUserByName
};

function addUser(req, res, next) {
    let body = req.body;
    let user = {
        userInfoId: uuidv4(),
        userId: body.userId,
        userName: body.userName,
        password: body.password,
        role: body.role,
        roleLevel: body.roleLevel,
        createDatetime: body.createDatetime,
        updateDatetime: body.updateDatetime,
        isSupport: body.isSupport
    };
    userInfoFacade.addUser(user, (error, result) => {
        if (error) {
            return next(new Error(error));
        } else {
            return res.json(result);
        }
    });
}

function searchUserByName(req, res, next) {
    let params = req.params;
    let userId = params.userId;
    if (_.isEmpty(userId)) {
        return next(new Error('user name is empty'));
    } else {
        userInfoFacade.getUserInfoByName(userId, (error, result) => {
            if (error) {
                return next(new Error(error));
            } else {
                return res.json(result);
            }
        });
    }
}