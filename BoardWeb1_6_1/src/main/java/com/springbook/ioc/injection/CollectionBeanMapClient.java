package com.springbook.ioc.injection;


import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionBeanMapClient {
	
	private static Logger log 
		= LoggerFactory.getLogger(CollectionBeanMapClient.class);
	
	public static void main(String[] args) {
		
		AbstractApplicationContext factory 
			= new GenericXmlApplicationContext("applicationContext.xml");
		CollectionBeanMap bean 
			=  (CollectionBeanMap) factory.getBean("collectionBeanMap");
		
		Map<String, String> addressList = bean.getAddressList();
		
		// addressList.forEach((k,v)->log.debug(k + "=" + v));
		addressList.forEach((k,v)->log.debug("{}={}",k,v));
		
		factory.close();
	}
}
