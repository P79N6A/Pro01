hec.service('WflService', [
    '$http',
    '$timeout', 'AuHttp', 'HecService',
    function ($http, $timeout, auHttp, hecS) {
        return {
            /**
             * todo_query:待办事项查询
             * 参数:
             * ins_doc_num（可选）：单据编码
             * ins_sub_emp（可选）：单据提交人
             * ins_sub_date_from（可选）：单据提交日期从
             * ins_sub_date_to（可选）：单据提交日期到
             * ins_doc_desc（可选）：单据描述
             * ins_doc_type（可选）：单据类别
             * ins_node_name（可选）：单据节点名称
             * ins_doc_category（可选）：单据类别
             *                          ACP_REQUISITION         付款申请单
             *                          BUDGET_JOURNAL          预算记账
             *                          CON_CONTRACT            合同
             *                          EXP_REPORT              费用报销单
             *                          EXP_REQUISITION         费用申请单
             *                          EXP_TRAVEL_PLAN         差旅计划
             *                          OA_FLOW                 BPM流程申请
             *                          PAYMENT_REQUISITION     借款申请单
             *                          PTL_ANNOUNCEMENT        门户公告
             *                          PTL_FILES               文档管理
             * 返回值:
             * ins_doc_num：单据编码
             * ins_sub_emp：单据提交人
             * ins_sub_date：单据提交日期
             * ins_sub_date_format：格式化后的单据提交日期
             * ins_doc_amount：单据金额
             * ins_doc_desc：单据描述
             * ins_id：工作流实例ID
             * ins_node_id：工作流节点ID、
             * ins_node_name：工作流节点名称
             * ins_rcpt_id：待办事项接受者ID
             * ins_doc_category：单据类别
             * ins_doc_category_desc：单据类别描述
             */
            queryTodoList: function (option) {
                opt = option || {};
                return auHttp.request({
                    url: hecS.getUrl('todo_query') + '?pagesize=' + ( opt.pagesize || hecS.resultLength) + '&pagenum=' + (opt.pagenum || 1) + '&_fetchall=' + (opt._fetchall || 'false') + '&_autocount=' + (opt.autocount || 'true'),
                    para: opt.para
                });
            },
            /**
             * todo_count_query：工作流待办数量查询接口
             * 参数：
             * 无
             * 返回值：
             * todo_count：待办数量
             */
            queryTodoCount: function (option) {
                opt = option || {};
                return auHttp.request({
                    url: hecS.getUrl('todo_count_query') + '?pagesize=' + ( opt.pagesize || hecS.resultLength) + '&pagenum=' + (opt.pagenum || 1) + '&_fetchall=' + (opt._fetchall || 'false') + '&_autocount=' + (opt.autocount || 'true'),
                    para: opt.para
                });
            },
            /**
             * notify_count_query：工作流通知数量查询接口
             * 参数：
             * 无
             * 返回值：
             * notify_count：通知数量
             */
            queryNotifyCount: function (option) {
                opt = option || {};
                return auHttp.request({
                    url: hecS.getUrl('notify_count_query') + '?pagesize=' + ( opt.pagesize || hecS.resultLength) + '&pagenum=' + (opt.pagenum || 1) + '&_fetchall=' + (opt._fetchall || 'false') + '&_autocount=' + (opt.autocount || 'true'),
                    para: opt.para
                });
            },
            /**
             * done_query：待办事项查询
             * 参数：
             * 无
             * 返回值：
             * ins_doc_num：工作流单据编号
             * ins_sub_emp：工作流单据提交人
             * ins_sub_date：工作流单据提交时间
             * ins_sub_date_format：格式化后的单据提交日期
             * ins_doc_amount：工作流单据金额
             * ins_doc_desc：工作流单据描述
             * ins_id：工作流ID
             * ins_node_id：工作流节点ID
             * ins_node_name：工作流节点名称
             * ins_doc_category：工作流单据类别
             * ins_doc_category_desc：工作流单据类别描述
             * ins_param：工作流单据ID
             */
            queryDoneList: function (option) {
                opt = option || {};
                return auHttp.request({
                    url: hecS.getUrl('done_query') + '?pagesize=' + ( opt.pagesize || hecS.resultLength) + '&pagenum=' + (opt.pagenum || 1) + '&_fetchall=' + (opt._fetchall || 'false') + '&_autocount=' + (opt.autocount || 'true'),
                    para: opt.para
                });
            },
            /**
             * notify_query：通知事项查询
             * 参数：
             * 无
             * 返回值：
             * notify_id：通知ID
             * notify_note：通知备注
             * ins_doc_num：工作流单据编号
             * ins_sub_emp：工作流单据提交时间
             * ins_sub_date_format：工作流单据提交时间格式化
             * ins_id：工作流ID
             * ins_node_id：工作流节点ID
             * ins_node_name：工作流节点名称
             * ins_doc_category_desc：工作流单据类别描述
             * ins_doc_desc：通知备注
             */
            queryNotifyList: function (option) {
                opt = option || {};
                return auHttp.request({
                    url: hecS.getUrl('notify_query') + '?pagesize=' + ( opt.pagesize || hecS.resultLength) + '&pagenum=' + (opt.pagenum || 1) + '&_fetchall=' + (opt._fetchall || 'false') + '&_autocount=' + (opt.autocount || 'true'),
                    para: opt.para
                });
            },
            /**
             * approve：工作流审批接口
             * 参数：数组
             * action_type：审批类型
             *              APPROVE    通过
             *              REJECT      拒绝
             * comment：审批意见
             * rcpt_id：工作流待办接受者ID
             */
            approve: function (option) {
                var para = [];
                if (option.length) {
                    for (var i = 0; i < option.length; i++) {
                        option[i]._status = 'execute';
                    }
                    para = option;
                } else {
                    option._status = 'execute';
                    para.push(option);
                }
                return auHttp.request({
                    url: hecS.getUrl('approve'),
                    para: para
                });
            },
            /**
             * commission：工作流转交接口
             * 参数：数组
             * rcpt_id：工作流待办接受者ID
             * commission_emp_id：转交员工ID
             * comment：转交意见
             */
            commission: function (option) {
                var para = [];
                if (option.length) {
                    for (var i = 0; i < option.length; i++) {
                        option[i]._status = 'execute';
                    }
                    para = option;
                } else {
                    option._status = 'execute';
                    para.push(option);
                }
                return auHttp.request({
                    url: hecS.getUrl('commission'),
                    para: para
                });
            },
            /**
             * notify：工作流通知接口
             * 参数：数组
             * instance_id：工作流实例ID
             * node_id：工作流节点ID
             * notify_emp_id：通知员工ID
             * note：通知备注
             */
            notify: function (option) {
                var para = [];
                if (option.length) {
                    for (var i = 0; i < option.length; i++) {
                        option[i]._status = 'execute';
                    }
                    para = option;
                } else {
                    option._status = 'execute';
                    para.push(option);
                }
                return auHttp.request({
                    url: hecS.getUrl('notify'),
                    para: para
                });
            },
            /**
             * add_approver：工作流添加审批人接口
             * 参数：数组
             * rcpt_id：工作流待办接受者ID
             * priority：添加顺序，之前[BEFORE]，平行[PARALLEL]，之后[AFTER]
             * comment：添加意见
             * add_emp_id：添加员工ID
             */
            addApprover: function (option) {
                var para = [];
                if (option.length) {
                    for (var i = 0; i < option.length; i++) {
                        option[i]._status = 'execute';
                    }
                    para = option;
                } else {
                    option._status = 'execute';
                    para.push(option);
                }
                return auHttp.request({
                    url: hecS.getUrl('add_approver'),
                    para: para
                });
            },
            /**
             * approve_record_query：审批记录查询接口
             * 参数
             * ins_id:工作流实例ID
             * 返回值：
             * approve_action_title：审批动作标题
             * approve_user_name：审批者姓名
             * approve_comment：审批意见
             * approve_user_id：审批用户ID
             * approve_date：approve_date
             * approve_date_format：审批日期格式化
             */
            queryApproveRecord: function (option) {
                opt = option || {};
                return auHttp.request({
                    url: hecS.getUrl('approve_record_query') + '?pagesize=' + ( opt.pagesize || hecS.resultLength) + '&pagenum=' + (opt.pagenum || 1) + '&_fetchall=' + (opt._fetchall || 'false') + '&_autocount=' + (opt.autocount || 'true'),
                    para: opt.para
                });
            }
        }
    }]);

hec.controller('WflController', [
    '$scope',
    '$timeout',
    'HecService',
    'WflService',
    function ($scope, $timeout, hecS, wflS) {

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
            console.log(e);
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

        $scope.hideSeniorPanel = function ($event) {
            var $target = angular.element($event.target);
            var attrs = $target[0].attributes;
            for (var i = (attrs.length - 1); i >= 0; i--) {
                var attr = attrs[i];
                if ((attr.name == "cound-hide")) {
                    $scope.approveMode = $scope.approveModes.SCAN;
                }
            }
        };
        $scope.notHideSeniorPanel = function ($event) {
            var target = $event.target;
            var $target = angular.element(target);


            console.log($target);
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
            console.log($scope.isSelectMode() && $scope.showSelectAll && !$scope.isSelectedAll);
            console.log($scope.showSelectAll);
            console.log($scope.isSelectMode());
            console.log(!$scope.isSelectedAll);
            $scope.showSelectAll = true;
        };
        //  Over ...

        // WFLListController... 加载数据相关
        $scope.loadMoreData = function () {
            if ($scope.isLoadingMore)
                return;
            $scope.isLoadingMore = true;
            $scope.noMoreData = true;
            var page = Math.ceil($scope.listItemDatas.length / hecS.resultLength) + 1;
            wflS.queryTodoList({pagenum: page}).then(function (resp) {
                if (resp.data) {
                    for (var i = resp.data.length - 1; i >= 0; i--) {
                        $scope.listItemDatas.push(resp.data[i]);
                    }
                    if (resp.response.result && resp.response.result.totalCount) {
                        if (resp.response.result.totalCount >= hecS.resultLength) {
                            $scope.noMoreData = false;
                        } else {
                            $scope.noMoreData = true;
                        }
                    } else {
                        $scope.noMoreData = false;
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
            if ($scope.isLoadingMore)
                return;
            $scope.noMoreData = true;
            $scope.isLoadingMore = true;
            $scope.listItemDatas = [];
            wflS.queryTodoList({pagenum: 1}).
                then(function (resp) {
                    if (resp.data) {
                        $scope.listItemDatas = resp.data;
                        if (resp.response.result && resp.response.result.totalCount) {
                            if (resp.response.result.totalCount >= hecS.resultLength) {
                                $scope.noMoreData = false;
                            } else {
                                $scope.noMoreData = true;
                            }
                        } else {
                            $scope.noMoreData = false;
                        }
                    } else {
                        $scope.noMoreData = true;
                    }
                }, function (resp) {
                    $scope.noMoreData = true;
                });
            $scope.$broadcast('scroll.refreshComplete');
            $scope.isLoadingMore = false;
        };
        $scope.noMoreData = true;
        $scope.isLoadingMore = false;
        $scope.listItemDatas = [];
    }]);

hec.controller('WflListController', ['$scope', function ($scope) {

}]);