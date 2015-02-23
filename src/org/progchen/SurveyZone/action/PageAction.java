package org.progchen.SurveyZone.action;

import org.progchen.SurveyZone.domain.Page;
import org.progchen.SurveyZone.service.PageService;
import org.progchen.SurveyZone.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
public class PageAction extends BaseAction<Page> implements ModelDriven<Page>{

	private static final long serialVersionUID = -6357013638383492996L;

	private Integer sid;
	
	@Autowired
	private SurveyService surveyService;
	@Autowired
	private PageService pageService;
	
	
	public String addPage(){
		return "addPage";
	}
	
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
}
