package org.progchen.SurveyZone.dao;

import java.util.List;

/**
 * dao�ӿ�
 */
public interface BaseDao<T> {
	//д����
	public void saveEntity(T t);
	public void updateEntity(T t);
	public void saveOrUpdateEntity(T t);
	public void deleteEntity(T t);
	//����hql������ʵ��
	public void batchEntityByHQL(String hql,Object...objects);
	
	public T getEntity(Integer id);
	public T loadEntity(Integer id);
	public List<T> findEntitiesByHQL(String hql,Object...objects);
	
}
