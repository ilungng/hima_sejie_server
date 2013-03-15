package com.hima.sejie.dao;

import com.hima.sejie.bean.UserBean;


public class TestDao extends BaseDao implements IDao {
	@Override
	public Object findByPrimaryKey(Integer id) throws Exception {
		Object obj = this.getHibernateTemplate().get(UserBean.class, id);
		return obj;
	}
	
	@Override
	public Object insert(Object obj) throws Exception {
		
		return this.getHibernateTemplate().save(obj);
	}
}
