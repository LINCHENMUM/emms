//归还设备
function returnDevice(){
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
		document.location.href("borrowReturnFindById.action?id="+deviceId);
    }
}
//删除设备
function deleteBorrowReturn(){
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
	    	if (confirm("确认要删除")){ 
				document.location.href("borrowReturnDelete.action?id="+deviceId);
			}
	    }
	}
}

//查看记录
function lookDevice(){

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
		document.location.href("lookborrowReturn.action?id="+deviceId);
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