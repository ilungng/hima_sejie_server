package com.hima.sejie.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hima.sejie.dao.IDao;

public class UseApplicationContext {
	
	public static ApplicationContext action;
	static{
		action =new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	public static IDao getDaoImpl(String daoName){
		return (IDao)action.getBean(daoName);
	}

}
