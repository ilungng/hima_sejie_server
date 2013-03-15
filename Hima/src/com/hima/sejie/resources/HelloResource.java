package com.hima.sejie.resources;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import com.hima.sejie.bean.UserBean;
import com.hima.sejie.dao.CutPageBean;
import com.hima.sejie.dao.IDao;
import com.hima.sejie.utils.PojoMapper;
import com.hima.sejie.utils.UseApplicationContext;


public class HelloResource extends ServerResource{
	private CutPageBean cutpage;
	
	public CutPageBean getCutpage() {
		return cutpage;
	}

	public void setCutpage(CutPageBean cutpage) {
		this.cutpage = cutpage;
	}

	@Get("json")
	public String getUser(){
		String u = null;
		IDao dao = UseApplicationContext.getDaoImpl("testDao");
		try {
		 UserBean bean= (UserBean) dao.findByPrimaryKey(1);
		u =  PojoMapper.toJson(bean, true);
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return u;
		
	}
}
