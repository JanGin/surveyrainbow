package org.progchen.SurveyZone.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.progchen.SurveyZone.dao.BaseDao;
import org.progchen.SurveyZone.domain.Page;
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
	public void updateSurvey(Survey survey) {
		surveyDao.updateEntity(survey);
		
	}

}
