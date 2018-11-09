/*
关于插件的一些说明：
parentID:是指父容器的id，最好是一个无序列表ul的id。
childTag:是父容器里面包裹每一个图片的标签名，在无序列表里可以是li。
使用此插件要想有一个图片透明度渐进改变的效果，要给包裹图片的标签一个样式，如下：
transition: opacity 1s ease-in-out;
可以对这个transition就行相应的修改；
建议使用此插件的Html结构如下：
<ul id="parentId">
    <li><img src=""></li>
    <li><img src=""></li>
    <li><img src=""></li>
</ul>
此时：parentId即为ul的id;
      childTag即为li;
*/

var autoPlay=function(parentID,childTag) {
    var pictures = document.getElementById(parentID);
    var items = pictures.getElementsByTagName(childTag);
    var len=items.length;
    var index = 0;
    showItem();
    // 显示一张图片
    function showItem() {
        // 首先将所有图片透明度设为0
        hideItems();
        items[index].style.opacity = 1;
        // 将要显示的透明度改变让其显示
        if (index > len - 2) {
            index = 0;
        } else {
            index++;
        }
        // 在这里用setTimeout模拟setInterval的效果
        setTimeout(showItem, 2500);
    }
    // 将所有图片透明度设为0
    function hideItems() {
        for (var i = 0; i < len; i++) {
            items[i].style.opacity = 0;
        }
    }
};