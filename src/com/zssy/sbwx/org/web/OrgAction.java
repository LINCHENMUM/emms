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
	private IOrgService OrService; // 注入业务方法
	private Org org;
	private Integer id;
	private Integer parentId;
	private List orgList; // 所有记录
	private static Logger logger = Logger.getLogger(OrgAction.class);
	private String search;

	public String orgAdd(){
		try{
			logger.info("添加部门开始！");
			//System.out.println(org.getorgname());
			OrService.save(org);
			logger.info("添加部门结束！");
		}catch(Exception e){
			logger.info("添加部门异常：", e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String orgDelete(){
		try{
			logger.info("删除部门开始！");
			org = OrService.findById(id);
			if (org != null) {
				OrService.delete(org);
			}
			logger.info("删除部门结束！");
		}catch(Exception e){
			logger.info("删除部门异常：",e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String orgList(){
		try{
			logger.info("部门列表开始！");
			orgList = OrService.findAll();
			logger.info("部门列表结束！");
		}catch(Exception e){
			logger.info("部门列表异常：", e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String orgEdit(){
		try{
			logger.info("部门修改开始！");
			org = OrService.findById(id);
			logger.info("部门修改结束！");
		}catch(Exception e){
			logger.info("部门修改异常：", e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String orgUpdate() throws Exception {
		try{
			logger.info("部门更新开始！");
			if (null == org) {
				System.out.println("---ERROR---");
			}
//			System.out.println(org.getId());
//			System.out.println(org.getorgname());
//			System.out.println(org.getPassword());
			OrService.update(org);
			logger.info("部门更新结束！");
		}catch(Exception e){
			logger.info("部门更新异常：", e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String orgFindById() throws Exception {
		try{
			logger.info("查找部门开始！");
			OrService.findById(id);
			logger.info("查找部门结束！");
		}catch(Exception e){
			logger.info("查找部门异常：", e);
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String orgFindByParentId() throws Exception{
		try{
			logger.info("通过父节点查找部门开始！");
			orgList=OrService.findByParentId(parentId);
			Org o=(Org)orgList.get(0);
			System.out.println(orgList.size()+o.getName());
			logger.info("通过父节点查找部门结束！");
		}catch (Exception e) {
			// TODO: handle exception
			logger.info("通过父节点查找部门异常！", e);
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String getTreeNode() throws Exception{
		try{
			logger.info("获得树节点开始！");
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
                  //第一、第二级别分类可以有多选框
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
            logger.info("获得树节点结束！");
		}catch (Exception e) {
			// TODO: handle exception
			logger.info("获得树节点异常：", e);
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String search(){
		try{
			String name = this.getSearch().trim();// 获得请求中cate的值
			name = java.net.URLDecoder.decode(name, "GBK");
			String searchStr = name;
		//  System.out.println(search);
		//  response.setContentType("text/xml");//设置返回数据类型为xml格式
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
	  //    System.out.println(buf.toString());//调试程序使用的。
//			out.print(parasToXML(vData));//调用parasToXML()方法
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
