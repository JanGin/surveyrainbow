package org.progchen.SurveyZone.test;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.progchen.SurveyZone.domain.User;
import org.progchen.SurveyZone.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestContext {

	private static ApplicationContext context = null;
	
	@BeforeClass
	public static void initContext(){
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	@Test
	public void testUserService(){
		UserService userService = (UserService) context.getBean("userService");
		User user = new User();
		user.setNickName("xili");
		user.setPassword("123456");
		user.setRegisteDate(new Date());
		user.setEmail("xili@yahoo.cn");
		userService.saveEntity(user);
	}
}
