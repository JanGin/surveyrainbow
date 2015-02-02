package org.progchen.SurveyZone.service;

import java.util.List;

public interface BaseService<T> {
	//写操作
	public void saveEntity(T t);
	public void updateEntity(T t);
	public void saveOrUpdateEntity(T t);
	public void deleteEntity(T t);
	//按照hql批处理实体
	public void batchEntityByHQL(String hql,Object...objects);
	
	public T getEntity(Integer id);
	public T loadEntity(Integer id);
	public List<T> findEntitiesByHQL(String hql,Object...objects);
}
