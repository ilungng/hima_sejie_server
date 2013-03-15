package com.hima.sejie.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
public class BaseDao extends HibernateDaoSupport implements IDao {

	public CutPageBean cutPage(final int pageNO, final int pageSize,
			final String hql, final Object[] values) {
		CutPageBean bean = new CutPageBean();

		// 通过回调函数，扩展HibernateTemplate功能。
		List<?> list = this.getHibernateTemplate().executeFind(
				new HibernateCallback<Object>() {

					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query q = session.createQuery(hql);
						q.setFirstResult((pageNO - 1) * pageSize);
						q.setMaxResults(pageSize);

						if (values != null) {
							for (int i = 0; i < values.length; i++) {
								q.setParameter(i, values[i]);
							}
						}
						List<?> list = q.list();
						return list;
					}
				});
		bean.setRows(list);

		String s = this.getHibernateTemplate()
				.find("select count(*) " + hql, values).get(0).toString();

		int count = Integer.parseInt(s);
		if (count % pageSize == 0) {
			bean.setTotal(count / pageSize);
		} else {
			bean.setTotal(count / pageSize + 1);
		}

		return bean;
	}

	public Object insert(Object obj) throws Exception {
		
		return null;
	}

	public Object update(Object obj) throws Exception {
		
		return null;
	}

	public Object delete(Integer id) throws Exception {
		
		return null;
	}

	public Object findByPrimaryKey(Integer id) throws Exception {
		
		return null;
	}

	public List<?> findAll() throws Exception {
		
		return null;
	}

	public List<?> findWhereNameEquals(String name) throws Exception {
		
		return null;
	}

	public List<Map<String, Object>> findByDynamicSelect(String sql, Object[] sqlParams)
			throws Exception {
		Session session = this.getHibernateTemplate().getSessionFactory()
				.openSession();
		Connection conn = session.connection();
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
			System.out.println(sql);
			PreparedStatement ps = conn.prepareStatement(sql);
			for (int i = 0; i < sqlParams.length; i++) {
				Object param = sqlParams[i];
				ps.setObject(i + 1, param);
				System.out.println(sqlParams[i]);
			}
			ResultSet rs = ps.executeQuery();
			
			ResultSetMetaData md = rs.getMetaData();
			int columnCount = md.getColumnCount();
			while (rs.next()) {
				for (int i = 1; i <= columnCount; i++) {
//					System.out.print(rs.getObject(i) + "  ");
				}
				System.out.println();
				Map<String, Object> map = new HashMap<String, Object>();
				for (int i = 1; i <= columnCount; i++) {
					map.put(md.getColumnName(i), rs.getObject(i));
				}
				list.add(map);
			}
			rs.close();
			ps.close();
			session.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public Object executeSQL(String sql, Object[] sqlParams) throws Exception {
		
		return null;
	}
}
