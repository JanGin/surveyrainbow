package org.progchen.SurveyZone.service;

import org.progchen.SurveyZone.domain.User;

public interface UserService extends BaseService<User> {

	/**
	 * �ж������Ƿ�ע���
	 */
	public boolean isRegistered(String email);
	
	/**
	 * У���¼�ֶ�
	 */
	public User validateSignIn(String email,String password);
}
