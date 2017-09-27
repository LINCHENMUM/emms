package com.zssy.sbwx.common;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.AbstractAction;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 对ActionSupport类进一步封装，并添加execute方法
 * @author DengJianhua
 * 2011-3-8 上午08:19:35
 */
public abstract class BaseAction extends ActionSupport {

	private Map session;

	
    public  String execute(String action,AbstractBaseAction absAction) throws Exception{
    	
    	System.out.println("执行："+action);
		return absAction.execute(getSession(), getRequest(), getResponse());
    	
    }
    
    protected HttpServletRequest getRequest(){
        return ServletActionContext.getRequest();
    }
    protected HttpServletResponse getResponse(){
        return ServletActionContext.getResponse();
    }
    
    protected Object getSession(String name) {
        return getSession().get(name);
    }

    @SuppressWarnings("unchecked")
    protected void setSession(String name, Object value) {
        getSession().put(name, value);
    }
    
    protected void removeSession(String name) {
        getContext().getSession().remove(name);
    }

    private ActionContext getContext(){
        return ActionContext.getContext();
    }
    @SuppressWarnings("unchecked")
    private Map getSession(){
        return getContext().getSession();
    }

    public void setSession(Map map) {
        this.session = map;
        
    }
   
}