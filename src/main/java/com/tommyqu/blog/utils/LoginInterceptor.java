/**
 * Project: TommyQuBlog
 * Comments: Login interceptor
 * JDK Version Used: JDK 1.7
 * Author: Tommy Qu
 * Created Date: 08/20/2015
 * Modified By:
 * Modified Date:
 * Why is modified:
 */

package com.tommyqu.blog.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Repository
public class LoginInterceptor implements HandlerInterceptor {
	
	private static final String[] IGNORE_URI = {"/page/showBlogPage.do", "/page/showIndexPage.do", "/page/showSinglePostPage.do", "/page/showAboutMe.do", "/user/login.do", "/user/signOut.do"};

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {
		String requestUrl = request.getRequestURI().replace(request.getContextPath(), "");
		for(int i = 0; i < IGNORE_URI.length; i++) {
			if(requestUrl.contains(IGNORE_URI[i])) {
				return true;
			}
		}
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("user");
		if(obj == null || "".equals(obj.toString())) {
			response.sendRedirect("../page/showIndexPage.do");  
			return false;
		}
		else 
			return true;
	}

}
