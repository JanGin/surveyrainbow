package org.progchen.SurveyZone.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.progchen.SurveyZone.dao.BaseDao;
import org.progchen.SurveyZone.domain.User;
import org.progchen.SurveyZone.service.UserService;
import org.progchen.SurveyZone.util.ValidateUtil;
import org.springframework.stereotype.Service;

/**
 * UserServiceImpl
 */
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements
		UserService {

	/**
	 * 重写该方法,覆盖注解
	 */
	@Resource(name="userDao")
	public void setBaseDao(BaseDao<User> dao) {
		super.setBaseDao(dao);
	}

	@Override
	public boolean isRegistered(String email) {
		String hql = "FROM User u WHERE u.email = ?";
		return ValidateUtil.isValid(this.findEntitiesByHQL(hql, email));
	
	}

	@Override
	public User validateSignIn(String email, String password) {
		String hql = "FROM User u WHERE u.email = ? AND u.password = ?";
		List<User> list = this.findEntitiesByHQL(hql, email,password);
		return ValidateUtil.isValid(list) ? list.get(0) : null; 
	}

}
