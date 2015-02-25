package org.progchen.SurveyZone.domain;

import java.util.Date;

public class Answer {

	private Integer id;
	
	private String uuid;		//问题批次
	
	private String answerIds;
	//其他选项
	private String otherAnswer;
	
	private Integer questionId;
	//冗余字段，为了删除时提高效率
	//private Integer pageId;
	//冗余字段，为了删除时提高效率
	private Integer surveyId;

	private Date answerTime = new Date();
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	/*
	public Integer getPageId() {
		return pageId;
	}

	public void setPageId(Integer pageId) {
		this.pageId = pageId;
	}
	 */
	public Integer getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(Integer surveyId) {
		this.surveyId = surveyId;
	}

	public String getAnswerIds() {
		return answerIds;
	}

	public void setAnswerIds(String answerIds) {
		this.answerIds = answerIds;
	}

	public String getOtherAnswer() {
		return otherAnswer;
	}

	public void setOtherAnswer(String otherAnswer) {
		this.otherAnswer = otherAnswer;
	}
	
	public Date getAnswerTime() {
		return answerTime;
	}

	public void setAnswerTime(Date answerTime) {
		this.answerTime = answerTime;
	}

}
