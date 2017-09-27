//Gets the browser specific XmlHttpRequest Object
function getXmlHttpRequestObject() {
	if (window.XMLHttpRequest) {
		return new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		return new ActiveXObject("Microsoft.XMLHTTP");
	} else {
		alert("Your Browser Sucks!\nIt's about time to upgrade don't you think?");
	}
}
function createAjaxObj() {
	var httprequest = false
	if (window.XMLHttpRequest) { // if Mozilla, Safari etc
		httprequest = new XMLHttpRequest()
		if (httprequest.overrideMimeType)
			httprequest.overrideMimeType('text/xml')
	} else if (window.ActiveXObject) { // if IE
		try {
			httprequest = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			try {
				httprequest = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e) {
			}
		}
	}
	return httprequest
}
//Our XmlHttpRequest object to get the auto suggest
var searchReq = createAjaxObj();

//Called from keyup on the search textbox.
//Starts the AJAX request.
function searchSuggest() {
		//alert('a');
	if (searchReq.readyState == 4 || searchReq.readyState == 0) {
		//alert('b');
		var url = document.getElementById('txtSearch').value;
		//alert(url);
		url = encodeURI(url);
		//alert('c');
		url = encodeURI(url);
		//alert('d');
		var str = url;
		//alert('e');
		searchReq.open("GET", 'search.action?search=' + str, true);
		//alert('f');
		searchReq.onreadystatechange = handleSearchSuggest;
		//alert('g');
		searchReq.send();
		//alert('h');
	}
}

/*function search(){
	alert('a');
}*/

//Called when the AJAX response is returned.
function handleSearchSuggest() {
	//alert('kkkkkk');
	if (searchReq.readyState == 4) {
		//alert('bbbb');
		var ss = document.getElementById('search_suggest')
		//alert(ss);
		//url=encodeURI(url);
		//url=encodeURI(url);
		//var ss=url;  
		ss.innerHTML = '';
		//alert(searchReq.responseText);
		var str = searchReq.responseText.split("\n");
		//alert(str);
		for (i = 0; i < str.length - 1; i++) {
			//Build our element string.  This is cleaner using the DOM, but
			//IE doesn't support dynamically added attributes.
			
			var suggest = '<div  onmouseover="javascript:suggestOver(this);" ';
			suggest += 'onmouseout="javascript:suggestOut(this);" ';
			suggest += 'onclick="javascript:setSearch(this.innerHTML);" ';
			suggest += 'class="suggest_link">' + str[i] + '</div>';
			ss.innerHTML += suggest;
		}
	}
}

//Mouse over function
function suggestOver(div_value) {
	div_value.className = 'suggest_link_over';
}
//Mouse out function
function suggestOut(div_value) {
	div_value.className = 'suggest_link';
}
//Click function
function setSearch(value) {
	
	/*var intKey = -1;
		var event = window.event || ev;
		intKey = event.keyCode;
		
		if (intKey == 38) { //向上移
			move(id, -1);
		} else if (intKey == 40) { //向下移
			move(id, 1);
		}else if (intKey == 13) { //Enter 键
			if(zhuti) document.getElementById("zhutiText").focus();
			else {
				hidden(id);
			}
		}*/
	
	//document.getElementById('txtSearch').value = value;
	document.getElementById('borrowOffice').value = value;
	document.getElementById('search_suggest').innerHTML = '';
}

/*function move(id, index){	
		if(isVisible(id)) {
			var div = document.getElementById(id);
			if(div.childNodes && div.childNodes.length > 0){
				var arr = div.childNodes[0].childNodes;
				var cur = parseInt(_index);
				
				if(index == -1){
					cur -= 1; 
				}else{
					cur += 1; 
				}
				
				if(cur < 0 || cur == arr.length ){
					return;
				}
				setHightlighter(id,cur);
				setValue(id,cur);
			}
		}
}*/