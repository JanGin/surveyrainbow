package org.progchen.SurveyZone.interceptor;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.progchen.SurveyZone.action.BaseAction;
import org.progchen.SurveyZone.action.RegisterAction;
import org.progchen.SurveyZone.action.SignInAction;
import org.progchen.SurveyZone.action.UserAware;
import org.progchen.SurveyZone.domain.User;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class SignInInterceptor implements Interceptor {

	private static final long serialVersionUID = 1L;

	@Override
	public void destroy() {
	
	}

	@Override
	public void init() {
	
	}

	@SuppressWarnings("rawtypes")
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		BaseAction action = (BaseAction) invocation.getAction();
		if (action instanceof RegisterAction || action instanceof SignInAction){
			return invocation.invoke();
		} else{
			HttpSession session = ServletActionContext.getRequest().getSession();
			User user = (User)session.getAttribute("user");
			if (user == null){
				return "index";
			} else{
				if (action instanceof UserAware){
					//×¢ÈëUser
					((UserAware) action).setUser(user);
				}
				return invocation.invoke();
			}
		}
		
	}

}
