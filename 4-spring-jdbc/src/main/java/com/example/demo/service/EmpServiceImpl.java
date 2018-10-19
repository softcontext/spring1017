package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.EmpDao;
import com.example.demo.domain.Emp;

// 클래스에 트랜잭션 설정을 하면 이 안에 있는 모든 메소드에 트랜잭션이 적용됩니다.
// 서비스 메소드에서 다수의 DAO 메소드를 호출하면, 그 메소드 모두 하나의 트랜잭션 단위로 처리됩니다.
@Transactional(
		isolation=Isolation.DEFAULT,
		propagation=Propagation.REQUIRED,
		timeout=-1,
		readOnly=false)
@Service
public class EmpServiceImpl implements EmpService {
	@Autowired
	private EmpDao empDao;
	
	// 트랜잭션은 일종의 어라운드 어드바이스 입니다.
	// 이 어드바이스는 try-catch 로직을 갖고 있어서 
	// 서비스 메소드 또는 서비스 메소드에서 호출하는 DAO 메소드에서 
	// 예외가 발생하는 경우 어드바이스에 catch 블록이 작동하게 되고
	// 롤백이 처리됩니다.
	@Transactional
	@Override
	public int insert(Emp emp) {
		// 부가로직을 추가해야 할 때 서비스 클래스를 사용합니다.
		return empDao.insert(emp);
	}

	@Override
	public int update(Emp emp) {
		return empDao.update(emp);
	}

	@Override
	public int delete(int empno) {
		return empDao.delete(empno);
	}

	@Transactional(readOnly=true)
	@Override
	public List<Emp> findAll() {
		return empDao.findAll();
	}

	@Override
	public int count() {
		return empDao.count();
	}

	@Override
	public Emp findOne(int empno) {
		return empDao.findOne(empno);
	}

}
