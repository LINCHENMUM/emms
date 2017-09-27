<!--
isIE = (document.all ? true : false);
function getIEPosX(elt) { return getIEPos(elt,"Left"); }
function getIEPosY(elt) { return getIEPos(elt,"Top"); }
//---
//function getIEPosR(elt) { return getIEPos(elt,"Right"); }
//function getIEPosB(elt) { return getIEPos(elt,"Bottom"); }
//---
function getIEPos(elt,which) {
 iPos = 0
 while (elt!=null) {
  iPos += elt["offset" + which]
  elt = elt.offsetParent
 }
 return iPos
}

function getXBrowserRef(eltname) {
 return (isIE ? document.all[eltname].style : document.layers[eltname]);
}

function hideElement(eltname) { getXBrowserRef(eltname).visibility = 'hidden'; }

function Clear(eltname) { 
	displayElement.value = '';
	getXBrowserRef(eltname).visibility = 'hidden'; 
}

// 按不同的浏览器进行处理元件的位置
function moveBy(elt,deltaX,deltaY) {
 if (isIE) {
  elt.left = elt.pixelLeft + deltaX;
  elt.top = elt.pixelTop + deltaY;
 } else {
  elt.left += deltaX;
  elt.top += deltaY;
 }
}

function toggleVisible(eltname) {
 elt = getXBrowserRef(eltname);
 if (elt.visibility == 'visible' || elt.visibility == 'show') {
   elt.visibility = 'hidden';
 } else {
   fixPosition(eltname);
   elt.visibility = 'visible';
 }
}

function setPosition(elt,positionername,isPlacedUnder) {
 positioner = null;
 if (isIE) {
  positioner = document.all[positionername];
  elt.left = getIEPosX(positioner);
  elt.top = getIEPosY(positioner);
 } else {
  positioner = document.images[positionername];
  elt.left = positioner.x;
  elt.top = positioner.y;
 }
 if (isPlacedUnder) { moveBy(elt,0,positioner.height); }
}




//——————————————————————————————————————

         // 判断浏览器
         isIE = (document.all ? true : false);

         // 初始月份及各月份天数数组
     var months = new Array("一　月", "二　月", "三　月", "四　月", "五　月", "六　月", "七　月",
	 "八　月", "九　月", "十　月", "十一月", "十二月");
     var daysInMonth = new Array(31, 28, 31, 30, 31, 30, 31, 31,
            30, 31, 30, 31);
	 var displayMonth = new Date().getMonth();
	 var displayYear = new Date().getFullYear();
	 var displayDivName;
	 var displayElement;

         function getDays(month, year) {
            //测试选择的年份是否是润年？
            if (1 == month)
               return ((0 == year % 4) && (0 != (year % 100))) ||
                  (0 == year % 400) ? 29 : 28;
            else
               return daysInMonth[month];
         }

         function getToday() {
            // 得到今天的日期
            this.now = new Date();
            this.year = this.now.getFullYear();
            this.month = this.now.getMonth();
            this.day = this.now.getDate();
         }

         // 并显示今天这个月份的日历
         today = new getToday();

         function newCalendar(eltName,attachedElement) {
	    if (attachedElement) {
	       if (displayDivName && displayDivName != eltName) hideElement(displayDivName);
	       displayElement = attachedElement;
	    }
	    displayDivName = eltName;
            today = new getToday();
            var parseYear = parseInt(displayYear + '');
            var newCal = new Date(parseYear,displayMonth,1);
            var day = -1;
            var startDayOfWeek = newCal.getDay();
            if ((today.year == newCal.getFullYear()) &&
                  (today.month == newCal.getMonth()))
	    {
               day = today.day;
            }
            var intDaysInMonth =
               getDays(newCal.getMonth(), newCal.getFullYear());
            var daysGrid = makeDaysGrid(startDayOfWeek,day,intDaysInMonth,newCal,eltName);
	    if (isIE) {
	       var elt = document.all[eltName];
	       elt.innerHTML = daysGrid;
	    } else {
	       var elt = document.layers[eltName].document;
	       elt.open();
	       elt.write(daysGrid);
	       elt.close();
	    }
	 }

	 function incMonth(delta,eltName) {
	   displayMonth += delta;
	   if (displayMonth >= 12) {
	     displayMonth = 0;
	     incYear(1,eltName);
	   } else if (displayMonth <= -1) {
	     displayMonth = 11;
	     incYear(-1,eltName);
	   } else {
	     newCalendar(eltName);
	   }
	 }


	 function incYear(delta,eltName) {
	   displayYear = parseInt(displayYear + '') + delta;
	   newCalendar(eltName);
	 }

	 function makeDaysGrid(startDay,day,intDaysInMonth,newCal,eltName) {
	    var daysGrid;
	    var month = newCal.getMonth();
	    var year = newCal.getFullYear();
	    var isThisYear = (year == new Date().getFullYear());
	    var isThisMonth = (day > -1)
	    daysGrid = '<table border=1 cellspacing=0 cellpadding=2 bordercolor=#333333  style=font:10pt><tr><td bgcolor=#e6fbf1 nowrap>';
	    daysGrid += '<font face="courier new, courier" >';		//hideElement函数用于关闭	    
	    daysGrid += '<a href="javascript:incYear(-1,\'' + eltName + '\')"><font color=#333399 ><b>&laquo; </b></font></a>';
	    daysGrid += '<b>';
	    if (isThisYear) { daysGrid += '<font color=red>' + year + '</font>'; }
	    else { daysGrid += ''+year; }
	    daysGrid += '</b>';
	    daysGrid += '<a href="javascript:incYear(1,\'' + eltName + '\')"><font color=#333399 ><b> &raquo;</b></font></a>';
		daysGrid += '&nbsp;&nbsp;';
		daysGrid += '<a href="javascript:incMonth(-1,\'' + eltName + '\')"><font color=#333399 ><b>&laquo; </b></font></a>';
		daysGrid += '<b>';
		if (isThisMonth) { daysGrid += '<font color=red >' + months[month] + '</font>'; }
	    else { daysGrid += months[month]; }
	    daysGrid += '</b>';
	    daysGrid += '<a href="javascript:incMonth(1,\'' + eltName + '\')"><font color=#333399 ><b> &raquo;</b></font></a>';	    
	    daysGrid += '&nbsp;&nbsp;';
		daysGrid += '<a href="javascript:Clear(\'' + eltName + '\')"><font color=#333399  style=font:9pt>清空</font></a>&nbsp;';
		daysGrid += '<a href="javascript:hideElement(\'' + eltName + '\')"><font color=#333399  style=font:9pt>关闭</font></a><br>';
/*	    daysGrid += '&nbsp;Su Mo Tu We Th Fr Sa&nbsp;<br>&nbsp;';
	    var dayOfMonthOfFirstSunday = (7 - startDay + 1);
	    for (var intWeek = 0; intWeek < 6; intWeek++) {
	       var dayOfMonth;
	       for (var intDay = 0; intDay < 7; intDay++) {
	         dayOfMonth = (intWeek * 7) + intDay + dayOfMonthOfFirstSunday - 7;
		 if (dayOfMonth <= 0) {
	           daysGrid += "&nbsp;&nbsp; ";
		 } else if (dayOfMonth <= intDaysInMonth) {
		   var color = "blue";
		   if (day > 0 && day == dayOfMonth) color="red";
		   daysGrid += '<a href="javascript:setDay(';
		   daysGrid += dayOfMonth + ',\'' + eltName + '\')" '
		   daysGrid += 'style="color:' + color + '">';
		   var dayString = dayOfMonth + "</a> ";
		   if (dayString.length == 6) dayString = '0' + dayString;
		   daysGrid += dayString;
		 }
	       }
	       if (dayOfMonth < intDaysInMonth) daysGrid += "<br>&nbsp;";
	    }
	    return daysGrid + "</td></tr></table>"; */
	    
		daysGrid += "<table border=0 width='210' cellspacing=0 cellpadding=2 bordercolor=#333333  style='text-align:center;margin-top:8px;margin-bottom:8px;'>";
		daysGrid += '<tr><td>日</td><td>一</td><td>二</td><td>三</td><td>四</td><td>五</td><td>六</td></tr>';
	    var dayOfMonthOfFirstSunday = (7 - startDay + 1);
	    for (var intWeek = 0; intWeek < 6; intWeek++) {
	       daysGrid += '<tr>';
	       
	       var dayOfMonth;
	       for (var intDay = 0; intDay < 7; intDay++) {
	         dayOfMonth = (intWeek * 7) + intDay + dayOfMonthOfFirstSunday - 7;
			 if (dayOfMonth <= 0) {
		           daysGrid += "<td>&nbsp;</td>";
			 } else if (dayOfMonth <= intDaysInMonth) {
			   var color = "blue";
			   if (day > 0 && day == dayOfMonth) color="red";
			   
			   daysGrid += '<td><a href="javascript:setDay(';
			   daysGrid += dayOfMonth + ',\'' + eltName + '\')" '
			   daysGrid += 'style="color:' + color + '">';
			   
			   var dayString = dayOfMonth + "</a></td>";
			   if (dayString.length == 6) dayString = '0' + dayString;
			   daysGrid += dayString;
			 }
	       }
	       if (dayOfMonth < intDaysInMonth) daysGrid += "</tr>";
	       
	    }
		
		daysGrid += '</table>';	    
	    return daysGrid ;	    
	 }

	 function setDay(day,eltName) {
	   Month = displayMonth + 1;	 
	   var str_day,str_month;
	   if(day<10) str_day = "0" + day
	   else str_day = day
	   if(Month<10) str_month = "0" + Month;
	   else str_month = Month;
	   
	   displayElement.value = displayYear + "-" + str_month + "-" + str_day ;
	   hideElement(eltName);
	 }


//——————————————————————————————————————
// fixPosition() 这个函数和前面所讲的那个函数一样
//
function fixPosition(eltname) {
 elt = getXBrowserRef(eltname);
 positionerImgName = eltname + 'Pos';
 // hint: try setting isPlacedUnder to false
 isPlacedUnder = false;
 if (isPlacedUnder) {
  setPosition(elt,positionerImgName,true);
 } else {
  setPosition(elt,positionerImgName)
 }
}

function toggleDatePicker(eltName,formElt) {
  var x = formElt.indexOf('.');
  var formName = formElt.substring(0,x);
  var formEltName = formElt.substring(x+1);
  newCalendar(eltName,document.forms[formName].elements[formEltName]);
  toggleVisible(eltName);
}
-->