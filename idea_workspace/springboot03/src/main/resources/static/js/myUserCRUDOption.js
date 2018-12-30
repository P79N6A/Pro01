function selectFun(){
    var id=$("#text1").val();
    $.ajax({
        url:'/UserController/singleBaseSelect?id='+id,
        type:'GET',
        data: {},
        async: false,//！！！！！！！ 同步这样才能执行完再传出去
        beforeSend:function(){
        },
        success:function(res){
            console.log(res);
            console.log(res.userName);
            $("#text2").val(res.userName);
            $("#text3").val(res.password);
            $("#text4").val(res.sex);
            $("#text5").val(res.age);
            $("#text6").val(res.phoneNumber);
            $("#text7").val(res.comments);
            $("#text8").val(res.creationDate);
            $("#text9").val(res.lastUpdateDate);
        },
        complete:function(){ //生成分页条
        },
        error:function(){
            alert("数据加载失败");
        }
    });
}

function insertFun(){
    if($("#text2").val()=='') {
        alert('必须输入姓名！');
        document.getElementById('text2').focus();
        return ;
    }
    if($("#text3").val()=='') {
        alert('必须输入密码！');
        document.getElementById('text2').focus();
        return ;
    }

    data={
        "userId":$("#text1").val(),
        "userName":$("#text2").val(),
        "password":$("#text3").val(),
        "sex":$("#text4").val(),
        "age": $("#text5").val(),
        "phoneNumber":$("#text6").val(),
        "comments":$("#text7").val(),
    }
    ;
    $.ajax({
        contentType: "application/json;charset=UTF-8",
        url:'/UserController/singleBaseInsert',
        type:'POST',
        data: JSON.stringify(data),
        async: false,//！！！！！！！ 同步这样才能执行完再传出去
        beforeSend:function(){
        },
        success:function(res){
            console.log("结果"+res)
            console.log(res.status)
            if(res){
                alert("增加成功");
            }
        },
        complete:function(){ //生成分页条
        },
        error:function(){
            alert("数据加载失败");
        }
    });
}
function deleteFun(){
    var id=$("#text1").val();
    $.ajax({
        url:'/UserController/singleBaseDelete?id='+id,
        type:'GET',
        data: {},
        async: false,//！！！！！！！ 同步这样才能执行完再传出去
        beforeSend:function(){
        },
        success:function(res){
            alert("删除成功！");
        },
        complete:function(){ //生成分页条
        },
        error:function(){
            alert("数据加载失败");
        }
    });
}
function updateFun(){
    if($("#text2").val()=='') {
        alert('必须输入姓名！');
        document.getElementById('text2').focus();
        return ;
    }
    if($("#text3").val()=='') {
        alert('必须输入密码！');
        document.getElementById('text2').focus();
        return ;
    }

    data={
        "userId":$("#text1").val(),
        "userName":$("#text2").val(),
        "password":$("#text3").val(),
        "sex":$("#text4").val(),
        "age": $("#text5").val(),
        "phoneNumber":$("#text6").val(),
        "comments":$("#text7").val(),
        "creationDate":$("#text8").val(),
        "lastUpdateDate":$("#text9").val(),
    }
    ;
    $.ajax({
        type:'POST',
        contentType: "application/json;charset=UTF-8",
        url:'/UserController/singleBaseUpdate',
        data: JSON.stringify(data),
        async: false,//！！！！！！！ 同步这样才能执行完再传出去
        beforeSend:function(){
        },
        success:function(res){
            console.log("结果"+res)
            alert("更新成功");
        },
        complete:function(){ //生成分页条
        },
        error:function(){
            alert("数据加载失败");
        }
    });
}