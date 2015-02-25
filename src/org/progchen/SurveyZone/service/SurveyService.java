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
	 * 新建调查
	 */
	Survey newSurvey(User user);
	
	/**
	 * 按照id查询survey
	 */
	Survey getSurveyById(Integer sid);
	/**
	 * 我的调查列表
	 */
	List<Survey> findMySurveys(User user);
	
	/**
	 * 获取完整的Survey(包含子属性)
	 */
	Survey getSurveyWithChildren(Integer sid);

	/**
	 * 保存或更新调查页面
	 * @param survey
	 */
	void saveOrUpatePage(Page page);

	/**
	 * 更新调查
	 */
	void updateSurvey(Survey survey);

	/**
	 * 根据页面id获取该调查的相关页面
	 * @param pid
	 * @return
	 */
	Page getPage(Integer pid);

	/**
	 * 保存或更新问题
	 * @param question
	 */
	void saveOrUpateQuestion(Question question);

	/**
	 * 根据id获得问题实体
	 * @param qid
	 * @return
	 */
	Question getQuestion(Integer qid);

	/**
	 * 根据id删除问题
	 * @param qid
	 */
	void deleteQuestion(Integer qid);

	/**
	 * 根据id删除调查
	 * @param sid
	 */
	void deleteSurvey(Integer sid);
	
	/**
	 * 根据id删除页面
	 * @param pid
	 */
	void deletePage(Integer pid);

	/**
	 * 清除特定调查的答案
	 * @param sid
	 */
	void clearAnswer(Integer sid);

	/**
	 * 切换调查的状态
	 * @param sid
	 */
	void toggleStatus(Integer sid);
}
