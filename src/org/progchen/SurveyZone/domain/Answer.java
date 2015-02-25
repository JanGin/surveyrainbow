package org.progchen.SurveyZone.domain;

import java.util.Date;

public class Answer {

	private Integer id;
	
	private String uuid;		//��������
	
	private String answerIds;
	//����ѡ��
	private String otherAnswer;
	
	private Integer questionId;
	//�����ֶΣ�Ϊ��ɾ��ʱ���Ч��
	//private Integer pageId;
	//�����ֶΣ�Ϊ��ɾ��ʱ���Ч��
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
