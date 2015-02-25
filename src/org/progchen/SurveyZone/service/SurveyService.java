package org.progchen.SurveyZone.service;

import java.util.List;

import org.progchen.SurveyZone.domain.Page;
import org.progchen.SurveyZone.domain.Question;
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

	/**
	 * ������������
	 * @param question
	 */
	void saveOrUpateQuestion(Question question);

	/**
	 * ����id�������ʵ��
	 * @param qid
	 * @return
	 */
	Question getQuestion(Integer qid);

	/**
	 * ����idɾ������
	 * @param qid
	 */
	void deleteQuestion(Integer qid);

	/**
	 * ����idɾ������
	 * @param sid
	 */
	void deleteSurvey(Integer sid);
	
	/**
	 * ����idɾ��ҳ��
	 * @param pid
	 */
	void deletePage(Integer pid);

	/**
	 * ����ض�����Ĵ�
	 * @param sid
	 */
	void clearAnswer(Integer sid);

	/**
	 * �л������״̬
	 * @param sid
	 */
	void toggleStatus(Integer sid);
}
