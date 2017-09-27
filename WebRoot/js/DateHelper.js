/*----------------------------------------------------------------------------\
|                                日期验证处理JS
|-----------------------------------------------------------------------------
|                   Copyright (c) 2004 Eshore
|               作者:Bob(email:shenjx@gsta.com)
\----------------------------------------------------------------------------*/

/*验证比较开始日期和结束日期及日期有效性;
当strDatestyle = "US"; //United States date style(月日年)
当strDatestyle = "CN"; //Chinese date style(年月日)
当strDatestyle = "EU";  //European date style
*/
//通过验证返回true,否则false 
function validateDate(from, to) {
  return validateDateMsg(from, to, '开始日期', '结束日期');
}

function validateDateMsg(from, to, frommsg, tomsg) {
var strFrom = checkdate(from,frommsg);
var strTo = checkdate(to,tomsg);
if (strFrom == true || strFrom == false || strTo == true || strTo == false) {
  return false;
}
if (Date.parse(strFrom) <= Date.parse(strTo)) {
  return true;
}
else {
if (from.value == "" || to.value == "") 
alert(frommsg+"和"+tomsg+"必须输入!");
else 
alert(frommsg+"不能大于"+tomsg+"！");
   }
return false;
}
function checkdate(objName,msg) {
var datefield = objName;
var strReturn = chkdate(objName);
if ( strReturn == false) {
datefield.select();
alert(msg+"无效,请重新输入!");
datefield.focus();
return false;
}
else if ( strReturn == true) {
datefield.select();
alert(msg+"不能为空,必须输入!");
return false;
}
else {
return strReturn;
   }
}

function chkdate(objName) {
//var strDatestyle = "US"; //United States date style
var strDatestyle = "CN"; //Chinese date style
//var strDatestyle = "EU";  //European date style
var strDate;
var strDateArray;
var strDay;
var strMonth;
var strYear;
var intday;
var intMonth;
var intYear;
var booFound = false;
var datefield = objName;
var strReturn;
var strSeparatorArray = new Array("-"," ","/",".");
var intElementNr;
var err = 0;
var strMonthArray = new Array(12);
strMonthArray[0] = "Jan";
strMonthArray[1] = "Feb";
strMonthArray[2] = "Mar";
strMonthArray[3] = "Apr";
strMonthArray[4] = "May";
strMonthArray[5] = "Jun";
strMonthArray[6] = "Jul";
strMonthArray[7] = "Aug";
strMonthArray[8] = "Sep";
strMonthArray[9] = "Oct";
strMonthArray[10] = "Nov";
strMonthArray[11] = "Dec";
strDate = datefield.value;

if (strDate.length < 1) {
return true;
}
else if( strDate.length < 8){
	return false;
}

for (intElementNr = 0; intElementNr < strSeparatorArray.length; intElementNr++) {
if (strDate.indexOf(strSeparatorArray[intElementNr]) != -1) {
strDateArray = strDate.split(strSeparatorArray[intElementNr]);
//是不否有年月日
if (strDateArray.length != 3) {
err = 1;
return false;
}
else {
strDay = strDateArray[0];
strMonth = strDateArray[1];
strYear = strDateArray[2];
}
booFound = true;
   }
}

if (booFound == false) {
if (strDate.length>5) {
strDay = strDate.substr(0, 2);
strMonth = strDate.substr(2, 2);
strYear = strDate.substr(4);
   }
}
if (strYear.length == 2) {
strYear = '20' + strYear;
}

// US style
if (strDatestyle == "US") {
strTemp = strDay;
strDay = strMonth;
strMonth = strTemp;
}
// Chinese style
if (strDatestyle == "CN") {
strYear = strDate.substr(0, 4);
strMonth = strDate.substr(5, 2);
strDay = strDate.substr(8);
}
intday = parseInt(strDay, 10);
if (isNaN(intday)) {
err = 2;
return false;
}
intMonth = parseInt(strMonth, 10);
if (isNaN(intMonth)) {
for (i = 0;i<12;i++) {
if (strMonth.toUpperCase() == strMonthArray[i].toUpperCase()) {
intMonth = i+1;
strMonth = strMonthArray[i];
i = 12;
   }
}
if (isNaN(intMonth)) {
err = 3;
return false;
   }
}
intYear = parseInt(strYear, 10);
if (isNaN(intYear)) {
err = 4;
return false;
}
if (intMonth>12 || intMonth<1) {
err = 5;
return false;
}
if ((intMonth == 1 || intMonth == 3 || intMonth == 5 || intMonth == 7 || intMonth == 8 || intMonth == 10 || intMonth == 12) && (intday > 31 || intday < 1)) {
err = 6;
return false;
}
if ((intMonth == 4 || intMonth == 6 || intMonth == 9 || intMonth == 11) && (intday > 30 || intday < 1)) {
err = 7;
return false;
}
if (intMonth == 2) {
if (intday < 1) {
err = 8;
return false;
}
if (LeapYear(intYear) == true) {
if (intday > 29) {
err = 9;
return false;
}
}
else {
if (intday > 28) {
err = 10;
return false;
}
}
}
if (strDatestyle == "US") {
//datefield.value = strMonthArray[intMonth-1] + " " + intday+" " + strYear;
strReturn = strMonthArray[intMonth-1] + " " + intday+" " + strYear;
}
else if (strDatestyle == "CN") {
//datefield.value = strMonthArray[intMonth-1] + " " + intday+" " + strYear;
strReturn = strMonthArray[intMonth-1] + " " + intday+" " + strYear;
}
else {
//datefield.value = intday + " " + strMonthArray[intMonth-1] + " " + strYear;
strReturn = intday + " " + strMonthArray[intMonth-1] + " " + strYear;
}
//return true;
return strReturn;
}

function LeapYear(intYear) {
if (intYear % 100 == 0) {
if (intYear % 400 == 0) { return true; }
}
else {
if ((intYear % 4) == 0) { return true; }
}
return false;
}
