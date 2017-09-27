package com.zssy.sbwx.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyGBKFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("GBK");
		System.out.println(request.getCharacterEncoding());
		chain.doFilter(request, response);
	}

	public void init(FilterConfig arg0) throws ServletException {
	}

}