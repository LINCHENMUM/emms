package com.zssy.sbwx.manage.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionContext;
import com.zssy.sbwx.common.AbstractBaseAction;
import com.zssy.sbwx.common.BaseAction;
import com.zssy.sbwx.common.OperateLogCompare;
import com.zssy.sbwx.log.model.OperateRecord;
import com.zssy.sbwx.log.service.IOperateService;
import com.zssy.sbwx.manage.model.BorrowReturn;
import com.zssy.sbwx.manage.model.Device;
import com.zssy.sbwx.manage.service.IBorrowReturnService;
import com.zssy.sbwx.manage.service.IDeviceReserveService;
import com.zssy.sbwx.manage.vo.BorrowReturnVo;
import com.zssy.sbwx.util.Page;
import com.zssy.sbwx.util.QueryResult;
/**
 * struts层，即表现层的
 * @author DengJianhua
 * 2011-2-16 下午04:45:54
 */
public class BorrowReturnAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private IBorrowReturnService BRService; // 注入业务方法
	private IDeviceReserveService deviceReserveService;
	private IOperateService operateService;//操作日志
	//private IOperateService operateService;
	private BorrowReturn borrowReturn;
	private BorrowReturnVo borrowReturnVo;
	private Device device;
	private Integer id;
	private List borrowReturnList	; // 所有记录
	private Map<Integer,String> options;
	private Page page;//分页
	//private Map<Integer,String> gotoMap = new HashMap<Integer,String>();//跳转页码的map
	private List<String> gotoMap = new ArrayList<String>();
	private static Logger logger = Logger.getLogger(BorrowReturnAction.class);
	
	/*public Map<Integer, String> getGotoMap() {
		return gotoMap;
	}
	public void setGotoMap(Map<Integer, String> gotoMap) {
		this.gotoMap = gotoMap;
	}*/
	
	public BorrowReturnAction(){
		
	}

	/**
	 * 借出设备，即新增borrowDevice表记录
	 * @return
	 * @throws Exception 
	 */	
/*	public String borrowDevice() throws Exception {
		try{
			BRService.save(borrowReturn);//新增借出记录
		}catch(Exception e){
			e.printStackTrace();
		}
		return SUCCESS;
	}*/
	public String borrowDevice() throws Exception {
		return this.execute("新增借出记录",new AbstractBaseAction(){
			@Override
			public String execute(Map session,HttpServletRequest request,HttpServletResponse response){
				try{
					logger.info("新增借出记录开始！");
					
					Device device = deviceReserveService.findById(borrowReturn.getDeviceId());
					borrowReturn.setCreateTimeTemp(device.getCreateDate());
					BRService.save(borrowReturn);//新增借出记录
					
					OperateLogCompare oc1 = new OperateLogCompare();
					//System.out.println(userOld.getUsername());
					//设置修改前的重要字段
					oc1.setCompareOne(device.getStatus());
					device.setStatus(0);
					deviceReserveService.update(device);
					OperateLogCompare oc2 = new OperateLogCompare();
//					设置修改后的重要字段
					oc2.setCompareOne(device.getStatus());
					OperateRecord or = new OperateRecord();
					oc1.compareFeild(oc1, oc2, or);
					String operator = ActionContext.getContext().getSession().get("username").toString();
					String operatorId = ActionContext.getContext().getSession().get("userId").toString();
					or.setOperator(operator);
					or.setOperatorId(operatorId);
					or.setOperateTable("borrowreturn");
					or.setOperateedId(Integer.toString(borrowReturn.getId()));
					or.setOperateTime(new Date());
					or.setOperation("更新");
					operateService.save(or);
					//操作日志
					//String username=(String)request.getSession().getAttribute("username");
					//OperateRecord operateRecord=new OperateRecord();
					/*operateRecord.setLoginName(username);
					operateRecord.setOperateModule(OperateModule.BORROWRETURN);
					operateRecord.setOperateTime(DateUtil.formatDate(DateUtil.YYYY_MM_DD_HH_MM_SS, new Date()));
					operateRecord.setOperateType(OperateType.INSERT);*/
					/*operateService.save(operateRecord);*///保存操作日志
					//String operator = ActionContext.getContext().getSession().get("username").toString();
					//String operatorId = ActionContext.getContext().getSession().get("userId").toString();
					OperateRecord operateRecord = new OperateRecord(operator,operatorId,"borrowreturn",Integer.toString(borrowReturn.getId()),"插入");
					operateService.save(operateRecord);
					logger.info("新增借出记录结束！");
				}catch(Exception e){
					logger.info("新增借出记录异常：", e);
					e.printStackTrace();
				}
				return SUCCESS;
			}
		});
	}

	/**
	 * 删除借出归还记录
	 * @return
	 */
	public String borrowReturnDelete(){
		try{
			logger.info("删除借出归还记录开始！");
			borrowReturn = BRService.findById(id);
			if (borrowReturn != null) {
				BRService.delete(borrowReturn);
				String operator = ActionContext.getContext().getSession().get("username").toString();
				String operatorId = ActionContext.getContext().getSession().get("userId").toString();
				OperateRecord operateRecord = new OperateRecord(operator,operatorId,"borrowreturn",Integer.toString(borrowReturn.getId()),"删除");
				operateService.save(operateRecord);
				logger.info("删除借出归还记录结束！");
			}
		}catch(Exception e){
			logger.info("删除借出归还记录异常：", e);
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	/**
	 * 选择某天记录进行修改
	 * @return
	 * @throws Exception 
	 */
	public String borrowReturnEdit(){
		try{
			logger.info("对某天的记录修改开始！");
			borrowReturn = BRService.findById(id);
			logger.info("对某天的记录修改结束！");
		}catch(Exception e){
			logger.info("对某天的记录修改异常：", e);
			e.printStackTrace();
		}
		return SUCCESS;
	}
	

	
	/**
	 * 归还设备，即更新记录
	 */
	public String returnDevice() throws Exception {
		try{
			logger.info("归还设备开始！");
			if (null == borrowReturn) {
				System.out.println("---ERROR---");
				logger.info("归还设备为null！");
			}
			OperateLogCompare oc1 = new OperateLogCompare();
			//System.out.println(userOld.getUsername());
			//设置修改前的重要字段
			oc1.setCompareOne(borrowReturn.getReturnStatus());
			oc1.setCompareTwo(borrowReturn.getBorrowSendBy());
			oc1.setCompareThree(borrowReturn.getReceiveTime());
			System.out.println("标号"+borrowReturn.getDeviceId());
			Device device = deviceReserveService.findById(borrowReturn.getDeviceId());
			device.setStatus(2);
			
			BRService.update(borrowReturn);
			deviceReserveService.update(device);
			
			OperateLogCompare oc2 = new OperateLogCompare();
//			设置修改后的重要字段
			oc2.setCompareOne(borrowReturn.getReturnStatus());
			oc2.setCompareTwo(borrowReturn.getBorrowSendBy());
			oc2.setCompareThree(borrowReturn.getReceiveTime());
			
			OperateRecord or = new OperateRecord();
			oc1.compareFeild(oc1, oc2, or);
			String operator = ActionContext.getContext().getSession().get("username").toString();
			String operatorId = ActionContext.getContext().getSession().get("userId").toString();
			or.setOperator(operator);
			or.setOperatorId(operatorId);
			or.setOperateTable("borrowreturn");
			or.setOperateedId(Integer.toString(borrowReturn.getId()));
			or.setOperateTime(new Date());
			or.setOperation("更新");
			operateService.save(or);
			logger.info("归还设备结束！");
		}catch(Exception e){
			logger.info("归还设备异常：", e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String borrowReturnFindById() throws Exception {
		try{
			logger.info("查找归还记录开始！");
			borrowReturn=BRService.findById(id);
			logger.info("查找归还记录结束！");
		}catch(Exception e){
			logger.info("查找归还记录异常：",e);
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String lookborrowReturn() throws Exception{
		try{
			logger.info("查看借出记录开始！");
			borrowReturn=BRService.findById(id);
			logger.info("查看借出记录结束！");
		}catch(Exception e){
			logger.info("查看借出记录异常：", e);
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	/*public String lookborrowReturn() throws Exception{
		return this.execute("登录",new AbstractBaseAction(){
			@Override
			public String execute(Map session,HttpServletRequest request,HttpServletResponse response){
				try{
					String username=(String) request.getSession().getAttribute("username");
					System.out.println(username);
					return null;
				}catch(Exception e){
					e.printStackTrace();
				}
				return null;
			}
			
		});
	}*/
	public String borrowReturnList(){
		
		/*if(null!=page){
			System.out.println(page.getFirstPage());
		}*/
		
		try{
			logger.info("借出设备列表开始！");
			String hql=null;
			if(null!=borrowReturnVo){
				//System.out.println(deviceView.getDeviceName());
				String startString = "2000-01-01";
				String endString = "2100-01-01";
				//System.out.println("".equals(deviceView.getCreateDateStart()));
				if(null!=borrowReturnVo.getBorrowTimeStart()&&!"".equals(borrowReturnVo.getBorrowTimeStart())){
					startString = borrowReturnVo.getBorrowTimeStart();
					System.out.println("start: "+startString);
				}
				
				if(null!=borrowReturnVo.getBorrowTimeEnd()&&!"".equals(borrowReturnVo.getBorrowTimeEnd())){
					endString = borrowReturnVo.getBorrowTimeEnd();
					System.out.println("end: "+endString);
				}
				
				hql = "From BorrowReturn borrowReturn where borrowReturn.deviceName like '%"+borrowReturnVo.getDeviceName()+
						"%' and borrowReturn.borrowOffice like " +"'%"+borrowReturnVo.getBorrowOffice()+
						"%' and borrowReturn.lendBy like " +"'%"+borrowReturnVo.getLendBy()+
						"%' and borrowReturn.borrowSendBy like " +"'%"+borrowReturnVo.getBorrowSendBy()+
						"%' and borrowReturn.status="+borrowReturnVo.getReturnStatus()+" and borrowReturn.borrowTime between '"+startString+"' and '"+endString+"'"+
						" order by id,borrowTime ,lendBy,borrowOffice,status ,deviceName asc";
				
			}else{
				hql = "From BorrowReturn borrowReturn where borrowReturn.status=0 and " +
				"borrowReturn.borrowTime between '2000-01-01' and '2100-01-01'"+
				" order by  id,borrowTime ,lendBy,borrowOffice,status ,deviceName asc";
				System.out.println("hql: "+hql);
			
			}
			System.out.println("hql: "+hql);
			
			if(null==this.page){
				this.page=new Page();
			}
			//page.setCurrentPage(page.getFirstPage()+1);
			/*if(page.getFirstPage()==0){
				page.setCurrentPage(1);
			}*/
			page.setCurrentPage(page.getFirstPage());
			if(page.getCurrentPage()==0){
				page.setCurrentPage(1);
			}
			System.out.println("firstPage: "+page.getFirstPage()+" current: "+page.getCurrentPage());
			
			QueryResult qr = BRService.getBorrowReturnByHQL(hql,page);
			borrowReturnList = qr.getList();
			this.page=qr.getPage();
			if(this.page.getPageCount()!=0){
				for(int i=0;i<page.getPageCount();i++){
					System.out.println(i);
					//this.gotoMap.put(i, Integer.toString(i+1));
					this.gotoMap.add(Integer.toString(i+1));
				}
			}
			BorrowReturn b=null;
			for(int i=0;i<borrowReturnList.size();i++){
				b=(BorrowReturn)borrowReturnList.get(i);
				System.out.println(i+"------"+b.getDeviceName());
			}
			//devices = deviceReserveService.listAllDevice();
			
			logger.info("借出设备列表结束！");
		}catch(Exception e){
			logger.info("借出设备列表异常：",e);
			e.printStackTrace();
		}
		return SUCCESS;
	}
	public BorrowReturn getborrowReturn() {
		return borrowReturn;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public BorrowReturn getBorrowReturn() {
		return borrowReturn;
	}

	public void setBorrowReturn(BorrowReturn borrowReturn) {
		this.borrowReturn = borrowReturn;
	}

	public List getBorrowReturnList() {
		return borrowReturnList;
	}

	public void setBorrowReturnList(List borrowReturnList) {
		this.borrowReturnList = borrowReturnList;
	}

	public void setBRService(IBorrowReturnService service) {
		BRService = service;
	}
	public IBorrowReturnService getBRService() {
		return BRService;
	}
	public Map<Integer, String> getOptions() {
		return options;
	}
	public void setOptions(Map<Integer, String> options) {
		this.options = options;
	}
	public BorrowReturnVo getBorrowReturnVo() {
		return borrowReturnVo;
	}
	public void setBorrowReturnVo(BorrowReturnVo borrowReturnVo) {
		this.borrowReturnVo = borrowReturnVo;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
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
	/*public IOperateService getOperateService() {
		return operateService;
	}
	public void setOperateService(IOperateService operateService) {
		this.operateService = operateService;
	}*/
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
