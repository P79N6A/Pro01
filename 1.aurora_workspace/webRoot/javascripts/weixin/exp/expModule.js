/**
 * Created by mouse on 2015/9/23.
 */
hec.service('ExpService', ['AuHttp', 'HecService', function (auHttp, hecS) {
    return {
        queryEmployeeDetail: function (option) {
            opt = option || {};
            return auHttp.request({
                url: hecS.getUrl('employee_detail') + '?pagesize=' + ( opt.pagesize || hecS.resultLength) + '&pagenum=' + (opt.pagenum || 1) + '&_fetchall=' + (opt._fetchall || 'false') + '&_autocount=' + (opt.autocount || 'true'),
                para: opt.para
            });
        },
        /**
         * employee_list：员工列表查询
         * 参数：
         * exp_emp_name（可选）：员工姓名
         * 返回值：
         * exp_emp_id：员工ID
         * exp_emp_name：员工姓名
         * exp_emp_org_info：员工组织架构信息
         */
        queryEmployeeList: function (option) {
            opt = option || {};
            return auHttp.request({
                url: hecS.getUrl('employee_list') + '?pagesize=' + ( opt.pagesize || hecS.resultLength) + '&pagenum=' + (opt.pagenum || 1) + '&_fetchall=' + (opt._fetchall || 'false') + '&_autocount=' + (opt.autocount || 'true'),
                para: opt.para
            });
        }
    }
}]);