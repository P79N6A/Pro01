var curPage = 0; //当前页码
var total=getData(0);//总条数
var pageSize=5;//每页数
var totalPage=total/pageSize; //总页数

function  clickItemFirst() {
    curPage=0;
    getData(curPage);
}
function  clickItemPre() {
    if(curPage>=1){curPage=curPage-1;getData(curPage);}
}
function  clickItemNext() {
    if(curPage<total/pageSize-1){//一定别忘了减1！！！！因为是从第0页开始的
        curPage=curPage+1;
        getData(curPage);
    }
}
function  clickItemEnd() {
    curPage=Math.floor(total/pageSize);
    getData(curPage)
}
var aaa=0;

function getData(page){
    var   ttt;
    $.ajax({
        url:'/ItemController/myPageTest?pageNum='+page+'&pageSize='+5,
        type:'GET',
        data: {},
        async: false,//！！！！！！！ 同步这样才能执行完再传出去
        beforeSend:function(){
        },
        success:function(json){
            console.log("结果是"+json.list);
            for(var i=0;i<json.list.length;i++){
                console.log(json.list[i]);
                // $('#reply_'+mid).prepend("<dl style='background-color:pink;'><dt>"+content+"</dt><dd>回复者："+name+"</dd><dd>回复时间："+time+"</dd></dl>");
            }
            ttt = json.total.valueOf(); //总记录数
            pageSize=5;
            curPage = page; //当前页
            totalPage = json.totalPage; //总页数
            var ul=$('.tbody3_Item').find('*').remove();
            string='';
            $.each(json.list,function(index,array){ //遍历json数据列
                string += "<tr>" +
                    "<td>" + "<input type='checkbox' value='check'></td>" +
                    "<td contentEditable='true'>"+array['todoItemId']+"</td>" +
                    "<td>"+array['userId']+"</td>" +
                    "<td>"+array['todoItemTitle']+"" + "</td>" +
                    "<td>"+array['todoItemContent']+"" + "</td>" +
                    "<td>"+array['priority']+"" + "</td>" +
                    "<td>"+array['creationDate']+"" + "</td>" +
                    "<td>"+array['lastUpdateDate']+"" + "</td>" +
                    "<td>"+array['comments']+"" + "</td>" +
                    "<td>" +
                    "<select id='permission' name='type'>" +
                    "<option value ='present'>权限控制</option>" +
                    "<option value ='none'>超级管理员</option>" +
                    "<option value ='all'>普通管理员</option>" +
                    "<option value ='order'>用户</option>" +
                    "<option value ='customer'>无权限</option>" +
                    "</select>" +
                    "</td>" +
                    "</tr>";

            });
            $('.tbody3_Item').append(string);
        },
        complete:function(){ //生成分页条
            // getPageBar();
        },
        error:function(){
            alert("数据加载失败");
        }
    });
    return ttt;
}