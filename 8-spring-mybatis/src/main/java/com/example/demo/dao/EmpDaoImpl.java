package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Emp;

@Repository
public class EmpDaoImpl implements EmpDao {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insert(Emp emp) {

		return 0;
	}

	@Override
	public int update(Emp emp) {

		return 0;
	}

	@Override
	public int delete(int empno) {

		return 0;
	}

	@Override
	public List<Emp> findAll() {
//		select * from emp order by empno asc"
		
		return sqlSession.selectList("com.example.demo.dao.EmpDao.findAll");
	}

	@Override
	public int count() {

		return 0;
	}

	@Override
	public Emp findOne(int empno) {

		return null;
	}

}
