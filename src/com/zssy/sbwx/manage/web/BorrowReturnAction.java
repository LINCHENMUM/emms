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
 * struts�㣬�����ֲ��
 * @author DengJianhua
 * 2011-2-16 ����04:45:54
 */
public class BorrowReturnAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private IBorrowReturnService BRService; // ע��ҵ�񷽷�
	private IDeviceReserveService deviceReserveService;
	private IOperateService operateService;//������־
	//private IOperateService operateService;
	private BorrowReturn borrowReturn;
	private BorrowReturnVo borrowReturnVo;
	private Device device;
	private Integer id;
	private List borrowReturnList	; // ���м�¼
	private Map<Integer,String> options;
	private Page page;//��ҳ
	//private Map<Integer,String> gotoMap = new HashMap<Integer,String>();//��תҳ���map
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
	 * ����豸��������borrowDevice���¼
	 * @return
	 * @throws Exception 
	 */	
/*	public String borrowDevice() throws Exception {
		try{
			BRService.save(borrowReturn);//���������¼
		}catch(Exception e){
			e.printStackTrace();
		}
		return SUCCESS;
	}*/
	public String borrowDevice() throws Exception {
		return this.execute("���������¼",new AbstractBaseAction(){
			@Override
			public String execute(Map session,HttpServletRequest request,HttpServletResponse response){
				try{
					logger.info("���������¼��ʼ��");
					
					Device device = deviceReserveService.findById(borrowReturn.getDeviceId());
					borrowReturn.setCreateTimeTemp(device.getCreateDate());
					BRService.save(borrowReturn);//���������¼
					
					OperateLogCompare oc1 = new OperateLogCompare();
					//System.out.println(userOld.getUsername());
					//�����޸�ǰ����Ҫ�ֶ�
					oc1.setCompareOne(device.getStatus());
					device.setStatus(0);
					deviceReserveService.update(device);
					OperateLogCompare oc2 = new OperateLogCompare();
//					�����޸ĺ����Ҫ�ֶ�
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
					or.setOperation("����");
					operateService.save(or);
					//������־
					//String username=(String)request.getSession().getAttribute("username");
					//OperateRecord operateRecord=new OperateRecord();
					/*operateRecord.setLoginName(username);
					operateRecord.setOperateModule(OperateModule.BORROWRETURN);
					operateRecord.setOperateTime(DateUtil.formatDate(DateUtil.YYYY_MM_DD_HH_MM_SS, new Date()));
					operateRecord.setOperateType(OperateType.INSERT);*/
					/*operateService.save(operateRecord);*///���������־
					//String operator = ActionContext.getContext().getSession().get("username").toString();
					//String operatorId = ActionContext.getContext().getSession().get("userId").toString();
					OperateRecord operateRecord = new OperateRecord(operator,operatorId,"borrowreturn",Integer.toString(borrowReturn.getId()),"����");
					operateService.save(operateRecord);
					logger.info("���������¼������");
				}catch(Exception e){
					logger.info("���������¼�쳣��", e);
					e.printStackTrace();
				}
				return SUCCESS;
			}
		});
	}

	/**
	 * ɾ������黹��¼
	 * @return
	 */
	public String borrowReturnDelete(){
		try{
			logger.info("ɾ������黹��¼��ʼ��");
			borrowReturn = BRService.findById(id);
			if (borrowReturn != null) {
				BRService.delete(borrowReturn);
				String operator = ActionContext.getContext().getSession().get("username").toString();
				String operatorId = ActionContext.getContext().getSession().get("userId").toString();
				OperateRecord operateRecord = new OperateRecord(operator,operatorId,"borrowreturn",Integer.toString(borrowReturn.getId()),"ɾ��");
				operateService.save(operateRecord);
				logger.info("ɾ������黹��¼������");
			}
		}catch(Exception e){
			logger.info("ɾ������黹��¼�쳣��", e);
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	/**
	 * ѡ��ĳ���¼�����޸�
	 * @return
	 * @throws Exception 
	 */
	public String borrowReturnEdit(){
		try{
			logger.info("��ĳ��ļ�¼�޸Ŀ�ʼ��");
			borrowReturn = BRService.findById(id);
			logger.info("��ĳ��ļ�¼�޸Ľ�����");
		}catch(Exception e){
			logger.info("��ĳ��ļ�¼�޸��쳣��", e);
			e.printStackTrace();
		}
		return SUCCESS;
	}
	

	
	/**
	 * �黹�豸�������¼�¼
	 */
	public String returnDevice() throws Exception {
		try{
			logger.info("�黹�豸��ʼ��");
			if (null == borrowReturn) {
				System.out.println("---ERROR---");
				logger.info("�黹�豸Ϊnull��");
			}
			OperateLogCompare oc1 = new OperateLogCompare();
			//System.out.println(userOld.getUsername());
			//�����޸�ǰ����Ҫ�ֶ�
			oc1.setCompareOne(borrowReturn.getReturnStatus());
			oc1.setCompareTwo(borrowReturn.getBorrowSendBy());
			oc1.setCompareThree(borrowReturn.getReceiveTime());
			System.out.println("���"+borrowReturn.getDeviceId());
			Device device = deviceReserveService.findById(borrowReturn.getDeviceId());
			device.setStatus(2);
			
			BRService.update(borrowReturn);
			deviceReserveService.update(device);
			
			OperateLogCompare oc2 = new OperateLogCompare();
//			�����޸ĺ����Ҫ�ֶ�
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
			or.setOperation("����");
			operateService.save(or);
			logger.info("�黹�豸������");
		}catch(Exception e){
			logger.info("�黹�豸�쳣��", e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String borrowReturnFindById() throws Exception {
		try{
			logger.info("���ҹ黹��¼��ʼ��");
			borrowReturn=BRService.findById(id);
			logger.info("���ҹ黹��¼������");
		}catch(Exception e){
			logger.info("���ҹ黹��¼�쳣��",e);
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String lookborrowReturn() throws Exception{
		try{
			logger.info("�鿴�����¼��ʼ��");
			borrowReturn=BRService.findById(id);
			logger.info("�鿴�����¼������");
		}catch(Exception e){
			logger.info("�鿴�����¼�쳣��", e);
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	/*public String lookborrowReturn() throws Exception{
		return this.execute("��¼",new AbstractBaseAction(){
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
			logger.info("����豸�б�ʼ��");
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
			
			logger.info("����豸�б������");
		}catch(Exception e){
			logger.info("����豸�б��쳣��",e);
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
