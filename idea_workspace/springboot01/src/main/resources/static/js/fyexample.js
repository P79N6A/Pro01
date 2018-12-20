function setPage(){
    var pagesize = 3;//每页显示的记录数
    var recondsize = 0;//总记录数
    var countpage = 0;//总页数
    var nowpage= 1;
    var users = new Array();//存放所有的记录

    var start = 0; //保存当前页开始的记录
    var end = 0 ;//保存当前页结束的记录

    var domUserName = $("userName");
    var domUserSex = $("userSex");
    var domUserRole = $("userRole");

    var domshowUsers = $("showUsers");
    var addBtn = $("addUsers");

//为按钮注册事件
    addBtn.onclick = function() {
//创建user对象
        var user = new User(domUserName.value, domUserSex.value,
            domUserRole.value);
//把user对象存放数组中
        users.push(user);
        recondsize = users.length; //得出总记录数
//计算出总页数
        countpage = recondsize % pagesize == 0 ? recondsize / pagesize : Math
            .ceil(recondsize / pagesize);

        if (recondsize > pagesize) { //当总记录大于pagezie 思路 从后往前数3个数
            start = recondsize-pagesize;
            end=recondsize;
        }else{ // pagesize start =1;
            start=0;
            end=recondsize; //end=实际的个数 就是 recondsize
        }

        //调用显示user的方法
        showUser(users,start,end,recondsize,countpage,domshowUsers);

    }
    //获取分页相关的按钮
    var firstPage = $("firstPage");
    var backPage = $("backPage");
    var nextPage = $("nextPage");
    var lastPage = $("lastPage");

    firstPage.onclick = function() {
        nowpage = 1;

        if (recondsize<= pagesize && recondsize > 0) {
            start = 0;
            end = recondsize;
        }else{
            start=0;
            end=pagesize;
        }

        showUser(users,start,end,recondsize,countpage,domshowUsers);

    }


    backPage.onclick = function() {
        nowpage = nowpage-1;//重新赋值

        if(nowpage<=1){
            nowpage=1;
        }

        if (recondsize <= pagesize && recondsize > 0) {
            start = 0;
            end = recondsize;
        }else{
            start=(nowpage-1)*pagesize;
            end = (nowpage-1)*pagesize+pagesize;
        }

        showUser(users,start,end,recondsize,countpage,domshowUsers);

    }

    nextPage.onclick = function() {
        nowpage = nowpage+1;//重新赋值

        if(nowpage>=countpage){
            nowpage=countpage;
        }

        if (recondsize <= pagesize && recondsize > 0) {
            start = 0;
            end = recondsize;
        }else{
            start=(nowpage-1)*pagesize;
            if((nowpage-1)*pagesize+pagesize>=recondsize){
                end = recondsize;
            }else{
                end =(nowpage-1)*pagesize+pagesize;
            }
        }
        showUser(users,start,end,recondsize,countpage,domshowUsers);

    }
    lastPage.onclick = function() {
        nowpage = countpage;//重新赋值

        if (recondsize <= pagesize && recondsize > 0) {
            start = 0;
            end = recondsize;
        }else{
            start=(nowpage-1)*pagesize;
            end = recondsize;
        }
        showUser(users,start,end,recondsize,countpage,domshowUsers);

    }

}

//创建一个Function函数 函数是保存User对象数据的
function User(name, sex, role) {
    this.name = name;
    this.sex = sex;
    this.role = role;
}

function $(id) {
    return document.getElementById(id);
}

function showUser(users,start,end,recondsize,countpage,domshowUsers){

//清空数据
    for ( var jj = 0; jj < domshowUsers.childNodes.length;) {
        domshowUsers.removeChild(domshowUsers.childNodes[jj]);
    }

    //for循环添加的
    for(var i=start;i<end;i++){
        var user = users[i];//考虑
        //创建一行
        var tr = document.createElement("tr");
//创建列
        var td1 = document.createElement("td");
//创建文本节点
        var td1TextNode = document.createTextNode(user.name);
//文本节点添加到td中
        td1.appendChild(td1TextNode);

//创建列
        var td2 = document.createElement("td");
//创建文本节点
        var td2TextNode = document.createTextNode(user.sex);
//文本节点添加到td中
        td2.appendChild(td2TextNode);

//创建列
        var td3 = document.createElement("td");
//创建文本节点
        var td3TextNode = document.createTextNode(user.role);
//文本节点添加到td中
        td3.appendChild(td3TextNode);

//把列添加到行中
        tr.appendChild(td1);
        tr.appendChild(td2);
        tr.appendChild(td3);

//把行添加到tbody中
        if(domshowUsers.hasChildNodes()){
            domshowUsers.insertBefore(tr,domshowUsers.firstChild);//再最后一个数据之前添加数据
        }else{
            domshowUsers.appendChild(tr);//添加到末尾
        }
    }
    document.getElementById("msg").innerHTML = "总共：{" + recondsize
        + "}条记录,共{" + countpage + "}页";
}