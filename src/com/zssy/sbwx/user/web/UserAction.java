package com.zssy.sbwx.user.web;

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
import com.zssy.sbwx.log.model.LoginRecord;
import com.zssy.sbwx.log.model.OperateRecord;
import com.zssy.sbwx.log.service.ILoginService;
import com.zssy.sbwx.log.service.IOperateService;
import com.zssy.sbwx.user.model.User;
import com.zssy.sbwx.user.service.IUserService;
import com.zssy.sbwx.util.DateUtil;
import com.zssy.sbwx.util.EncryptUtil;

public class UserAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private IUserService service; // ע��ҵ�񷽷�
	private ILoginService loginService;//��¼ҵ�񷽷�
	private IOperateService operateService;//������־
	private OperateRecord operateRecord;
	private User user;
	private String id;
	private List users; // ���м�¼
	private static Logger logger = Logger.getLogger(UserAction.class);

	public String userAdd(){
		try{
			logger.info("����û���ʼ��");
			//System.out.println(user.getUsername());
			user.setPassword(EncryptUtil.encrypt(user.getPassword()));
			service.save(user);
			String operator = ActionContext.getContext().getSession().get("username").toString();
			String operatorId = ActionContext.getContext().getSession().get("userId").toString();
			this.operateRecord = new OperateRecord(operator,operatorId,"user",user.getId(),"����");
			operateService.save(this.operateRecord);
			logger.info("����û�������");
		}catch(Exception e){
			logger.info("����û��쳣��", e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String userDelete(){
		try{
			logger.info("ɾ���û���ʼ��");
			user = service.findById(id);
			if (user != null) {
				service.delete(user);
			}
			String operator = ActionContext.getContext().getSession().get("username").toString();
			String operatorId = ActionContext.getContext().getSession().get("userId").toString();
			this.operateRecord = new OperateRecord(operator,operatorId,"user",user.getId(),"ɾ��");
			operateService.save(this.operateRecord);
			logger.info("ɾ���û��ɹ���");
		}catch(Exception e){
			logger.info("ɾ���û��쳣��", e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String userList(){
		try{
			logger.info("�û��б�ʼ��");
			System.out.println("session username: "
					+ActionContext.getContext().getSession().get("username"));
			System.out.println("session userId: "
					+ActionContext.getContext().getSession().get("userId"));
			users = service.findAll();
			logger.info("�û��б������");
		}catch(Exception e){
			logger.info("�û��б��쳣��", e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String userEdit(){
		try{
			logger.info("�޸��û���ʼ��");
			user = service.findById(id);
			logger.info("�޸��û�������");
		}catch(Exception e){
			logger.info("�޸��û��쳣��", e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String userUpdate() throws Exception {
		try{
			logger.info("�����û���ʼ��");
			if (null == user) {
				logger.info("�����û�userΪnull��");
				System.out.println("---ERROR---");
			}else{	
				User userOld = service.findById(user.getId());
				user.setPassword(EncryptUtil.encrypt(user.getPassword()));
				service.update(user);
				OperateLogCompare oc1 = new OperateLogCompare();
				//System.out.println(userOld.getUsername());
				//�����޸�ǰ����Ҫ�ֶ�
				oc1.setCompareOne(userOld.getId());
				oc1.setCompareTwo(userOld.getUsername());
				oc1.setCompareThree(userOld.getOffice());
				
				OperateLogCompare oc2 = new OperateLogCompare();
//				�����޸ĺ����Ҫ�ֶ�
				oc2.setCompareOne(user.getId());
				oc2.setCompareTwo(user.getUsername());
				oc2.setCompareThree(user.getOffice());
				
				OperateRecord or = new OperateRecord();
				oc1.compareFeild(oc1, oc2, or);
				String operator = ActionContext.getContext().getSession().get("username").toString();
				String operatorId = ActionContext.getContext().getSession().get("userId").toString();
				or.setOperator(operator);
				or.setOperatorId(operatorId);
				or.setOperateTable("user");
				or.setOperateedId(user.getId());
				or.setOperateTime(new Date());
				or.setOperation("����");
				operateService.save(or);
			}
			logger.info("�����û�������");
		}catch(Exception e){
			logger.info("�����û��쳣��", e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String userFindById() throws Exception {
		try{
			logger.info("�����û���ʼ��");
			service.findById(id);
			logger.info("�����û�������");
		}catch(Exception e){
			logger.info("�����û��쳣��", e);
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	/**
	 * ��¼
	 * @return
	 */
/*	public String login() throws Exception {
		try{
			System.out.println(user.getUsername());
		}catch(Exception e){
			e.printStackTrace();
		}
		return SUCCESS;
	}*/
	public String login() throws Exception {
		return this.execute("��¼",new AbstractBaseAction(){
			@Override
			public String execute(Map session,HttpServletRequest request,HttpServletResponse response){
				logger.info("��¼��ʼ��");
				try{
					System.out.println("��¼��login..........");
					boolean flag=false;
					flag=service.check(user);
					System.out.println("��¼��check..........");
					if(flag){
//						request.getSession().setAttribute("username",user.getUsername());
						ActionContext ac = ActionContext.getContext();// ���ActionContext
						String loginTime=DateUtil.getFormatDate(DateUtil.YYYY_MM_DD_HH_MM_SS, new Date());
						ac.getSession().put("username", user.getUsername());// 
						ac.getSession().put("userId", user.getId());
						ac.getSession().put("loginTime",loginTime);
						LoginRecord loginRecord=new LoginRecord();//��¼�Ǽ���Ϣ
						loginRecord.setLoginName(user.getUsername());
						loginRecord.setLoginTime(DateUtil.parseStringDate(DateUtil.YYYY_MM_DD_HH_MM_SS,loginTime));
						loginService.save(loginRecord);
					}else{
						response.setHeader("Pragma", "no-cache");
				        response.setHeader("Cache-Control", "no-cache");
				        response.setContentType("text/html; charset=GBK");
				    	StringBuffer sb = new StringBuffer();
				    	sb.append("<script type=\"text/javascript\"> alert('�û��������벻��ȷ');history.go(-1)");
				    	sb.append("</script>");
						response.getWriter().write(sb.toString());
				    	response.getWriter().close();
						return null;
					}
					logger.info("��¼������");
					return SUCCESS;
				}catch(Exception e){
					logger.info("��¼�쳣��", e);
					e.printStackTrace();
				}
				return SUCCESS;
			}
		});
	}
/*	public String logout() throws Exception {
		try{
			
		}catch(Exception e){
				e.printStackTrace();
			}
			return null;
	}*/
	public String logout() throws Exception {
		return this.execute("�˳�",new AbstractBaseAction(){
			@Override
			public String execute(Map session,HttpServletRequest request,HttpServletResponse response){
				logger.info("�˳���ʼ��");
				try{
					String username=(String)request.getSession().getAttribute("username");
					String loginTime=(String)request.getSession().getAttribute("loginTime");
					LoginRecord loginRecord=loginService.findByHQL("From LoginRecord l where l.loginName='"+username
							+"' and l.loginTime='"+loginTime+"'");
					loginRecord.setLogoutTime(DateUtil.formatDate(DateUtil.YYYY_MM_DD_HH_MM_SS, new Date()));
					loginService.update(loginRecord);
					ActionContext ac = ActionContext.getContext();
					ac.getSession().remove("username");
					ac.getSession().remove("loginTime");
					response.setHeader("Pragma", "no-cache");
			        response.setHeader("Cache-Control", "no-cache");
			        response.setContentType("text/html; charset=GBK");
			    	StringBuffer sb = new StringBuffer();
			    	sb.append("<script type=\"text/javascript\"> window.close();");
			    	sb.append("</script>");
					response.getWriter().write(sb.toString());
			    	response.getWriter().close();
			    	logger.info("�˳�������");
				}catch(Exception e){
					logger.info("�˳��쳣��", e);
					e.printStackTrace();
				}
				return null;
			}
		});
	}
	
	  
	public IUserService getService() {
		return service;
	}

	public User getUser() {
		return user;
	}

	public String getId() {
		return id;
	}

	public void setService(IUserService service) {
		this.service = service;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List getUsers() {
		return users;
	}

	public void setUsers(List users) {
		this.users = users;
	}



	public ILoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(ILoginService loginService) {
		this.loginService = loginService;
	}

	public IOperateService getOperateService() {
		return operateService;
	}

	public void setOperateService(IOperateService operateService) {
		this.operateService = operateService;
	}

	public OperateRecord getOperateRecord() {
		return operateRecord;
	}

	public void setOperateRecord(OperateRecord operateRecord) {
		this.operateRecord = operateRecord;
	}
}
