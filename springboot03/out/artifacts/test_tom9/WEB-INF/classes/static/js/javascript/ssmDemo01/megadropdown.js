
	$(document).ready(function(){
		var sub=$('#sub')
		var activeRow
		var activeMenu
		
		var  timer/*延迟*/
		var mouseInsub=false
		
		sub.on('mouseenter',function(e){
			mouseInsub=true
		})
		.on('mouseleave',function(e){
			mouseInsub=false
		})
		
		var mouseTrack=[]//
		
		var moveHanlder=function(e){
			mouseTrack.push({
				x:e.pageX,
				y:e.pageY
			})
			if(mouseTrack.length>3){
				mouseTrack.shift()
			}
		}
		$("#test")
		.on("mouseenter",function(e){
			sub.removeClass('none')
			
			$(document).bind('mousemove',moveHanlder)//
		})
		.on("mouseleave",function(e){
			console.log('fire mouse leave')
		sub.addClass('none')
		
		if(activeRow){
			activeRow.removeClass('active')
			activeRow=null;
		}
		
		if(activeMenu){
			activeMenu.addClass('none')
			activeMenu=null;
		}
		
		 $(document).unbind('mousemove',moveHanlder) //
		})
		
		.on("mouseenter",'li',function(e){
			
			if(!activeRow){
			activeRow=$(e.target).addClass('active')
			activeMenu=$('#'+activeRow.data('id'))
			activeMenu.removeClass('none')
			return;
			}
			
			if(timer){
				clearTimeout(timer)
			}
			var currMousePos=mouseTrack[mouseTrack.length-1]//当前点的坐标
			var leftCorner=mouseTrack[mouseTrack.length-2]//a点的坐标，映射在左侧
			
			var delay= needDelay(sub, leftCorner, currMousePos)/*延迟*/
			if(delay){
				timer=setTimeout(function(){
					if(mouseInsub){
						return
					}
					activeRow.removeClass('active')
					activeMenu.addClass('none')
					activeRow=$(e.target)
					activeRow.addClass('active')
					activeMenu=$('#'+activeRow.data('id'))
					activeMenu.removeClass('none')
					timer=null;
				},300)
			}else{
				
				var prevActiveRow=activeRow
				var prevActiveMenu=activeMenu
				
				//把之前行隐藏，当前显示
				activeRow=$(e.target)
				activeMenu=$('#'+ activeRow.data('id'))
				
				prevActiveRow.removeClass('active')
				prevActiveMenu.addClass('none')
				activeRow.addClass('active')
				activeMenu.removeClass('none')
			}
			
			/*//如何判定延时
			timer=setTimeout(function(){
				if(mouseInsub){
					return
				}
				activeRow.removeClass('active')
				activeMenu.addClass('none')
				activeRow=$(e.target)
				activeRow.addClass('active')
				activeMenu=$('#'+activeRow.data('id'))
				activeMenu.removeClass('none')
				timer=null;
			},300)
			*/		
			
		})
	})
	