//�鿴
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
    			alert("ֻ��ѡһ��");
    			return false;
    		}
		}
    }  
    if(""==deviceId){
    	alert("��ѡ��һ����¼");
    	return false;
    }else{
		document.location.href("viewDevice.action?deviceId="+deviceId);
	}
}

//�޸��豸
function editDevice(){
	if(false==checkUserPower()){
		alert('�Բ�����û��Ȩ�޽��иò�����');
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
	    			alert("ֻ��ѡһ��");
	    			return false;
	    		}
			}
	    }  
	    if(""==deviceId){
	    	alert("��ѡ��һ����¼");
	    	return false;
	    }else{
			document.location.href("editDevice.action?deviceId="+deviceId);
	    }
	}
}
//ɾ���豸
function deleteDevice(){
	if(false==checkUserPower()){
		alert('�Բ�����û��Ȩ�޽��иò�����');
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
	    			alert("ֻ��ѡһ��");
	    			return false;
	    		}
			}
	    }  
	    if(""==deviceId){
	    	alert("��ѡ��һ����¼");
	    	return false;
	    }else{
	    	if (confirm("ȷ��Ҫɾ��")){    	
	    		//alert(deviceId);
	    		document.location.href("logicDeleteDevice.action?deviceId="+deviceId);
	    	}
	    }	
	}
}

//����豸
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
    			alert("ֻ��ѡһ��");
    			return false;
    		}
		}
    }  
    if(""==deviceId){
    	alert("��ѡ��һ����¼");
    	return false;
    }else{
    	//alert(deviceId);
    	document.location.href("goBorrowDevice.action?deviceId="+deviceId+"&deviceName=a");

    }
}

//����û�Ȩ��
function checkUserPower(){
	var check = document.getElementById("checkUsername");
	//alert(check.value);
	if("��ۻ�"==check.value){
		return true;
	}else if("�����"==check.value){
		return true;
	}else if("�޺�ǿ"==check.value){
		return true;
	}else if("�����"==check.value){
		return true;
	}else{
		return false;
	}
}