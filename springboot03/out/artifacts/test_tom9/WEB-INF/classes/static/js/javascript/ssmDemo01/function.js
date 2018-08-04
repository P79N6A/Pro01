function sameSign(a,b){
	return (a ^ b)>=0//相同为0，不同为1，这是异或运算,
}

function vector(a,b){
	return{
		x:b.x-a.x,
		y:b.y-a.y
	}
}
function vectorProduct(v1,v2) {
	return v1.x*v2.y-v2.x*v1.y
}
function isPointInTrangle(p,a,b,c){
	var pa=vector(p,a)
	var pb=vector(p,b)
	var pc=vector(p,c)
	
	var t1=vectorProduct(pa,pb)//叉乘结果
	var t2=vectorProduct(pb,pc)
	var t3=vectorProduct(pc,pa)
	return sameSign(t1,t2) && sameSign(t2,t3)//判定符号是否相同
}

function needDelay(elem,leftCorner,currMousePos){
 var offset=elem.offset()	//利用jquery的offset方法获取二级菜单上下单元的坐标
 var	topLeft={
	x:offset.left,
	y:offset.top
 }
var bottomLeft={
	 x:offset.left,
	 y:offset.top+elem.height()//加上它的高度就等于下单元的纵坐标
 } 
 return isPointInTrangle(currMousePos,leftCorner, topLeft, bottomLeft)
}