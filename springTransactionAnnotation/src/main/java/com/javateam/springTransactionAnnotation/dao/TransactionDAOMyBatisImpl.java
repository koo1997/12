package com.javateam.springTransactionAnnotation.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
// import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javateam.springTransactionAnnotation.domain.MemberVO;

import lombok.extern.slf4j.Slf4j;

@Repository("txDAOMyBatis") 
@Slf4j
public class TransactionDAOMyBatisImpl implements TransactionDAOMyBatis {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void insertMember(final MemberVO member) {
		
		log.info("insertMember");
		
		sqlSession.getMapper(TransactionDAOMyBatis.class)
				  .insertMember(member);
		// sqlSession.insert("com.javateam.springTransactionAnnotation.dao.TransactionDAOMyBatis.insertMember", member);

	} // insertMember

	@Override
	public MemberVO getMember(String id) {
		
		log.info("getMember");
		
		return sqlSession.getMapper(TransactionDAOMyBatis.class)
				 		 .getMember(id);
	} // 

	@Override
	public void updateMember(final MemberVO member) {
		
		log.info("updateMember");
		
		TransactionDAOMyBatis memberMapper = sqlSession.getMapper(TransactionDAOMyBatis.class);
		memberMapper.updateMember(member);
	} //

	@Override
	public void deleteMember(final String id) {
		
		log.info("deleteMember");
		
		TransactionDAOMyBatis memberMapper = sqlSession.getMapper(TransactionDAOMyBatis.class);
		memberMapper.deleteMember(id);
	} //

	@Override
	public List<MemberVO> getAllMembers() {

		log.info("getAllMembers");
		
		TransactionDAOMyBatis memberMapper = sqlSession.getMapper(TransactionDAOMyBatis.class);
		return memberMapper.getAllMembers();
	} //
	
} // class 