package com.example.demo.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.demo.model.Emp;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class EmpDaoImplTest {
	@Autowired
	private EmpDao dao;
	
	@Test
	public void testDi() {
		System.out.println(dao);
		System.out.println(((EmpDaoImpl)dao).jdbcTemplate);
	}
	
	@Test
	public void testTransaction() {
		int oldCount = dao.count();
		System.out.println("oldCount = " + oldCount);
		
		Emp emp = new Emp();
		emp.setEmpno(3301);
		emp.setEname("홍길동");
		emp.setJob("도둑");
		emp.setSal(999);
		
		try {
			int affected = dao.insert(emp);
			System.out.println("affected = " + affected);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		int nowCount = dao.count();
		System.out.println("nowCount = " + nowCount);
		
		assertEquals("insert 메소드에서 예외발생, 트랜잭션 어드바이스 적용, "
				+ "롤백이 되어야 하기 때문에 oldCount 값과 nowCount 값은 같아야 한다.", 
				oldCount, nowCount);
	}

	@Test
	public void testInsert() {
		Emp emp = new Emp();
		emp.setEmpno(3201);
		emp.setEname("홍길동");
		emp.setJob("도둑");
		emp.setSal(999);
		
		int affected = dao.insert(emp);
		System.out.println("affected = " + affected);
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAll() {
		List<Emp> emps = dao.findAll();
		System.out.println(emps.size());
		
		for (Emp emp : emps) {
			System.out.println(emp);
		}
	}

}
