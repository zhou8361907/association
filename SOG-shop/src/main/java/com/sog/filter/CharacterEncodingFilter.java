package com.sog.filter;

import java.io.IOException;
import java.security.spec.ECField;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * 
 * @类名 CharacterEncodingFilter
 * @描述  过滤路径
 * @作者 王帅
 * @日期 2018年6月27日 上午9:46:09
 *
 */

@WebFilter(filterName = "CharacterEncoding", urlPatterns = { "/*" }, initParams = {
		@WebInitParam(name = "encoding", value = "UTF-8")
})
public class CharacterEncodingFilter implements Filter {

    public CharacterEncodingFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String encoding = fConfig.getInitParameter("encoding");
		//设置编码
		request.setCharacterEncoding(encoding);
		//设置响应编码
		response.setCharacterEncoding(encoding);
		response.setContentType("text/html;charset=" + encoding);
		
		//向下传送
		chain.doFilter(request, response);
	}

	private FilterConfig fConfig;
	public void init(FilterConfig fConfig) throws ServletException {
			this.fConfig = fConfig;
	}

}
