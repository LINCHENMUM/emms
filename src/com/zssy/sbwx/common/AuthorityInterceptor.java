package com.zssy.sbwx.common;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

//Ȩ�޼���������̳�AbstractInterceptor�� 
public class AuthorityInterceptor extends AbstractInterceptor {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// ����Action��������ط���
	public String intercept(ActionInvocation invocation) throws Exception {
		// ȡ��������ص�ActionContextʵ��
		//ActionContext ctx = invocation.getInvocationContext();
		ActionContext ctx = ActionContext.getContext();// ���ActionContext
		Map session = ctx.getSession();
		// ȡ����Ϊuser��Session����
		String username = (String) session.get("username");
		
		System.out.println("username:"+username);
		// ���û�е�½�����ߵ�½���õ��û�������scott�����������µ�½
		if (username != null && !"".equals(username)) {
			return invocation.invoke();
		}
		// û�е�½������������ʾ���ó�һ��HttpServletRequest����
		ctx.put("tip", "����û�е�½���������½ϵͳ");
		// ֱ�ӷ���login���߼���ͼ
		return Action.LOGIN;
	}
}
