package com.example.demo.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Emp;

@Repository
public class EmpDaoImpl implements EmpDao {
	public JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
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
		
		return null;
	}

}
