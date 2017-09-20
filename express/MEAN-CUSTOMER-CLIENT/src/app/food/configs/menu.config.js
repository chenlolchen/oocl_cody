/* Created by ZHENGNI3 on 09-02-2017.*/

authMenuConfig.$inject = ['navMenuService'];
function authMenuConfig(navMenuService) {
  console.log('**************');
  navMenuService.addMenu({
    state: 'food',
    displayName: 'Foods'
  });
}

module.exports = authMenuConfig;