package com.springbook.ioc.injection;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionBeanListClient {
	
	private static Logger log 
		= LoggerFactory.getLogger(CollectionBeanListClient.class);
	
	public static void main(String[] args) {
		
		AbstractApplicationContext factory 
			= new GenericXmlApplicationContext("applicationContext.xml");
		CollectionBeanList bean 
			=  (CollectionBeanList) factory.getBean("collectionBeanList");
		
		List<String> addressList = bean.getAddressList();
		
		for(String s : addressList){
			log.debug("- : " + s);
		}
		
		factory.close();
	}
}
