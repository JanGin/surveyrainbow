package org.progchen.SurveyZone.action;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.struts2.util.ServletContextAware;
import org.progchen.SurveyZone.domain.Survey;
import org.progchen.SurveyZone.domain.User;
import org.progchen.SurveyZone.service.SurveyService;
import org.progchen.SurveyZone.util.ValidateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class SurveyAction extends BaseAction<Survey> implements UserAware,ServletContextAware{

	private static final long serialVersionUID = 5560126741364814472L;

	private ServletContext servletContext;
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
	
	public String deleteSurvey(){
		surveyService.deleteSurvey(sid);
		return "mySurveyList";
	}
	
	public String clearAnswers(){
		surveyService.clearAnswer(sid);
		return "clearAnswer";
	}
	
	public String toggleStatus(){
		surveyService.toggleStatus(sid);
		return "mySurveyList";
	}
	
	/**
	 * 到达增加logo页面
	 */
	public String toAddLogoPage(){
		return "toAddLogoPage";
	}
	
	/*=========================处理文件上传====================================*/
	private String logoPictureFileName;
	
	private File logoPicture;
	
	public String getLogoPictureFileName() {
		return logoPictureFileName;
	}

	public void setLogoPictureFileName(String logoPictureFileName) {
		this.logoPictureFileName = logoPictureFileName;
	}

	public File getLogoPicture() {
		return logoPicture;
	}
	
	public void setLogoPicture(File logoPicture) {
		this.logoPicture = logoPicture;
	}

	public String doAddLogo(){
		//文件上传
		if (ValidateUtil.isValid(logoPictureFileName)){
			String dir = servletContext.getRealPath("/upload");
			long timestamp = System.nanoTime();
			String ext = logoPictureFileName.substring(logoPictureFileName.lastIndexOf("."));
			File file = new File(dir, timestamp + ext);
			logoPicture.renameTo(file);
			//更新数据库
			surveyService.addFilePath2DB("/upload/" + timestamp + ext,sid);
		}

		return "updatedSurvey";
	}
	
	/*图片是否存在*/
	@SuppressWarnings("unused")
	private boolean logoPictureExists() {
		if (ValidateUtil.isValid(model.getLogoPicPath())){
			String realPath = servletContext.getRealPath(model.getLogoPicPath());
			return new File(realPath).exists();
		}
		return false;
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

	@Override
	public void setServletContext(ServletContext arg0) {
		this.servletContext = arg0;
	}
	
}
