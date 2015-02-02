package org.progchen.SurveyZone.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.progchen.SurveyZone.dao.BaseDao;
import org.progchen.SurveyZone.service.BaseService;

/**
 * 抽象的service实现,专门用于继承
 */
public abstract class BaseServiceImpl<T> implements BaseService<T> {
	
	protected BaseDao<T> dao ;
	
	//注入dao
	@Resource
	public void setBaseDao(BaseDao<T> dao) {
		this.dao = dao;
	}

	public void saveEntity(T t) {
		dao.saveEntity(t);
	}

	public void updateEntity(T t) {
		dao.updateEntity(t);
	}

	public void saveOrUpdateEntity(T t) {
		dao.saveOrUpdateEntity(t);
	}

	public void deleteEntity(T t) {
		dao.deleteEntity(t);
	}

	public void batchEntityByHQL(String hql, Object... objects) {
		dao.batchEntityByHQL(hql, objects);
	}

	public T getEntity(Integer id) {
		return dao.getEntity(id);
	}

	public T loadEntity(Integer id) {
		return dao.loadEntity(id);
	}

	public List<T> findEntitiesByHQL(String hql, Object... objects) {
		return dao.findEntitiesByHQL(hql, objects);
	}

}
