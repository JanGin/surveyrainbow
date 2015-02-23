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

	
}
