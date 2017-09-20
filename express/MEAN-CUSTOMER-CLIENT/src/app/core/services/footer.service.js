/* Created by ZHENGNI3 on 09-02-2017.*/
function footerService() {
  var svc = this;

  svc.info = [
    {
      displayInfo: 'Copyright © 2017.oocl.'
    }
  ];

  function addInfo(info) {
    svc.info.push(info);
  }

  function getInfos() {
    return svc.info;
  }

  return {
    getInfos: getInfos,
    addInfo: addInfo
  };
}

module.exports = footerService;