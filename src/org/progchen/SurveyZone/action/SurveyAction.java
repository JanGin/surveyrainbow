package org.progchen.SurveyZone.action;

import java.util.List;

import org.progchen.SurveyZone.domain.Survey;
import org.progchen.SurveyZone.domain.User;
import org.progchen.SurveyZone.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class SurveyAction extends BaseAction<Survey> implements UserAware{

	private static final long serialVersionUID = 5560126741364814472L;

	@Autowired
	private SurveyService surveyService;
	
	private List<Survey> surveysList;

	private Integer sid;
	
	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	//接收User
	private User user;

	public String newSurvey(){
		
		this.model = surveyService.newSurvey(user);
		return "newSurvey";
	}
	
	public String mySurveys(){
		
		this.surveysList = surveyService.findMySurveys(user);
		return "mySurveys";
	}
	
	public String designSurvey(){
		//this.model = surveyService.getSurveyById(sid);
		//解决懒加载问题一次性将survey和其子属性一并获取
		this.model = surveyService.getSurveyWithChildren(sid);
		return "designSurvey";
	}
	
	public String editSurvey(){
		this.model = surveyService.getSurveyById(sid);
		return "editSurvey";
	}
	
	public String updateSurvey(){
		this.sid = model.getId();
		this.model.setUser(user);
		surveyService.updateSurvey(model);
		return "updatedSurvey";
	}
	/*
	 * 确保在designSurvey和getModel之前执行
	 
	public void prepareDesignSurvey() throws Exception {
		this.model = surveyService.getSurveyById(sid);
	}
	*/
	public List<Survey> getSurveysList() {
		return surveysList;
	}

	public void setSurveysList(List<Survey> surveysList) {
		this.surveysList = surveysList;
	}
	
	public User getUser() {
		return user;
	}

	@Override
	public void setUser(User user) {
		this.user = user;
	}
	
}
