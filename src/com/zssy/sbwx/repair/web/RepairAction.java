package com.zssy.sbwx.repair.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zssy.sbwx.common.ConstantsXmlPath;
import com.zssy.sbwx.common.OperateLogCompare;
import com.zssy.sbwx.log.model.OperateRecord;
import com.zssy.sbwx.log.service.IOperateService;
import com.zssy.sbwx.repair.model.Repair;
import com.zssy.sbwx.repair.service.IRepairService;
import com.zssy.sbwx.repair.vo.RepairView;
import com.zssy.sbwx.util.DateUtil;
import com.zssy.sbwx.util.Page;
import com.zssy.sbwx.util.QueryResult;

public class RepairAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private IRepairService repairService;
	private IOperateService operateService;//操作日志
	private Repair repair;
	private Page page;
	private RepairView repairView;
	private List<Repair> repairs;
	//private Map<Integer,String> gotoMap = new HashMap<Integer,String>();//跳转页码的map
	private List<String> gotoMap = new ArrayList<String>();
	private Map<String,String> orgMap;//把后台xml配置文件中的部门信息读出来，放到map上，在前台界面显示
	private Map<String,String> deviceMap;//把后台xml配置文件中的设备信息读出来，放到map上，在前台界面显示
	private Map<String,String> transportorMap;//把后台xml配置文件中的输送人信息读出来，放到map上，在前台界面显示
	private Map<Integer,String> repairStatusMap;//把后台xml配置文件中的维修状态（类型）信息读出来，放到map上，在前台界面显示
	private Map<Integer,String> repairResultMap;//把后台xml配置文件中的维修结果信息读出来，放到map上，在前台界面显示
	private static Logger logger = Logger.getLogger(RepairAction.class);//log4j
	
	//添加维修设备视图
	public String addRepairView(){
		try{
			logger.info("添加维修设备视图开始！");
			this.orgMap = ConstantsXmlPath.orgMap;
			System.out.println(orgMap.get("信息科"));
			System.out.println("dddddddddddddddddddddddddddd");
			this.deviceMap = ConstantsXmlPath.deviceMap;
			this.transportorMap =ConstantsXmlPath.transportorMap;
			logger.info("添加维修设备视图结束！");
		}catch(Exception e){
			logger.info("添加维修设备视图异常：", e);
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	//添加现场维修或电话维修视图
	public String addOtherRepairView(){
		try{
			logger.info("添加现场维修或电话维修视图开始！");
			this.orgMap = ConstantsXmlPath.orgMap;
			this.deviceMap = ConstantsXmlPath.deviceMap;
			this.repairStatusMap = ConstantsXmlPath.repairStatusMap;
			this.repairResultMap = ConstantsXmlPath.repairResultMap;
			repairResultMap.remove(0);
			for(int i=0;i<3;i++){
				repairStatusMap.remove(i);
			}
			logger.info("添加现场维修或电话维修视图结束！");
		}catch(Exception e){
			logger.info("添加现场维修或电话维修视图异常：", e);
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	//添加一个维修设备
	public String addRepair(){
		try{
			logger.info("添加设备开始！");
			//设置电话维修或现场维修设备的归还状态1，即为归还
			if((3==repair.getRepairStatus()||4==repair.getRepairStatus())&&2==repair.getRepairResult()){
				repair.setReturnFlag(1);
			}
			repairService.add(repair);
			String operator = ActionContext.getContext().getSession().get("username").toString();
			String operatorId = ActionContext.getContext().getSession().get("userId").toString();
			OperateRecord operateRecord = new OperateRecord(operator,operatorId,"repair",Integer.toString(repair.getRepairId()),"插入");
			operateService.save(operateRecord);
			logger.info("添加设备结束！");
			return SUCCESS;
		}catch(Exception e){
			logger.info("添加设备异常：", e);
			e.printStackTrace();
		}
		return ERROR;
	}
	
	//列出所有的待修设备
	public String listWaitingRepair(){
		try{
			logger.info("列出待修设备开始！");
			this.orgMap = ConstantsXmlPath.orgMap;
			this.deviceMap = ConstantsXmlPath.deviceMap;
			// System.out.println(deviceView.getDeviceName());
			String startString = "1900-01-01";
			String endString = "2100-01-01";
			// System.out.println("".equals(deviceView.getCreateDateStart()));
			if(null!=repairView){
				if (null != repairView.getTransportDateStart()
						&& !"".equals(repairView.getTransportDateStart())) {
					startString = repairView.getTransportDateStart();
					System.out.println("start: " + startString);
				}

				if (null != repairView.getTransportDateEnd()
						&& !"".equals(repairView.getTransportDateEnd())) {
					endString = repairView.getTransportDateEnd();
					System.out.println("end: " + endString);
				}

				if(null==repairView.getRepairOffices()){
					repairView.setRepairOffices("");
				}
				if(null==repairView.getRepairDevice()){
					repairView.setRepairDevice("");
				}

			}
						
			String hql="";
			if(null!=repairView){
				 hql = "From Repair repair where repair.repairStatus=0 and repair.repairResult=0"
						+ " and repair.repairOffices like '%"
						+ repairView.getRepairOffices() + "%'"
						+ " and repair.repairDevice like '%"
						+ repairView.getRepairDevice() + "%'"
						+ " and repair.transportDate between '" + startString
						+ "' and '" + endString + "' order by repair.transportDate";
			}else{
				 hql = "From Repair repair where repair.repairStatus=0 and repair.repairResult=0"
						+ " and repair.transportDate between '" + startString
						+ "' and '" + endString + "' order by repair.transportDate";
			}
			System.out.println("hql: " + hql);

			if (null == this.page) {
				this.page = new Page();
			}
			page.setCurrentPage(page.getFirstPage() + 1);
			System.out.println("firstPage: " + page.getFirstPage()
					+ " current: " + page.getCurrentPage());

			QueryResult qr = repairService.getDeviceByHQL(hql, page);
			repairs = qr.getList();
			this.page = qr.getPage();
			//设置跳转页的map
			if(this.page.getPageCount()!=0){
				for(int i=0;i<page.getPageCount();i++){
					//this.gotoMap.put(i, Integer.toString(i+1));
					this.gotoMap.add(Integer.toString(i+1));
				}
			}
			logger.info("列出待修设备结束！");
		}catch(Exception e){
			logger.info("列出设备异常：", e);
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	//加入我的维修列表
	public String addToMyRepair(){
		try{
			logger.info("加入我的维修列表开始！");
			int[] ids = repairView.getCheckboxs();
			/*for(int i=0;i<ids.length;i++){
				System.out.println(ids[i]);
			}*/
			for(int i=0;i<ids.length;i++){
				System.out.println(ids[i]);
				Repair addRepair = this.repairService.findRepairById(ids[i]);
				
				OperateLogCompare oc1 = new OperateLogCompare();
				//System.out.println(userOld.getUsername());
				//设置修改前的重要字段
				oc1.setCompareOne(addRepair.getRepairMan());
				oc1.setCompareTwo(addRepair.getRepairStartDay());
				oc1.setCompareThree(addRepair.getRepairResult());
				
				addRepair.setRepairMan("蔡");
				addRepair.setRepairStartDay(DateUtil.getToday());
				//addRepair.setRepairStartDay(new Date());
				//System.out.println(addRepair.getRepairStartDay());
				addRepair.setRepairResult(1);
				this.repairService.updateRepair(addRepair);
				
				OperateLogCompare oc2 = new OperateLogCompare();
//				设置修改后的重要字段
				oc2.setCompareOne(addRepair.getRepairMan());
				oc2.setCompareTwo(addRepair.getRepairStartDay());
				oc2.setCompareThree(addRepair.getRepairResult());
				
				OperateRecord or = new OperateRecord();
				oc1.compareFeild(oc1, oc2, or);
				String operator = ActionContext.getContext().getSession().get("username").toString();
				String operatorId = ActionContext.getContext().getSession().get("userId").toString();
				or.setOperator(operator);
				or.setOperatorId(operatorId);
				or.setOperateTable("repair");
				or.setOperateedId(Integer.toString(addRepair.getRepairId()));
				or.setOperateTime(new Date());
				or.setOperation("更新");
			}
			logger.info("加入我的维修列表结束！");
		}catch(Exception e){
			logger.info("加入我的维修列表异常：", e);
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	//列出我的维修列表
	public String listMyRepair(){
		try{
			logger.info("列出我的维修列表开始！");
			this.orgMap = ConstantsXmlPath.orgMap;
			this.deviceMap = ConstantsXmlPath.deviceMap;
			this.repairStatusMap = ConstantsXmlPath.repairStatusMap;
			repairStatusMap.remove(3);
			repairStatusMap.remove(4);
			// System.out.println(deviceView.getDeviceName());
			String startString = "1900-01-01";
			String endString = "2100-01-01";
			// System.out.println("".equals(deviceView.getCreateDateStart()));
			if(null!=repairView){
				if (null != repairView.getTransportDateStart()
						&& !"".equals(repairView.getTransportDateStart())) {
					startString = repairView.getTransportDateStart();
					System.out.println("start: " + startString);
				}

				if (null != repairView.getTransportDateEnd()
						&& !"".equals(repairView.getTransportDateEnd())) {
					endString = repairView.getTransportDateEnd();
					System.out.println("end: " + endString);
				}

				if(null==repairView.getRepairOffices()){
					repairView.setRepairOffices("");
				}
				if(null==repairView.getRepairDevice()){
					repairView.setRepairDevice("");
				}
			}
						
			String hql="";
			if(null!=repairView){
				if(100==repairView.getRepairType()){
					hql = "From Repair repair where (repair.repairStatus=0 or repair.repairStatus=1 " +
				 		"or repair.repairStatus=2) and repair.repairResult=1 and repair.repairMan='蔡'"
						+ " and repair.repairOffices like '%"
						+ repairView.getRepairOffices() + "%'"
						+ " and repair.repairDevice like '%"
						+ repairView.getRepairDevice() + "%'"
						+ " and repair.transportDate between '" + startString
						+ "' and '" + endString + "' order by repair.transportDate";
				}else{
					hql = "From Repair repair where repair.repairStatus="+repairView.getRepairType()+
			 		" and repair.repairResult=1 and repair.repairMan='蔡'"
					+ " and repair.repairOffices like '%"
					+ repairView.getRepairOffices() + "%'"
					+ " and repair.repairDevice like '%"
					+ repairView.getRepairDevice() + "%'"
					+ " and repair.transportDate between '" + startString
					+ "' and '" + endString + "' order by repair.transportDate";
				}
			}else{
				 hql = "From Repair repair where (repair.repairStatus=0 or repair.repairStatus=1" +
				 		" or repair.repairStatus=2) and repair.repairResult=1 and repair.repairMan='蔡'"
						+ " and repair.transportDate between '" + startString
						+ "' and '" + endString + "' order by repair.transportDate";
			}
			System.out.println("hql: " + hql);

			if (null == this.page) {
				this.page = new Page();
			}
			page.setCurrentPage(page.getFirstPage() + 1);
			System.out.println("firstPage: " + page.getFirstPage()
					+ " current: " + page.getCurrentPage());

			QueryResult qr = repairService.getDeviceByHQL(hql, page);
			repairs = qr.getList();
			this.page = qr.getPage();
			//设置跳转页的map
			if(this.page.getPageCount()!=0){
				for(int i=0;i<page.getPageCount();i++){
					//this.gotoMap.put(i, Integer.toString(i+1));
					this.gotoMap.add(Integer.toString(i+1));
				}
			}
			logger.info("列出我的维修列表结束！");
		}catch(Exception e){
			logger.info("列出我的维修列表异常：",e);
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	//把已经在我的维修列表里的维修记录转出到待修列表
	public String outMyRepair(){
		try{
			logger.info("转出到待修列表开始！");
			int[] ids = repairView.getCheckboxs();
			for(int i=0;i<ids.length;i++){
				System.out.println(ids[i]);
				Repair outRepair = this.repairService.findRepairById(ids[i]);
				
				OperateLogCompare oc1 = new OperateLogCompare();
				//System.out.println(userOld.getUsername());
				//设置修改前的重要字段
				oc1.setCompareOne(outRepair.getRepairMan());
				oc1.setCompareTwo(outRepair.getRepairStartDay());
				oc1.setCompareThree(outRepair.getRepairResult());
				
				outRepair.setRepairMan("");
				outRepair.setRepairStartDay(null);
				outRepair.setRepairResult(0);
				this.repairService.updateRepair(outRepair);
				
				OperateLogCompare oc2 = new OperateLogCompare();
//				设置修改后的重要字段
				oc2.setCompareOne(outRepair.getRepairMan());
				oc2.setCompareTwo(outRepair.getRepairStartDay());
				oc2.setCompareThree(outRepair.getRepairResult());
				
				OperateRecord or = new OperateRecord();
				oc1.compareFeild(oc1, oc2, or);
				String operator = ActionContext.getContext().getSession().get("username").toString();
				String operatorId = ActionContext.getContext().getSession().get("userId").toString();
				or.setOperator(operator);
				or.setOperatorId(operatorId);
				or.setOperateTable("repair");
				or.setOperateedId(Integer.toString(outRepair.getRepairId()));
				or.setOperateTime(new Date());
				or.setOperation("更新");
			}
			logger.info("转出到待修列表结束！");
		}catch(Exception e){
			logger.info("转出到待修列表异常：",e);
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	//维修设备
	public String completeRepairView(){
		try{
			logger.info("维修设备开始！");
			this.repairStatusMap = ConstantsXmlPath.repairStatusMap;
			this.repairResultMap = ConstantsXmlPath.repairResultMap;
//			repairStatusMap.remove(3);
//			repairStatusMap.remove(4);
//			repairResultMap.remove(0);
			System.out.println("id: "+repairView.getCheckboxs()[0]);
			this.repair = this.repairService.findRepairById(repairView.getCheckboxs()[0]);
			logger.info("维修设备结束！");
		}catch(Exception e){
			logger.info("维修设备异常：", e);
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	//保存维修设备
	public String saveCompleteRepair(){
		try{
			logger.info("保存维修设备开始!");
			OperateLogCompare oc1 = new OperateLogCompare();
			//System.out.println(userOld.getUsername());
			//设置修改前的重要字段
			oc1.setCompareOne(repair.getRepairStatus());
			oc1.setCompareTwo(repair.getRepairReason());
			oc1.setCompareThree(repair.getRepairMethod());
			//System.out.println(repair.getTransportDate());
			//System.out.println(repair.getRepairStartDay());
			//System.out.println(repair.getRepairEndDay());
			repair.setSendbackDate(DateUtil.initialDate());
			//System.out.println(repair.getSendbackDate());
			
			if (null == this.repair) {
				System.out.println("---ERROR---");
			}
			this.repairService.updateRepair(this.repair);
			
			OperateLogCompare oc2 = new OperateLogCompare();
//			设置修改后的重要字段
			oc2.setCompareOne(repair.getRepairStatus());
			oc2.setCompareTwo(repair.getRepairReason());
			oc2.setCompareThree(repair.getRepairMethod());
			
			OperateRecord or = new OperateRecord();
			oc1.compareFeild(oc1, oc2, or);
			String operator = ActionContext.getContext().getSession().get("username").toString();
			String operatorId = ActionContext.getContext().getSession().get("userId").toString();
			or.setOperator(operator);
			or.setOperatorId(operatorId);
			or.setOperateTable("repair");
			or.setOperateedId(Integer.toString(repair.getRepairId()));
			or.setOperateTime(new Date());
			or.setOperation("更新");
			logger.info("保存维修设备结束！");
		}catch(Exception e){
			logger.info("保存维修设备异常：", e);
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	//列出尚未归还的维修结果
	public String listRepairResult(){
		try{
			logger.info("未归还设备开始！");
			this.orgMap = ConstantsXmlPath.orgMap;
			this.deviceMap = ConstantsXmlPath.deviceMap;
			// System.out.println(deviceView.getDeviceName());
			String startString = "1900-01-01";
			String endString = "2100-01-01";
			// System.out.println("".equals(deviceView.getCreateDateStart()));
			if(null!=repairView){
				if (null != repairView.getTransportDateStart()
						&& !"".equals(repairView.getTransportDateStart())) {
					startString = repairView.getTransportDateStart();
					System.out.println("start: " + startString);
				}

				if (null != repairView.getTransportDateEnd()
						&& !"".equals(repairView.getTransportDateEnd())) {
					endString = repairView.getTransportDateEnd();
					System.out.println("end: " + endString);
				}

				if(null==repairView.getRepairOffices()){
					repairView.setRepairOffices("");
				}
				if(null==repairView.getRepairDevice()){
					repairView.setRepairDevice("");
				}

			}
						
			String hql="";
			if(null!=repairView){
				 hql = "From Repair repair where repair.repairResult=2 and repair.returnFlag!=1"
						+ " and repair.repairOffices like '%"
						+ repairView.getRepairOffices() + "%'"
						+ " and repair.repairDevice like '%"
						+ repairView.getRepairDevice() + "%'"
						+ " and repair.transportDate between '" + startString
						+ "' and '" + endString + "' order by repair.transportDate";
			}else{
				 hql = "From Repair repair where repair.repairResult=2 and repair.returnFlag!=1"
						+ " and repair.transportDate between '" + startString
						+ "' and '" + endString + "' order by repair.transportDate";
			}
			System.out.println("hql: " + hql);

			if (null == this.page) {
				this.page = new Page();
			}
			page.setCurrentPage(page.getFirstPage() + 1);
			System.out.println("firstPage: " + page.getFirstPage()
					+ " current: " + page.getCurrentPage());

			QueryResult qr = repairService.getDeviceByHQL(hql, page);
			repairs = qr.getList();
			this.page = qr.getPage();
			//设置跳转页的map
			if(this.page.getPageCount()!=0){
				for(int i=0;i<page.getPageCount();i++){
					//this.gotoMap.put(i, Integer.toString(i+1));
					this.gotoMap.add(Integer.toString(i+1));
				}
			}
			logger.info("未归还设备结束！");
		}catch(Exception e){
			logger.info("未归还设备异常：", e);
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	//列出我的维修日志
	public String listMyRepairResult(){
		try{
			logger.info("列出我的维修日志开始！");
			this.orgMap = ConstantsXmlPath.orgMap;
			this.deviceMap = ConstantsXmlPath.deviceMap;
			this.repairStatusMap = ConstantsXmlPath.repairStatusMap;
			this.repairResultMap = ConstantsXmlPath.repairResultMap;
			// System.out.println(deviceView.getDeviceName());
			String startString = "1900-01-01";
			String endString = "2100-01-01";
			// System.out.println("".equals(deviceView.getCreateDateStart()));
			if(null!=repairView){
				if (null != repairView.getTransportDateStart()
						&& !"".equals(repairView.getTransportDateStart())) {
					startString = repairView.getTransportDateStart();
					System.out.println("start: " + startString);
				}

				if (null != repairView.getTransportDateEnd()
						&& !"".equals(repairView.getTransportDateEnd())) {
					endString = repairView.getTransportDateEnd();
					System.out.println("end: " + endString);
				}

				if(null==repairView.getRepairOffices()){
					repairView.setRepairOffices("");
				}
				if(null==repairView.getRepairDevice()){
					repairView.setRepairDevice("");
				}

			}
						
			String hql="";
			if(null!=repairView){
				if(100==repairView.getRepairType()&&100==repairView.getRepairResultType()){
					hql = "From Repair repair where repair.repairStatus!=100 and" +
						" repair.repairResult!=100"
						+ " and repair.repairOffices like '%"
						+ repairView.getRepairOffices() + "%'"
						+ " and repair.repairDevice like '%"
						+ repairView.getRepairDevice() + "%'"
						+ " and repair.repairStartDay between '" + startString
						+ "' and '" + endString + "' order by repair.repairStartDay";
				}else if(100!=repairView.getRepairType()&&100==repairView.getRepairResultType()){
					hql = "From Repair repair where repair.repairStatus="+repairView.getRepairType()+" and" +
					" repair.repairResult!=100"
					+ " and repair.repairOffices like '%"
					+ repairView.getRepairOffices() + "%'"
					+ " and repair.repairDevice like '%"
					+ repairView.getRepairDevice() + "%'"
					+ " and repair.repairStartDay between '" + startString
					+ "' and '" + endString + "' order by repair.repairStartDay";
				}else if(100==repairView.getRepairType()&&100!=repairView.getRepairResultType()){
					hql = "From Repair repair where repair.repairStatus!=100 and" +
					" repair.repairResult="+repairView.getRepairResultType()
					+ " and repair.repairOffices like '%"
					+ repairView.getRepairOffices() + "%'"
					+ " and repair.repairDevice like '%"
					+ repairView.getRepairDevice() + "%'"
					+ " and repair.repairStartDay between '" + startString
					+ "' and '" + endString + "' order by repair.repairStartDay";
				}else if(100!=repairView.getRepairType()&&100!=repairView.getRepairResultType()){
					hql = "From Repair repair where repair.repairStatus="+repairView.getRepairType()+" and" +
					" repair.repairResult="+repairView.getRepairResultType()
					+ " and repair.repairOffices like '%"
					+ repairView.getRepairOffices() + "%'"
					+ " and repair.repairDevice like '%"
					+ repairView.getRepairDevice() + "%'"
					+ " and repair.repairStartDay between '" + startString
					+ "' and '" + endString + "' order by repair.repairStartDay";
				}
				 
			}else{
				 hql = "From Repair repair where repair.repairStatus!=100 and" +
						" repair.repairResult!=100"
						+ " and repair.repairStartDay between '" + startString
						+ "' and '" + endString + "' order by repair.repairStartDay";
			}
			System.out.println("hql: " + hql);

			if (null == this.page) {
				this.page = new Page();
			}
			page.setCurrentPage(page.getFirstPage() + 1);
			System.out.println("firstPage: " + page.getFirstPage()
					+ " current: " + page.getCurrentPage());

			QueryResult qr = repairService.getDeviceByHQL(hql, page);
			repairs = qr.getList();
			this.page = qr.getPage();
			//设置跳转页的map
			if(this.page.getPageCount()!=0){
				for(int i=0;i<page.getPageCount();i++){
					//this.gotoMap.put(i, Integer.toString(i+1));
					this.gotoMap.add(Integer.toString(i+1));
				}
			}
			logger.info("列出我的维修日志结束！");
		}catch(Exception e){
			logger.info("列出我的维修日志异常：", e);
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	//归还维修设备
	public String returnDeviceToOfficesView(){
		try{
			logger.info("归还维修设备开始！");
			this.transportorMap = ConstantsXmlPath.transportorMap;
			int id = this.repairView.getCheckboxs()[0];
			System.out.println(id);
			Repair returnRepair = this.repairService.findRepairById(id);
			returnRepair.setSendbackDate(null);
			this.repair = returnRepair;
			logger.info("归还维修设备结束！");
		}catch(Exception e){
			logger.info("归还维修设备异常：",e);
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	//保存归还维修设备
	public String returnDeviceToOffices(){
		try{
			logger.info("保存归还维修设备开始！");
			OperateLogCompare oc1 = new OperateLogCompare();
			//System.out.println(userOld.getUsername());
			//设置修改前的重要字段
			oc1.setCompareOne(repair.getReturnFlag());
			
			repair.setReturnFlag(1);
			this.repairService.updateRepair(repair);
			OperateLogCompare oc2 = new OperateLogCompare();
//			设置修改后的重要字段
			oc2.setCompareOne(repair.getReturnFlag());
			
			OperateRecord or = new OperateRecord();
			oc1.compareFeild(oc1, oc2, or);
			String operator = ActionContext.getContext().getSession().get("username").toString();
			String operatorId = ActionContext.getContext().getSession().get("userId").toString();
			or.setOperator(operator);
			or.setOperatorId(operatorId);
			or.setOperateTable("repair");
			or.setOperateedId(Integer.toString(repair.getRepairId()));
			or.setOperateTime(new Date());
			or.setOperation("更新");
			logger.info("保存归还维修设备结束！");
		}catch(Exception e){
			logger.info("保存归还维修设备异常：", e);
			e.printStackTrace();
		}
		return SUCCESS;
	}
	

	public Repair getRepair() {
		return repair;
	}
	public void setRepair(Repair repair) {
		this.repair = repair;
	}
	public IRepairService getRepairService() {
		return repairService;
	}
	public void setRepairService(IRepairService repairService) {
		this.repairService = repairService;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public RepairView getRepairView() {
		return repairView;
	}
	public void setRepairView(RepairView repairView) {
		this.repairView = repairView;
	}
	/*public Map<Integer, String> getGotoMap() {
		return gotoMap;
	}
	public void setGotoMap(Map<Integer, String> gotoMap) {
		this.gotoMap = gotoMap;
	}*/
	public List<Repair> getRepairs() {
		return repairs;
	}
	public void setRepairs(List<Repair> repairs) {
		this.repairs = repairs;
	}
	public Map<String, String> getDeviceMap() {
		return deviceMap;
	}
	public void setDeviceMap(Map<String, String> deviceMap) {
		this.deviceMap = deviceMap;
	}
	public Map<String, String> getOrgMap() {
		return orgMap;
	}
	public void setOrgMap(Map<String, String> orgMap) {
		this.orgMap = orgMap;
	}
	public Map<String, String> getTransportorMap() {
		return transportorMap;
	}
	public void setTransportorMap(Map<String, String> transportorMap) {
		this.transportorMap = transportorMap;
	}
	public Map<Integer, String> getRepairStatusMap() {
		return repairStatusMap;
	}
	public void setRepairStatusMap(Map<Integer, String> repairStatusMap) {
		this.repairStatusMap = repairStatusMap;
	}
	public Map<Integer, String> getRepairResultMap() {
		return repairResultMap;
	}
	public void setRepairResultMap(Map<Integer, String> repairResultMap) {
		this.repairResultMap = repairResultMap;
	}
	public IOperateService getOperateService() {
		return operateService;
	}
	public void setOperateService(IOperateService operateService) {
		this.operateService = operateService;
	}

	public List<String> getGotoMap() {
		return gotoMap;
	}

	public void setGotoMap(List<String> gotoMap) {
		this.gotoMap = gotoMap;
	}
}
