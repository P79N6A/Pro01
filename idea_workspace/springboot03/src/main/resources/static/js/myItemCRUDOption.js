
function selectItemFun(){
    var todoItemId=$("#textItem1").val();
    $.ajax({
        url:'/ItemController/singleBaseSelect?id='+todoItemId,
        type:'GET',
        data: {},
        async: false,//！！！！！！！ 同步这样才能执行完再传出去
        beforeSend:function(){
        },
        success:function(res){
            $("#textItem2").val(res.userId);
            $("#textItem3").val(res.todoItemTitle);
            $("#textItem4").val(res.todoItemContent);
            $("#textItem5").val(res.priority);
            $("#textItem6").val(res.creationDate);
            $("#textItem7").val(res.lastUpdateDate);
            $("#textItem8").val(res.comments);
        },
        complete:function(){ //生成分页条
        },
        error:function(){
            alert("数据加载失败");
        }
    });
}

function insertItemFun(){
    if($("#textItem3").val()=='') {
        alert('必须输事件标题！');
        document.getElementById('textItem3').focus();
        return ;
    }
    if($("#textItem5").val()=='') {
        alert('必须输入优先级！');
        document.getElementById('textItem5').focus();
        return ;
    }
    data={
        "todoItemId":$("#textItem1").val(),
        "userId":$("#textItem2").val(),
        "todoItemTitle":$("#textItem3").val(),
        "todoItemContent":$("#textItem4").val(),
        "priority": $("#textItem5").val(),
        "creationDate":$("#textItem6").val(),
        "lastUpdateDate":$("#textItem7").val(),
        "comments":$("#textItem8").val(),
    }
    ;
    $.ajax({
        contentType: "application/json;charset=UTF-8",
        url:'/ItemController/singleBaseInsert',
        type:'POST',
        data: JSON.stringify(data),
        async: false,//！！！！！！！ 同步这样才能执行完再传出去
        beforeSend:function(){
        },
        success:function(res){
            alert("增加成功");
        },
        complete:function(){ //生成分页条
        },
        error:function(){
            alert("数据加载失败");
        }
    });
}
function deleteItemFun(){
    var todoItemId=$("#textItem1").val();
    $.ajax({
        url:'/ItemController/singleBaseDelete?id='+todoItemId,
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
function updateItemFun(){
    data={
        "todoItemId":$("#textItem1").val(),
        "userId":$("#textItem2").val(),
        "todoItemTitle":$("#textItem3").val(),
        "todoItemContent":$("#textItem4").val(),
        "priority": $("#textItem5").val(),
        "creationDate":$("#textItem6").val(),
        "lastUpdateDate":$("#textItem7").val(),
        "comments":$("#textItem8").val()
    }
    ;
    $.ajax({
        type:'POST',
        contentType: "application/json;charset=UTF-8",
        url:'/ItemController/singleBaseUpdate',
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