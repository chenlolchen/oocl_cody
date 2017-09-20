/* Created by ZHENGNI3 on 09-02-2017.*/
footerController.$inject = ['footerService'];
function footerController(footerService) {
  var vm = this;
  vm.info = footerService.getInfos();
}

module.exports = footerController;