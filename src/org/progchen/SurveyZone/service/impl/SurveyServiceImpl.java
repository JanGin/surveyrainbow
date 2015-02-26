package org.progchen.SurveyZone.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.progchen.SurveyZone.dao.BaseDao;
import org.progchen.SurveyZone.domain.Answer;
import org.progchen.SurveyZone.domain.Page;
import org.progchen.SurveyZone.domain.Question;
import org.progchen.SurveyZone.domain.Survey;
import org.progchen.SurveyZone.domain.User;
import org.progchen.SurveyZone.service.SurveyService;
import org.springframework.stereotype.Service;

@Service("surveyService")
public class SurveyServiceImpl implements SurveyService{

	@Resource(name="surveyDao")
	private BaseDao<Survey> surveyDao;
	
	@Resource(name="pageDao")
	private BaseDao<Page> pageDao;
	
	@Resource(name="questionDao")
	private BaseDao<Question> questionDao;
	
	@Resource(name="answerDao")
	private BaseDao<Answer> answerDao;
	@Override
	public Survey newSurvey(User user) {
		Survey survey = new Survey();
		Page page = new Page();
		survey.setUser(user);
		//…Ë÷√πÿ¡™
		page.setSurvey(survey);
		survey.getPages().add(page);
		surveyDao.saveEntity(survey);
		pageDao.saveEntity(page);
		return survey;
	}

	@Override
	public List<Survey> findMySurveys(User user) {
		String hql = "FROM Survey s WHERE s.user.id =?";
		List<Survey> surveysList = surveyDao.findEntitiesByHQL(hql, user.getId());
		return surveysList;
	}

	@Override
	public Survey getSurveyById(Integer sid) {
		Survey survey = surveyDao.getEntity(sid);
		return survey;
	}

	@Override
	public Survey getSurveyWithChildren(Integer sid) {
		Survey survey = this.getSurveyById(sid);
		for (Page p : survey.getPages()){
			p.getQuestions().size();
		}
		return survey;
	}

	@Override
	public void saveOrUpatePage(Page page) {
		pageDao.saveOrUpdateEntity(page);
	}

	@Override
	public void updateSurvey(Survey survey) {
		surveyDao.updateEntity(survey);
	}

	@Override
	public Page getPage(Integer pid) {
		return pageDao.getEntity(pid);
	}

	@Override
	public void saveOrUpateQuestion(Question question) {
		questionDao.saveOrUpdateEntity(question);
	}

	@Override
	public Question getQuestion(Integer qid) {
		return questionDao.getEntity(qid);
	}

	@Override
	public void deleteQuestion(Integer qid) {
		String hql1 = "delete FROM Answer a WHERE a.questionId = ?";
		answerDao.batchEntityByHQL(hql1, qid);
		String hql2 = "delete FROM Question q WHERE q.id = ?";
		questionDao.batchEntityByHQL(hql2, qid);
	}

	@Override
	public void deletePage(Integer pid){
		String hql1 = "delete FROM Answer a WHERE a.questionId in (select id FROM Question q WHERE q.page.id = ?)";
		answerDao.batchEntityByHQL(hql1, pid);
		String hql2 = "delete FROM Question q WHERE q.page.id = ?";
		questionDao.batchEntityByHQL(hql2, pid);
		String hql3 = "delete FROM Page p WHERE p.id = ?";
		pageDao.batchEntityByHQL(hql3, pid);
	}
	
	@Override
	public void deleteSurvey(Integer sid){
		String hql1 = "delete FROM Answer a WHERE a.surveyId = ?";
		answerDao.batchEntityByHQL(hql1, sid);
		String hql2 = "delete FROM Question q WHERE q.page.id in (select id FROM Page p WHERE p.survey.id =?)";
		questionDao.batchEntityByHQL(hql2, sid);
		String hql3 = "delete FROM Page p WHERE p.survey.id = ?";
		pageDao.batchEntityByHQL(hql3, sid);
		String hql4 = "delete FROM Survey s WHERE s.id = ?";
		surveyDao.batchEntityByHQL(hql4, sid);
	}

	@Override
	public void clearAnswer(Integer sid) {
		String hql = "delete FROM Answer a WHERE a.surveyId = ?";
		answerDao.batchEntityByHQL(hql, sid);
	}

	@Override
	public void toggleStatus(Integer sid) {
		Survey survey = surveyDao.getEntity(sid);
		String hql = "UPDATE Survey s SET s.opened = ? WHERE s.id = ?";
		surveyDao.batchEntityByHQL(hql,!survey.isOpened(),sid);
	}

	@Override
	public void addFilePath2DB(String path,Integer sid) {
		String hql = "UPDATE Survey s SET s.logoPicPath = ? WHERE s.id = ?";
		surveyDao.batchEntityByHQL(hql, path,sid);
	}
}
