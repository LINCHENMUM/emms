package com.zssy.sbwx.common;

import com.zssy.sbwx.log.model.OperateRecord;

public class OperateLogCompare {
	
	public OperateLogCompare(){
		
	}
	
	private Object compareOne;
	private Object compareTwo;
	private Object compareThree;
	
	public void compareFeild(OperateLogCompare oc1,OperateLogCompare oc2,OperateRecord or){
		if(null!=oc1.getCompareOne()&&null!=oc2.getCompareOne()
				&&oc1.getCompareOne()!=oc2.getCompareOne()){
			or.setOperateBeforeOne(oc1.getCompareOne().toString());
			or.setOperateAfterOne(oc2.getCompareOne().toString());
		}
		
		if(null!=oc1.getCompareTwo()&&null!=oc2.getCompareTwo()
				&&oc1.getCompareTwo()!=oc2.getCompareTwo()){
			or.setOperateBeforeTwo(oc1.getCompareTwo().toString());
			or.setOperateAfterTwo(oc2.getCompareTwo().toString());
		}
		
		if(null!=oc1.getCompareThree()&&null!=oc2.getCompareThree()
				&&oc1.getCompareThree()!=oc2.getCompareThree()){
			or.setOperateBeforeThree(oc1.getCompareThree().toString());
			or.setOperateAfterThree(oc2.getCompareThree().toString());
		}
	}
	
	public Object getCompareOne() {
		return compareOne;
	}
	public void setCompareOne(Object compareOne) {
		this.compareOne = compareOne;
	}
	public Object getCompareThree() {
		return compareThree;
	}
	public void setCompareThree(Object compareThree) {
		this.compareThree = compareThree;
	}
	public Object getCompareTwo() {
		return compareTwo;
	}
	public void setCompareTwo(Object compareTwo) {
		this.compareTwo = compareTwo;
	}
}
