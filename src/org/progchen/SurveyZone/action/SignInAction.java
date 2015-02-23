package org.progchen.SurveyZone.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.progchen.SurveyZone.domain.User;
import org.progchen.SurveyZone.service.UserService;
import org.progchen.SurveyZone.util.EncryptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * 处理登陆请求的action，此action实现SessionAware是为了更方便的获得session
 */
@Controller
@Scope("prototype")
public class SignInAction extends BaseAction<User> implements SessionAware{

	private static final long serialVersionUID = -5180272108598400745L;

	@Autowired
	private UserService userService;
	
	private Map<String,Object> map;

	public String logOut(){
		map.clear();
		return "logout";
	}
	
	public String toSignInPage(){
		return "toSignInPage";
	}

	public String signIn(){
		
		return SUCCESS;
	}
	/*
	 * validateSignIn(validate为验证前缀,该方法在signIn之前运行)
	 */
	public void validateSignIn() {
		try{
			User user = userService.validateSignIn(model.getEmail(), 	//
				EncryptUtil.encrypt(model.getPassword()));	
			if (user == null){
				addActionError("登录邮箱与密码不匹配，请重新输入!");
			} else{
				map.put("user", user);
			}
		} catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void setSession(Map<String, Object> map) {
		this.map = map;
	}
	
	

}
