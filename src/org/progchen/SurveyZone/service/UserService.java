package org.progchen.SurveyZone.service;

import org.progchen.SurveyZone.domain.User;

public interface UserService extends BaseService<User> {

	/**
	 * �ж������Ƿ�ע���
	 */
	public boolean isRegistered(String email);
}
