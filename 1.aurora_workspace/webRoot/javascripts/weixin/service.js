/**
 * Created by mouse on 2015/9/11.
 */
hec.service("HecService", [function () {
    var hostName = 'http://hec3dev.imwork.net';
    var resultLength = 10;
    var urls = {
        'login': hostName + '/' + 'modules/weixin/sys/login.svc',
        'fun_list': hostName + '/' + 'autocrud/weixin.sys.sys_user_mobile_function_query/query',
        'todo_query': hostName + '/' + 'autocrud/weixin.wfl.wfl_todo_list_query/query',
        'employee_detail': hostName + '/' + 'modules/weixin/exp/exp_employee_detail_query.svc',
        'employee_list': hostName + '/' + 'autocrud/weixin.exp.exp_employee_list_query/query',
        'todo_count_query': hostName + '/' + 'autocrud/weixin.wfl.wfl_todo_count_query/query',
        'notify_count_query': hostName + '/' + 'autocrud/weixin.wfl.wfl_notify_count_query/query',
        'done_query': hostName + '/' + 'autocrud/weixin.exp.exp_employee_list_query/query',
        'notify_query': hostName + '/' + 'autocrud/weixin.wfl.wfl_notify_list_query/query',
        'approve': hostName + '/' + 'autocrud/db.sys_mobile_pkg.wfl_approve/batch_apply',
        'commission': hostName + '/' + 'autocrud/db.sys_mobile_pkg.wfl_commission/batch_apply',
        'notify': hostName + '/' + 'autocrud/db.sys_mobile_pkg.wfl_notify/batch_apply',
        'add_approver': hostName + '/' + 'autocrud/db.sys_mobile_pkg.wfl_add_approver/batch_apply',
        'approve_record_query': hostName + '/' + 'autocrud/weixin.wfl.wfl_approve_record_query/query'
    };
    return {
        getUrl: function (itfName) {
            //return contextPath + '/' + urls[itfName];
            return urls[itfName];
        },
        resultLength: resultLength
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
                                resultData = data.result.record;
                            } else {
                                resultData = [];
                                resultData.push(data.result.record);
                            }
                        }
                    }
                    delay.resolve({
                        data: resultData,
                        status: status,
                        headers: headers,
                        config: config,
                        response: data
                    });
                } else {
                    var msgBox = $ionicPopup.alert({
                        title: '错误',
                        template: data.error.message
                    });

                    delay.reject({
                        data: resultData,
                        status: status,
                        headers: headers,
                        config: config,
                        response: data,
                        msgBox: msgBox
                    });
                }
            }).error(function (data, status, headers, config) {
                var msgBox = $ionicPopup.alert({
                    title: '错误',
                    template: '请求失败'
                });

                delay.reject({
                    data: data,
                    status: status,
                    headers: headers,
                    config: config,
                    resp: data,
                    msgBox: msgBox
                });
            });
            return delay.promise;
        }
    }
}]);