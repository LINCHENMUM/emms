package com.zssy.sbwx.org.web;

import java.io.PrintWriter;
import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.zssy.sbwx.org.model.Org;
import com.zssy.sbwx.org.service.IOrgService;

public class OrgAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private IOrgService OrService; // ע��ҵ�񷽷�
	private Org org;
	private Integer id;
	private Integer parentId;
	private List orgList; // ���м�¼
	private static Logger logger = Logger.getLogger(OrgAction.class);
	private String search;

	public String orgAdd(){
		try{
			logger.info("��Ӳ��ſ�ʼ��");
			//System.out.println(org.getorgname());
			OrService.save(org);
			logger.info("��Ӳ��Ž�����");
		}catch(Exception e){
			logger.info("��Ӳ����쳣��", e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String orgDelete(){
		try{
			logger.info("ɾ�����ſ�ʼ��");
			org = OrService.findById(id);
			if (org != null) {
				OrService.delete(org);
			}
			logger.info("ɾ�����Ž�����");
		}catch(Exception e){
			logger.info("ɾ�������쳣��",e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String orgList(){
		try{
			logger.info("�����б�ʼ��");
			orgList = OrService.findAll();
			logger.info("�����б������");
		}catch(Exception e){
			logger.info("�����б��쳣��", e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String orgEdit(){
		try{
			logger.info("�����޸Ŀ�ʼ��");
			org = OrService.findById(id);
			logger.info("�����޸Ľ�����");
		}catch(Exception e){
			logger.info("�����޸��쳣��", e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String orgUpdate() throws Exception {
		try{
			logger.info("���Ÿ��¿�ʼ��");
			if (null == org) {
				System.out.println("---ERROR---");
			}
//			System.out.println(org.getId());
//			System.out.println(org.getorgname());
//			System.out.println(org.getPassword());
			OrService.update(org);
			logger.info("���Ÿ��½�����");
		}catch(Exception e){
			logger.info("���Ÿ����쳣��", e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String orgFindById() throws Exception {
		try{
			logger.info("���Ҳ��ſ�ʼ��");
			OrService.findById(id);
			logger.info("���Ҳ��Ž�����");
		}catch(Exception e){
			logger.info("���Ҳ����쳣��", e);
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String orgFindByParentId() throws Exception{
		try{
			logger.info("ͨ�����ڵ���Ҳ��ſ�ʼ��");
			orgList=OrService.findByParentId(parentId);
			Org o=(Org)orgList.get(0);
			System.out.println(orgList.size()+o.getName());
			logger.info("ͨ�����ڵ���Ҳ��Ž�����");
		}catch (Exception e) {
			// TODO: handle exception
			logger.info("ͨ�����ڵ���Ҳ����쳣��", e);
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String getTreeNode() throws Exception{
		try{
			logger.info("������ڵ㿪ʼ��");
			HttpServletResponse response = null;
			response.setHeader("Pragma", "no-cache");
	        response.setHeader("Cache-Control", "no-cache");
	        //response.setDateHeader("Expires", 0);
	        response.setContentType("text/xml; charset=UTF-8");
	        StringBuffer sb = new StringBuffer();
	        System.out.println(org.getId());
	        Integer firstId=org.getId();
	        String nodeName=org.getName();
	        List list=OrService.findByParentId(org.getParentId());
	        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            sb.append("<tree>");
            Org org1=null;
            for(int i=0;i<list.size();i++){
            	  org1=(Org)list.get(i);
            	  sb.append("<tree");
                  sb.append(" value=\"" + org1.getId());
//                  sb.append(":" + pName);
//                  sb.append(":" + codint);
                  sb.append("\"");
                  //if (catalogId.length() < 4) {
                  sb.append(" src=\"").append("getTreeNode.action?parentId=").append(firstId).append("\"");
                      
                  //}
                  sb.append("  text=\"").append(org1.getName()).append("\"");
                 
                   //.append("(").append(pId).append(")")
                  sb.append(" action=\"").append("javascript:void(0)").append("\"");
                 // long flo = knowledgeIndexService.knowledgeIndexFloor(pId);
                  //��һ���ڶ������������ж�ѡ��
                 // if (flo > 2) {
                  sb.append(" checkbox=\"true\"");
                 // }
                  sb.append(" />");
            }
            sb.append("</tree>");
            System.out.println(sb.toString());
            PrintWriter out = response.getWriter();
            out.write(sb.toString());
            out.flush();
            out.close();
            logger.info("������ڵ������");
		}catch (Exception e) {
			// TODO: handle exception
			logger.info("������ڵ��쳣��", e);
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String search(){
		try{
			String name = this.getSearch().trim();// ���������cate��ֵ
			name = java.net.URLDecoder.decode(name, "GBK");
			String searchStr = name;
		//  System.out.println(search);
		//  response.setContentType("text/xml");//���÷�����������Ϊxml��ʽ
			HttpServletResponse response = ServletActionContext.getResponse();
			/*System.out.println(response.getClass());*/
			response.setCharacterEncoding("UTF-8");
			//response.setContentType("text/xml; charset=GBK");
			response.setHeader("Cache-Control","no-cache");
			java.io.PrintWriter out = response.getWriter();
			Vector vData = OrService.searchOrg(searchStr);
			StringBuffer buf = new StringBuffer();
			System.out.println("vData.size(): "+vData.size());
			for (int i=0;i<vData.size();i++){
			    String keyword = (String)vData.get(i);
			    System.out.println("keyword: "+keyword);
			    buf.append(keyword+";");
			}
			out.write(buf.toString());  
			//out.print(buf.toString());
	  //    System.out.println(buf.toString());//���Գ���ʹ�õġ�
//			out.print(parasToXML(vData));//����parasToXML()����
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Org getOrg() {
		return org;
	}

	public void setOrg(Org org) {
		this.org = org;
	}

	public List getOrgList() {
		return orgList;
	}

	public void setOrgList(List orgList) {
		this.orgList = orgList;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public IOrgService getOrService() {
		return OrService;
	}

	public void setOrService(IOrgService orService) {
		OrService = orService;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

}
