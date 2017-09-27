function CompareDate(d1,d2)
{
  if((new Date(d1.replace(/-/g,"\/"))) > (new Date(d2.replace(/-/g,"\/")))){
	  //alert("开始时间不大于结束时间");
	  return false;
  }
  return true;
}
