package org.progchen.SurveyZone.service;

import org.progchen.SurveyZone.domain.User;

public interface UserService extends BaseService<User> {

	/**
	 * ÅĞ¶ÏÓÊÏäÊÇ·ñ±»×¢²á¹ı
	 */
	public boolean isRegistered(String email);
}
