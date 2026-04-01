package com.apik.person.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.dao.DataAccessException;

import com.apik.person.command.PersonCommand;
import com.apik.person.dao.PersonDAO;

public class PersonDaoImpl extends SqlSessionDaoSupport implements PersonDAO {
	
	
	//회원 검색
	@Override
	public List<PersonCommand> searchperson(PersonCommand personDto) throws DataAccessException {
		// TODO Auto-generated method stub
		System.out.println("searchperson 메소드 실행");
		return getSqlSession().selectList("searchperson",personDto);
	}
	
	//회원 목록
	@Override
	public List<PersonCommand> listperson() throws DataAccessException {
		// TODO Auto-generated method stub
		List<PersonCommand> listperson=getSqlSession().selectList("listperson");
		return listperson;
	}
	
	//검색된 목록 수
	@Override
	public int countperson() throws DataAccessException {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("countperson");
	}
	@Override
	public int countsearchperson(PersonCommand personDto) throws DataAccessException {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("countsearchperson",personDto);
	}
	
	
	//회원 등록
	@Override
	public void insertperson(PersonCommand personDto) throws DataAccessException {
		// TODO Auto-generated method stub
		getSqlSession().insert("insertperson",personDto);
	}
	
	//회원 상세정보
	@Override
	public PersonCommand detailsperson(String id) throws DataAccessException {
		// TODO Auto-generated method stub
		return (PersonCommand)getSqlSession().selectOne("detailsperson",id);
	}
	
	//회원 수정
	@Override
	public void updateperson(PersonCommand personDto) throws DataAccessException {
		// TODO Auto-generated method stub
		getSqlSession().update("updateperson",personDto);
	}
	
	//회원 삭제
	@Override
	public void deleteperson(String id) throws DataAccessException {
		// TODO Auto-generated method stub
		getSqlSession().delete("deleteperson",id);
	}
	
	@Override
	public int checkId(String id) {
		int countID=getSqlSession().selectOne("loginperson", id);
		return countID;
	}

}
