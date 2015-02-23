package org.progchen.SurveyZone.test;

import java.security.NoSuchAlgorithmException;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.progchen.SurveyZone.domain.User;
import org.progchen.SurveyZone.service.SurveyService;
import org.progchen.SurveyZone.service.UserService;
import org.progchen.SurveyZone.util.EncryptUtil;
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
	
	@Test
	public void testEncrypt() throws NoSuchAlgorithmException{
		String src = "progchen";
		String des = EncryptUtil.encrypt(src);
		System.out.println(des);
		System.out.println(des.length());
	}
	
	@Test
	public void testSurveyService(){
		SurveyService  surveyService = (SurveyService) context.getBean("surveyService"); 
		User u = new User();
		u.setId(3);
		surveyService.newSurvey(u);
	}
	
}
