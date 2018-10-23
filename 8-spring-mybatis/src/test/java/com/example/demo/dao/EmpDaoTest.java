package com.example.demo.dao;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.domain.Emp;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmpDaoTest {
	@Autowired
	private EmpDao dao;

	@Test
	public void testInsert() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		Emp emp = new Emp();
		emp.setEname("Tom");
		emp.setJob("Programmer");
		emp.setSal(700);
		
		System.out.println("전: " + emp);
		
		int affected = dao.insert(emp);
		System.out.println("affected = " + affected);
		
		// 수정을 위해서는 키 값인 empno 값이 필요합니다.
		// 별다른 작업을 하지 않는다면 여전히 0 값이 상태이고 이러면 수정할 수 없습니다.
		
		System.out.println("후: " + emp);
		
		emp.setJob("Designer");
		emp.setSal(900);
		
		affected = dao.update(emp);
		System.out.println("affected = " + affected);
		
		Emp e = dao.findOne(emp.getEmpno());
		System.out.println(e);
		
		affected = dao.delete(emp.getEmpno());
		System.out.println("affected = " + affected);
		
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

	@Test
	public void testCount() {
		int count = dao.count();
		System.out.println(count);
	}

	@Test
	public void testFindOne() {
		int empno = 1;
		Emp emp = dao.findOne(empno);
		System.out.println(emp);
	}

}
