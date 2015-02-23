package org.progchen.SurveyZone.service;

import org.progchen.SurveyZone.domain.User;

public interface UserService extends BaseService<User> {

	/**
	 * 判断邮箱是否被注册过
	 */
	public boolean isRegistered(String email);
	
	/**
	 * 校验登录字段
	 */
	public User validateSignIn(String email,String password);
}
