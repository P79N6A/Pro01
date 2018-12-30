function setCookie(userName,password){
    $.cookie("userName", userName);
    $.cookie("password", password);
}
function login() {
    var userName=$.trim($("#txtUserName").val());
    var password=$("#tetPassword").val()

    if(userName==null || password==null){
        alert("用户名或密码为空,请重新输入！")
    return false;
    }
    if (password.length < 8) {
        alert("密码长度不能小于8，请重新输入！")
        return false;
    }
    var reg = new RegExp(/^(?![^a-zA-Z]+$)(?!\D+$)/);
    if (reg.test(password)!=true){
        alert("密码至少一位数字和字母!")
        return false;
    }

    $.ajax({//几个参数需要注意一下
        type: "GET",//方法类型
        url: "/UserController/checkUser" ,
        data: {"userName":userName,"password":password},
        success: function (result) {
            console.log(result);//打印服务端返回的数据(调试用)
            if(result.status=="OK" &&result.data!=0){alert("用户名密码正确，登陆成功");
                // localStorage.setItem("userName",userName);//H5 统一域名才有效
                // localStorage.setItem("password",password);
                // setCookie("userName",userName);
                // setCookie("password",password);
                setCookie(userName,password)
                window.location.href="http://localhost:8090/index";
                console.log(localStorage.getItem("userName")+localStorage.getItem("password"));

            }else{alert("登录失败");}
        },
        dataType: "json",//预期服务器返回的数据类型,
        error : function() {alert("异常！");}
    });
}