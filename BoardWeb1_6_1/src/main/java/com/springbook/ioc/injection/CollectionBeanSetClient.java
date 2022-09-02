package com.springbook.ioc.injection;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionBeanSetClient {
	
	private static Logger log 
		= LoggerFactory.getLogger(CollectionBeanSetClient.class);
	
	public static void main(String[] args) {
		
		AbstractApplicationContext factory 
			= new GenericXmlApplicationContext("applicationContext.xml");
		CollectionBeanSet bean 
			=  (CollectionBeanSet) factory.getBean("collectionBeanSet");
		
		Set<String> addressList = bean.getAddressList();
		
		for(String s : addressList){
			log.debug("- : " + s);
		}
		
		factory.close();
	}
}
