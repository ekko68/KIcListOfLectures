package com.apik.person.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.apik.person.command.PersonCommand;

//Person Table을 사용하는 모든 기능 등록
public interface PersonDAO {
	
	//0.회원 검색 (searchperson)
	public List<PersonCommand> searchperson(PersonCommand personDto) throws DataAccessException;
	//1.회원 목록 (listperson)
	public List<PersonCommand> listperson() throws DataAccessException;
	public int countperson() throws DataAccessException;
	public int countsearchperson(PersonCommand personDto) throws DataAccessException;
	//2. 회원 로그인 (loginperson)
	//3. 회원 등록 (insertperson)
	public void insertperson(PersonCommand personDto) throws DataAccessException;
	//4. 회원 수정 (updateperson)
	public void updateperson(PersonCommand personDto) throws DataAccessException;	
	//5. 회원 비밀번호 변경 (updatepersonpasswd)
	//6. 회원 삭제 (deleteperson)
	public void deleteperson(String id) throws DataAccessException;
	//7.회원 상세정보
	public PersonCommand detailsperson(String id) throws DataAccessException;
	

	//7. checked id
	public int checkId(String id);
	
}
