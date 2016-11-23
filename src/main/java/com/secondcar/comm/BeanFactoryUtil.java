package com.secondcar.comm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanFactoryUtil {
	
	public static Object getBean(String name){
		ApplicationContext ct = new  ClassPathXmlApplicationContext("applicationContext.xml");
		return ct.getBean(name);
	}

}
