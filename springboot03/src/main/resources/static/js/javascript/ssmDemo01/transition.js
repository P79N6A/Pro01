var autoSlide = function(parentId, childTag) {
    var parent = document.getElementById(parentId);
    // 这里将元素的position设为relative，这样才可以对left值进行改变，当然也可以设为absolute
    parent.style.position = "relative";
    var items = parent.getElementsByTagName(childTag);
    var width = items[0].offsetWidth;
    var index = 0;
    function slide() {
        if (index > items.length - 2) {
            index = 0;
        } else {
            index++;
        }
        moveWidth = -width * index;
        parent.style.left = moveWidth + "px";
        setTimeout(slide, 1500);
    }
    slide();
};