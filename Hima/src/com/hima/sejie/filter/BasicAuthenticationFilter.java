package com.hima.sejie.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class BasicAuthenticationFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		// TODO Auto-generated method stub
		final HttpServletRequest httpRequest = (HttpServletRequest) arg0;
		final HttpServletResponse httpResponse = (HttpServletResponse) arg1;
		String path = httpRequest.getPathInfo() ;	// 获取地址
		System.out.println("访问地址是"+path);
		arg2.doFilter( arg0, arg1 ) ;
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
	}

}
