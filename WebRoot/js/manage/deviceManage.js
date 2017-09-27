//查看
function seeDevice(){
	var deviceId="";
	var ids = document.getElementsByName("checkbox");   
	var num=0;
    for (var i = 0; i < ids.length; i++){          
    	if ( ids[i].checked ){
    		num++;
    		if(num<=1){
    			deviceId=ids[i].value;
    		}else {
    			alert("只能选一条");
    			return false;
    		}
		}
    }  
    if(""==deviceId){
    	alert("请选择一条记录");
    	return false;
    }else{
		document.location.href("viewDevice.action?deviceId="+deviceId);
	}
}

//修改设备
function editDevice(){
	if(false==checkUserPower()){
		alert('对不起！你没有权限进行该操作！');
	}else{
		var deviceId="";
		var ids = document.getElementsByName("checkbox");   
		var num=0;
	    for (var i = 0; i < ids.length; i++){          
	    	if ( ids[i].checked ){
	    		num++;
	    		if(num<=1){
	    			deviceId=ids[i].value;
	    		}else {
	    			alert("只能选一条");
	    			return false;
	    		}
			}
	    }  
	    if(""==deviceId){
	    	alert("请选择一条记录");
	    	return false;
	    }else{
			document.location.href("editDevice.action?deviceId="+deviceId);
	    }
	}
}
//删除设备
function deleteDevice(){
	if(false==checkUserPower()){
		alert('对不起！你没有权限进行该操作！');
	}else{
		//alert(checkUserPower());
		var deviceId="";
		var ids = document.getElementsByName("checkbox");   
		var num=0;
	    for (var i = 0; i < ids.length; i++){          
	    	if ( ids[i].checked ){
	    		num++;
	    		if(num<=1){
	    			deviceId=ids[i].value;
	    		}else {
	    			alert("只能选一条");
	    			return false;
	    		}
			}
	    }  
	    if(""==deviceId){
	    	alert("请选择一条记录");
	    	return false;
	    }else{
	    	if (confirm("确认要删除")){    	
	    		//alert(deviceId);
	    		document.location.href("logicDeleteDevice.action?deviceId="+deviceId);
	    	}
	    }	
	}
}

//借出设备
function borrowDevice(){
	var deviceId="";
	var ids = document.getElementsByName("checkbox");   
	var num=0;
    for (var i = 0; i < ids.length; i++){          
    	if ( ids[i].checked ){
    		num++;
    		if(num<=1){
    			deviceId=ids[i].value;
    		}else {
    			alert("只能选一条");
    			return false;
    		}
		}
    }  
    if(""==deviceId){
    	alert("请选择一条记录");
    	return false;
    }else{
    	//alert(deviceId);
    	document.location.href("goBorrowDevice.action?deviceId="+deviceId+"&deviceName=a");

    }
}

//检查用户权限
function checkUserPower(){
	var check = document.getElementById("checkUsername");
	//alert(check.value);
	if("沈慧华"==check.value){
		return true;
	}else if("陈其辉"==check.value){
		return true;
	}else if("罗洪强"==check.value){
		return true;
	}else if("范年丰"==check.value){
		return true;
	}else{
		return false;
	}
}