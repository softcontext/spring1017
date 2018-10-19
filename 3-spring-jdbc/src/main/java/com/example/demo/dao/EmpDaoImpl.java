package com.example.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Emp;

@Repository
public class EmpDaoImpl implements EmpDao {
	@Autowired
	public JdbcTemplate jdbcTemplate;
	
//	Row(테이블 행) 정보를 <Emp> 객체에 Mapper(매핑) 하기 위한 로직
//	어는 칼럼의 데이터를 어는 멤버변수에 넣어야 하는지 알려주는 로직
	private RowMapper<Emp> rowMapper = new RowMapper<Emp>() {
		@Override
		public Emp mapRow(ResultSet rs, int rowNum) throws SQLException {
			Emp e = new Emp();
			e.setEmpno(rs.getInt("empno"));
			e.setEname(rs.getString("ename"));
			e.setJob(rs.getString("job"));
			e.setSal(rs.getDouble("sal"));
			
			return e;
		}
	};	
	
//	@Autowired
//	public void setDataSource(DataSource dataSource) {
//		this.jdbcTemplate = new JdbcTemplate(dataSource);
//	}
	
	@Override
	public int insert(Emp emp) {
		String sql = "insert into EMP9(empno, ename, job, sal) values(?, ?, ?, ?)";
		int affected = jdbcTemplate.update(sql, 
				emp.getEmpno(), emp.getEname(), emp.getJob(), emp.getSal());
		
//		return affected;	
		
		/*
		 * 트랜잭션 테스트
		 */
		System.out.println("영향받은 로우의 개수 = " + affected);
		throw new RuntimeException("트랜잭션 테스트 용 언체크드 예외");
	}

	@Override
	public int update(Emp emp) {
		String sql = "update EMP9 set ename=?, job=?, sal=? where empno=?";
		return jdbcTemplate.update(sql, 
				emp.getEname(), emp.getJob(), emp.getSal(), emp.getEmpno());
	}

	@Override
	public int delete(int empno) {
		String sql = "delete EMP9 where empno=?";
		return jdbcTemplate.update(sql, empno);
	}

	@Override
	public List<Emp> findAll() {
		String sql = "select empno, ename, job, sal from EMP9 order by empno asc";
		return jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public int count() {
		String sql = "select count(*) from EMP9";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	@Override
	public Emp findOne(int empno) {
		String sql = "select empno, ename, job, sal from EMP9 where empno=?";
		return jdbcTemplate.queryForObject(sql, rowMapper, empno);
	}

}
