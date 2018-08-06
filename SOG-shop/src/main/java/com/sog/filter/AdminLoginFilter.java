package com.sog.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * 
 * @类名 AdminLoginFilter
 * @描述 TODO(一句话描述类的作用)
 * @作者 王帅
 * @日期 2018年6月27日 下午8:08:18
 *
 */
@WebFilter("/admin/*")
public class AdminLoginFilter implements Filter {

    public AdminLoginFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		HttpServletResponse servletResponse = (HttpServletResponse) response;
		HttpSession session = servletRequest.getSession();
		
		//获得用户请求的url
		String path = servletRequest.getRequestURI();
		//System.out.println(path);
		if(path.contains("login") || path.contains("css") || path.contains("f")|| path.contains("AdminServlet")) {
			chain.doFilter(request, response);
		}else {
			Object obj = session.getAttribute("username");
			if(null == obj) {
				servletResponse.sendRedirect("/admin/login.html");
			}else {
				chain.doFilter(request, response);
			}
		} 
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
