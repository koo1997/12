/**
 * 
 */
package com.javateam.springTranscationAnnotation.test;

import java.sql.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.javateam.springTransactionAnnotation.config.DbConfig;
import com.javateam.springTransactionAnnotation.config.WebConfig;
import com.javateam.springTransactionAnnotation.dao.TransactionDAOMyBatis;
import com.javateam.springTransactionAnnotation.domain.MemberVO;

import lombok.extern.slf4j.Slf4j;

/**
 * @author javateam
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {
//		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
//        "file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@ContextConfiguration(classes= {DbConfig.class, WebConfig.class})
@WebAppConfiguration 
@Slf4j
@Transactional(rollbackFor = {RuntimeException.class, Exception.class})
public class InsertTest {
	
	@Autowired
	@Qualifier("txDAOMyBatis")
	private TransactionDAOMyBatis dao;
	
	@Test
    @Transactional(propagation=Propagation.REQUIRES_NEW)
    // @Rollback(true) // DB에 반영하지 않고 rollback !
	@Rollback(false) // DB에 반영 !
	public void testTransaction() {
		
		log.info("######### 트랜잭션 insert 테스트 ##############");
		
		MemberVO member = new MemberVO(); 
		member.setId("spring1234");
		member.setPw("11111111");
		member.setName("스프링맨");
		member.setAddress("가산디지털단지");
		member.setJoindate(new Date(System.currentTimeMillis()));
		
		dao.insertMember(member);
	} //

}
