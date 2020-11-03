package com.choa.s4.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class TestFilter
 */
public class TestFilter implements Filter {

    /**
     * Default constructor. 
     */
    public TestFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req=((HttpServletRequest)request);
		HttpSession session=	req.getSession();
		Object obj = session.getAttribute("member");
		
		String url = req.getRequestURL().toString();
		int i=url.lastIndexOf("/")+1;
		url=url.substring(i);
		//로그인이 된상태
		if(obj!=null) {
			//컨트롤러로보냄
			chain.doFilter(request, response);
		}else {
			if(url.equals("qnaList")) {
				chain.doFilter(request, response);
			}else {
				((HttpServletResponse)response).sendRedirect("../member/memberLogin");
			}
			
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
