// app module define code                         // 'hec-templates'
var hec = angular.module('hec', ['ionic', 'ngAnimate']);

hec.config([
    '$stateProvider',
    '$urlRouterProvider',
    function ($stateProvider, $urlRouterProvider) {
        $stateProvider
            .state('login', {
                url: '/login',
                templateUrl: 'html/login.html'
            })
            .state('home', {
                url: '/home',
                abstract: true,
                templateUrl: 'html/home/home.html'
            })
            .state('home.main', {
                url: '/main',
                views: {
                    'homeContent': {
                        'templateUrl': 'html/home/main.html'
                    }
                }
            })
            .state('wfl', {
                url: '/wfl',
                abstract: true,
                templateUrl: 'html/wfl/wfl.html'
            })
            .state('wfl.main', {
                url: '/main',
                views: {
                    'wflContent': {
                        'templateUrl': 'html/wfl/main.html'
                    }
                }
        });
        $urlRouterProvider
            .when('', 'login')
            .otherwise('/login');
    }]);

/**
 * Created by mouse on 2015/9/11.
 */

hec.controller('HecController', [
    '$scope',
    '$state',
    '$timeout',
    function ($scope, $state, $timeout) {

        // ���� state ����ҳ����ת
        $scope.goState = function (state) {
            $state.go(state);
            /*if (sec && sec > 0) {
                $timeout(function () {
                    $state.go(state);
                }, sec);
            } else {

            }*/
        };

    }]);

(function(module) {
try { module = angular.module("hec-templates"); }
catch(err) { module = angular.module("hec-templates", []); }
module.run(["$templateCache", function($templateCache) {
  "use strict";
  $templateCache.put("html/login.html",
    "<ion-view hide-nav-bar=\"true\" hide-back-button=\"true\" cache-view=\"false\" ng-controller=\"LoginController\">\n" +
    "  <ion-content>\n" +
    "\n" +
    "\n" +
    "    <div class=\"div-content\">\n" +
    "      login page<br/>\n" +
    "      <a href=\"#/home/main\">去主页</a>\n" +
    "    </div>\n" +
    "\n" +
    "\n" +
    "  </ion-content>\n" +
    "</ion-view>\n" +
    "");
}]);
})();

(function(module) {
try { module = angular.module("hec-templates"); }
catch(err) { module = angular.module("hec-templates", []); }
module.run(["$templateCache", function($templateCache) {
  "use strict";
  $templateCache.put("html/home/home.html",
    "<ion-view view-title=\"主页\" ng-controller=\"HomeController\" id=\"home-home\" >\n" +
    "	<ion-nav-view name=\"homeContent\"></ion-nav-view>\n" +
    "</ion-view>\n" +
    "");
}]);
})();

(function(module) {
try { module = angular.module("hec-templates"); }
catch(err) { module = angular.module("hec-templates", []); }
module.run(["$templateCache", function($templateCache) {
  "use strict";
  $templateCache.put("html/home/main - 副本.html",
    "<ion-view view-title=\"主页\">\n" +
    "<ion-content class=\"padding\" id=\"home-main\" scroll=\"false\">\n" +
    "\n" +
    "\n" +
    "  <div class=\"home-main-body\">\n" +
    "    <div class=\"slider-img-block\">\n" +
    "        slider-img-block\n" +
    "    </div>\n" +
    "    <div class=\"nine-block-container\">\n" +
    "      <div class=\"nine-block-line\" ng-repeat=\"items in nineBlockData\">\n" +
    "        <div class=\"nine-block\" ng-repeat=\"item in items\">\n" +
    "          <img src=\"{{item.imageUrl}}\"/>\n" +
    "          <span>{{item.title}}</span>\n" +
    "        </div>\n" +
    "      </div>\n" +
    "    </div>\n" +
    "  </div>\n" +
    "\n" +
    "\n" +
    "</ion-content>\n" +
    "</ion-view>\n" +
    "");
}]);
})();

(function(module) {
try { module = angular.module("hec-templates"); }
catch(err) { module = angular.module("hec-templates", []); }
module.run(["$templateCache", function($templateCache) {
  "use strict";
  $templateCache.put("html/home/main-bad-back.html",
    "<!--style>\n" +
    ".nine-block-container{\n" +
    "  display: table;\n" +
    "  background-color: white;\n" +
    "  width: 100%;\n" +
    "  line-height: 180px;\n" +
    "  padding: 2% 1% 2% 1%;\n" +
    "}\n" +
    ".nine-blocks-line{\n" +
    "  display: table-row;\n" +
    "}\n" +
    ".nine-block{\n" +
    "  display: table-cell;\n" +
    "}\n" +
    "\n" +
    ".nine-block .image-wrapper{\n" +
    "  padding: 10% 8% 10% 8%;\n" +
    "  border: 1px solid red;\n" +
    "}\n" +
    ".image-wrapper .image{\n" +
    "  width: 50%;\n" +
    "  height: 50%;\n" +
    "  margin: 0px auto;\n" +
    "  display: table-cell;\n" +
    "}\n" +
    ".nine-block .title{\n" +
    "  text-align: center;\n" +
    "  size: 2rem;\n" +
    "}\n" +
    "</style-->\n" +
    "\n" +
    "<!--div class=\"nine-block\" ng-repeat=\"item in nineBlockData\">\n" +
    "    <div class=\"nine-block-img\" style=\"background-image:url(img/test.png);\">\n" +
    "\n" +
    "    </div>\n" +
    "    <img class=\"nine-block-img\" src=\"{{item.imageUrl}}\" ng-if=\"item.imageUrl\"/>\n" +
    "    <div class=\"nine-block-img {{item.iconClass}}\" ng-if=\"item.iconClass\"></div>\n" +
    "    <div class=\"title\">{{item.title}}</div>\n" +
    "</div-->\n" +
    "");
}]);
})();

(function(module) {
try { module = angular.module("hec-templates"); }
catch(err) { module = angular.module("hec-templates", []); }
module.run(["$templateCache", function($templateCache) {
  "use strict";
  $templateCache.put("html/home/main.html",
    "<ion-view view-title=\"主页\" hide-back-button=\"true\"  cache-view=\"true\" >\n" +
    "<ion-content id=\"home-main\" scroll=\"false\">\n" +
    " \n" +
    "  <div class=\"home-main-body\">\n" +
    "    <div class=\"slider-img-block\">\n" +
    "      <ion-slide-box on-slide-changed=\"slideChanged(index)\" style=\"height:100%;width:100%;\">\n" +
    "        <ion-slide style=\"height:100%;width:100%;\">\n" +
    "          <div class=\"slid-box\" style=\"height:100%;width:100%;\">\n" +
    "            <img src=\"images/weixin/slid1.png\" style=\"height:100%;width:100%;\"/>\n" +
    "          </div>\n" +
    "        </ion-slide>\n" +
    "        <ion-slide>\n" +
    "          <div class=\"slid-box\">\n" +
    "            <img src=\"images/weixin/slid2.png\" style=\"height:100%;width:100%;\"/>\n" +
    "          </div>\n" +
    "        </ion-slide>\n" +
    "        <ion-slide>\n" +
    "          <div class=\"slid-box\">\n" +
    "            <img src=\"images/weixin/slid3.png\" style=\"height:100%;width:100%;\"/>\n" +
    "          </div>\n" +
    "        </ion-slide>\n" +
    "      </ion-slide-box>\n" +
    "\n" +
    "\n" +
    "    <ion-scroll has-bouncing=\"false\">\n" +
    "    <div class=\"nine-block-container\" >\n" +
    "      <div class=\"nine-blocks-line\" ng-repeat=\"items in nineBlockData2\">\n" +
    "        <div class=\"nine-block\" ng-click=\"goState(item.state);\" ng-repeat=\"item in items\">\n" +
    "          <div class=\"image-wrapper\">\n" +
    "            <img style=\"width:50px;height:50px;\" class=\"image\" src=\"images/weixin/test.png\"/>\n" +
    "          </div>\n" +
    "          <div class=\"title\">\n" +
    "            {{item.title}}\n" +
    "          </div>\n" +
    "        </div>\n" +
    "      </div>\n" +
    "\n" +
    "    </div>\n" +
    "    </ion-scroll>\n" +
    "  </div>\n" +
    "  </div>\n" +
    "\n" +
    "</ion-content>\n" +
    "</ion-view>\n" +
    "");
}]);
})();

(function(module) {
try { module = angular.module("hec-templates"); }
catch(err) { module = angular.module("hec-templates", []); }
module.run(["$templateCache", function($templateCache) {
  "use strict";
  $templateCache.put("html/wfl/main.html",
    "<ion-view view-title=\"审批\" hide-nav-bar=\"false\"\n" +
    "          hide-back-button=\"false\" cache-view=\"true\">\n" +
    "    <!--   ng-controller=\"WFLListController\"  -->\n" +
    "    <ion-nav-buttons side=\"right\">\n" +
    "        <!--button class=\"button wfl_select_button\">\n" +
    "            <span ng-show=\"isSelectMode() && showSelectAll &&!isSelectedAll\" ng-click=\"selectAll();\"> 全选  </span>\n" +
    "            <span ng-show=\"isSelectMode() && isSelectedAll\" ng-click=\"unSelectAll();\"> 取消全选 </span>\n" +
    "            <span ng-show=\"isSelectMode() && currentSelectedItems > 0 && !isSelectedAll && !showSelectAll\" ng-click=\"clickNumberButton();\"> {{currentSelectedItems}} </span>\n" +
    "        </button-->\n" +
    "        <button class=\"button wfl_select_button\" ng-if=\"isSelectMode() && showSelectAll &&!isSelectedAll\"\n" +
    "                ng-click=\"selectAll();\">\n" +
    "            <span> 全选 </span>\n" +
    "        </button>\n" +
    "        <button class=\"button wfl_select_button\" ng-if=\"isSelectMode() && isSelectedAll\" ng-click=\"unSelectAll();\">\n" +
    "            <span>取消</span>\n" +
    "        </button>\n" +
    "        <button class=\"button wfl_select_button\"\n" +
    "                ng-if=\"isSelectMode() && currentSelectedItems > 0 && !isSelectedAll && !showSelectAll\"\n" +
    "                ng-click=\"clickNumberButton();\">\n" +
    "            <span>{{currentSelectedItems}} </span>\n" +
    "        </button>\n" +
    "    </ion-nav-buttons>\n" +
    "    <ion-content id=\"approve-main-page\" scroll=\"false\">\n" +
    "        <!--div class=\"top\"></div-->\n" +
    "\n" +
    "        <div class=\"center-list\">\n" +
    "            <ion-scroll id=\"center-list-scroller\" class=\"fill-parent\">\n" +
    "                <ion-refresher pulling-text=\"{{refresherText}}\" on-refresh=\"reloadData();\" on-pulling=\"onPulling();\">\n" +
    "                </ion-refresher>\n" +
    "                <ion-list ng-init=\"reloadData()\" class=\"fill-parent wfl-list\">\n" +
    "                    <ion-item class=\"wfl-list-item\"\n" +
    "                              ng-class=\"{'first':($index==0),'last':($index==(listItemDatas.length-1))}\"\n" +
    "                              ng-repeat=\"item in listItemDatas\">\n" +
    "                        <!--div class=\"image-wrapper fill-parent\">\n" +
    "                            <div class=\"image-wrapper-inner fill-parent\">\n" +
    "                                <img src=\"{{item.logo}}\" class=\"item-logo fill-parent\">\n" +
    "                            </div>\n" +
    "                        </div-->\n" +
    "                        <div class=\"wfl-item-center\">\n" +
    "                            <div class=\"wfl-item-center-inner fill-parent\">\n" +
    "                                <div class=\"wfl-item-center-table-wrapper\">\n" +
    "                                    <table class=\"fill-parent\">\n" +
    "                                        <tr>\n" +
    "                                            <td class=\"type\">{{item.ins_doc_category_desc}} : {{item.ins_sub_emp}}</td>\n" +
    "                                        </tr>\n" +
    "                                        <tr>\n" +
    "                                            <td><span>{{item.ins_doc_num}}</span></td>\n" +
    "                                        </tr>\n" +
    "                                        <tr>\n" +
    "                                            <td>{{item.ins_doc_desc}}</td>\n" +
    "                                        </tr>\n" +
    "                                    </table>\n" +
    "                                </div>\n" +
    "                            </div>\n" +
    "                        </div>\n" +
    "                        <div class=\"wfl-item-right\">\n" +
    "                            <div class=\"wfl-item-right-inner fill-parent\">\n" +
    "                                <div class=\"right-left fill-height\">\n" +
    "                                    left\n" +
    "                                </div>\n" +
    "                                <div class=\"right-right fill-height\">\n" +
    "                                    <div class=\"right-right-top\">\n" +
    "                                        {{item.ins_sub_date}}\n" +
    "                                    </div>\n" +
    "                                    <div class=\"right-right-bottom\">\n" +
    "                                        <label class=\"checkbox\" ng-click=\"selectItem(item)\">\n" +
    "                                            <input type=\"checkbox\" ng-checked=\"item.selected\">\n" +
    "                                        </label>\n" +
    "                                    </div>\n" +
    "                                </div>\n" +
    "                            </div>\n" +
    "                        </div>\n" +
    "                    </ion-item>\n" +
    "                </ion-list>\n" +
    "                <div class=\"no-more-data\" ng-if=\"!noMoreData\">\n" +
    "                    上拉加载更多\n" +
    "                </div>\n" +
    "                <ion-infinite-scroll ng-if=\"isLoadingMore ? false:!noMoreData\" immediate-check=\"false\" distance=\"5%\" on-infinite=\"loadMoreData();\">\n" +
    "                </ion-infinite-scroll>\n" +
    "                <div class=\"no-more-data\" ng-if=\"noMoreData\">\n" +
    "                    暂无更多数据了\n" +
    "                </div>\n" +
    "            </ion-scroll>\n" +
    "        </div>\n" +
    "\n" +
    "        <div class=\"select-operations fill-width\" ng-if=\"isSelectMode()\">\n" +
    "            <div class=\"select-operation nod\">\n" +
    "                <a class=\"button button-outline icon-right ion-checkmark-rounds button-positive\">\n" +
    "                    同意\n" +
    "                </a>\n" +
    "            </div>\n" +
    "            <div class=\"select-operation refuse\">\n" +
    "                <a class=\"button button-outline icon-right ion-close-round button-positive\">\n" +
    "                    拒绝\n" +
    "                </a>\n" +
    "            </div>\n" +
    "            <div class=\"select-operation more\">\n" +
    "                <a class=\"button button-outline icon-right ion-more button-positive\">\n" +
    "                    更多\n" +
    "                </a>\n" +
    "            </div>\n" +
    "        </div>\n" +
    "\n" +
    "        <div class=\"wfl-basic-search-bar\" ng-if=\"isScanMode()\">\n" +
    "            <div class=\"wfl-basic-search-wrapper\">\n" +
    "                <div class=\"wfl-basic-search\">\n" +
    "                    <labe class=\"item item-input\">\n" +
    "                        <i class=\"icon ion-search placeholder-icon\"></i>\n" +
    "                        <input type=\"text\" placeholder=\"输入搜索内容\"/>\n" +
    "                    </labe>\n" +
    "                </div>\n" +
    "                <div class=\"wfl-basic-button\" ng-click=\"toogleSearchBottom();\">\n" +
    "                    <div class=\"button button-outline button-positive\" ng-disabled=\"isSelectMode()\">\n" +
    "                        高级\n" +
    "                    </div>\n" +
    "                </div>\n" +
    "            </div>\n" +
    "        </div>\n" +
    "\n" +
    "        <div class=\"wfl-senior-search-panel\" ng-if=\"isSearchMode()\" ng-click=\"hideSeniorPanel();\">\n" +
    "            <div class=\"wfl-senior-search-wrapper\" ng-click=\"notHideSeniorPanel();\">\n" +
    "                aaaaaaaaaaaaa<br/>\n" +
    "                aaaaaaaaaaaaa<br/>\n" +
    "                aaaaaaaaaaaaa<br/>\n" +
    "                aaaaaaaaaaaaa<br/>\n" +
    "                aaaaaaaaaaaaa<br/>\n" +
    "            </div>\n" +
    "        </div>\n" +
    "\n" +
    "\n" +
    "    </ion-content>\n" +
    "</ion-view>\n" +
    "\n" +
    "\n" +
    "<!--style>\n" +
    "  .fill-parent{\n" +
    "    width: 100%;\n" +
    "    height: 100%;\n" +
    "  }\n" +
    "  /*** 全局style *****/  \n" +
    "  .center-list {\n" +
    "    width: 100%;\n" +
    "    height: 92%;\n" +
    "    background-color: white;\n" +
    "  }\n" +
    "  .page-buttom {\n" +
    "    background-color: #EEEDF3;\n" +
    "    width: 100%;\n" +
    "    height: 8%;\n" +
    "    min-height: 4em;\n" +
    "  }\n" +
    "  /********  cent-list  *********/\n" +
    "  #center-list-scroller{\n" +
    "    padding-top: 0.5em;\n" +
    "    padding-bottom: 0.5em;\n" +
    "  }\n" +
    "  /**********  page-button ******************/\n" +
    "  .page-buttom .item-input-inset{\n" +
    "    border: 0px solid white;\n" +
    "    /*height: 95%;*/\n" +
    "    height: 30px;\n" +
    "    padding: 0px 0px 0px 5%;\n" +
    "    width: 60%;\n" +
    "    float: left;\n" +
    "    margin: 0px;\n" +
    "    display: inline-block;\n" +
    "    background-color: #EEEDF3;\n" +
    "  }\n" +
    "  .basic-search{\n" +
    "    /*border: 1px solid red;*/\n" +
    "     padding: 0px 5% 0 0;\n" +
    "  }\n" +
    "  .basic-search input{\n" +
    "    height: 2em;\n" +
    "  }\n" +
    "  .basic-search .item-input-wrapper{\n" +
    "    border-bottom: 1px solid green;\n" +
    "    border-bottom-left-radius: 5px;\n" +
    "    border-bottom-right-radius: 5px;\n" +
    "  }\n" +
    "  \n" +
    "  .search-buttons {\n" +
    "    width: 40%;\n" +
    "    height: 100%;\n" +
    "    display: inline-block;\n" +
    "    float: right;\n" +
    "  }\n" +
    "  .search-buttons .search-button-wrapper{\n" +
    "    display: table;\n" +
    "  }\n" +
    "  .search-buttons div{\n" +
    "    display: table-cell;\n" +
    "    text-align: center;\n" +
    "    vertical-align: middle;\n" +
    "  }\n" +
    "  .search-buttons span{\n" +
    "    padding: 0.5em;\n" +
    "    font-size: 1em;\n" +
    "    font-color: #999;\n" +
    "  }\n" +
    "</style-->");
}]);
})();

(function(module) {
try { module = angular.module("hec-templates"); }
catch(err) { module = angular.module("hec-templates", []); }
module.run(["$templateCache", function($templateCache) {
  "use strict";
  $templateCache.put("html/wfl/wfl.html",
    "<ion-view view-title=\"审批\"  ng-controller=\"WflController\" id=\"approve-approve\" cache-view=\"true\">\n" +
    "	<ion-nav-view name=\"wflContent\"></ion-nav-view>\n" +
    "</ion-view>\n" +
    "");
}]);
})();

hec.service('LoginService', [
  'HecService',
function(appS){

}]);

hec.controller('LoginController', [
  '$scope',
  'LoginService',
function($scope, loginS){

}]);

/**
 * Created by mouse on 2015/9/11.
 */
hec.service("HecService", [function () {
    var contextPath = '';
    var urls = {
        'login': 'modules/weixin/sys/login.svc',
        'fun_list': 'autocrud/weixin.sys.sys_user_mobile_function_query/query',
        'todo_query': 'autocrud/weixin.wfl.wfl_todo_list_query/query'
    };
    return {
        getUrl: function (itfName) {
            return contextPath + '/' + urls[itfName];
        }
    }
}]).service('AuHttp', ['$http', '$q', '$filter', '$ionicPopup', function ($http, $q, $filter, $ionicPopup) {
    return {
        request: function (opt) {
            var delay = $q.defer();
            $http.post(opt.url, "_request_data=" + encodeURIComponent($filter('json')({parameter: opt.para})), {headers: {"Content-Type": "application/x-www-form-urlencoded"}}).success(function (data, status, headers, config) {
                var resultData = null;
                if (data.success) {
                    if (data && data.result) {
                        if (data.result.record) {
                            if (data.result.record.length) {
                                resultData = [];
                                resultData = data.result.record;
                            } else {
                                resultData.push(data.result.record);
                            }
                        }
                    }
                    delay.resolve({
                        data: resultData,
                        status: status,
                        headers: headers,
                        config: config,
                        resp: data
                    });
                } else {
                    $ionicPopup.alert({
                        title: '错误',
                        template: data.error.message
                    });

                    delay.reject({
                        data: resultData,
                        status: status,
                        headers: headers,
                        config: config,
                        resp: data
                    });
                }
            }).error(function (data, status, headers, config) {
                $ionicPopup.alert({
                    title: '错误',
                    template: '请求失败'
                });

                delay.reject({
                    data: data,
                    status: status,
                    headers: headers,
                    config: config,
                    resp: data
                });
            });
            return delay.promise;
        }
    }
}]);
hec.service('HomeService', [
    'HecService',
    function (appS) {

    }]);


hec.controller('HomeController', [
    '$scope',
    '$ionicSlideBoxDelegate',
    'HomeService',
    function ($scope, $ionicSlideBoxDelegate, homeS) {

        $scope.goState2 = function (state) {
            void 0;
            $state.go(state);
        }

        $scope.slideChanged = function (index) {
            $scope.slideIndex = index;
            void 0;
        };
        $scope.next = function () {
            $ionicSlideBoxDelegate.next();
        };
        $scope.previous = function () {
            $ionicSlideBoxDelegate.previous();
        };

        $scope.nineBlockData2 = [
            [
                {
                    imageUrl: 'http://a.hiphotos.baidu.com/baike/c0%3Dbaike80%2C5%2C5%2C80%2C26/sign=911e0d8af403738dca470470d272db34/5882b2b7d0a20cf419b28cf574094b36acaf99fd.jpg',
                    iconClass: '',
                    title: '审批单据',
                    state: 'wfl.main',
                    destUrl: 'wfl/main'
                },
                {
                    imageUrl: 'http://a.hiphotos.baidu.com/baike/c0%3Dbaike80%2C5%2C5%2C80%2C26/sign=911e0d8af403738dca470470d272db34/5882b2b7d0a20cf419b28cf574094b36acaf99fd.jpg',
                    iconClass: '',
                    title: '审批单据',
                    state: 'wfl.main'
                },
                {
                    imageUrl: 'http://a.hiphotos.baidu.com/baike/c0%3Dbaike80%2C5%2C5%2C80%2C26/sign=911e0d8af403738dca470470d272db34/5882b2b7d0a20cf419b28cf574094b36acaf99fd.jpg',
                    iconClass: '',
                    title: '审批单据',
                    state: 'wfl.main'
                }
            ],
            [
                {
                    imageUrl: 'http://a.hiphotos.baidu.com/baike/c0%3Dbaike80%2C5%2C5%2C80%2C26/sign=911e0d8af403738dca470470d272db34/5882b2b7d0a20cf419b28cf574094b36acaf99fd.jpg',
                    iconClass: '',
                    title: '审批单据',
                    state: 'wfl.main'
                },
                {
                    imageUrl: 'http://a.hiphotos.baidu.com/baike/c0%3Dbaike80%2C5%2C5%2C80%2C26/sign=911e0d8af403738dca470470d272db34/5882b2b7d0a20cf419b28cf574094b36acaf99fd.jpg',
                    iconClass: '',
                    title: '审批单据',
                    state: 'wfl.main'
                },
                {
                    imageUrl: 'http://a.hiphotos.baidu.com/baike/c0%3Dbaike80%2C5%2C5%2C80%2C26/sign=911e0d8af403738dca470470d272db34/5882b2b7d0a20cf419b28cf574094b36acaf99fd.jpg',
                    iconClass: '',
                    title: '审批单据',
                    state: 'wfl.main'
                }
            ],
            [
                {
                    imageUrl: 'http://a.hiphotos.baidu.com/baike/c0%3Dbaike80%2C5%2C5%2C80%2C26/sign=911e0d8af403738dca470470d272db34/5882b2b7d0a20cf419b28cf574094b36acaf99fd.jpg',
                    iconClass: '',
                    title: '审批单据',
                    state: 'wfl.main'
                },
                {
                    imageUrl: 'http://a.hiphotos.baidu.com/baike/c0%3Dbaike80%2C5%2C5%2C80%2C26/sign=911e0d8af403738dca470470d272db34/5882b2b7d0a20cf419b28cf574094b36acaf99fd.jpg',
                    iconClass: '',
                    title: '审批单据',
                    state: 'wfl.main'
                },
                {
                    imageUrl: 'http://a.hiphotos.baidu.com/baike/c0%3Dbaike80%2C5%2C5%2C80%2C26/sign=911e0d8af403738dca470470d272db34/5882b2b7d0a20cf419b28cf574094b36acaf99fd.jpg',
                    iconClass: '',
                    title: '审批单据',
                    state: 'wfl.main'
                }
            ]
        ];


    }]);

/**
* Created by mouse on 2015/9/17.
*/
hec.service("SysService", [
    "HecService",'AuHttp',
    function (hecS,auHttp) {
        return {
            login:function(option){
                auHttp.request({
                    url:hecS.getUrl('login'),
                    para:{
                        user_name:1811
                    }
                });
            }
        }
    }]);

hec.service('WflService', [
    '$http',
    '$timeout', 'AuHttp', 'HecService',
    function ($http, $timeout, auHttp, hecS) {
        return {
            queryTodoList: function (option) {
                opt = option || {};
                return auHttp.request({
                    url: hecS.getUrl('todo_query') + '?pagesize=' + ( opt.pagesize || 20) + '&pagenum=' + (opt.pagenum || 1) + '&_fetchall=' + (opt._fetchall || 'false') + '&_autocount=' + (opt.autocount || 'true'),
                    para: opt.para
                });
            }
        }
    }]);

hec.controller('WflController', [
    '$scope',
    '$timeout',
    'WflService',
    function ($scope, $timeout, wflS) {

        /*
         * 可供选择的模式：scan、select、search
         */
        $scope.approveModes = {
            SCAN: 0,
            SELECT: 1,
            SEARCH: 2
        };
        $scope.approveConfig = {
            scan_bottom_open: false,  // scan mode下的 basic search面板是否打开
            //senior_search_open: false, // 高级搜索面板是否打开
            search_placeholder: '输入单据信息'
        };
        $scope.seniorSearchConfig = {
            OERDER_NUMBER: '',
            fromDate: '',
            toDate: '',
            ORDER_STATUS: '',
            ORDER_PROVIDER: '',
            ORDER_FAST: false
        };
        $scope.approveMode = $scope.approveModes.SCAN;

        $scope.toogleScanBottom = function () {
            $scope.approveConfig.scan_bottom_open = !$scope.approveConfig.scan_bottom_open;
        };
        $scope.toogleSearchBottom = function () {
            switch ($scope.approveMode) {
                case $scope.approveModes.SEARCH:
                    $scope.approveMode = $scope.approveModes.SCAN;
                    break;
                case $scope.approveModes.SCAN:
                    $scope.approveMode = $scope.approveModes.SEARCH;
                    break;
            }
            //$scope.approveConfig.senior_search_open = !$scope.approveConfig.senior_search_open;
        };

        $scope.enterMode = function (mode) {
            switch (mode) {
                case $scope.approveModes.SCAN:
                    enterScanMode();
                    break;
                case $scope.approveModes.SELECT:
                    enterSelectMode();
                    break;
                case $scope.approveModes.SEARCH:
                    enterSearchMode();
                    break;
                default:
            }
        };

        $scope.listClicked = function (e) {
            void 0;
        };

        $scope.isScanMode = function () {
            return $scope.approveMode == $scope.approveModes.SCAN;
        };

        $scope.isSelectMode = function () {
            return $scope.approveMode == $scope.approveModes.SELECT;
        };

        $scope.isSearchMode = function () {
            return $scope.approveMode == $scope.approveModes.SEARCH;
        };

        $scope.basicRemoteSearch = function () {

        };
        $scope.seniorRemoteSearch = function () {

        };

        function enterScanMode() {

        }

        function enterSelectMode() {

        }

        function enterSearchMode() {

        }

        $scope.selectStatus = [true, false, false, false];
        $scope.senior_selectStatus = function (i) {
            $scope.selectStatus = [false, false, false, false];
            $scope.selectStatus[i] = true;
        };

        $scope.hideSeniorPanel = function (event) {
            void 0;
            $scope.approveMode = $scope.approveModes.SCAN;
        };
        $scope.notHideSeniorPanel = function () {

        };


        // 全选相关    item.selected、currentSelectedItems、approveMode 三者须同步变化
        $scope.isSelectedAll = false;
        $scope.showSelectAll = false;
        $scope.currentSelectedItems = 0;
        $scope.selectAll = function () {
            var maxIndex = $scope.listItemDatas.length - 1;
            for (var i = maxIndex; i >= 0; i--) {
                $scope.listItemDatas[i].selected = true;
            }
            $scope.currentSelectedItems = $scope.listItemDatas.length;
            $scope.approveMode = $scope.approveModes.SELECT;
            $scope.isSelectedAll = true;
            $scope.showSelectAll = false;
        };
        $scope.unSelectAll = function () {
            var maxIndex = $scope.listItemDatas.length - 1;
            for (var i = maxIndex; i >= 0; i--) {
                $scope.listItemDatas[i].selected = false;
            }
            $scope.currentSelectedItems = 0;
            $scope.approveMode = $scope.approveModes.SCAN;
            $scope.isSelectedAll = false;
        };
        $scope.selectItem = function (item) {
            if (item.selected) {
                item.selected = false;
                $scope.currentSelectedItems--;
            } else {
                item.selected = true;
                $scope.currentSelectedItems++;
                $scope.approveMode = $scope.approveModes.SELECT;
            }
            if ($scope.currentSelectedItems <= 0) {
                $scope.approveMode = $scope.approveModes.SCAN;
            }
            $scope.isSelectedAll = ($scope.currentSelectedItems == $scope.listItemDatas.length);
        };
        $scope.clickNumberButton = function () {
            void 0;
            void 0;
            void 0;
            void 0;
            $scope.showSelectAll = true;
        };
        //  Over ...

        // WFLListController... 加载数据相关
        $scope.loadMoreData = function () {
            void 0;
            $scope.isLoadingMore = true;
            var page = Math.ceil($scope.listItemDatas.length / 20) + 1;
            wflS.queryTodoList({pagenum: page}).then(function (resp) {
                if (resp.data) {
                    for (var i = resp.data.length - 1; i >= 0; i--) {
                        $scope.listItemDatas.push(resp.data[i]);
                    }
                } else {
                    $scope.noMoreData = true;
                }
                $scope.$broadcast('scroll.infiniteScrollComplete');
            }, function (resp) {
                $scope.noMoreData = true;
                $scope.$broadcast('scroll.infiniteScrollComplete');
            });
            $scope.isLoadingMore = false;
        };
        $scope.refresherText = '刷新页面';
        $scope.downRefreshList = function () {
            $timeout(function () {
                $scope.$broadcast('scroll.refreshComplete');
            }, 1000);
        };
        $scope.onPulling = function () {
            $scope.refresherText = '松开刷新';
        };
        $scope.reloadData = function () {
            $scope.noMoreData = false;
            $scope.isLoadingMore = true;
            $scope.listItemDatas = [];
            wflS.queryTodoList({pagenum: 1}).
                then(function (resp) {
                    if (resp.data) {
                        $scope.listItemDatas = resp.data;
                    } else {
                        $scope.noMoreData = true;
                    }
                }, function (resp) {
                    $scope.noMoreData = true;
                });
            $scope.$broadcast('scroll.refreshComplete');
            $scope.isLoadingMore = false;
        };
        $scope.noMoreData = false;
        $scope.isLoadingMore = false;


        //$scope.$on('stateChangeSuccess', function () {
        //    $scope.loadMoreData();
        //});
        $scope.listItemDatas = [];


    }]);

hec.controller('WflListController', ['$scope', function ($scope) {

}]);