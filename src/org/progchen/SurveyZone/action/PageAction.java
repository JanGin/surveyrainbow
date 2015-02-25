package org.progchen.SurveyZone.action;

import org.progchen.SurveyZone.domain.Page;
import org.progchen.SurveyZone.domain.Survey;
import org.progchen.SurveyZone.service.PageService;
import org.progchen.SurveyZone.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class PageAction extends BaseAction<Page> {

	private static final long serialVersionUID = -6357013638383492996L;

	private Integer sid;
	
	private Integer pid;
	
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	
	@Autowired
	private SurveyService surveyService;
	@Autowired
	private PageService pageService;
	
	public String saveOrUpdatePage(){
		Survey survey = new Survey();
		survey.setId(sid);
		model.setSurvey(survey);
		surveyService.saveOrUpatePage(model);
		return "updatedSurvey";
	}
	
	/**
	 * 增加页面
	 */
	public String addPage(){
		return "addPage";
	}
	
	/**
	 *编辑页面标题
	 */
	public String editPage(){
		this.model = surveyService.getPage(pid);
		return "editPage";
	}
	
	/**
	 * 删除页
	 */
	public String deletePage() {
		surveyService.deletePage(pid);
		return "updatedSurvey";
	}
}
