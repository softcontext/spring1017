package com.example.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Emp;

@Repository
public class EmpDaoImpl implements EmpDao {
	@Autowired
	public JdbcTemplate jdbcTemplate;
	
	private SimpleJdbcInsert jdbcInsert;
	@Autowired
	private NamedParameterJdbcTemplate nTemplate;
	
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
	
	@PostConstruct
	public void init() {
		jdbcInsert = new SimpleJdbcInsert(jdbcTemplate)
				.withTableName("EMP").usingGeneratedKeyColumns("empno");
		// 디비가 자동으로 증가시키는 키 값을 얻을 수 있다.
	}
	
//	@Autowired
//	public void setDataSource(DataSource dataSource) {
//		this.jdbcTemplate = new JdbcTemplate(dataSource);
//	}
	
	@Override
	public int insert(Emp emp) {

		if (emp.getEmpno() == 0) {
			// 도메인 클래스의 멤버변수 이름과 테이블의 칼럼명이 일치하는 경우
			// 멤버변수를 칼럼명으로 사용하여 자동으로 SQL insert 쿼리문을 작성합니다.
			// jdbcInsert 객체를 사용해서 insert 를 수행할 때 따로 SQL 쿼리문을 알려줄 필요가 없어진다.
			SqlParameterSource param = new BeanPropertySqlParameterSource(emp);
			// 자바에서 숫자를 취급하는 객체가 디비가 제너레이트한 키 값을 갖고 있습니다.
			Number number = jdbcInsert.executeAndReturnKey(param);
			// 디비가 사용한 키 값을 메소드가 받은 파라미터 객체에 추가하면
			// 객체는 참조이기 때문에 메소드를 호출한 측에서 이 객체에서 키 값을 꺼내서 사용할 수 있습니다.
			emp.setEmpno(number.intValue());
			
			return 1;
		} else {
			String sql = "insert into EMP(empno, ename, job, sal) values(?, ?, ?, ?)";
			return jdbcTemplate.update(sql, 
					emp.getEmpno(), emp.getEname(), emp.getJob(), emp.getSal());
		}
		
	}

	@Override
	public int update(Emp emp) {
//		String sql = "update EMP set ename=?, job=?, sal=? where empno=?";
//		return jdbcTemplate.update(sql, 
//				emp.getEname(), emp.getJob(), emp.getSal(), emp.getEmpno());
		
		// 순서 기반 위치보유자 ? 대신,
		// 이름 기반 위치보유자 : 를 사용하면 
		// SQL 문에 파라미터로 받은 값을 매핑할 때 
		// 벌어지는 실수를 예방할 수 있습니다.
		String sql = "update EMP set ename=:ename, job=:job, sal=:sal "
				+ "where empno=:key";
		
		Map<String, Object> map = new HashMap<>();
		map.put("key", emp.getEmpno());
		map.put("ename", emp.getEname());
		map.put("job", emp.getJob());
		map.put("sal", emp.getSal());
		
		return nTemplate.update(sql, map);
	}

	@Override
	public int delete(int empno) {
		String sql = "delete EMP where empno=?";
		return jdbcTemplate.update(sql, empno);
	}

	@Override
	public List<Emp> findAll() {
		String sql = "select empno, ename, job, sal from EMP order by empno asc";
		return jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public int count() {
		String sql = "select count(*) from EMP";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	@Override
	public Emp findOne(int empno) {
		String sql = "select empno, ename, job, sal from EMP where empno=?";
		return jdbcTemplate.queryForObject(sql, rowMapper, empno);
	}

}
