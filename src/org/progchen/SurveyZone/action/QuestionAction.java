package org.progchen.SurveyZone.action;

import org.progchen.SurveyZone.domain.Question;
import org.progchen.SurveyZone.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class QuestionAction extends BaseAction<Question> {

	private static final long serialVersionUID = 176259162683709466L;

	private Integer sid;
	private Integer pid;
	private Integer qid;
	
	@Autowired
	private SurveyService surveyService;
	
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public Integer getQid() {
		return qid;
	}
	public void setQid(Integer qid) {
		this.qid = qid;
	}
	
	public String toSelectQuestionType(){
		return "toSelectQuestionType";
	}
	
	public String toAddQuestionPage(){
		
		return "" + model.getQuestionType();
	}
	
	
}
