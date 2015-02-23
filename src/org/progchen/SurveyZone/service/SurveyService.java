package org.progchen.SurveyZone.service;

import java.util.List;

import org.progchen.SurveyZone.domain.Page;
import org.progchen.SurveyZone.domain.Survey;
import org.progchen.SurveyZone.domain.User;

/**
 * SurveyService
 */
public interface SurveyService {

	/**
	 * �½�����
	 */
	Survey newSurvey(User user);
	
	/**
	 * ����id��ѯsurvey
	 */
	Survey getSurveyById(Integer sid);
	/**
	 * �ҵĵ����б�
	 */
	List<Survey> findMySurveys(User user);
	
	/**
	 * ��ȡ������Survey(����������)
	 */
	Survey getSurveyWithChildren(Integer sid);

	/**
	 * �������µ���ҳ��
	 * @param survey
	 */
	void saveOrUpatePage(Page page);

	/**
	 * ���µ���
	 */
	void updateSurvey(Survey survey);

	/**
	 * ����ҳ��id��ȡ�õ�������ҳ��
	 * @param pid
	 * @return
	 */
	Page getPage(Integer pid);

	
}
