//�黹�豸
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
    			alert("ֻ��ѡһ��");
    			return false;
    		}
		}
    }  
    if(""==deviceId){
    	alert("��ѡ��һ����¼");
    	return false;
    }else{
		document.location.href("borrowReturnFindById.action?id="+deviceId);
    }
}
//ɾ���豸
function deleteBorrowReturn(){
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
	    	if (confirm("ȷ��Ҫɾ��")){ 
				document.location.href("borrowReturnDelete.action?id="+deviceId);
			}
	    }
	}
}

//�鿴��¼
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
    			alert("ֻ��ѡһ��");
    			return false;
    		}
		}
    }  
    if(""==deviceId){
    	alert("��ѡ��һ����¼");
    	return false;
    }else{
		document.location.href("lookborrowReturn.action?id="+deviceId);
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