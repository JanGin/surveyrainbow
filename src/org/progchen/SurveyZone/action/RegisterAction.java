package org.progchen.SurveyZone.action;

import org.apache.struts2.interceptor.validation.SkipValidation;
import org.progchen.SurveyZone.domain.User;
import org.progchen.SurveyZone.service.UserService;
import org.progchen.SurveyZone.util.ValidateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class RegisterAction extends BaseAction<User> {

	private static final long serialVersionUID = 1L;
	@Autowired
	private UserService userService;
	private String confirmPassword;
	
	private User model = new User();

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	@Override
	public User getModel() {
		return model;
	}

	@SkipValidation
	public String toRegisterPage(){
		
		return "toRegisterPage";
	}
	
	public String doRegister(){
		userService.saveEntity(model);
		ActionContext.getContext().getSession().put("success", "恭喜你注册成功!");
	    return SUCCESS;
	}

	@Override
	public void validate() {
		if (!ValidateUtil.isValid(model.getNickName())){
			addFieldError("nickName", "用户昵称不能为空");
		} 
		if (!ValidateUtil.isValid(model.getPassword())){
			addFieldError("password","密码不能为空");
		}
		if (!model.getPassword().equals(confirmPassword)){
			addFieldError("password","两次输入的密码不一致");
		}
		if (!ValidateUtil.isValid(model.getEmail())){
			addFieldError("email","邮箱不能为空");
		}
		if (this.hasErrors()){
			return ;
		}
		if (userService.isRegistered(model.getEmail())){
			addFieldError("email", "该邮箱已被注册过");
		}
		
	}
	
}
