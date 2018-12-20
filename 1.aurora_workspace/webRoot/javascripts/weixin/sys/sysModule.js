/**
 * Created by mouse on 2015/9/17.
 */
hec.service("SysService", [
    "HecService", 'AuHttp',
    function (hecS, auHttp) {
        return {
            /**
             * login：用户登陆
             * 参数：
             * user_name：用户名
             * ticket：微信登陆票据
             * 返回值：无
             */
            login: function (option) {
                return auHttp.request({
                    url: hecS.getUrl('login'),
                    para: {
                        user_name: option.user_name,
                        ticket: option.ticket
                    }
                });
            }
        }
    }]).directive('hecLogin', ['SysService', function (sysS) {
    return {
        template: '',
        link: function ($scope, element, attrs) {
            sysS.login({
                user_name: attrs.userName,
                ticket: attrs.ticket
            }).then(function (resp) {
                window.location.href = 'index.html';
            });
        }
    }
}]);
