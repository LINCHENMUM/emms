package com.zssy.sbwx.manage.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zssy.sbwx.common.OperateLogCompare;
import com.zssy.sbwx.log.model.OperateRecord;
import com.zssy.sbwx.log.service.IOperateService;
import com.zssy.sbwx.manage.model.Device;
import com.zssy.sbwx.manage.service.IDeviceReserveService;
import com.zssy.sbwx.manage.vo.DeviceView;
import com.zssy.sbwx.util.Page;
import com.zssy.sbwx.util.QueryResult;

public class DeviceReserveAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private Device device;
	private DeviceView deviceView;
	private IDeviceReserveService deviceReserveService;
	private List<Device> devices;
	private int deviceId;
	private Map<Integer,String> statueMap = new HashMap<Integer,String>();//设备状态的map
	//private Map<Integer,String> gotoMap = new HashMap<Integer,String>();//跳转页码的map
	private List<String> gotoMap = new ArrayList<String>();
	private Page page;
	private int headId=100;
	private String headString = "";//设置状态的默认字符串
	private static Logger logger = Logger.getLogger(DeviceReserveAction.class);
	private IOperateService operateService;//操作日志
	private int addCount;
	private String strSame="";
	
	public String goBorrowDevice(){
		try{
			logger.info("借出设备开始！");
			System.out.println("id:+"+deviceId);
			device = deviceReserveService.findById(deviceId);
			System.out.println(device.getDeviceName());
			logger.info("借出设备结束！");
		}catch(Exception e){
			logger.info("借出设备异常：", e);
			e.printStackTrace();
		}
		return SUCCESS;
		
	}
	
	public String addDeviceReserve(){
		try{
			logger.info("添加设备开始！");
			//System.out.println(this.getAddCount());
			String tempName = device.getDeviceName();
			//String temp1="";
		/*	Device d=deviceReserveService.findByDeviceName(tempName);
			if(d!=null){
				System.out.println("设备名已存在.........");
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setHeader("Pragma", "no-cache");
		        response.setHeader("Cache-Control", "no-cache");
		        response.setContentType("text/html; charset=GBK");
		    	StringBuffer sb = new StringBuffer();
		    	sb.append("<script type=\"text/javascript\"> alert('设备已存在,请用其他名称');history.go(-1)");
		    	sb.append("</script>");
				response.getWriter().write(sb.toString());
		    	response.getWriter().close();
				return null;
			}else{*/
			//System.out.println("maxNo:"+deviceReserveService.getMaxNO());
			//int maxNo = deviceReserveService.getMaxNO();
				if(addCount>0){
					for(int i=1;i<(addCount+1);i++){
						//int tempno = maxNo+i;
						device.setDeviceName(tempName+i);
						//device.setOrderNO(tempno);
						System.out.println(device.getDeviceName());
						deviceReserveService.add(device);
						String operator = ActionContext.getContext().getSession().get("username").toString();
						String operatorId = ActionContext.getContext().getSession().get("userId").toString();
						OperateRecord operateRecord = new OperateRecord(operator,operatorId,"device",Integer.toString(device.getDeviceId()),"插入");
						operateService.save(operateRecord);
					}
				}else{
					System.out.println(device.getDeviceName());
					deviceReserveService.add(device);
					String operator = ActionContext.getContext().getSession().get("username").toString();
					String operatorId = ActionContext.getContext().getSession().get("userId").toString();
					OperateRecord operateRecord = new OperateRecord(operator,operatorId,"device",Integer.toString(device.getDeviceId()),"插入");
					operateService.save(operateRecord);
				}
			//}
			
			logger.info("添加设备结束！");
		}catch(Exception e){
			logger.info("添加设备异常：", e);
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String listAllDevice(){
		
		/*if(null!=page){
			System.out.println(page.getFirstPage());
		}*/
		//System.out.println("session username: "+ActionContext.getContext().getSession().get("username"));
		//statueMap.put(2, "正常");
		statueMap.put(1, "维修");
		statueMap.put(3, "报废");
		statueMap.put(0, "借出");
		statueMap.put(5, "已安装");
		try{
			logger.info("列出所有设备开始！");
			if(null!=deviceView){
				//System.out.println(deviceView.getDeviceName());
				String startString = "1900-01-01";
				String endString = "2100-01-01";
				//System.out.println("".equals(deviceView.getCreateDateStart()));
				if(null!=deviceView.getCreateDateStart()&&!"".equals(deviceView.getCreateDateStart())){
					startString = deviceView.getCreateDateStart();
					System.out.println("start: "+startString);
				}
				
				if(null!=deviceView.getCreateDateEnd()&&!"".equals(deviceView.getCreateDateEnd())){
					endString = deviceView.getCreateDateEnd();
					System.out.println("end: "+endString);
				}
				
				/*Date startDate = DateUtil.string2Date(startString);
				Date endDate = DateUtil.string2Date(endString);*/
				System.out.println("deviceViewStatue: "+deviceView.getStatue());
				
				String hql = "From Device device where device.status!=4 and device.deviceName like '%"+deviceView.getDeviceName()+"%' " +
						"and device.status = "+deviceView.getStatue()+" and device.createBy like " +
						"'%"+deviceView.getCreateBy()+"%' and device.createDate between '"+startString+"' and '"+endString+"'" +
						" order by deviceId,createDate,deviceName";
				System.out.println("hql: "+hql);
				
				if(null==this.page){
					this.page=new Page();
				}
				//page.setCurrentPage(page.getFirstPage()+1);
				page.setCurrentPage(page.getFirstPage());
				if(page.getCurrentPage()==0){
					page.setCurrentPage(1);
				}
				System.out.println("firstPage: "+page.getFirstPage()+" current: "+page.getCurrentPage());
				
				QueryResult qr = deviceReserveService.getDeviceByHQL(hql,page);
				devices = qr.getList();
				this.page=qr.getPage();
				if(this.page.getPageCount()!=0){
					for(int i=0;i<page.getPageCount();i++){
						//this.gotoMap.put(i, Integer.toString(i+1));
						this.gotoMap.add(Integer.toString(i+1));
					}
				}
			}else{
				String hql = "From Device device where device.status!=4 and device.deviceName like '%%' " +
				"and device.status = 2 and device.createBy like " +
				"'%%' and device.createDate between '1900-01-01' and '2100-01-01'"+
				" order by deviceId,createDate,deviceName";
				System.out.println("hql: "+hql);
				if(null==this.page){
					this.page=new Page();
				}
				//page.setCurrentPage(page.getFirstPage()+1);
				page.setCurrentPage(page.getFirstPage());
				if(page.getCurrentPage()==0){
					page.setCurrentPage(1);
				}
				System.out.println("firstPage: "+page.getFirstPage()+" current: "+page.getCurrentPage());
				
				QueryResult qr = deviceReserveService.getDeviceByHQL(hql,page);
				devices = qr.getList();
				this.page=qr.getPage();
				if(this.page.getPageCount()!=0){
					for(int i=0;i<page.getPageCount();i++){
						//this.gotoMap.put(i, Integer.toString(i+1));
						this.gotoMap.add(Integer.toString(i+1));
					}
				}
			}
			//devices = deviceReserveService.listAllDevice();
			logger.info("列出所有设备结束！");
		}catch(Exception e){
			logger.info("列出所有设备异常：", e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String viewDevice(){
		try{
			logger.info("查看设备开始！");
			device = deviceReserveService.findById(deviceId);
			logger.info("查看设备结束！");
		}catch(Exception e){
			logger.info("查看设备异常：", e);
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String editDevice(){
		try{
			logger.info("修改设备开始！");
			device = deviceReserveService.findById(deviceId);
			statueMap.put(2, "正常");
			statueMap.put(1, "维修");
			statueMap.put(3, "报废");
			statueMap.put(0, "借出");
			statueMap.put(5, "已安装");
			for(int i=0;i<4;i++){
				if(i==device.getStatus()){
					headId = i;
					headString = statueMap.get(i);
					statueMap.remove(i);
				}
			}
			logger.info("修改设备结束！");
		}catch(Exception e){
			logger.info("修改设备异常：", e);
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String updateDevice(){
		try{
			logger.info("更新设备开始！");
			if(null==device){
				System.out.println("----------error-----------");
			}else{
				OperateLogCompare oc1 = new OperateLogCompare();
				//System.out.println(userOld.getUsername());
				//设置修改前的重要字段
				oc1.setCompareOne(device.getCreateBy());
				oc1.setCompareTwo(device.getCreateDate());
				oc1.setCompareThree(device.getDeleteBy());
				deviceReserveService.update(device);
				OperateLogCompare oc2 = new OperateLogCompare();
//				设置修改后的重要字段
				oc2.setCompareOne(device.getCreateBy());
				oc2.setCompareTwo(device.getCreateDate());
				oc2.setCompareThree(device.getDeleteBy());
				
				OperateRecord or = new OperateRecord();
				oc1.compareFeild(oc1, oc2, or);
				String operator = ActionContext.getContext().getSession().get("username").toString();
				String operatorId = ActionContext.getContext().getSession().get("userId").toString();
				or.setOperator(operator);
				or.setOperatorId(operatorId);
				or.setOperateTable("user");
				or.setOperateedId(Integer.toString(device.getDeviceId()));
				or.setOperateTime(new Date());
				or.setOperation("更新");
				logger.info("更新设备结束！");
			}
		}catch(Exception e){
			logger.info("更新设备异常：", e);
			e.printStackTrace();
		}
		return SUCCESS;
	}
	/*public String logicDeleteDevice() throws Exception {
		return this.execute("登录",new AbstractBaseAction(){
			@Override
			public String execute(Map session,HttpServletRequest request,HttpServletResponse response){
				try{
					String id=request.getParameter("deviceId");
					if(id!=null && !"".endsWith(id))
					deviceId=Integer.parseInt(id);
					System.out.println(deviceId);
					device = deviceReserveService.findById(deviceId);
					device.setStatus(4);
					deviceReserveService.update(device);
				
					return SUCCESS;
				}catch(Exception e){
					e.printStackTrace();
				}
				return SUCCESS;
			}
		});
	}*/
	public String logicDeleteDevice(){
		try{
			logger.info("逻辑删除设备开始！");
			System.out.println(deviceId);
			device = deviceReserveService.findById(deviceId);
			OperateLogCompare oc1 = new OperateLogCompare();
			//System.out.println(userOld.getUsername());
			//设置修改前的重要字段
			oc1.setCompareOne(device.getStatus());
			device.setStatus(4);
			deviceReserveService.update(device);
			OperateLogCompare oc2 = new OperateLogCompare();
//			设置修改后的重要字段
			oc2.setCompareOne(device.getStatus());
			
			OperateRecord or = new OperateRecord();
			oc1.compareFeild(oc1, oc2, or);
			String operator = ActionContext.getContext().getSession().get("username").toString();
			String operatorId = ActionContext.getContext().getSession().get("userId").toString();
			or.setOperator(operator);
			or.setOperatorId(operatorId);
			or.setOperateTable("user");
			or.setOperateedId(Integer.toString(device.getDeviceId()));
			or.setOperateTime(new Date());
			or.setOperation("更新");
			logger.info("逻辑删除设备结束！");
		}catch(Exception e){
			logger.info("逻辑删除设备异常：", e);
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

	public IDeviceReserveService getDeviceReserveService() {
		return deviceReserveService;
	}

	public void setDeviceReserveService(IDeviceReserveService deviceReserveService) {
		this.deviceReserveService = deviceReserveService;
	}

	public List<Device> getDevices() {
		return devices;
	}

	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}

	public int getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}

	public DeviceView getDeviceView() {
		return deviceView;
	}

	public void setDeviceView(DeviceView deviceView) {
		this.deviceView = deviceView;
	}

	public Map<Integer, String> getStatueMap() {
		return statueMap;
	}

	public void setStatueMap(Map<Integer, String> statueMap) {
		this.statueMap = statueMap;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}

	/*public Map<Integer, String> getGotoMap() {
		return gotoMap;
	}

	public void setGotoMap(Map<Integer, String> gotoMap) {
		this.gotoMap = gotoMap;
	}*/
	

	public IOperateService getOperateService() {
		return operateService;
	}

	public void setOperateService(IOperateService operateService) {
		this.operateService = operateService;
	}

	public String getHeadString() {
		return headString;
	}

	public void setHeadString(String headString) {
		this.headString = headString;
	}

	public int getHeadId() {
		return headId;
	}

	public void setHeadId(int headId) {
		this.headId = headId;
	}

	public int getAddCount() {
		return addCount;
	}

	public void setAddCount(int addCount) {
		this.addCount = addCount;
	}

	public String getStrSame() {
		return strSame;
	}

	public void setStrSame(String strSame) {
		this.strSame = strSame;
	}

	public List<String> getGotoMap() {
		return gotoMap;
	}

	public void setGotoMap(List<String> gotoMap) {
		this.gotoMap = gotoMap;
	}

}
