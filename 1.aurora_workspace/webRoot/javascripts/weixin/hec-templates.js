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
