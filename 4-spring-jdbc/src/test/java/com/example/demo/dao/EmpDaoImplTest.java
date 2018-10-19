package com.example.demo.dao;

// CoreMatchers 클래스에 is 메소드는 static 메소드입니다.
// 원래 사용방법은 CoreMatchers.is() 방식인데
// 클래스를 명시하지 않고 is() 형태로 사용하고 싶어서 
// import static 설정을 합니다.
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
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
public class EmpDaoImplTest {
	@Autowired
	private EmpDao dao;

	@Test
	public void testInsert() {
		int oldCount = dao.count();
		
		Emp emp = new Emp();
		emp.setEname("Tom");
		emp.setJob("Actor");
		emp.setSal(999);
		
		System.out.println("전: " + emp);
		
		int affected = dao.insert(emp);
		System.out.println("affected = " + affected);
		
		System.out.println("후: " + emp);
		
		int nowCount = dao.count();
		
		assertThat("한 행이 추가되었으므로 nowCount는 oldCount 보다 1이 커야 합니다.", 
				nowCount, is(oldCount + 1));
	}

	@Test
	public void testUpdate() {
		Emp emp = new Emp();
		emp.setEname("Tom");
		emp.setJob("Actor");
		emp.setSal(999);

		int affected = dao.insert(emp);
		System.out.println("affected = " + affected);
		
		System.out.println("전: " + emp);
		
		emp.setJob("None");
		emp.setSal(0);
		
		affected = dao.update(emp);
		System.out.println("affected = " + affected);
		
		Emp e = dao.findOne(emp.getEmpno());
	
		System.out.println("후: " + e);
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAll() {
		List<Emp> emps = dao.findAll();
		int count = dao.count();
		
		assertEquals("리스트의 사이즈는 카운트 값과 일치해야 한다.",  emps.size(), count);
		System.out.println("count = " + count);
		
		emps.forEach(System.out::println);
	}

	@Test
	public void testCount() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindOne() {
		fail("Not yet implemented");
	}

}
